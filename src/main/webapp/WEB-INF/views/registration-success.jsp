<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
<h1>Your registration is successful</h1>
<h2>the details entered by you are:</h2>
user: ${userReg.name}<br>
user Name: ${userReg.userName}<br>
password: ${userReg.password}<br>
country: ${userReg.countryName}<br>
gender: ${userReg.gender}<br>
hobbies: <br>
age: ${userReg.age}<br>


<c:forEach var ="temp" items="${userReg.hobbies}"><br>
<c:out value="${temp}"></c:out>
</c:forEach>
<br>
Email:${userReg.communicationDto.email}
<br>
Phone:${userReg.communicationDto.phone.countryCode}-${userReg.communicationDto.phone.userNumber}




</body>
</html>