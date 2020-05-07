package cn.njxz.fitness.repetitive.annotation;


import cn.njxz.fitness.constants.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created ApiIdempotent by kalend.zhang on 2020/4/2.
 *
 * 在需要保证 接口防重复提交的 的Controller的方法上使用此注解
 *
 * type取值为head/form，默认 head
 *  head:表示客户端token放在请求头中
 *  form:表示客户端token放在表单中
 *
 * @author kalend.zhang
 * @date 2020/4/2 9:42
 */
@Target( {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiRepetitive {
    /**
     * Token获取位置
     */
    String type() default Constants.ExtApi.EXTAPIHEAD;

    /**
     * 重复提交检查时间 默认5秒
     */
    long exsitTime() default 5L;
}
