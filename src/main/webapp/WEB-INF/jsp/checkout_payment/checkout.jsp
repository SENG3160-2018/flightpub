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

<div class="container">
    <div id="progress" class="container p-5"  style="background-image: url('../../assets/clouds.jpeg')">
        <p class="h5 text-white">So close...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 75%;" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">75%</div>
        </div>
    </div>
</div>
<div id="checkout" class="container mt-5">
    <s:form action="confirmation" method="POST" theme="simple">
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
                            <s:iterator value="%{#session.CART}" var="flight">
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
                                        <fmt:formatNumber value="${price.price}" type="currency" currencySymbol="$"/>
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
                    </div>
                    <div class="form-group">
                        <label for="exp_month">Expiry Month</label>
                        <select name="exp_month" class="form-control" id="exp_month" required>
                            <option disabled selected value>-</option>
                            <option>Jan 01</option>
                            <option>Feb 02</option>
                            <option>Mar 03</option>
                            <option>Apr 04</option>
                            <option>May 05</option>
                            <option>Jun 06</option>
                            <option>Jul 07</option>
                            <option>Aug 08</option>
                            <option>Sep 09</option>
                            <option>Oct 10</option>
                            <option>Nov 11</option>
                            <option>Dec 12</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exp_year">Expiry Year</label>
                        <select name="exp_year" class="form-control" id="exp_year" required>
                            <option disabled selected value>-</option>
                            <option>2018</option>
                            <option>2019</option>
                            <option>2020</option>
                            <option>2021</option>
                            <option>2022</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="ccv">CCV</label>
                        <input type="text" name="ccv" class="form-control" id="ccv" placeholder="CCV" required>
                    </div>

                    <c:set var="total" value="${0}"/>
                    <s:iterator value="%{#session.CART}" var="flight">
                        <c:set var="total" value="${total + price.price}" />
                    </s:iterator>
                    <button type="submit" class="btn btn-primary btn-block">Pay <fmt:formatNumber value="${total}" type="currency" currencySymbol="$"/></button>
                </div>
            </div>
        </div>
    </s:form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>