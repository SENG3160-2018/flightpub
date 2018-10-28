<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 6/5/18
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/jsp/includes/head.jsp" %>

<%--<script>--%>
    <%--$(document).ready(function() {--%>
        <%--var max_fields      = 3;--%>
        <%--var wrapper         = $(".addEmail");--%>
        <%--var add_button      = $(".add_form_field");--%>

        <%--var x = 1;--%>
        <%--$(add_button).click(function(e){--%>
            <%--e.preventDefault();--%>
            <%--if(x < max_fields){--%>
                <%--x++;--%>
                <%--$(wrapper).append('<td><input name="email'+ x +'" placeholder="Enter Friend\'s email"/>' +--%>
                    <%--'\n' +--%>
                    <%--'                <a href="#" class="delete">Remove</a></div>'); //add input box--%>

            <%--}--%>
            <%--else--%>
            <%--{--%>
                <%--alert('Maximum number of Friends!')--%>
            <%--}--%>
        <%--});--%>

        <%--$(wrapper).on("click",".delete", function(e){--%>
            <%--e.preventDefault(); $(this).parent('div').remove(); x--;--%>
        <%--})--%>

    <%--});--%>
<%--</script>--%>

<div class="container">
    <div id="progress" class="container p-5"  style="background-image: url('../../assets/clouds.jpeg')">
        <p class="h5 text-white">So close...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">75%</div>
        </div>
    </div>
</div>
<div id="checkout" class="container mt-5">
    <s:form action="confirmation" method="POST" theme="simple" cssClass="needs-validation" id="checkout-form">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Departure Time</th>
                                <th scope="col">Arrival Time</th>
                                <th scope="col">Departure City</th>
                                <th scope="col">Cabin Class</th>
                                <th scope="col">Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="%{#session.CART}" var="flight" status="itStatus">
                                <tr>
                                    <td scope="row">
                                        <fmt:formatDate value="${departureTime}" pattern="dd/MM/YY HH:mm" />
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${arrivalTime}" pattern="dd/MM/YY HH:mm" />
                                    </td>
                                    <td>${flight.departure}</td>
                                    <td>${price.classCode}</td>
                                    <td>
                                        <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="$"/>
                                    </td>
                                    <td>
                                        <a href="<s:url action="removeCartCO">
                                        <s:param name="flightCt2">${itStatus.count}</s:param>
                                        </s:url>">Remove from Cart</a>
                                    </td>
                                    <c:if test="${userType.equals('group')}">
                                        <td>
                                            <a href="<s:url action="share">
                                            <s:param name="flightCt2">${itStatus.count}</s:param>
                                            </s:url>">Share with a Friend</a>
                                        </td>
                                    </c:if>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
                <div class="col-12"><c:if test="${session.SHARE!=null}"><h2>Share Flights</h2></c:if>
                    <table class="table table-hover">
                        <thead><c:if test="${session.SHARE!=null}">
                            <tr>
                                <th scope="col">Departure Time</th>
                                <th scope="col">Arrival Time</th>
                                <th scope="col">Departure City</th>
                                <th scope="col">Cabin Class</th>
                                <th scope="col">Price</th>
                            </tr></c:if>
                        </thead>
                        <tbody>
                            <s:iterator value="%{#session.SHARE}" var="flight" status="itStatus">
                                <tr>
                                    <td scope="row">
                                        <fmt:formatDate value="${departureTime}" pattern="dd/MM/YY HH:mm" />
                                    </td>
                                    <td>${flight.departure}</td>
                                    <td>
                                        <fmt:formatDate value="${arrivalTime}" pattern="dd/MM/YY HH:mm" />
                                    </td>
                                    <td>${price.classCode}</td>
                                    <td>
                                        <fmt:formatNumber value="${totalPrice}" type="currency" currencySymbol="$"/>
                                    </td>
                                    <div class="addEmail">
                                        <td>
                                            <input name="email1" placeholder="Enter Friend's email"/>
                                        </td>
                                    </div>
                                    <%--<td><button class="add_form_field">Add another email&nbsp; <span style="font-size:16px; font-weight:bold;">+ </span></button></td>--%>
                                    <td>
                                        <a href="<s:url action="emailFriend"><s:param name="flightCt3">${itStatus.count}</s:param></s:url>">Email Friends</a>
                                    </td>
                                    <td>
                                        <a href="<s:url action="undo"></s:url>">Undo</a>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
                <div class="col-6 mt-5">
                    <h1>Payment Details</h1>
                    <div class="form-group">
                        <label for="card_number">Card Number</label>
                        <input type="text" name="card_number" class="form-control" id="card_number" placeholder="Card Number" required>
                        <div class="invalid-feedback">
                            Invalid card number.
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="expiry">Expiry</label>
                        <input type="text" name="expiry" class="form-control" id="expiry" required>
                        <div class="invalid-feedback">
                            Invalid expiry.
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ccv">CCV</label>
                        <input type="text" name="ccv" class="form-control" id="ccv" placeholder="CCV" required>
                        <div class="invalid-feedback">
                            Invalid CCV.
                        </div>
                    </div>

                    <c:set var="total" value="${0}"/>
                    <s:iterator value="%{#session.CART}" var="flight">
                        <c:set var="total" value="${total + totalPrice}" />
                    </s:iterator>
                    <button type="submit" class="btn btn-primary btn-block">Pay <fmt:formatNumber value="${total}" type="currency" currencySymbol="$"/></button>
                </div>
            </div>
        </div>
    </s:form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>