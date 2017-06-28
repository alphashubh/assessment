<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<style>

body{
	margin:0 auto;
	 background-color: #f7f7f7;
}
.logincontainer{
/* padding-top: 30px; */
	margin-top: 180px;
 Width: 400px;
 height:250px;
 background-color: #dfe3ee;
 position: relative;
 border-radius: 20px;
 }
 .input{
 padding-top: 35px;
 }
 
 button {
 	margin-top: 20px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    width:60px;
    height:30px;
    border: 2px solid #3b5998;
     }

button:hover {
    background-color: #3b5998; /* Green */
    color: white;
}
 
 h3{
 
 color: white;
 background-color: #3b5998;
 border-radius:10px;
 }
 </style>
</head>
<body >
<center>

<form method="GET" action = "mvc/home?accountNumber" >
<div class="logincontainer" >

	<center><h3>LOGIN</h3></center>
	<!-- Please add your application links by replacing the below sample links -->
	<br>
	<div class="input">
	<input Placeholder="Account Number" name="accountNumber" type="Text" maxlength="16"></input>
	<center><button type="submit">Login</button></center>
	</div>
	</div>
	</form>
	</center>
</body>
</html>