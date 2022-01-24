<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <title>Email-page</title>
</head>
<body>
<h1>hi ${userInfo.userName}</h1>
<h2>Send result to your friend</h2>
<form:form action="/process-email" method="get" modelAttribute="emailDTO">
<label>Enter your Email:</label>
<form:input path="userEmail"/>
<input type="submit" value ="send">
</form:form>

</body>
</html>