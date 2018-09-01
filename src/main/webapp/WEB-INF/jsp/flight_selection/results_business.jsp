<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 6/5/18
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/includes/head.jsp" %>

<div class="container">
    <div id="progress" class="container p-5" style="background-image: url('../../assets/clouds.jpeg')">
        <p class="h5 text-white">You're almost there...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">50%</div>
        </div>
    </div>
</div>
<div id="results" class="container mt-5">
    <p class="h4">Results.</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Departure Time</th>
            <th scope="col">Arrival Time</th>
            <th scope="col">Departure City</th>
            <th scope="col">Arrival City</th>
            <th scope="col">Cabin Class</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="flight" items="${flights}">
            <tr>
                <td scope="row"> ${flight.departureTime} </td>
                <td>${flight.arrivalTime}</td>
                <td>depCity</td>
                <td>arrCity</td>
                <td>Business Class</td>
                <td class="text-white">
                    <a href="<s:url action="checkout" />" role="button" class="btn btn-primary btn-sm">Add to Cart</a>
                    <a href="<s:url action="checkout" />" role="button" class="btn btn-success btn-sm">Express Checkout</a>
                </td>
            </tr>
        </c:forEach>

        <c:forEach var="destination" items="${requestScope.destinations}">
            <option>${destination.airport} - ${destination.destinationCode}</option>
        </c:forEach>

        <tr>
            <td scope="row">09:00 am</td>
            <td>11:00 am</td>
            <td>Newcastle</td>
            <td>Sydney</td>
            <td>1 Class</td>
            <td class="text-white">
                <a href="<s:url action="checkout" />" role="button" class="btn btn-primary btn-sm">Add to Cart</a>
                <a href="<s:url action="checkout" />" role="button" class="btn btn-success btn-sm">Express Checkout</a>
            </td>
        </tr>
        <tr>
            <td scope="row">11:00 am</td>
            <td>1:00 pm</td>
            <td>Newcastle</td>
            <td>Sydney</td>
            <td>2 Class</td>
            <td class="text-white">
                <a href="<s:url action="checkout" />" role="button" class="btn btn-primary btn-sm">Add to Cart</a>
                <a href="<s:url action="checkout" />" role="button" class="btn btn-success btn-sm">Express Checkout</a>
            </td>
        </tr>
        </tbody>
    </table>
    <a role="button" class="btn btn-secondary" href="<s:url action='search' >
                        <s:param name='userType' value='userType' />
                    </s:url>">Back to Search</a>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>
