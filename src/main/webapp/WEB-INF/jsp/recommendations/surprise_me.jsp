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
    <div id="progress" class="container p-5"  style="background-image: url('../../assets/clouds.jpeg')">
        <p class="h5 text-white">You're almost there...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
        </div>
    </div>
</div>
<div id="checkout" class="container mt-5">
    <s:form action="results">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form-group">
                        <label for="budget">Budget</label>
                        <input type="text" name="budget" class="form-control" id="budget" placeholder="Budget" required>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form-group">
                        <label for="passengers">Number of passengers</label>
                        <select class="form-control" id="passengers">
                            <option disabled selected value>-</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form-group">
                        <label for="interests">Interests</label>
                        <select class="form-control" id="interests">
                            <option disabled selected value>-</option>
                            <option value="1">Night life</option>
                            <option value="2">Beaches</option>
                            <option value="3">Shopping</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form-group">
                        <label for="departure_date">Departure date</label>
                        <div class="input-group date" data-target-input="nearest">
                            <input type="text" class="form-control datetimepicker-input" id="departure_date" data-toggle="datetimepicker" data-target="#departure_date"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form-group">
                        <label for="departure">Departure City</label>
                        <select class="form-control" id="departure" required>
                            <option disabled selected value>-</option>
                            <option>Sydney</option>
                            <option>Newcastle</option>
                            <option>Brisbane</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-3">
                    <div class="form-group">
                        <div class="form-check form-check-inline" style="margin-left: 20px;">
                            <input class="form-check-input" type="checkbox" value="" id="direct_flight">
                            <label class="form-check-label" for="direct_flight">
                                Direct flight
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-group">
                        <div class="form-check form-check-inline" style="margin-left: 20px;">
                            <input class="form-check-input" type="checkbox" value="" id="multi_city">
                            <label class="form-check-label" for="multi_city">
                                Multi-city
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <button type="submit" class="btn btn-primary btn-block">Find me a flight!</button>
                </div>
            </div>
        </div>
    </s:form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>