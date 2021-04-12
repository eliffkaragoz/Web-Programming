<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style>
			div { 
	 			  outline: #727272 solid 10px; 
	 			  margin: auto;   
	 			  padding: 300px; 
	 			  text-align: center; 
	
	 			  width: 200px; 
	 			  padding-top: 150px; 
	 			  padding-right: 50px; 
	 			  padding-bottom: 200px; 
	 			  padding-left: 80px; 
			}
		
		</style>
	</head>
	<body>
	<div >
	  <center>
		<form action="ClientAccessCount" method="post">
			<h1>Login</h1>
			
			<p>UserName: <input type="text" name="userName"></p>
			
			 <p> Password: <input type="password" name="password"></p>
			
			<input type="submit" value="Login" name="btn_submit">
		</form>
		</center>
	</div> 
	</body> 
</html>















