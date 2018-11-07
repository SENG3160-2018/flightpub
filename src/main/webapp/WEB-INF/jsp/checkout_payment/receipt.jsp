<%--
  Created by IntelliJ IDEA.
  User: nathanebba
  Date: 5/09/18
  Time: 4:32 PM
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

<div id="receipt" class="container mt-5">
    <div class="container">
        <s:form action="search">
            <div class="container">
                <p class="h4">Email sent.</p>
                <div class="col-6">
                    <button type="submit" class="btn btn-primary float-right">Search again?</button>
                </div>
            </div>
        </s:form>
    </div>

</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>


