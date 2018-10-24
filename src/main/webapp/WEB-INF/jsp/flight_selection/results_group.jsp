<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 6/5/18
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <c:if test="${not passengers.equals(cart.size())}">
    <div class="row">
        <div class="col">
            <p class="h4">Results.</p>
            <p class="h5">Date: <fmt:formatDate value="${date}" pattern="dd/MM/YY" /></p>

            <table class="table table-hover table-striped datatable">
                <thead>
                <tr>
                    <th scope="col">Departure Time</th>
                    <th scope="col">Departure City</th>
                    <th scope="col">Arrival Time</th>
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
                            <td>${flight.departure}</td>
                            <td>
                                <fmt:formatDate value="${arrivalTime}" pattern="HH:mm" />
                            </td>
                            <td>${flight.destination}</td>
                            <td>${price.classCode}</td>
                            <td scope="row">
                                <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="$"/>
                            </td>
                            <td class="text-white">
                                <a href="<s:url action="addToGroup">
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
</c:if>
    <div class="row mt-5">
        <div class="col">
            <%@ include file="/WEB-INF/jsp/recommendations/friends.jsp" %>
        </div>
    </div>
    <div class="row mt-5">
        <div class="col">
            <p class="h4">Cart Preview.</p>
            <table class="table table-hover table-striped">
                <thead>
                    <th scope="col">Departure Time</th>
                    <th scope="col">Departure City</th>
                    <th scope="col">Arrival Time</th>
                    <th scope="col">Arrival City</th>
                    <th scope="col">Cabin Class</th>
                    <th scope="col">Price</th>
                    <th scope="col"></th>
                </thead>
                <tbody>
                <s:iterator value="%{#session.CART}" var="flight" status="itStatus">
                    <tr>
                        <td scope="row">
                            <fmt:formatDate value="${departureTime}" pattern="HH:mm" />
                        </td>
                        <td scope="row">${flight.departure}</td>
                        <td scope="row">
                            <fmt:formatDate value="${arrivalTime}" pattern="HH:mm" />
                        </td>
                        <td scope="row">${flight.destination}</td>
                        <td scope="row">${price.classCode}</td>
                        <td scope="row">
                            <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="$"/>
                        </td>
                        <td>
                            <a href="<s:url action="removeCartSearch">
                                    <s:param name="flightCt">${itStatus.count}</s:param>
                                </s:url>">Remove from Cart</a>
                        </td>
                    </tr>
                </s:iterator>

                <c:set var="total" value="${0}"/>
                <s:iterator value="%{#session.CART}" var="flight">
                    <c:set var="total" value="${total + totalPrice}" />
                </s:iterator>
                <tr>
                    <td colspan="7">Current Total: <fmt:formatNumber value="${total}" type="currency" currencySymbol="$"/></td>
                </tr>
                <tr>
                    <td colspan="7">
                        <a href="<s:url action="groupCheckout"></s:url>" role="button" class="btn btn-primary btn-sm float-right">Proceed to Checkout</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <a role="button" class="btn btn-secondary" href="<s:url action='search' >
                        <s:param name='userType' value='userType' />
                    </s:url>">Back to Search</a>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>

<%--
<tr>
<td>Cart</td>
</tr>
<tr>
<th scope="col">Departure Time</th>
<th scope="col">Departure City</th>
<th scope="col">Arrival Time</th>
<th scope="col">Arrival City</th>
<th scope="col">Cabin Class</th>
<th scope="col">Price</th>
<th scope="col"></th>
</tr>
<s:iterator value="%{#session.CART}" var="flight" status="itStatus">
    <tr>
    <td scope="row">
    <fmt:formatDate value="${departureTime}" pattern="HH:mm" />
    </td>
    <td scope="row">${flight.departure}</td>
    <td scope="row">
    <fmt:formatDate value="${arrivalTime}" pattern="HH:mm" />
    </td>
    <td scope="row">${flight.destination}</td>
    <td scope="row">${price.classCode}</td>
    <td scope="row">
    <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="$"/>
    </td>
    <td>
    <a href="<s:url action="removeCartSearch">
    <s:param name="flightCt">${itStatus.count}</s:param>
</s:url>">Remove from Cart</a>
    </td>
    </tr>
</s:iterator>
<s:iterator value="flights" var="flight">
                        <tr>
                            <td scope="row">
                                <fmt:formatDate value="${departureTime}" pattern="HH:mm" />
                            </td scope="row">
                            <td scope="row">${flight.departure}</td>
                            <td scope="row">
                                <fmt:formatDate value="${arrivalTime}" pattern="HH:mm" />
                            </td>
                            <td scope="row">${flight.destination}</td>
                            <td scope="row">${price.classCode}</td>
                            <td scope="row">
                                <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="$"/>
                            </td>
                            <td class="text-white">
                                <a href="<s:url action="addToGroup">
                                <s:param name="flightId" value="%{id}" />
                                <s:param name="airline" value="%{price.airlineCode}" />
                                <s:param name="tcktClass" value="%{price.classCode}" />
                                <s:param name="tcktType" value="%{price.ticketCode}" />
                                <s:param name="flightNumber" value="%{flightNumber}" />
                            </s:url>" role="button" class="btn btn-primary btn-sm float-right">Add to Cart</a>
                            </td>
                        </tr>
                    </s:iterator>

                    <c:set var="total" value="${0}"/>
                    <s:iterator value="%{#session.CART}" var="flight">
                        <c:set var="total" value="${total + totalPrice}" />
                    </s:iterator>
                    <tr>
                        <td>Current Total: <fmt:formatNumber value="${total}" type="currency" currencySymbol="$"/></td>
                    </tr>
                    <tr>
                        <td><a href="<s:url action="groupCheckout"></s:url>" role="button" class="btn">Proceed to Checkout</a></td>
                    </tr>
--%>
