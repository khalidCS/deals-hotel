package hotels;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HotelDeals implements Deals<Hotel> {
	private final String url = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
	public OfferInfo offerInfo;
	public UserInfo userInfo;
	public Offer offers;

	public ArrayList<Hotel> getDeals(HashMap<HotelParameters, String> map) throws Exception {
		HttpURLConnection con = createConnection();
		con.setRequestMethod("GET");
		Hotel[] hotels = new Gson().fromJson(getResponse(con.getInputStream()), HotelDeals.class).offers.Hotel;
		if (isEmptyMap(map))
			return new ArrayList<>(Arrays.asList(hotels));
		return filteredHotel(hotels, map);
	}

	private ArrayList<Hotel> filteredHotel(Hotel[] hotels, HashMap<HotelParameters, String> map) {
		ArrayList<Hotel> hotelList = new ArrayList<>();
		for (int i = 0; i < hotels.length; i++) {
			if (matchFilter(hotels[i], map))
				hotelList.add(hotels[i]);
		}
		if (hotelList.size() == 0)
			return null;
		return hotelList;
	}

	private boolean matchFilter(Hotel hotel, HashMap<HotelParameters, String> map) {
		return (map.get(HotelParameters.location).trim().equals("")
				|| map.get(HotelParameters.location).trim().equalsIgnoreCase(hotel.destination.shortName))
				&& (map.get(HotelParameters.minStartDate).equals("") || (Integer.parseInt(
						map.get(HotelParameters.minStartDate).split("-")[0]) == hotel.offerDateRange.travelStartDate[0]
						&& Integer.parseInt(map.get(HotelParameters.minStartDate)
								.split("-")[1]) == hotel.offerDateRange.travelStartDate[1]
						&& Integer.parseInt(map.get(HotelParameters.minStartDate)
								.split("-")[2]) == hotel.offerDateRange.travelStartDate[2]))
				&& (map.get(HotelParameters.maxStartDate).equals("") || (Integer.parseInt(
						map.get(HotelParameters.maxStartDate).split("-")[0]) == hotel.offerDateRange.travelEndDate[0]
						&& Integer.parseInt(map.get(HotelParameters.maxStartDate)
								.split("-")[1]) == hotel.offerDateRange.travelEndDate[1]
						&& Integer.parseInt(map.get(HotelParameters.maxStartDate)
								.split("-")[2]) == hotel.offerDateRange.travelEndDate[2]))
				&& (map.get(HotelParameters.lenghtOfStay).trim().equals("")
						|| Integer.parseInt(map.get(HotelParameters.lenghtOfStay)) == hotel.offerDateRange.lengthOfStay)
				&& (map.get(HotelParameters.minStarRating).trim().equals("")
						|| Double.parseDouble(map.get(HotelParameters.minStarRating)) >= Double
								.parseDouble(hotel.hotelInfo.hotelStarRating))
				&& (map.get(HotelParameters.MaxStarRating).trim().equals("")
						|| Double.parseDouble(map.get(HotelParameters.MaxStarRating)) <= Double
								.parseDouble(hotel.destination.shortName))
				&& (map.get(HotelParameters.minTotalRate).trim().equals("") || Double.parseDouble(
						map.get(HotelParameters.minTotalRate)) <= (Double.parseDouble(hotel.hotelInfo.hotelStarRating)
								+ hotel.hotelInfo.hotelGuestReviewRating))
				&& (map.get(HotelParameters.maxTotalRate).trim().equals("") || Double.parseDouble(
						map.get(HotelParameters.maxTotalRate)) <= (Double.parseDouble(hotel.hotelInfo.hotelStarRating)
								+ hotel.hotelInfo.hotelGuestReviewRating))
				&& (map.get(HotelParameters.minGuestRate).trim().equals("") || Double
						.parseDouble(map.get(HotelParameters.minGuestRate)) <= hotel.hotelInfo.hotelGuestReviewRating)
				&& (map.get(HotelParameters.maxGuestRate).trim().equals("") || Double
						.parseDouble(map.get(HotelParameters.maxGuestRate)) >= hotel.hotelInfo.hotelGuestReviewRating);
	}

	private boolean isEmptyMap(HashMap<HotelParameters, String> map) {
		return map == null || (isNullOrEmpty(map.get(HotelParameters.location))
				&& isNullOrEmpty(map.get(HotelParameters.minStartDate))
				&& isNullOrEmpty(map.get(HotelParameters.maxStartDate))
				&& isNullOrEmpty(map.get(HotelParameters.lenghtOfStay))
				&& isNullOrEmpty(map.get(HotelParameters.minStarRating))
				&& isNullOrEmpty(map.get(HotelParameters.MaxStarRating))
				&& isNullOrEmpty(map.get(HotelParameters.minTotalRate))
				&& isNullOrEmpty(map.get(HotelParameters.maxTotalRate))
				&& isNullOrEmpty(map.get(HotelParameters.minGuestRate))
				&& isNullOrEmpty(map.get(HotelParameters.maxGuestRate)));
	}

	private boolean isNullOrEmpty(String string) {
		return string == null || string.trim().equals("");
	}

	private String getResponse(InputStream inputStream) throws IOException {
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer response = new StringBuffer();
		String inputLine;
		while ((inputLine = bufferReader.readLine()) != null) {
			response.append(inputLine);
		}
		bufferReader.close();
		return response.toString();
	}

	private HttpURLConnection createConnection() throws IOException, MalformedURLException {
		return (HttpURLConnection) new URL(url).openConnection();
	}

	public class Offer {
		public Hotel[] Hotel;
	}

	public class OfferInfo {
		public String siteID;
		public String language;
		public String currency;
		public String userSelectedCurrency;
	}

	public class UserInfo {
		public Persona persona;
		public String userId;
	}

	public class Persona {
		public String personaType;
	}
}