package com.persistent.swapnil.batch;

import com.persistent.swapnil.indexer.DocumentIndexer;

public class IndexerBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String documentPath = "/home/swapper/Programming_Data.txt";
		DocumentIndexer.index(documentPath);
	}	
}
