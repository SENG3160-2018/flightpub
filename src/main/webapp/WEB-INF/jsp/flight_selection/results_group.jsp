<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 6/5/18
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
    <div class="row">
        <div class="col-8">
            <p class="h4">Results.</p>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Price</th>
                    <th scope="col">Departure City</th>
                    <th scope="col">Arrival City</th>
                    <th scope="col">Cabin Class</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td scope="row">$150</td>
                    <td>Newcastle</td>
                    <td>Sydney</td>
                    <td>Business Class</td>
                    <td class="text-white">
                        <a href="<s:url action="checkout" />" role="button" class="btn btn-primary btn-sm float-right">Add to Cart</a>
                        <a href="<s:url action="checkout" />" role="button" class="btn btn-success btn-sm float-right">Express Checkout</a>
                    </td>
                </tr>
                <tr>
                    <td scope="row">$150</td>
                    <td>Newcastle</td>
                    <td>Sydney</td>
                    <td>Business Class</td>
                    <td class="text-white">
                        <a href="<s:url action="checkout" />" role="button" class="btn btn-primary btn-sm float-right">Add to Cart</a>
                        <a href="<s:url action="checkout" />" role="button" class="btn btn-success btn-sm float-right">Express Checkout</a>
                    </td>
                </tr>
                <tr>
                    <td scope="row">$150</td>
                    <td>Newcastle</td>
                    <td>Sydney</td>
                    <td>Business Class</td>
                    <td class="text-white">
                        <a href="<s:url action="checkout" />" role="button" class="btn btn-primary btn-sm float-right">Add to Cart</a>
                        <a href="<s:url action="checkout" />" role="button" class="btn btn-success btn-sm float-right">Express Checkout</a>
                    </td>
                </tr>
                <tr>
                    <td scope="row">$150</td>
                    <td>Newcastle</td>
                    <td>Sydney</td>
                    <td>Business Class</td>
                    <td class="text-white">
                        <a href="<s:url action="checkout" />" role="button" class="btn btn-primary btn-sm float-right">Add to Cart</a>
                        <a href="<s:url action="checkout" />" role="button" class="btn btn-success btn-sm float-right">Express Checkout</a>
                    </td>
                </tr>
                </tbody>
            </table>
            <a role="button" class="btn btn-secondary" href="<s:url action='search' >
                        <s:param name='userType' value='userType' />
                    </s:url>">Back to Search</a>
        </div>
        <div class="col-4">
            <%@ include file="/WEB-INF/jsp/recommendations/friends.jsp" %>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>
