<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<c:url var="saveUrl" value="/save"/>

<body>
<div class="container">
    <div class="page-header">
        <h2>New Message</h2>
        <form:form modelAttribute="message" method="POST" action="${saveUrl}" class="form-horizontal">

            <div class="control-group">
                <form:label class="control-label" path="userName">Name</form:label>
                <div class="controls">
                    <form:input path="userName" class="form-control"/>
                </div>
            </div>

            <div class="control-group">
                <form:label class="control-label" path="messageText">Text</form:label>
                <div class="controls">
                    <form:textarea class="form-control" rows="3" path="messageText"/>
                </div>
            </div>

            <div style="margin-top: 15px">
                <input type="submit" value="Save" class="btn btn-primary"/>
                <a href="${pageContext.request.contextPath}/messages" class="btn btn-success">Show Messages</a>
            </div>

        </form:form>
    </div>
</div>
</body>
</html>