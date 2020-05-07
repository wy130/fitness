package cn.njxz.fitness.repetitive.aspect;



import cn.njxz.fitness.constants.Constants;
import cn.njxz.fitness.constants.StringPool;
import cn.njxz.fitness.error.CommonErrorEnum;
import cn.njxz.fitness.exception.CommonException;
import cn.njxz.fitness.repetitive.annotation.ApiRepetitive;
import cn.njxz.fitness.util.JsonUtil;
import cn.njxz.fitness.util.RedisUtils;
import cn.njxz.fitness.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created ApiIdempotentAspect by kalend.zhang on 2020/4/2.
 *
 * @author kalend.zhang
 * @date 2020/4/2 9:48
 */
@Slf4j
@Component
@Aspect
public class ApiRepetitiveAspect {
    @Resource
    private RedisUtils redisUtils;

    private static final String TOKEN = "token";

    @Pointcut("execution(public * cn.njxz.fitness.controller.*.*(..))")
    public void apiIdempotentAop() {
    }


    /**
     * 环绕通知验证参数
     * @author kalend.zhang
     * @date 15:09 2020/4/2
     * @param proceedingJoinPoint ProceedingJoinPoint
     * @return Object
     **/
    @Around("apiIdempotentAop()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        ApiRepetitive apiRepetitive = signature.getMethod().getDeclaredAnnotation(ApiRepetitive.class);
        if (apiRepetitive != null) {
            return apiRepetitive(proceedingJoinPoint, signature);
        }
        //放行 正常执行后面（Controller）的业务逻辑
        Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }


    public Object apiRepetitive(ProceedingJoinPoint proceedingJoinPoint, MethodSignature signature)
    throws Throwable {
        ApiRepetitive apiRepetitive = signature.getMethod().getDeclaredAnnotation(ApiRepetitive.class);
        if (apiRepetitive == null) {
            // 直接执行程序
            Object proceed = proceedingJoinPoint.proceed();
            return proceed;
        }
        // 代码步骤：
        // 1.获取令牌 存放在请求头中
        String token = null;
        String servletPath = null;
        // value就是获取类型 请求头之类的
        String valueType = apiRepetitive.type();
        long exsitTime = apiRepetitive.exsitTime();
        if (StringUtil.isBlank(valueType)) {
            valueType = Constants.ExtApi.EXTAPIHEAD;
        }
        if(!Objects.isNull(RequestContextHolder.getRequestAttributes())) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //如果存在header中 从头中获取
            if (valueType.equals(Constants.ExtApi.EXTAPIHEAD)) {
                //从头中获取
                token = request.getHeader(TOKEN);
            } else {
                //否则从 请求参数获取
                token = request.getParameter(TOKEN);
            }
            servletPath = request.getServletPath();
        }

        String jsonString = this.getRequestParasJsonString(proceedingJoinPoint);
        String sha1 = this.generateSha1(jsonString);
        StringBuilder lockKey = new StringBuilder();
        if(StringUtil.isBlank(token)) {
            lockKey.append(token);
            lockKey.append(StringPool.DASH);
        }
        if(StringUtil.isBlank(servletPath)) {
            lockKey.append(servletPath);
            lockKey.append(StringPool.DASH);
        }
        lockKey.append(sha1);
        if(log.isDebugEnabled()) {
            log.debug("{Servlet Path: {}\tToken: {}\tJson String: {}\tSHA-1: {}\n\tResult Key: {} \n}", servletPath, token
                , jsonString, sha1, lockKey.toString());
        }
        if(redisUtils.hasKey(lockKey.toString())){
           throw new CommonException(CommonErrorEnum.REPETITIVE_OPERATION);
        }
        Object proceed = proceedingJoinPoint.proceed();
        redisUtils.setNx(lockKey.toString(),lockKey.toString(),exsitTime);
        return proceed;
    }


    /**
     * 获取请求参数
     * @param point ProceedingJoinPoint
     * @return String
     */
    private String getRequestParasJsonString(ProceedingJoinPoint point) {
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
        ConcurrentHashMap<String, String> args = null;

        if (Objects.nonNull(parameterNames)) {
            args = new ConcurrentHashMap<>(parameterNames.length);
            for (int i = 0; i < parameterNames.length; i++) {
                String value = point.getArgs()[i] != null ? point.getArgs()[i].toString() : "null";
                args.put(parameterNames[i], value);
            }
        }
        return JsonUtil.toJson(args);
    }

    private String generateSha1(String str){
        if (null == str || 0 == str.length()){
            return null;
        }
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA-256");
            mdTemp.update(str.getBytes(StandardCharsets.UTF_8));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
