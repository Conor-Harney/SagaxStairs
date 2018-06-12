package com.sagax.intergration;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import com.sagax.service.business.StairsService;
import com.sagax.service.business.StairsServiceJson;
import com.sagax.util.JSONUtil;

@Path("/stairs")
public class StrideCounterEndpoint {
	
	@Inject
	private JSONUtil util = new JSONUtil();
	
	@Inject
	private static final Logger LOGGER = Logger.getLogger(StrideCounterEndpoint.class);

	@Inject
	private StairsService service = new StairsServiceJson();

	@Path("/json")
	@POST
	@Produces({ "application/json"})
	public String getStrides(String stairData) {
		LOGGER.info("StrideCounterEndpoint: getStrides called");
		return util.getJSONForObject(service.countStrides(stairData));
	}
}
