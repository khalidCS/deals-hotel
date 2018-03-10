package deals;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import hotels.HotelDeals;
import hotels.HotelParameters;

public class HotelDealsTest {

	@Test
	public void getDealsWithNullMap() throws Exception {
		assertEquals(5, new HotelDeals().getDeals(null).size());
	}

	@Test
	public void getDealsWithEmptyMap() throws Exception {
		HashMap<HotelParameters, String> emotyMap = new HashMap();
		emotyMap.put(HotelParameters.location, "");
		emotyMap.put(HotelParameters.minStartDate, "");
		emotyMap.put(HotelParameters.maxStartDate, "");
		emotyMap.put(HotelParameters.lenghtOfStay, "");
		emotyMap.put(HotelParameters.minStarRating, "");
		emotyMap.put(HotelParameters.MaxStarRating, "");
		emotyMap.put(HotelParameters.minTotalRate, "");
		emotyMap.put(HotelParameters.maxTotalRate, "");
		emotyMap.put(HotelParameters.minGuestRate, "");
		emotyMap.put(HotelParameters.maxGuestRate, "");
		assertEquals(5, new HotelDeals().getDeals(emotyMap).size());
	}
	
	@Test
	public void getDealsWithValidLocationMap() throws Exception {
		HashMap<HotelParameters, String> validLocationMap = new HashMap();
		validLocationMap.put(HotelParameters.location, "miami");
		validLocationMap.put(HotelParameters.minStartDate, "");
		validLocationMap.put(HotelParameters.maxStartDate, "");
		validLocationMap.put(HotelParameters.lenghtOfStay, "");
		validLocationMap.put(HotelParameters.minStarRating, "");
		validLocationMap.put(HotelParameters.MaxStarRating, "");
		validLocationMap.put(HotelParameters.minTotalRate, "");
		validLocationMap.put(HotelParameters.maxTotalRate, "");
		validLocationMap.put(HotelParameters.minGuestRate, "");
		validLocationMap.put(HotelParameters.maxGuestRate, "");
		assertEquals(1, new HotelDeals().getDeals(validLocationMap).size());
	}
	
	@Test
	public void getDealsWithInvalidLocationMap() throws Exception {
		HashMap<HotelParameters, String> invalidLocationMap = new HashMap();
		invalidLocationMap.put(HotelParameters.location, "khalid");
		invalidLocationMap.put(HotelParameters.minStartDate, "");
		invalidLocationMap.put(HotelParameters.maxStartDate, "");
		invalidLocationMap.put(HotelParameters.lenghtOfStay, "");
		invalidLocationMap.put(HotelParameters.minStarRating, "");
		invalidLocationMap.put(HotelParameters.MaxStarRating, "");
		invalidLocationMap.put(HotelParameters.minTotalRate, "");
		invalidLocationMap.put(HotelParameters.maxTotalRate, "");
		invalidLocationMap.put(HotelParameters.minGuestRate, "");
		invalidLocationMap.put(HotelParameters.maxGuestRate, "");
		assertEquals(null, new HotelDeals().getDeals(invalidLocationMap));
	}
	
	@Test
	public void getDealsWithValidMinGuestRataAndMaxGuestRateMap() throws Exception {
		HashMap<HotelParameters, String> validMinGuestRataAndMaxGuestRate = new HashMap();
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.location, "");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.minStartDate, "");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.maxStartDate, "");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.lenghtOfStay, "");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.minStarRating, "");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.MaxStarRating, "");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.minTotalRate, "");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.maxTotalRate, "");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.minGuestRate, "0");
		validMinGuestRataAndMaxGuestRate.put(HotelParameters.maxGuestRate, "3");
		assertEquals(1, new HotelDeals().getDeals(validMinGuestRataAndMaxGuestRate).size());
	}
	
	@Test
	public void getDealsWithInvalidMinGuestRataAndMaxGuestRateMap() throws Exception {
		HashMap<HotelParameters, String> invalidMinGuestRataAndMaxGuestRate = new HashMap();
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.location, "");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.minStartDate, "");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.maxStartDate, "");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.lenghtOfStay, "");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.minStarRating, "");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.MaxStarRating, "");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.minTotalRate, "");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.maxTotalRate, "");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.minGuestRate, "10");
		invalidMinGuestRataAndMaxGuestRate.put(HotelParameters.maxGuestRate, "11");
		assertEquals(null, new HotelDeals().getDeals(invalidMinGuestRataAndMaxGuestRate));
	}
	
	@Test
	public void getDealsWithValidLocationAndMinGuestRataAndMaxGuestRateMap() throws Exception {
		HashMap<HotelParameters, String> validLocationAndMinGuestRataAndMaxGuestRate = new HashMap();
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.location, "miami");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.minStartDate, "");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.maxStartDate, "");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.lenghtOfStay, "");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.minStarRating, "");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.MaxStarRating, "");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.minTotalRate, "");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.maxTotalRate, "");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.minGuestRate, "0");
		validLocationAndMinGuestRataAndMaxGuestRate.put(HotelParameters.maxGuestRate, "3");
		assertEquals(1, new HotelDeals().getDeals(validLocationAndMinGuestRataAndMaxGuestRate).size());
	}
	
	@Test
	public void getDealsWithInvalidLocationAndValidMinGuestRataAndMaxGuestRateMap() throws Exception {
		HashMap<HotelParameters, String> invalidLocationAndValidMinGuestRataAndMaxGuestRate = new HashMap();
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.location, "khalid");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.minStartDate, "");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.maxStartDate, "");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.lenghtOfStay, "");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.minStarRating, "");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.MaxStarRating, "");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.minTotalRate, "");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.maxTotalRate, "");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.minGuestRate, "0");
		invalidLocationAndValidMinGuestRataAndMaxGuestRate.put(HotelParameters.maxGuestRate, "3");
		assertEquals(null, new HotelDeals().getDeals(invalidLocationAndValidMinGuestRataAndMaxGuestRate));
	}
}
