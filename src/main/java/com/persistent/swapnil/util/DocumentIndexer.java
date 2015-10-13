package com.persistent.swapnil.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ArrayListMultimap;
import com.persistent.swapnil.beans.PostingList;

public class DocumentIndexer {

	public static ArrayListMultimap<String, PostingList> index(File document) {
		
		ArrayListMultimap<String, PostingList> dictionary = null;
		long lineNumber = 1;
		if (document.exists()) {
					
			try (BufferedReader br = new BufferedReader(new FileReader(document)))
			{
				String line;
				dictionary = ArrayListMultimap.create();
				
				while ((line = br.readLine()) != null) {
					ArrayListMultimap<String, Integer> positionalIndexes = createPositionalIndexes(line);
					Set<String> terms = positionalIndexes.keySet();
					for (String term : terms) {
						List<Integer> positions = positionalIndexes.get(term);
						dictionary.put(term, new PostingList(lineNumber, positions));
					}
					lineNumber++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		} else {
			System.err.println(document.getAbsolutePath() + " is not present");
		}
		System.out.println(dictionary.size() + " terms indexed");
		return dictionary;
	}
	
	private static ArrayListMultimap<String,Integer> createPositionalIndexes(String line) {
	
		line = LinguisticOptimizer.procesLine(line);
		String[] tokens = line.split("\\s");
		
		ArrayListMultimap<String,Integer> positionalIndexes = ArrayListMultimap.create();
		
		for (int i = 0; i < tokens.length; i++) {
			String token = LinguisticOptimizer.processToken(tokens[i]);
			if (!StringUtils.isEmpty(token))
				positionalIndexes.put(token, (i+1));
		}
		return positionalIndexes;
	}

}
