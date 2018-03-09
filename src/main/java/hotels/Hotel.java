package hotels;

public class Hotel {
	public Destination destination;
	public OfferDateRange offerDateRange;
	public HotelInfo hotelInfo;
	public HotelPricingInfo hotelPricingInfo;
	public HotelUrls hotelUrls;

	public class Destination {
		public String regionID;
		public String associatedMultiCityRegionId;
		public String longName;
		public String shortName;
		public String country;
		public String province;
		public String city;
		public String tla;
		public String nonLocalizedCity;
	}

	public class OfferDateRange {
		public int[] travelStartDate;
		public int[] travelEndDate;
		public int lengthOfStay;
	}

	public class HotelInfo {
		public String hotelId;
		public String hotelName;
		public String localizedHotelName;
		public String hotelDestination;
		public String hotelDestinationRegionID;
		public String hotelLongDestination;
		public String hotelStreetAddress;
		public String hotelCity;
		public String hotelProvince;
		public String hotelCountryCode;
		public double hotelLatitude;
		public double hotelLongitude;
		public String hotelStarRating;
		public double hotelGuestReviewRating;
		public int hotelReviewTotal;
		public String hotelImageUrl;
		public boolean vipAccess;
		public boolean isOfficialRating;
	}

	public class HotelPricingInfo {
		public double averagePriceValue;
		public double totalPriceValue;
		public double crossOutPriceValue;
		public double originalPricePerNight;
		public String currency;
		public double percentSavings;
		public boolean drr;
	}

	public class HotelUrls {
		public String hotelInfositeUrl;
		public String hotelSearchResultUrl;
	}

}
