package com.persistent.swapnil.main;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.persistent.swapnil.beans.PostingList;
import com.persistent.swapnil.indexer.DocumentIndexer;

@Path("/search")
public class IndexerService {

	@GET
	@Path("/info")
	public Response getInfo() { 
		String output = "This is the REST Service for Search";
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/index")
	public Response index() {
		IndexerBatch.index();
		return Response.status(200).entity("Indexing Completed...").build();
	}
	
	@GET
	public Response doSearch(@QueryParam(value = "query") String query) {
		List<PostingList> results = DocumentIndexer.getDictionary().get(query);
		return Response.status(200).entity(results.toString()).build();
	}

}
