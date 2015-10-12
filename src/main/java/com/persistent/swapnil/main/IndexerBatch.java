package com.persistent.swapnil.main;

import com.persistent.swapnil.indexer.DocumentIndexer;

public class IndexerBatch {

	// private static final String DOCUMENT_PATH = "/home/swapper/Programming_Data.txt";
	private static final String DOCUMENT_PATH = "F:\\Swapnil\\labs\\Programming_Data.txt";
	
	public static void index() {
		System.out.println("Indexing Document...");
		DocumentIndexer.index(DOCUMENT_PATH);
	}
	
	public static void main(String[] args) {
		DocumentIndexer.index(DOCUMENT_PATH);
	}	
}
