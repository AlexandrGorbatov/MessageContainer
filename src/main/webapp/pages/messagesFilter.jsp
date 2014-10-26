<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css.map" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

</head>
<body>
<form method="get" action="<c:url value="/findByName"/>">

    <div class="row">

        <div class="col-xs-3">
            <label for="userName">Name</label>
            <input id="userName" class="form-control" placeholder="User name" name="userName"/>
        </div>

        <div class="col-xs-3">
            <label for="dateFrom">Date From</label>
            <input type="text" class="form-control " id="dateFrom" placeholder="Date From" name="dateFrom">
        </div>

        <div class="col-xs-3">
            <label for="dateTo">Date To</label>
            <input type="text" class="form-control" id="dateTo" placeholder="Date To" name="dateTo">
        </div>

        <div class="col-xs-3">
            <button type="submit" class="btn btn-primary" style="margin-top: 24px;">Find Messages</button>
        </div>
    </div>

</form>


<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script>
    $(function () {
        $("#dateFrom").datepicker();
    });
    $(function () {
        $("#dateTo").datepicker();
    });
</script>
</body>
</html>
