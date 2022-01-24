
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
    <h1 align="center">Love Calculator</h1>
    <h3>Hi! ${userInfo.userName}</h3>
    <hr/>
    <h2>The love calculator predicts:</h2>
    <br>
    ${userInfo.userName} and ${userInfo.crushName} are
    <br>
    ${result}
    <br>
 <a href="/sendEmail ">Send result to the email</a>

</body>
</html>