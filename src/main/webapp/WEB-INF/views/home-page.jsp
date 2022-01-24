<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Document</title>
  <style type="text/css">
    .error{
      color:red;
      position:fixed;
      text-align:left;
      margin-left: 40px;
    
    }
  </style>
  <script type="text/javascript">
    function validateUserName(){
     var userName= document.getElementById("yn").value;
    if(userName.length<3){
      alert("Your name atleast have should 3 character")
      return false;
    }
      else{
        return true;
      }
    }
  </script>
</head>
<body>
<h1 align="center">Love Calculator</h1>
<hr>
<form:form action="process-homepage" method="get" modelAttribute="userInfo"
 onsubmit="return validateUserName()">
<div align="center">
<div>
    <label for="yn">Your name</label>
    <form:input id='yn' path ="userName"/>
    <form:errors path="userName" cssClass="error"/>
    </div>
    <br>
    <div>
    <label for="cn">Crush name</label>
    <form:input id='cn' path="crushName"/>
    </div>
    <br>
    <form:checkbox path="termAndCondition" id="check"/>
    <label>I am agreeing that this is for fun </label>
    
   <form:errors path="termAndCondition" cssClass="error"/>
    <br>
    <input type="submit" value="calculate">

</div>

</form:form>
<br>

 


</body>
</html>