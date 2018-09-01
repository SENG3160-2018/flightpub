<%--
  Created by IntelliJ IDEA.
  User: joelp
  Date: 1/09/2018
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <div id="progress" class="container p-5">
        <p class="h5 text-white">You're almost there...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
        </div>
    </div>
</div>
<div id="search" class="container mt-5">
    <s:form action="results">
        <p class="h4">Find your Business flight...</p>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="departureCode">Departure City</label>
                    <select name="departureCode" class="form-control" id="departureCode" required>
                        <option disabled selected value>-</option>
                        <s:iterator value="destinations">
                            <option><%--<s:property value="airport"/> - --%><s:property value="destinationCode"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="destinationCode">Arrival City</label>
                    <select name="destinationCode" class="form-control" id="destinationCode" required>
                        <option disabled selected value>-</option>
                        <s:iterator value="destinations">
                            <option><s:property value="airport"/> - <s:property value="destinationCode"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <div class="form-group">
                    <label for="details">Cabin Class</label>
                    <select name="details" class="form-control" id="details">
                        <s:iterator value="ticketClasses">
                            <option ${classCode == 'BUS' ? "selected" : ""}><s:property value="details"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="name">Ticket Type</label>
                    <select name="name" class="form-control" id="name">
                        <s:iterator value="ticketTypes">
                            <option ${ticketCode == 'E' ? "selected" : ""}><s:property value="name"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="departureTime">Departure Time/date</label>
                    <div class="input-group date" data-target-input="nearest">
                        <input type="text" class="form-control datetimepicker-input" id="departureTime" data-toggle="datetimepicker" data-target="#departureTime" required/>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="arrivalTime">Arrival Time/date</label>
                    <div class="input-group date" data-target-input="nearest">
                        <input type="text" class="form-control datetimepicker-input" id="arrivalTime" data-toggle="datetimepicker" data-target="#arrivalTime" required/>
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
            <div class="col pull-right">
                <button type="submit" class="btn btn-primary float-right">Search</button>
            </div>
        </div>
    </s:form>
</div>