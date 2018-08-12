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
<div id="search" class="container mt-5">
    <s:form action="results">
        <p class="h4">Find your Business flight.</p>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="departure">Departure City</label>
                    <select name="departureCity" class="form-control" id="departure" required>
                        <option disabled selected value>-</option>
                        <option>Sydney</option>
                        <option>Newcastle</option>
                        <option>Brisbane</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="arrival">Arrival City</label>
                    <select name="arrivalCity" class="form-control" id="arrival" required>
                        <option disabled selected value>-</option>
                        <option>Sydney</option>
                        <option>Newcastle</option>
                        <option>Brisbane</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <div class="form-group">
                    <label for="class">Cabin Class</label>
                    <select name="cabinClass" class="form-control" id="class">
                        <option disabled selected value>-</option>
                        <option>Economy</option>
                        <option>Premium</option>
                        <option>Business</option>
                        <option>First Class</option>
                    </select>
                </div>
            </div>
            <div class="col pull-right">
                <div class="form-group">
                    <div class="form-check form-check-inline float-right">
                        <input name="arriveDayBefore" class="form-check-input" type="checkbox" value="" id="arrive_day_before">
                        <label class="form-check-label" for="arrive_day_before">
                            Arriving day before meeting
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="departure_time">Departure Time/date</label>
                    <div class="input-group date" data-target-input="nearest">
                        <input type="text" class="form-control datetimepicker-input" id="departure_time" data-toggle="datetimepicker" data-target="#departure_time"/>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="arrival_time">Arrival Time/date</label>
                    <div class="input-group date" data-target-input="nearest">
                        <input type="text" class="form-control datetimepicker-input" id="arrival_time" data-toggle="datetimepicker" data-target="#arrival_time"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <div class="form-check form-check-inline" style="margin-left: 20px;">
                        <input name="directFlightsOnly" class="form-check-input" type="checkbox" value="" id="direct_flight">
                        <label class="form-check-label" for="direct_flight">
                            Direct Flights
                        </label>
                    </div>
                </div>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary float-right">Search</button>
            </div>
        </div>
    </s:form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>
