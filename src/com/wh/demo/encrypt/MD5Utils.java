package com.wh.demo.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	/***
	 * @param data
	 * @return
	 */
	public static String toMD5(String data) {

		try {
			// 实例化一个指定摘要算法为MD5的MessageDigest对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 重置摘要以供再次使用
			md.reset();
			// 使用bytes更新摘要
			md.update(data.getBytes());
			// 使用指定的byte数组对摘要进行最的更新，然后完成摘要计算
			return toHexString(md.digest(), data);
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		return null;
	}

	// 将字符串中的每个字符转换为十六进制
	private static String toHexString(byte[] bytes, String separator) {

		StringBuilder hexstring = new StringBuilder();
		for (byte b : bytes) {
			String hex = Integer.toHexString(0xFF & b);
			if (hex.length() == 1) {
				hexstring.append('0');
			}
			hexstring.append(hex);
		}
		return hexstring.toString();
	}
}
