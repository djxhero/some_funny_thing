package com.djxhero.dto;

public enum CommonResultCode {
	SUCCESS(10000, "OK"),
	USER_NO_EXIST(10001, "用户不存在"),
	INVALID_PARAM(10002 , "请求参数错误"),

	MISSING_PARAM(10003, "请求参数不全"),
	UPDATE_DATA(10004, "更新数据失败，具体信息详见msg字段"),
	NO_SESSION(10005, "对不起，当前Session失效,请重新登录"),
	IMAGE_UPLOAD(10006, "只支持上传jpg/gif/png格式文件"),
	CODE_MALL_EXIST(10006 , "商城已存在"),
	CODE_PRODUCT_EXIST(10013, "已新增过此课程"),
	CODE_BANNER_EXCEED(10014 , "已存在5条上架素材，无法上架新素材"),

	REQUEST_NO_AUTH(10101 , "该请求未授权无法获取用户信息"),
	CHECK_CODE(10102 , "验证码不正确，请核对后重试"),
	CHECK_EXPIRED(10103 , "验证码已过期，请重新获取"),
	CHECK_CODE_INVALID(10104 , "无效验证码，请重新获取"),
	BIND_PHONE(10105 , "绑定手机失败，稍后再试"),
	UPLOAD_FILE(10106 , "上传文件失败，稍后再试"),
	CHECK_CODE_SEND_ERROR(10107, "验证码下发失败，请稍后再试"),
	USER_EXIST(10108, "此账号已添加进入系统，请配置所需角色。"),
	USER_EXIST_KLIB(10108, "账号已存在"),
	LOGIN_ERROR(10109, "您的账号或密码有误，请重新输入"),
	ALREADY_REGISTER(10110, "该手机号已注册"),
	PHONE_ALREADY_EXISTS(10111, "该手机号已存在"),
	RESET_PASSWORD_ERROR(10112, "重置密码失败，请稍后再试"),
	CODE_PRODUCT_UPDATE_PERMISSION(10012, "无权限上架该课程"),

	ROLE_EXIST(10201, "当前角色已经存在"),
	NO_ACCOUNT(10202, "对不起，当前帐户不存在"),
	NO_PERMISSION(10203, "sorry，暂无权限~~"),
	REGISTER_ERROR(10204, "用户注册失败"),
	ACCOUNT263_ALREADY_EXISTS(10205, "该263账号已存在"),
	CODE_REGISTER_ERROR(10025, "注册服务异常，请稍后再试"),
	CODE_ALREADY_REGISTER(10023, "账号已存在，可直接登录"),
	CODE_WORRY_DATE(10050, "手机日期和服务器日期不匹配"),
	DO_NOT_RESUBIMT(10099, "请勿重复提交"),
	DO_NOT_RECEIVE_WELFARE(10210, "福利已经领取，请勿重复领取"),

	SYS_BUSINESS_ERROR(200014,"[服务器]业务异常"),
	;


	public final int code;
	public final String msg;

	CommonResultCode(int code, String msg) {
		this.msg = msg;
		this.code = code;
	}

}
