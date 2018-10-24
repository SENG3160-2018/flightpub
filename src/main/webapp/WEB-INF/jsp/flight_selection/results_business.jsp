<%--
  Created by IntelliJ IDEA.
  User: joelp
  Date: 1/09/2018
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/jsp/includes/head.jsp" %>

<div class="container">
    <div id="progress" class="container p-5" style="background-image: url('../../assets/clouds.jpeg')">
        <p class="h5 text-white">You're almost there...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">50%</div>
        </div>
    </div>
</div>
<div><br /></div>
<s:if test="hasActionMessages()">
    <div class="message fadeOut">
        <s:actionmessage/>
    </div>
</s:if>
<s:if test="hasActionErrors()">
    <div class="errors fadeOut">
        <s:actionerror/>
    </div>
</s:if>
<div id="results" class="container mt-5">
    <div class="row">
        <div class="col">
            <p class="h4">Results.</p>
            <p class="h5">Date: <fmt:formatDate value="${date}" pattern="dd/MM/YY" /></p>

            <table class="table table-hover table-striped datatable">
                <thead>
                <tr>
                    <th scope="col">Departure Time</th>
                    <th scope="col">Arrival Time</th>
                    <th scope="col">Departure City</th>
                    <th scope="col">Flights</th>
                    <th scope="col">Arrival City</th>
                    <th scope="col">Cabin Class</th>
                    <th scope="col">Price</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="flights" var="flight">
                    <tr>
                        <td>
                            <fmt:formatDate value="${departureTime}" pattern="HH:mm" />
                        </td>
                        <td>
                            <fmt:formatDate value="${arrivalTime}" pattern="HH:mm" />
                        </td>
                        <td>${flight.departure}</td>
                        <td>${totalLegs}</td>
                        <td>${dstCode}</td>
                        <td>${price.classCode}</td>
                        <td>
                            <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="$"/>
                        </td>
                        <td class="text-white">
                            <a href="<s:url action="addToCart">
                                <s:param name="flightId" value="%{id}" />
                                <s:param name="airline" value="%{price.airlineCode}" />
                                <s:param name="tcktClass" value="%{price.classCode}" />
                                <s:param name="tcktType" value="%{price.ticketCode}" />
                                <s:param name="flightNumber" value="%{flightNumber}" />
                            </s:url>" role="button" class="btn btn-primary btn-sm float-right">Add to Cart</a>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
    <a role="button" class="btn btn-secondary" href="<s:url action='search' >
                        <s:param name='userType' value='userType' />
                    </s:url>">Back to Search</a>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>
