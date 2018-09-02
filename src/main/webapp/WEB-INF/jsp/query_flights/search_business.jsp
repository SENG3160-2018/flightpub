<%--
  Created by IntelliJ IDEA.
  User: joelp
  Date: 1/09/2018
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/jsp/includes/head.jsp" %>

<div class="container">
    <div id="progress" class="container p-5" style="background-image: url('../../assets/clouds.jpeg')">
        <p class="h5 text-white">You're almost there...</p>
        <div class="progress" style="height: 20px;">
            <div class="progress-bar" role="progressbar" style="width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
        </div>
    </div>
</div>
<div id="search" class="container mt-5">
    <s:form action="results" method="POST">
        <p class="h4">Find your Business flight...</p>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="departureCode">Departure City</label>
                    <select name="dptCode" class="form-control" id="departureCode" required>
                        <option disabled selected value>-</option>
                        <s:iterator value="destinations">
                            <option value="<s:property value="destinationCode"/>"><s:property value="airport"/> - <s:property value="destinationCode"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="destinationCode">Arrival City</label>
                    <select name="dstCode" class="form-control" id="destinationCode" required>
                        <option disabled selected value>-</option>
                        <s:iterator value="destinations">
                            <option value="<s:property value="destinationCode"/>"><s:property value="airport"/> - <s:property value="destinationCode"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col">
                <div class="form-group">
                    <label for="details">Cabin Class</label>
                    <select name="tcktClass" class="form-control" id="details">
                        <s:iterator value="ticketClasses">
                            <option value="<s:property value="classCode"/>" ${classCode == 'BUS' ? "selected" : ""}><s:property value="details"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="name">Ticket Type</label>
                    <select name="tcktType" class="form-control" id="name">
                        <s:iterator value="ticketTypes">
                            <option value="<s:property value="ticketCode"/>" ${ticketCode == 'E' ? "selected" : ""}><s:property value="name"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="departureTime">Depart After</label>
                    <div class="input-group date" data-target-input="nearest">
                        <input name="dptTime" type="text" class="form-control datetimepicker-input" id="departureTime" data-toggle="datetimepicker" data-target="#departureTime"/>
                        <span class="input-group-addon">
                            <span class="fas fa-calendar-alt"></span>
                        </span>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="arrivalTime">Arrive Before</label>
                    <div class="input-group date" data-target-input="nearest">
                        <input name="dstTime" type="text" class="form-control datetimepicker-input" id="arrivalTime" data-toggle="datetimepicker" data-target="#arrivalTime"/>
                        <span class="input-group-addon">
                            <span class="fas fa-calendar-alt"></span>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <div class="form-check form-check-inline" style="margin-left: 20px;">
                        <s:checkbox name="directFlightsOnly" fieldValue="true" theme="simple" />
                        <label class="form-check-label">
                            Direct flights
                        </label>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <div class="form-check form-check-inline float-right">
                        <s:checkbox name="arriveDayBefore" fieldValue="true" theme="simple" />
                        <label class="form-check-label">
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

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>
