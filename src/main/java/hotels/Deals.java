package hotels;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

public interface Deals<T> {
	public ArrayList<T> getDeals(HashMap<HotelParameters, String> map) throws Exception;
}
