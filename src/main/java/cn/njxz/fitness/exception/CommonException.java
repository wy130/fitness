package cn.njxz.fitness.exception;

import cn.njxz.fitness.error.IResultCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Kalend Zhang on 2019/7/18.
 *
 * @author Kalend Zhang
 * @date 2019/7/18 14:35
 */
@Slf4j
public class CommonException extends RuntimeException {

    @Getter
    private IResultCode resultCode;

    public CommonException(String message) {
        super(message);
    }
    public CommonException(IResultCode resultCode) {
        super(resultCode.getErrorMessage());
        this.resultCode = resultCode;
    }

    public CommonException(IResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
