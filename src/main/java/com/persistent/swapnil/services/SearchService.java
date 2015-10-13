package com.persistent.swapnil.services;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.persistent.swapnil.beans.PostingList;
import com.persistent.swapnil.beans.SearchResult;
import com.persistent.swapnil.util.LinguisticOptimizer;

public class SearchService {

	private IndexerService indexerService;
	private ArrayListMultimap<String, PostingList> dictionary;

	public SearchResult search(String query, long time) {
		SearchResult result = null;
		dictionary = indexerService.getDictionary();
		
		if (dictionary == null || dictionary.isEmpty()) {
			System.err.println("No Indexes to search for");
		} else {
			System.out.println("Original Query : " + query);
			query = LinguisticOptimizer.processToken(query);
			System.out.println("Query after Linguistic Operations : " + query);
			List<PostingList> postingList = indexerService.getDictionary().get(query);
			time = System.nanoTime() - time;
			result = new SearchResult(query, postingList, time);
		}
		return result;
	}

	public IndexerService getIndexerService() {
		return indexerService;
	}

	public void setIndexerService(IndexerService indexerService) {
		this.indexerService = indexerService;
	}

}
