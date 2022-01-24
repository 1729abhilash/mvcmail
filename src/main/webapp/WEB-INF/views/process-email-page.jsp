<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>processing-Email-page</title>
</head>
<body>
<h1>Hi ${userInfo.userName}</h1>
<label>Email successfully send to ${emailDTO.userEmail}</label>


</body>
</html>