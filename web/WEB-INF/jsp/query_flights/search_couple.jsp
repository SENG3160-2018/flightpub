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
        <p class="h4">Find your Couples flight.</p>
        <div class="row">
            <div class="col">
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
            <div class="col">
                <div class="form-group">
                    <label for="arrival">Arrival City</label>
                    <select class="form-control" id="arrival" required>
                        <option disabled selected value>-</option>
                        <option>Sydney</option>
                        <option>Newcastle</option>
                        <option>Brisbane</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="price_min">Price Min</label>
                    <select class="form-control" id="price_min">
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
                    <select class="form-control" id="price_max">
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
                    <label for="departure_date">Departure date</label>
                    <div class="input-group date" data-target-input="nearest">
                        <input type="text" class="form-control datetimepicker-input" id="departure_date" data-toggle="datetimepicker" data-target="#departure_date"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <div class="form-check form-check-inline" style="margin-left: 20px;">
                        <input class="form-check-input" type="checkbox" value="" id="direct_flight">
                        <label class="form-check-label" for="direct_flight">
                            Direct Flights
                        </label>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <div class="form-check form-check-inline" style="margin-left: 20px;">
                        <input class="form-check-input" type="checkbox" value="" id="include_return">
                        <label class="form-check-label" for="include_return">
                            Include return fare
                        </label>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <div class="form-check form-check-inline" style="margin-left: 20px;">
                        <input class="form-check-input" type="checkbox" value="" id="include_nearby">
                        <label class="form-check-label" for="include_nearby">
                            Include nearby airports
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <div class="form-check form-check-inline" style="margin-left: 20px;">
                        <input class="form-check-input" type="checkbox" value="" id="multi_city">
                        <label class="form-check-label" for="multi_city">
                            Multi-city
                        </label>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <div class="form-check form-check-inline" style="margin-left: 20px;">
                        <input class="form-check-input" type="checkbox" value="" id="include_surrounding_days">
                        <label class="form-check-label" for="include_surrounding_days">
                            Display surrounding days
                        </label>
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="stopovers">Number of stopovers</label>
                    <select class="form-control" id="stopovers">
                        <option disabled selected value>-</option>
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                    </select>
                </div>
            </div>
            <div class="col">

            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="class">Cabin Class</label>
                    <select class="form-control" id="class">
                        <option disabled selected value>-</option>
                        <option>Economy</option>
                        <option>Premium</option>
                        <option>Business</option>
                        <option>First Class</option>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="carrier">Carrier</label>
                    <select class="form-control" id="carrier">
                        <option disabled selected value>-</option>
                        <option>Qantas</option>
                        <option>Jetstar</option>
                        <option>Virgin</option>
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
