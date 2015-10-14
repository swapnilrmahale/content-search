package com.persistent.swapnil.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="index", method=RequestMethod.GET)
	@ResponseBody
	public long index(@RequestParam(value="path") String path) {
		return searchService.getIndexerService().index(path);
	}
	
	public SearchService getSearchService() {
		return searchService;
	}
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
}
