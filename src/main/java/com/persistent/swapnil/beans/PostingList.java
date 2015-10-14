package com.persistent.swapnil.beans;

import java.util.List;

public class PostingList {

	private Long lineNumber;
	private List<Integer> positions;
	private Integer termLineFrequency;
	
	public PostingList() {

	}

	public PostingList(Long lineNumber, List<Integer> positions) {
		this.lineNumber = lineNumber;
		this.positions = positions;
		termLineFrequency = positions.size();
	}
	
	public Long getLineNumber() {
		return lineNumber;
	}
	public Integer getTermLineFrequency() {
		return termLineFrequency;
	}
	public List<Integer> getPositions() {
		return positions;
	}

	@Override
	public String toString() {
		return "PostingList [lineNumber=" + lineNumber + ", positions="
				+ positions + ", termLineFrequency=" + termLineFrequency + "]";
	}
	
	
}
