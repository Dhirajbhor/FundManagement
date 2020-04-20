package com.dao;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class ToolsDao {
	
	public static String generateTokan() {
		int length = 12;
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdeghijklmnopqrstuvwxyz";
		
		StringBuilder sb = new StringBuilder(length);
		
		for(int i=0;i<length;i++) {
			int j =(int) Math.abs(Math.random()*letters.length());
			sb.append(letters.charAt(j));
		}
		
		String tokan = sb.toString();
		return tokan;
	}
	
	 public static String generatePassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	    {
	        int iterations = 1000;
	        char[] chars = password.toCharArray();
	        byte[] salt = getSalt();
	         
	        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        byte[] hash = skf.generateSecret(spec).getEncoded();
	        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
	    }
	     
	    private static byte[] getSalt() throws NoSuchAlgorithmException
	    {
	        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	        byte[] salt = new byte[16];
	        sr.nextBytes(salt);
	        return salt;
	    }
	     
	    private static String toHex(byte[] array) throws NoSuchAlgorithmException
	    {
	        BigInteger bi = new BigInteger(1, array);
	        String hex = bi.toString(16);
	        int paddingLength = (array.length * 2) - hex.length();
	        if(paddingLength > 0)
	        {
	            return String.format("%0"  +paddingLength + "d", 0) + hex;
	        }else{
	            return hex;
	        }
	    }
	    
	    
	    public static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException
	    {
	        String[] parts = storedPassword.split(":");
	        int iterations = Integer.parseInt(parts[0]);
	        byte[] salt = fromHex(parts[1]);
	        byte[] hash = fromHex(parts[2]);
	         
	        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        byte[] testHash = skf.generateSecret(spec).getEncoded();
	         
	        int diff = hash.length ^ testHash.length;
	        for(int i = 0; i < hash.length && i < testHash.length; i++)
	        {
	            diff |= hash[i] ^ testHash[i];
	        }
	        return diff == 0;
	    }
	    
	    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
	    {
	        byte[] bytes = new byte[hex.length() / 2];
	        for(int i = 0; i<bytes.length ;i++)
	        {
	            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	        }
	        return bytes;
	    }
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
	
		String password = ToolsDao.generatePassword("Gamedhiraj@123");
		System.out.println(ToolsDao.validatePassword("Gamedhiraj@123", password));
		String tokan = generateTokan();
		//System.out.print(tokan);
		
	}

}
