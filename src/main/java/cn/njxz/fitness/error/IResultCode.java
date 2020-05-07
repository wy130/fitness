package cn.njxz.fitness.error;

import java.io.Serializable;

/**
 * 业务代码接口
 *
 * @author Kalend
 */
public interface IResultCode extends Serializable {

	/**
	 * 消息
	 *
	 * @return String
	 */
	String getErrorMessage();

	/**
	 * 状态码
	 *
	 * @return int
	 */
	String getErrorCode();

}
