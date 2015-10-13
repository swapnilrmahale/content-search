package com.persistent.swapnil.beans;

import java.util.List;

public class SearchResult {

	private String query;
	private List<PostingList> postingList;
	private long elapsedTime;
	
	public SearchResult(String query, List<PostingList> postingList, long elapsedTime) {
		this.query = query;
		this.postingList = postingList;
		this.elapsedTime = elapsedTime;
	}
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public List<PostingList> getPostingList() {
		return postingList;
	}
	public void setPostingList(List<PostingList> postingList) {
		this.postingList = postingList;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	@Override
	public String toString() {
		return "SearchResult [query=" + query + ", postingList=" + postingList + ", elapsedTime=" + elapsedTime + "]";
	}
}
