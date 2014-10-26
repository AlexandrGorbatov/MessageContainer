<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <jsp:include page="messagesFilter.jsp"/>

    <div class="page-header">
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
    </div>
    <a href="${pageContext.request.contextPath}/" class="btn btn-success">Main page</a>
</div>
</body>
</html>
