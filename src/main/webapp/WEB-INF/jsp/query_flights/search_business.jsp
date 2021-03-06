<%--
  Created by IntelliJ IDEA.
  User: joelp
  Date: 1/09/2018
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

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
                    <select name="tcktClass" class="form-control" id="details" required>
                        <s:iterator value="ticketClasses">
                            <option value="<s:property value="classCode"/>" ${classCode == 'BUS' ? "selected" : ""}><s:property value="details"/></option>
                        </s:iterator>
                    </select>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="name">Ticket Type</label>
                    <select name="tcktType" class="form-control" id="name" required>
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
                    <label>Travel Date</label>
                    <div class="input-group date" data-target-input="nearest">
                        <sx:datetimepicker name="date" displayFormat="dd/MM/yyyy" cssClass="form-control datetimepicker-input" />
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label></label>
                    <div class="form-check" style="margin-left: 20px;">
                        <s:checkbox name="directFlightsOnly" value="true" fieldValue="true" theme="simple" />
                        <label class="form-check-label pl-3">
                            Direct flights
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col pull-right">
                <s:hidden name="stopOvers" value="-1" />
                <s:hidden name="passengers" value="1" />
                <button type="submit" class="btn btn-primary float-right">Search</button>
            </div>
        </div>
    </s:form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>