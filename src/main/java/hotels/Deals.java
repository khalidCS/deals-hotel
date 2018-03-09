package hotels;

import java.util.ArrayList;
import java.util.HashMap;

public interface Deals<T> {
	public ArrayList<T> getDeals(HashMap<HotelParameters, String> map) throws Exception;
}
