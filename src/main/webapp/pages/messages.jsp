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
<table class="table table-hover">
    <thead>
    <tr class="info">
        <th> Name</th>
        <th> Text</th>
        <th> Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="message" items="${messages}">
        <tr class="warning">
            <td><c:out value="${message.userName}"/></td>
            <td><c:out value="${message.messageText}"/></td>
            <td><c:out value="${message.createdDate}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
