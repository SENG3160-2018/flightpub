<%--
  Created by IntelliJ IDEA.
  User: b8ne
  Date: 13/5/18
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Flight Pub</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.0-alpha14/css/tempusdominus-bootstrap-4.min.css" />

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css" />
    <link rel="stylesheet" type="text/css" href="../dist/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../dist/css/styles.css">
    <sx:head />

    <%-- Styling for Message boxes --%>
    <style type="text/css">
        .message {
            background-color:#DDFFDD;
            border:1px solid #009900;
            display: flex;
            justify-content: center;;
            width:400px;
            margin-left: auto;
            margin-right: auto;
            -webkit-animation-duration: 10s;animation-duration: 10s;
            -webkit-animation-fill-mode: both;animation-fill-mode: both
        }
        .message li{
            list-style: none;
        }
        .errors {
            background-color:#FFCCCC;
            border:1px solid #CC0000;
            display: flex;
            justify-content: center;
            width:400px;
            margin-bottom:8px;
            margin-left: auto;
            margin-right: auto;
            -webkit-animation-duration: 10s;animation-duration: 10s;
            -webkit-animation-fill-mode: both;animation-fill-mode: both
        }
        .errors li{
            list-style: none;
        }
        @-webkit-keyframes fadeOut {
            0% {opacity: 1;}
            100% {opacity: 0;}
        }

        @keyframes fadeOut {
            0% {opacity: 1;}
            100% {opacity: 0;}
        }

        .fadeOut {
            -webkit-animation-name: fadeOut;
            animation-name: fadeOut;
        }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header.jsp" %>
