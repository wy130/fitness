package cn.njxz.fitness.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Hongchang.wu
 * @Description
 * @Date Created in 15:51 2020/3/10
 */
@Getter
@AllArgsConstructor
public enum CommonErrorEnum implements IResultCode {
    /**
     * 参数校验异常
     */
    PARAM_VALIDATE_ERROR("0299001","参数校验异常"),
    /**
     * 未知异常
     */
    UNKNOWN_EXCEPTION("0299999","未知异常"),
    /**
     * 数据库操作异常
     */
    DATA_ACCESS_EXCEPTION("0299002","数据库操作异常"),
    /**
     * 数据类型不匹配异常
     */
    PARAM_BIND_EXCEPTION("0299003","数据类型不匹配"),
    /**
     * 数据转换异常
     */
    INVALID_FORMAT_EXCEPTION("0299004","数据转换异常"),
    /**
     * 缺少参数异常
     */
    MISSING_PARAM_EXCEPTION("0299006","缺少必要参数"),
    /**
     * 参数类型错误
     */
    PARAM_KIND_EXCEPTION("0299007","参数类型错误"),

    /**
     * 数据记录失败
     */
    DATA_ACCESS_FAILED("0299008","数据记录失败"),
    /**
     * 重复提交请求
     */
    REPETITIVE_OPERATION("0299009","请勿重复操作"),

    /**
     * pageSize超过最大限制
     */
    PAGE_SIZE_TOO_LARGE("0202540","pageSize超过最大限制"),

    /**
     * PageNum参数异常，请传入大于0的整数
     */
    PAGE_NUM_ERROR("0202542","PageNum参数异常，请传入大于0的整数");

    private String errorCode;

    private String errorMessage;

}
