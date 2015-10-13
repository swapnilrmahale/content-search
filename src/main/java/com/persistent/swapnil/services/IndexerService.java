package com.persistent.swapnil.services;

import java.io.File;

import com.google.common.collect.ArrayListMultimap;
import com.persistent.swapnil.beans.PostingList;
import com.persistent.swapnil.util.DocumentIndexer;

public class IndexerService {

	private String staticCollection;
	private static ArrayListMultimap<String, PostingList> dictionary;

	static {
		dictionary = ArrayListMultimap.create();
	}
	
	public void index() {
		File location = new File(staticCollection);
		if (location.isDirectory()) {
			
			File[] documents = location.listFiles();
			if (documents.length == 0) {
				System.err.println("Not a single document at location " + staticCollection);
			}
			
			for (File file : documents) {
				dictionary.putAll(DocumentIndexer.index(file));
			}
			
		} else {
			System.err.println(staticCollection + " is not a directory");
		}
	}

	public String getStaticCollection() {
		return staticCollection;
	}
	public void setStaticCollection(String staticCollection) {
		this.staticCollection = staticCollection;
	}
	public ArrayListMultimap<String, PostingList> getDictionary() {
		return dictionary;
	}
}
