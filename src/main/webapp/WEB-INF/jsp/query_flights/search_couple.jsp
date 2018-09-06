<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 6/5/18
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
    <s:form action="results">
        <p class="h4">Find your Couples flight.</p>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="departure">Departure City</label>
                    <select name="dptCode" class="form-control" id="departure" required>
                        <option disabled selected value>-</option>
                        <s:iterator value="destinations">
                            <option value="<s:property value="destinationCode"/>"><s:property value="airport"/> - <s:property value="destinationCode"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="arrival">Arrival City</label>
                    <select name="dstCode" class="form-control" id="arrival" required>
                        <option disabled selected value>-</option>
                        <s:iterator value="destinations">
                            <option value="<s:property value="destinationCode"/>"><s:property value="airport"/> - <s:property value="destinationCode"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="class">Cabin Class</label>
                    <select name="tcktClass" class="form-control" id="class" required>
                        <option disabled selected value>-</option>
                        <s:iterator value="ticketClasses">
                            <option value="<s:property value="classCode"/>"><s:property value="details"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="class">Ticket Type</label>
                    <select name="tcktType" class="form-control" id="type" required>
                        <option disabled selected value>-</option>
                        <s:iterator value="ticketTypes">
                            <option value="<s:property value="ticketCode"/>"><s:property value="name"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="price_min">Price Min</label>
                    <select name="minPrice" class="form-control" id="price_min">
                        <option disabled selected value>-</option>
                        <option value="0">$0</option>
                        <option value="500">$500</option>
                        <option value="1000">$1000</option>
                        <option value="1500">$1500</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="price_max">Price Max</label>
                    <select name="maxPrice" class="form-control" id="price_max">
                        <option disabled selected value>-</option>
                        <option value="100">$100</option>
                        <option value="500">$500</option>
                        <option value="1000">$1000</option>
                        <option value="1500">$1500+</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="departureTime">Departure Date</label>
                    <div class="input-group date" data-target-input="nearest">
                        <input name="date" type="text" class="form-control datetimepicker-input" id="departureTime" data-toggle="datetimepicker" data-target="#departureTime"/>
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
                        <label class="form-check-label pl-3">
                            Direct flights
                        </label>
                    </div>
                </div>
            </div>
                <%--
                <div class="col">
                    <div class="form-group">
                        <div class="form-check form-check-inline float-right">
                            <s:checkbox name="includeReturn" fieldValue="true" theme="simple" />
                            <label class="form-check-label">
                                Include return fares
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <div class="form-check form-check-inline float-right">
                            <s:checkbox name="includeNearby" fieldValue="true" theme="simple" />
                            <label class="form-check-label">
                                Include nearby airports
                            </label>
                        </div>
                    </div>
                </div>
                --%>
            </div>
            <%--
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <div class="form-check form-check-inline float-right">
                            <s:checkbox name="multiCity" fieldValue="true" theme="simple" />
                            <label class="form-check-label">
                                Multi city
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <div class="form-check form-check-inline float-right">
                            <s:checkbox name="surroundingDays" fieldValue="true" theme="simple" />
                            <label class="form-check-label">
                                Display surrounding days
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col"></div>
            </div>
            --%>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="stopovers">Number of stopovers</label>
                    <select name="stopOvers" class="form-control" id="stopovers">
                        <option disabled selected value>-</option>
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="carrier">Carrier</label>
                    <select name="carrier" class="form-control" id="carrier">
                        <option disabled selected value>-</option>
                        <s:iterator value="airlines">
                            <option value="<s:property value="airlineCode"/>"><s:property value="airlineName"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <button type="submit" class="btn btn-primary float-right">Search</button>
            </div>
        </div>
    </s:form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>
