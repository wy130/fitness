package cn.njxz.fitness.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import cn.njxz.fitness.model.User;
import cn.njxz.fitness.util.AliyunSmsUtil;
import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.njxz.fitness.service.UserService;


@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

	@Autowired(required = true)
	UserService userService;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * md5加密方法
	 *
	 * @param str
	 *
	 * @return
	 */
	public static String getMD5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 前往首页
	 *
	 * @param request
	 *
	 * @return
	 */
	@GetMapping("/toIndex")
	@ResponseBody
	public User toIndex(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return user;
		}
		return null;
	}

	/**
	 * @param name
	 * @param pwd
	 * @param request
	 * @param response
	 *
	 * @return
	 *
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/login")
	public String login(String name, String pwd, String imagecode, HttpServletRequest request,
						HttpServletResponse response) throws
																															 ServletException,
																															 IOException {
		HttpSession session = request.getSession();
		// 获取 session中的验证码
		String sessionCode = (String) session.getAttribute("imgCode");
		//如果session中验证码为空或者获取到的前端用户输入验证码为空 则返回错误给前端
		if (null == sessionCode || "".equals(sessionCode) || null == imagecode || "".equals(imagecode)) {
			request.setAttribute("codeErr", "验证码为空!");
			return "templates/user/login";
		} else if (imagecode.equalsIgnoreCase(sessionCode)) {
			//根据第一个输入框输入的内容去数据库中查询
			User user = userService.findUserByNameOrPhoneOrEmail(name);
			//查询用户为空，则用户不存在，返回登录页，给出提示
			if (user == null) {
				request.setAttribute("nameErr", "用户名/手机号/邮箱不存在!");
				return "templates/user/login";
			} else {
				//对密码框中输入的密码先进行md5加密 再比对，因为注册时数据库中存入的是md5加密后的数据
				String pwdByMd5 = getMD5(pwd);
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Content-type", "text/html;charset=UTF-8");
				//比对成功后，用户登录成功，将该用户存入session
				if (user.getUPwd().equals(pwdByMd5)) {
					session.setAttribute("user", user);
					PrintWriter out = null;
					out = response.getWriter();
					out.print("<script>alert('登陆成功!前往主页...');</script>");
					out.flush();
					return "templates/index";
				} else {
					request.setAttribute("pwdErr", "密码错误!");
					return "templates/user/login";
				}
			}
		} else {
			request.setAttribute("codeErr", "验证码错误!");
			return "templates/user/login";
		}
	}

	//去注册页面注册
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {

		return "templates/user/register";
	}

	/**
	 * 用户名是否重复
	 */
	@PostMapping("/checkUname")
	@ResponseBody
	public String checkUname(String uName) {
		//校验当前用户是否存在
		if (userService.findUserByNameOrPhoneOrEmail(uName) != null) {
			return "{\"msg\":\"no\"}";
		} else {
			return "{\"msg\":\"ok\"}";
		}

	}

	/**
	 * 手机是否重复
	 */
	@PostMapping("/checkUphone")
	@ResponseBody
	public String checkUphone(String uPhone) {
		//校验手机号是否存在
		if (userService.findUserByNameOrPhoneOrEmail(uPhone) != null) {
			return "{\"msg\":\"no\"}";
		} else {
			return "{\"msg\":\"ok\"}";
		}
	}

	/**
	 * 检验图片验证码
	 */
	@PostMapping("/checkImageCode")
	@ResponseBody
	public String checkImageCode(String imagecode, HttpServletRequest request) {
		//校验图片验证码
		HttpSession session = request.getSession();
		// 获取 session中的验证码
		String sessionCode = (String) session.getAttribute("imgCode");
		//如果session中验证码为空或者获取到的前端用户输入验证码为空 则返回错误给前端
		if (null == sessionCode || "".equals(sessionCode) || null == imagecode || "".equals(imagecode)) {
			return "{\"msg\":\"no\"}";
		} else if (imagecode.equalsIgnoreCase(sessionCode)) {
			return "{\"msg\":\"ok\"}";
		}
		return "{\"msg\":\"no\"}";
	}

	//注册新用户到user表
	@RequestMapping("/toregister")
	public String toregister(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
		// 获取 session中的验证码
		String redisCode = stringRedisTemplate.opsForValue().get(user.getUPhone());
		// 获取表单中的验证码
		String checkCode = request.getParameter("checkcode");
		if (null == redisCode || "".equals(redisCode) || null == checkCode || "".equals(checkCode)) {
			request.setAttribute("codeErr", "验证码为空!");
			return "templates/user/register";
		} else if (checkCode.equalsIgnoreCase(redisCode)) {
			if (userService.findUserByNameOrPhoneOrEmail(
				user.getUName()) != null || userService.findUserByNameOrPhoneOrEmail(user.getUPhone()) != null) {
				request.setAttribute("nameErr", "当前用户已存在，请前往登录!");
				return "templates/user/register";
			}
			String pwdByMd5 = getMD5(user.getUPwd());
			user.setUPwd(pwdByMd5);
			if (userService.add(user) > 0) {
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Content-type", "text/html;charset=UTF-8");
				PrintWriter out = null;
				out = response.getWriter();
				out.print("<script>alert('注册成功，请登录!');</script>");
				out.flush();

				return "templates/user/login";
			}
		}
		return "templates/user/register";
	}

	@PostMapping("/getPhoneVerification")
	@ResponseBody
	public String getPhoneVerification(String memberphone) throws ClientException {
		//  判断是否填写手机号码
		if (memberphone == null) {
			//  未填写手机号码，返回失败提示
			return "{\"msg\":\"no\"}";
		}
		//  判断用户填写的手机号码是否合法
		if (!memberphone.matches("^1(([358]\\d)|66|76|77|99)\\d{8}$")) {
			//  手机号码不合法，返回失败提示
			return "{\"msg\":\"no\"}";
		}
		String validateCodeInRedis = stringRedisTemplate.opsForValue().get(memberphone);
		if (validateCodeInRedis != null) {
			String validateCode = AliyunSmsUtil.sendSms(memberphone, validateCodeInRedis);
			return "{\"msg\":\"ok\"}";
		}
		//    将用的短信验证码保存到Redis中
		String validateCode = AliyunSmsUtil.sendSms(memberphone, null);
		//  判断获取短信验证码是否出现异常
		if (validateCode.length() != 6) {
			//  说明返回的不是验证码，而是异常信息
			return "{\"msg\":\"no\"}";
		}
		//  将短信验证码保存到 Redis 中，有效期为5分钟
		//  key  ： 手机号码
		//  value： 验证码
		stringRedisTemplate.opsForValue().set(memberphone, validateCode);
		stringRedisTemplate.expire(memberphone, 300, TimeUnit.SECONDS);
		return "{\"msg\":\"ok\"}";

	}


	//退出
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		PrintWriter out = null;

		request.getSession().removeAttribute("user");

		out = response.getWriter();
		out.print("<script>alert('帐号已安全退出!');</script>");
		out.flush();                      //window.location.href='" + "/show/login.jsp" + "';

		modelAndView.setViewName("static/index");
		return modelAndView;
	}

	/**
	 * 主页中的业务，当用户没有登录的状态下，先登录在操作 contact 联系我们
	 *
	 * @return 成衣
	 */
	/*
	 * typo 我喜欢的
	 */
	@RequestMapping("/typo")
	public String typo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.getAttribute("user");
		//如果会话中user对象为空，跳转到登录页面
		if (session.getAttribute("user") == null) {
			request.setAttribute("error", "未登录，请登录后操作！谢谢");
			return "templates/error/error2";
		} else {
			return "/show/typo";
		}
	}

	/*
	 * 联系我们
	 */
	@RequestMapping("/contact")
	public String contact(HttpServletRequest request) {
		//		User user = (User) request.getSession().getAttribute("user");

		HttpSession session = request.getSession();
		session.getAttribute("user");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + session.getAttribute("user"));
		//如果会话中user对象为空，跳转到登录页面
		if (session.getAttribute("user") == null) {
			System.out.println("-----------------用户不存在----------");
			request.setAttribute("error", "未登录，请登录后操作！谢谢");
			return "/show/jsp/error2";
		} else {
			System.out.println("+++++++++++++++++++++buweikong+++++++++++++++++++++" + session.getAttribute("user"));
			return "templates/contact"; //联系我们的页面
		}
	}

	//后台管理用户
	@RequestMapping("/touserIndex")
	public String touserIndex() {
		return "templates/admin/userindex";
	}

	@RequestMapping("/tolist")
	public String tolist() {
		return "templates/admin/userlist";
	}

	@RequestMapping("/toalist")
	public String touserlist() {
		return "templates/admin/userlist";
	}

	//根据用户名查找user
	@RequestMapping("/selectUser")
	public void selectUser(@RequestParam(required = false, defaultValue = "")
							   String username, HttpServletRequest request, HttpServletResponse response,
						   @RequestParam(required = false, defaultValue = "1") Integer page, //第几页
						   @RequestParam(required = false, defaultValue = "10") Integer rows) throws IOException {
		username = URLDecoder.decode(username, "utf-8");
		System.out.println("未格式化的" + username);
		request.setCharacterEncoding("utf-8");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageSize", rows);
		params.put("pageNum", (page - 1) * rows);
		// if(username.substring(1,username.length()-1).length()==0||username.substring(1,username.length()-1).equals
		// ("")){
		params.put("username", null);
		// }else{
		params.put("username", username);
		// }
		List<User> alist = userService.selectByName(params);
		int total = userService.countselectByName(username).size();
		System.out.println("一共有多少数据" + total);
		JSONObject result = new JSONObject();
		String clist = JSONArray.fromObject(alist).toString();
		result.put("rows", clist);
		result.put("total", total);
		System.out.println(clist);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}

	/**
	 * 获取所有用户列表
	 *
	 * @param request
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	@RequestMapping("/getAllUser")
	public void getAllUser(HttpServletRequest request, HttpServletResponse response,
						   @RequestParam(required = false, defaultValue = "1") Integer page, //第几页
						   @RequestParam(required = false, defaultValue = "10") Integer rows //页数大小
						  ) throws IOException {
		System.out.println("进入查询");
		request.setCharacterEncoding("utf-8");
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("pageSize", rows);
		params.put("pageNum", (page - 1) * rows);
		params.put("username", "");
		List<User> findAll = userService.selectByName(params);
		int total = userService.countUser();
		System.out.println("user一共有多少数据" + total);
		JSONObject result = new JSONObject();
		String clist = JSONArray.fromObject(findAll).toString();
		result.put("rows", clist);
		result.put("total", total);
		//System.out.println(clist);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}

	/*后台管理员列表增加*/
	@RequestMapping("/toAdd")
	public String toAdd() {

		return "templates/admin/userinfo";
	}

	/**
	 * 添加用户
	 *
	 * @param user
	 * @param request
	 *
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request) {

		if (user != null) {
			//把购物车号赋值一下==用户的id
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss aa");//最后的aa表示上午或下午 HH表示24小时
			String d = sdf.format(new Date());
			String pwdByMd5 = getMD5(user.getUPwd());
			user.setUPwd(pwdByMd5);
			userService.add(user);
			return "templates/admin/userlist"; //添加成功后转到user列表
		} else {
			System.out.println("添加失败");
			return null;
		}
	}

	/**
	 * 根据id查询编辑用户
	 *
	 * @param id
	 * @param request
	 *
	 * @return
	 */
	@RequestMapping("/toEditUser")
	public String toEditUser(String id, Model model, HttpServletRequest request) {
		int index = Integer.valueOf(id);
		System.out.println("进入编辑" + index);
		User user = userService.findById(index);
		System.out.println(user.getUId() + user.getUName());
		model.addAttribute("user", user);
		return "templates/admin/editUser";
	}

	/**
	 * 更新用户
	 */
	@RequestMapping("/updateUser")
	public String updateUser(User user, HttpServletRequest request) {
		System.out.println("进入更新。。。。。");
		String pwdByMd5 = getMD5(user.getUPwd());
		user.setUPwd(pwdByMd5);
		if (userService.update(user) > 0) {
			return "templates/admin/userlist";
		} else {
			return null;
		}
	}

	/**
	 * 删除用户
	 *
	 * @param ids
	 * @param request
	 * @param response
	 */
	@RequestMapping("/delUser")
	public String delUser(String ids, HttpServletRequest request, HttpServletResponse response) {
		/**/
		System.out.println("进入删除");
		if (ids.length() == 1) {
			System.out.println("-------" + ids);
			if (userService.delete(Integer.parseInt(ids)) > 0) {
				return "templates/admin/userlist";
			} else {
				System.out.println("删除失败");
				return null;
			}
		} else {
			System.out.println(ids.toString());
			String[] num = ids.split(",");
			for (int i = 0; i < num.length; i++) {
				userService.delete(Integer.parseInt(num[i]));
			}
			return "templates/admin/userlist";
		}
	}


}
