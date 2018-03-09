package hotels;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class HotelDealsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("hotel", new HotelDeals().getDeals(getParameters(req)));
			req.getRequestDispatcher("hotel.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();// should render to error page
		}
	}

	private HashMap<HotelParameters, String> getParameters(HttpServletRequest req) {
		HashMap<HotelParameters, String> map = new HashMap();
		map.put(HotelParameters.location, req.getParameter("location"));
		map.put(HotelParameters.minStartDate, req.getParameter("minStartDate"));
		map.put(HotelParameters.maxStartDate, req.getParameter("maxStartDate"));
		map.put(HotelParameters.lenghtOfStay, req.getParameter("lenghtOfStay"));
		map.put(HotelParameters.minStarRating, req.getParameter("minStarRating"));
		map.put(HotelParameters.MaxStarRating, req.getParameter("MaxStarRating"));
		map.put(HotelParameters.minTotalRate, req.getParameter("minTotalRate"));
		map.put(HotelParameters.maxTotalRate, req.getParameter("maxTotalRate"));
		map.put(HotelParameters.minGuestRate, req.getParameter("minGuestRate"));
		map.put(HotelParameters.maxGuestRate, req.getParameter("maxGuestRate"));
		return map;
	}
}
