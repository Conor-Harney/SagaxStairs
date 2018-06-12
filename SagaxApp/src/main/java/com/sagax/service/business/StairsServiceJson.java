package com.sagax.service.business;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.sagax.domain.StairInfo;
import com.sagax.util.JSONUtil;

public class StairsServiceJson implements StairsService {
	
	@Inject
	private JSONUtil util = new JSONUtil();
	
	@Inject
	private static final Logger LOGGER = Logger.getLogger(StairsServiceJson.class);

	@Override
	public String countStrides(String stairData) {
		LOGGER.info("StairsServiceJson : countStrides called");
		StairInfo stairInfo = util.getObjectForJSON(stairData, StairInfo.class);
		stairInfo.applyConstraints();
		int landingCount = 0, strides = 0;
		for(int flightCount : stairInfo.getStepsPerFlight())
		{
			strides += countFligetStrides(flightCount, stairInfo.getStepsInStride());
			landingCount++;
		}
		landingCount--;
		strides += (landingCount * stairInfo.getStridesPerLanding());
		return Integer.toString(strides);
	}
	
	private int countFligetStrides(int steps, int maxStepsPerStride)
	{
		int strides = 0;
		while(steps > maxStepsPerStride)
		{
			strides++;
			steps -= maxStepsPerStride;
		}
		strides++;
		return strides;
	}
}
