<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: joelp
  Date: 1/09/2018
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/includes/head.jsp" %>

<div class="container">
    <div id="progress" class="container p-5">
        <p class="h5 text-white">You're almost there...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">50%</div>
        </div>
    </div>
</div>
<div id="results" class="container mt-5">
    <p class="h4">Results.</p>
    <s:form action="checkout">
    <table class="table table-hover">
        <thead>
        <tr>
            <th/>
            <th scope="col">Departure Time</th>
            <th scope="col">Arrival Time</th>
            <th scope="col">Departure City</th>
            <th scope="col">Arrival City</th>
            <th scope="col">Cabin Class</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
            <s:iterator value="flights">
            <tr>
                <td><s:hidden><s:property value="id"/></s:hidden> </td>
                <td><s:property value="departureTime"/></td>
                <td><s:property value="arrivalTime"/></td>
                <td><s:property value="departureCode"/></td>
                <td><s:property value="destinationCode"/></td>
                <td></td>
                <td><s:submit name="cart" value="Add to Cart"/></td>

            </tr>
            </s:iterator>
        </tbody>
    </table>
    </s:form>
</div>