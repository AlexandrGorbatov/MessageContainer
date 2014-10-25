<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:url var="saveUrl" value="/save"/>
<div class="panel">
    <h2>New Message</h2>

    <form:form modelAttribute="message" method="POST" action="${saveUrl}" class="form-horizontal">

        <div class="control-group">
            <form:label class="control-label" path="userName">Name</form:label>
            <div class="controls">
                <form:input path="userName"/>
            </div>
        </div>

        <div class="control-group">
            <form:label class="control-label" path="messageText">Text</form:label>
            <div class="controls">
                <form:textarea path="messageText"/>
            </div>
        </div>
        <input type="submit" value="Save" class="btn btn-primary"/>
        <a href="${pageContext.request.contextPath}/messages" class="btn btn-success">Show Messages</a>
    </form:form>

</div>
</body>
</html>