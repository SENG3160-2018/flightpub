<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 8/6/18
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/includes/head.jsp" %>

<div class="container">
    <div id="progress" class="container p-5"  style="background-image: url('../../assets/clouds.jpeg')">
        <p class="h3 text-white">Experience review.</p>
    </div>
</div>
<div id="review-experience" class="container mt-5">
    <form>
        <div class="row">
            <div class="col">
                <label for="question-1">Would you recommend this flight to other couples?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <select class="form-control" id="question-1">
                        <option value="5">Absolutely</option>
                        <option value="4">Likely</option>
                        <option value="3">Not Sure</option>
                        <option value="2">Unlikely</option>
                        <option value="1">Never</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label for="question-2">Did you find our recommendations helpful?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <select class="form-control" id="question-2">
                        <option value="5">Absolutely</option>
                        <option value="4">Likely</option>
                        <option value="3">Not Sure</option>
                        <option value="2">Unlikely</option>
                        <option value="1">Never</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label for="question-3">How important were the stopovers in your trip?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <select class="form-control" id="question-3">
                        <option value="5">Absolutely</option>
                        <option value="4">Likely</option>
                        <option value="3">Not Sure</option>
                        <option value="2">Unlikely</option>
                        <option value="1">Never</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label for="question-4">Would you travel with this carrier again?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <select class="form-control" id="question-4">
                        <option value="5">Absolutely</option>
                        <option value="4">Likely</option>
                        <option value="3">Not Sure</option>
                        <option value="2">Unlikely</option>
                        <option value="1">Never</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <button type="submit" class="btn btn-primary float-right">Submit</button>
            </div>
        </div>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>
