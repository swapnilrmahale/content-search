package com.persistent.swapnil.ctrl;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.persistent.swapnil.beans.PostingList;
import com.persistent.swapnil.beans.SearchResult;
import com.persistent.swapnil.services.SearchService;

@Controller
@RequestMapping("/search")
public class SearchController {

	private SearchService searchService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public SearchResult search(@RequestParam(value="query") String query) {
		SearchResult result = getSearchService().search(query, System.nanoTime());
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="re-index", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Collection<PostingList>> index() {
		searchService.getIndexerService().index();
		return searchService.getIndexerService().getDictionary().asMap();
	}
	
	public SearchService getSearchService() {
		return searchService;
	}
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
}
