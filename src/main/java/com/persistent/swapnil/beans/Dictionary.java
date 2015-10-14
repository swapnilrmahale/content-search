package com.persistent.swapnil.beans;

import java.util.List;
import java.util.Map;

public class Dictionary {

	private Map<String, List<PostingList>> dictionary;
	
	public Dictionary() {
	}
	
	public Map<String, List<PostingList>> getDictionary() {
		return dictionary;
	}
	public void setDictionary(Map<String, List<PostingList>> dictionary) {
		this.dictionary = dictionary;
	}
}
