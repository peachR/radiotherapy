package com.radiotherapy.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.radiotherapy.model.User;

public class PasswordHelper {
	private static final String algorithmName = "md5";
	private static final int hashIterations = 16;
	
	public static void encryPassword(User user){
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getId() + user.getNumber());
		String newPassword = new SimpleHash(
				algorithmName,user.getPassword(),
				credentialsSalt,
				hashIterations).toHex();
		user.setPassword(newPassword);
	}
	
	public static String encryPassword(int id, String number, String psw){
		ByteSource credentialsSalt = ByteSource.Util.bytes(id + number);
		return new SimpleHash(algorithmName, psw, credentialsSalt, hashIterations).toHex();
	}
}
