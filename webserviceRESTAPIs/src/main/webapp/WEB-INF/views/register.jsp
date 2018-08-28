<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration :: Student</title>
<style type="text/css">
body
{margin: 0px;
padding: 0px;
}
</style>
</head>
<body>

    <div align="center"  style="background-color: #FFF4F1 ;">
    <h1>Registration</h1>
	<h1>${success}</h1>
	<form:errors path="student.*" cssClass="error" />
	<form action="save" method="post"><table>
	<tr><th>First Name:</th><td><input type="text" name="firstName"></td></tr>
	<tr><th>Last Name:</th><td><input type="text" name="lastName"></td></tr>
	<tr><th>Email:</th><td><input type="email" name="email"></td></tr>
	<tr><th>Password:</th><td><input type="text" name="password"></td></tr>
	<tr><th>Confirm Password:</th><td><input type="text" name="confirmPassword"></td></tr>
	<tr><th>Date Of Birth:</th><td><input type="date" name="dob"></td></tr>
	<tr><th>Gender:</th><td><input type="radio" name="gender" value="Male">Male<input type="radio" name="gender" value="Female">Female</td></tr>
	 <tr><th>Mobile:</th><td><input type="text" name="mobile"></td></tr>
  <!--   <tr><th>Address:</th><td><input type="text" name="address.address"></td></tr>
	<tr><th>State:</th><td><input type="text"   name="address.state"></td></tr>
	<tr><th>Pin Code:</th><td><input type="text" name="address.pincode"></td></tr>
	<tr><th>Country:</th><td><input type="text" name="address.country"></td></tr> -->
	<tr><th colspan="2"><input type="submit" value="Register Now"></tr>
	</table>
	</form></div>
</body>
</html>