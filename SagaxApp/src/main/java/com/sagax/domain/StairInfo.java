package com.sagax.domain;

import javax.inject.Inject;
import javax.validation.constraints.Size;

import org.apache.log4j.Logger;

import com.sagax.service.business.StairsServiceJson;

public class StairInfo {
	
	@Inject
	private static final Logger LOGGER = Logger.getLogger(StairsServiceJson.class);
	
	private final int minStepsInStride = 1;
	private final int maxStepsInStride = 4;
	
	@Size(min = minStepsInStride, max = maxStepsInStride)
	int stepsInStride;
	
	private final int minStepsInFlight = 1;
	private final int maxStepsInFlight = 20;
	private final int minFlights = 1;
	private final int maxFlights = 30;
	@Size(min = minFlights, max = maxFlights)
	int[] stepsPerFlight;
	
	private final int stridesPerLanding = 2;
	
	public StairInfo()
	{
		
	}
	
	public StairInfo(int stepsInStride, int[] stepsPerFlight)
	{
		this.stepsInStride = stepsInStride;
		this.stepsPerFlight = stepsPerFlight;	
	}

	public int getStepsInStride() {
		return stepsInStride;
	}

	public void setStepsInStride(int stepsInStride) {
		this.stepsInStride = stepsInStride;
	}

	public int[] getStepsPerFlight() {
		return stepsPerFlight;
	}

	public void setStepsPerFlight(int[] stepsPerFlight) {
		this.stepsPerFlight = stepsPerFlight;
	}
	
	public int getStridesPerLanding() {
		return stridesPerLanding;
	}
	
	public void applyConstraints()
	{
		if(stepsInStride > maxStepsInStride) stepsInStride = maxStepsInStride;
		else if(stepsInStride < minStepsInStride) stepsInStride = minStepsInStride;
		
		int newArraySize;
		if(stepsPerFlight.length > maxFlights) newArraySize = maxFlights;
		else newArraySize = stepsPerFlight.length;
		int[] constrainedArray = new int[newArraySize];
		for(int i = 0; i < stepsPerFlight.length && i < newArraySize; i++)
		{ 
			if(stepsPerFlight[i] > maxStepsInFlight)constrainedArray[i] = maxStepsInFlight;
			else if(stepsPerFlight[i] < minStepsInFlight)constrainedArray[i] = minStepsInFlight;
			else constrainedArray[i] = stepsPerFlight[i];
		}
		stepsPerFlight = constrainedArray;
	}
	
	public void logFlightsInfo()
	{
		LOGGER.info("flight steps:");
		for(int steps : stepsPerFlight)
		{
			LOGGER.info(steps);
		}
	}
}
