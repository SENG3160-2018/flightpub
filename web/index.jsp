<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 6/5/18
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ include file="/WEB-INF/jsp/includes/head.jsp" %>

<div id="home" class="container mt-5">
    <p class="caption">Before we get started, tell us a bit about yourself:</p>
    <p class="h2 d-block">What is this trip for?</p>

    <div class="row justify-content-center">
        <div class="col-4">
            <a href="<s:url action="search" >
                        <s:param name="userType">business</s:param>
                    </s:url>">
                <div class="text-center shadow-sm p-3 bg-gradient-light rounded">
                    <i class="fas fa-briefcase"></i>
                    <p class="h5">Business</p>
                </div>
            </a>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-4">
            <a href="<s:url action="search" >
                        <s:param name="userType">couple</s:param>
                    </s:url>">
                <div class="text-center shadow-sm p-3 bg-gradient-light rounded">
                    <i class="fas fa-heart"></i>
                    <p class="h5">Couple</p>
                </div>
            </a>
        </div>
        <div class="col-4">
            <a href="<s:url action="search" >
                        <s:param name="userType">friends</s:param>
                    </s:url>">
                <div class="text-center shadow-sm p-3 bg-gradient-light rounded">
                    <i class="fas fa-user-friends"></i>
                    <p class="h5">Friends
                        <a href="<s:url action='surprise' >
                            <s:param name='userType'>friends</s:param>
                        </s:url>" class="badge badge-success">Surprise Me</a>
                    </p>
                </div>
            </a>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-4">
            <a href="<s:url action="search" >
                        <s:param name="userType">group</s:param>
                    </s:url>">
                <div class="text-center shadow-sm p-3 bg-gradient-light rounded">
                    <i class="fas fa-users"></i>
                    <p class="h5">Group</p>
                </div>
            </a>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/includes/foot.jsp" %>
