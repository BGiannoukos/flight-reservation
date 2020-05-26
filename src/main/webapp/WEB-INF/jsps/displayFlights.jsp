<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Flights</title>
</head>
<body>
<h2>Flights:</h2>
<table>
<tr><th>Airlines</th>
<th>Departure City</th>
<th>Departure Time</th>
</tr>
<c:forEach items="${flights}" var="flight">
<c:url var="selectLink" value="showCompleteReservation">
<c:param name="flightId" value="${flight.id}"/>
</c:url>

<tr>
<td>${flight.operatingAirlines}</td>
<td>${flight.departureCity}</td>
<td>${flight.arrivalCity}</td>
<td>${flight.estimatedDepartureTime}</td>

<td>
<a href="${selectLink}">Select</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>