package cn.njxz.fitness.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/image")
public class ImageController {

    @RequestMapping("imageCode")
    @ResponseBody
    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //做一个图片验证码
        //1.规定验证码范围
        char[] chars = "qwertyuiopASDFGHJKLzxcvBNM1234567890".toCharArray();
        //2.获取一个Image对象  用于存放图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_3BYTE_BGR);
        //3.获取画笔能够将内容图片中
        Graphics g = image.getGraphics();
        //4.图片背景设置
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 80, 20);
        //5.边框设置
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 79, 19);
        //6.字体设置
        g.setColor(Color.RED);
        g.setFont(new Font("黑体", Font.BOLD, 18));
        //7.随机生成4个字符   作为验证码
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int n = r.nextInt(chars.length);  //随机位置根据自己定义的chars数组而定
            sb.append(chars[n] + " ");   //将chars数组中对应位置内容  放入到sb 对象
        }
        //8.将随机数 添加到  画布中
        g.drawString(sb.toString(), 3, 15);
        //9.添加干扰点
        g.setColor(Color.BLUE);
        for (int i = 0; i < 100; i++) {
            int x = r.nextInt(80);
            int y = r.nextInt(20);
            g.drawOval(x, y, 1, 1);
        }
        //11.将验证码   放入session  之后用于 比较
        HttpSession session = request.getSession();
        //将StringBuilder中的验证码   取出来
        String[] strs = sb.toString().split(" ");
        String code = "";
        for (int i = 0; i < strs.length; i++) {
            code += strs[i];
        }
        session.setAttribute("imgCode", code);
        System.out.println(sb.toString());
        //10.显示拼装的图片
        ImageIO.write(image, "jpeg", response.getOutputStream());

    }
}



