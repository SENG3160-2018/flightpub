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
        <p class="h5 text-white">You did it...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 100%;" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">100%</div>
        </div>
    </div>
</div>
<div id="confirmation" class="container mt-5">
    <div class="container">
        <p class="h4">Booking Successful.</p>

        <p class="h6 pt-5">Confirmation ID: <span class="caption">123456789</span></p>
        <p>Enter your details below to send this confirmation and ticket information to an email address.</p>
    </div>
    <div class="container mt-5">
        <form>
            <div class="row justify-content-center">
                <div class="col-6">
                    <p class="h6">Email confirmation receipt:</p>
                    <div class="form-group">
                        <label for="name">Recipient Name</label>
                        <input type="text" class="form-control" id="name" aria-describedby="nameHelp" placeholder="Enter name">
                        <small id="nameHelp" class="form-text text-muted">The name of the person receiving this receipt.</small>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form-group">
                        <label for="email">Recipient Email</label>
                        <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">The email address of the person receiving this receipt.</small>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <button type="submit" class="btn btn-primary float-right">Send</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>