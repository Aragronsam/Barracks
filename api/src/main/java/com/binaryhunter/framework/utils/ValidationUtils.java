package com.binaryhunter.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据验证工具类
 * @author BinaryHunter
 *
 */
public class ValidationUtils {
	/**
	 * 判别是否是手机号码
	 * @param tel 手机号码
	 * @return 是否是手机号
	 * Create by Liyw -- 2015年5月6日
	 */
	public static boolean isTel(String tel){
		Pattern pattern = Pattern.compile("(^13\\d{9}$)|(^14)[5,7]\\d{8}$|(^15[0,1,2,3,5,6,7,8,9]\\d{8}$)|(^17)[6,7,8]\\d{8}$|(^18\\d{9}$)"); 
	    Matcher matcher = pattern.matcher(tel); 
	    return matcher.matches();
	}
}
