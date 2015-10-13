package com.persistent.swapnil.util;

public class LinguisticOptimizer {

	private static final String[] stopCharacter = {".", ",", ";", "\"", "(", ")", "'s"};
	private static final Porter porter = new Porter();
	
	public static String processToken(String token) {
		
		// 658 Terms Indexed
		// return processTokenSimple(token);
		
		// 648 Terms Indexed
		return processTokenOptimised(token);
	}

	private static String processTokenSimple(String token) {
		token = token.toLowerCase();
		for (String string : stopCharacter) {
			token = token.replace(string, "");
		}
		return token;
	}
	
	private static String processTokenOptimised(String token) {
		return porter.stripAffixes(token);
	}
	
	public static String procesLine(String line) {
		// line = line.replaceAll("-", " ");
		line = line.replaceAll("\\s+", " ").trim();
		return line;
	}
}
