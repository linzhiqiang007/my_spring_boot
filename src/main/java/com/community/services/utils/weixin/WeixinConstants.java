package com.community.services.utils.weixin;

import com.community.services.utils.file.PropertiesFileUtils;

public class WeixinConstants {

	public static String APPID = PropertiesFileUtils.getPropertyValue("application.properties", "APPID");

	public static String APP_SECRET = PropertiesFileUtils.getPropertyValue("application.properties", "APP_SECRET");
}
