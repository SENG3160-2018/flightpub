<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 8/6/18
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ include file="/WEB-INF/jsp/includes/head.jsp" %>

<div class="container">
    <div id="progress" class="container p-5"  style="background-image: url('../../assets/clouds.jpeg')">
        <p class="h3 text-white">Site review.</p>
    </div>
</div>
<div id="review-site" class="container mt-5">
    <s:form action="submitreview" method="POST">
        <div class="row">
            <div class="col">
                <label>How easy is the sites UI to navigate?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <s:select headerKey="-1" headerValue=" - "
                              theme="simple"
                              list="navigations"
                              name="review.uiNavigation"
                              cssClass="form-control"
                              required="true"
                    />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label>How would you rate this website?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <s:select label="How would you rate this website?"
                              headerKey="-1" headerValue=" - "
                              theme="simple"
                              list="ratings"
                              name="review.rating"
                              cssClass="form-control"
                              required="true"
                    />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label>Is it easy to navigate your way around this site?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <s:select label="Is it easy to navigate your way around this site?"
                              headerKey="-1" headerValue=" - "
                              theme="simple"
                              list="navigations"
                              name="review.siteNavigation"
                              cssClass="form-control"
                              required="true"
                    />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label>Would you recommend this site to others?</label>
            </div>
            <div class="col">
                <div class="form-group">
                    <s:select label="Would you recommend this site to others?"
                              headerKey="-1" headerValue=" - "
                              theme="simple"
                              list="recommendations"
                              name="review.recommendation"
                              cssClass="form-control"
                    />
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <a role="button" href="/" class="btn btn-secondary">Back</a>
                <button type="submit" class="btn btn-primary float-right">Submit</button>
            </div>
        </div>
    </s:form>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>