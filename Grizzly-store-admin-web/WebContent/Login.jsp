<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.button
{
border-radius:6px;
}
</style>
<script>
	function validate() {
		var username = document.form.username.value;
		var password = document.form.password.value;

		if (username == null || username == "") {
			alert("Username cannot be blank");
			return false;
		} else if (password == null || password == "") {
			alert("Password cannot be blank");
			return false;
		}
	}
</script>
</head>
<body>

<center><img src="C:\Users\768853\workspace\Grizzly-store-admin-web\WebContent\Project\Store.png" width="600" height="350"></center>
<form action="LoginServlet" method="GET" onsubmit="return validate()">
<center><b><input type="text" name="username" placeholder="Username" class="button"></b></center><br>
<center><b><input type="password" name="password" placeholder="Password" class="button"></b></center><br>
<center><button type="submit" class="button">Login</button></center>
</form>
		
</body>
</html>