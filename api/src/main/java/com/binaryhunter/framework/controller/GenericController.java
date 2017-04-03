package com.binaryhunter.framework.controller;

import javax.servlet.http.HttpServletRequest;

import com.binaryhunter.framework.bo.ResponseBean;

/**
 * 控制器父类
 * @author BinaryHunter
 */
public class GenericController {
	//正常返回
	public static final int CODE_OK = 0;
	//返回对象为空
	public static final int CODE_RESPONSE_OBJ_IS_NULL = 1;
	//用户输入有误
	public static final int CODE_WRONG_INPUT = 2;
	//未知错误
	public static final int CODE_UNKOWN_ERROR = 3;
	//未知错误提示信息
	public static final String MSG_UNKOWN_ERROR = "未知错误, 请联系客服人员";
	//参数错误
	public static final String MSG_PARAMS_ERROR = "参数错误, 请联系客服人员";
	//重复添加
	public static final String MSG_REPEATED = "已经有一个相同的, 请您换一个";
	
	/**
	 * 把返回对象进行封装
	 * @param bean 返回对象
	 * @return json 串
	 */
	protected ResponseBean toResponse(Object bean) {
		return toResponse(bean, CODE_OK);
	}
	
	/**
	 * 把返回对象进行封装
	 * @param bean 返回对象
	 * @param code 返回代码
	 * @return json 串
	 */
	protected ResponseBean toResponse(Object bean, int code) {
		ResponseBean rb = new ResponseBean();
		if(null != bean) {
			rb.setCode(code);
			rb.setData(bean);			
		} else {
			rb.setCode(CODE_RESPONSE_OBJ_IS_NULL);
			rb.setData("The response obj is null!");
		}
		
		return rb;
	}
	/**
	 * 获取项目URL
	 * @param request 请求对象
	 * @return 项目URL
	 */
	protected String getBasePath(HttpServletRequest request){
		return request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ request.getContextPath() + "/";
	}
}
