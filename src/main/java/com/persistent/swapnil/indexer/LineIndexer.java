package com.persistent.swapnil.indexer;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ArrayListMultimap;

public class LineIndexer {

	public static ArrayListMultimap<String,Integer> getPositionalIndexes(String line) {
		if (StringUtils.isEmpty(line)) {
			// throw new Exception();
		}

		line = line.toLowerCase();
		line = line.replace(".", "");
		line = line.replace(".", "");
		line = line.replace("(", "");
		line = line.replace(")", "");
		line = line.replace(",", "");
		line = line.replace("\"", "");
		line = line.replace("'s", "");
		
		line = line.replaceAll("\\s+", " ").trim();		
		String[] tokens = line.split("\\s");
		
		ArrayListMultimap<String,Integer> positionalIndexes = createPositionalIndexes(tokens);
		
		return positionalIndexes;
	}

	private static ArrayListMultimap<String,Integer> createPositionalIndexes(String[] tokens) {
		ArrayListMultimap<String,Integer> positionalIndexes =  ArrayListMultimap.create();
		
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i].trim();
			positionalIndexes.put(token, (i+1));
		}
		return positionalIndexes;
	}
}
