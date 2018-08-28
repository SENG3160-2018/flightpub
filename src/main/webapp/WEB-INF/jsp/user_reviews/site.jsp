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
        <p class="h3 text-white">Site review.</p>
    </div>
</div>
<div id="review-site" class="container mt-5">
    <form>
        <div class="row">
            <div class="col">
                <label for="question-1">How easy is the sites UI to navigate?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <select class="form-control" id="question-1">
                        <option value="5">Very Easy</option>
                        <option value="4">Easy</option>
                        <option value="3">So so</option>
                        <option value="2">Difficult</option>
                        <option value="1">Where am I?</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label for="question-2">How would you rate this website?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <select class="form-control" id="question-2">
                        <option value="5">5+</option>
                        <option value="4">4</option>
                        <option value="3">3</option>
                        <option value="2">2</option>
                        <option value="1">1</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label for="question-3">Is it easy to navigate your way around this site?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <select class="form-control" id="question-3">
                        <option value="5">Absolutely</option>
                        <option value="4">Sure</option>
                        <option value="3">So so</option>
                        <option value="2">No</option>
                        <option value="1">Where am I?</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label for="question-4">Would you recommend this site to others?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <select class="form-control" id="question-4">
                        <option value="5">Absolutely</option>
                        <option value="4">Sure</option>
                        <option value="3">Not Sure</option>
                        <option value="2">Unlikely</option>
                        <option value="1">Never</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <a role="button" href="/" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-primary float-right">Submit</button>
            </div>
        </div>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>