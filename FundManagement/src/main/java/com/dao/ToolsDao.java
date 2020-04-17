package com.dao;

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
	
	public static void main(String[] args) {
	
		String tokan = generateTokan();
		System.out.print(tokan);
		
	}

}
