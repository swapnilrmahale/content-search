package com.persistent.swapnil.indexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.persistent.swapnil.beans.PostingList;

public class DocumentIndexer {

	private static ArrayListMultimap<String, PostingList> dictionary = null;
	
	public static void index(String documentPath) {
		
		long lineNumber = 1;
		if (documentPath == null) {
			//throw new Exception();
		}
		
		dictionary = ArrayListMultimap.create();
		
		try (BufferedReader br = new BufferedReader(new FileReader(documentPath)))
		{
			String line;

			while ((line = br.readLine()) != null) {
				ArrayListMultimap<String, Integer> positionalIndexes = LineIndexer.getPositionalIndexes(line);
				Set<String> terms = positionalIndexes.keySet();
				for (String term : terms) {
					List<Integer> positions = positionalIndexes.get(term);
					dictionary.put(term, new PostingList(lineNumber, positions));
				}
				lineNumber++;
			}
			System.out.println(dictionary);

		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
