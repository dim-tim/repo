<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" />

    <spring:url value="/resources/styles/standard.css" var="app_css_url" />
    <link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}" />
</head>
<body class="tundra spring">
<div class="headerWrapper">
    <tiles:insertAttribute name="header" ignore="true" />
</div>
<div class="wrapper">
    <tiles:insertAttribute name="menu" ignore="true" />
    <div class="main">
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="footer" ignore="true"/>
    </div>
</div>
</body>
</html>