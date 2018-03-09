<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<link rel="stylesheet" href="bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="bootstrap-grid.min.css">
<link rel="stylesheet" type="text/css" href="bootstrap-reboot.min.css">
<link rel="stylesheet" type="text/css" href="hotel.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>
<script src="popper.min.js"></script>

<%@ page import="hotels.*"%>
<%@ page import="java.util.ArrayList" %>
<title>Hotel</title>
</head>
<body style="background-color: rgba(240, 248, 255, 0.5)">

	<div class="form-group">
		<form class="form-control textCenter" action="hotel" method="get">
			<input class="add" placeholder="Location" type="text" name="location"
				id="location"><input class="add" type="date"
				name="minStartDate" id="minStartDate"><input class="add"
				type="date" name="maxStartDate" id="maxStartDate"><input
				class="add" placeholder="lenght of stay" type="number"
				name="lenghtOfStay" id="lenghtOfStay"><input class="add"
				placeholder="min star rating" type="number" name="minStarRating"
				id="minStarRating"><input class="add"
				placeholder="max star rating" type="number" name="MaxStarRating"
				id="MaxStarRating"><input class="add"
				placeholder="min total rate" type="number" name="minTotalRate"
				id="minTotalRate"><input class="add"
				placeholder="max total rate" type="number" name="maxTotalRate"
				id="maxTotalRate"><input class="add"
				placeholder="min guest rate" type="number" name="minGuestRate"
				id="minGuestRate"><input class="add"
				placeholder="max guest rate" type="number" name="maxGuestRate"
				id="maxGuestRate"> <input
				class="textcolor btn btn-primary button" type="submit"
				value="search">
		</form>
	</div>
	<br>

	<%
		if (request.getAttribute("hotel") != null) {
	%>
	<table style="margin-left: 10%" width="80%"
		class="table-striped table-hover">
		<tr>
			<th bgcolor="#b2b2b2" height="40px">Image</th>
			<th bgcolor="#b2b2b2" height="40px">Hotel Name</th>
			<th bgcolor="#b2b2b2" height="40px">Hotel Location</th>
			<th bgcolor="#b2b2b2" height="40px">Hotel Price Per Night</th>
		</tr>
		<%
			ArrayList<Hotel> hotels = (ArrayList<Hotel>) request.getAttribute("hotel");
				for (int i = 0; i < hotels.size(); i++) {
		%>
		<tr>
			<td height="40px" class="textCenter"><img
				src="<%=hotels.get(i).hotelInfo.hotelImageUrl%>"
				style="width: 100px; height: 100px;"></td>
			<td height="40px" class="textCenter"><%=hotels.get(i).hotelInfo.hotelName%></td>
			<td height="40px" class="textCenter"><%=hotels.get(i).destination.shortName%>
				, <%=hotels.get(i).destination.province%></td>
			<td height="40px" class="textCenter"><%=hotels.get(i).hotelPricingInfo.originalPricePerNight%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
	%>
	<p>Sorry we could not find any result that match your search,
		please search for another one.</p>
	<%
		}
	%>

</body>
</html>