<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/green-nature-dual-monitor-other.jpg">
<h1 align="center">Chocoholics Anonymous</h1>
<h2 align = "center">Update Member</h2>
<form action="/AddMem" method="post">

			<table align="center">
				<tr>
					<td><label> First Name : </label></td>
					<td> <input name="firstname"> </td>
				</tr>
				<tr>
					<td><label> Last Name : </label></td>
					<td> <input name="lastname"> </td>
				</tr>
				<tr>
					<td><label> Street Address : </label></td>
					<td> <input name="stadd"> </td>
				</tr>
				<tr>
					<td><label> City : </label></td>
					<td> <input name="city"> </td>
				</tr>	
				<tr>
					<td><label> State : </label></td>
					<td> <input name="state"> </td>
				</tr>	
				<tr>
					<td><label> ZipCode : </label></td>
					<td> <input name="zip"> </td>
				</tr>
				<tr>
					<td><label> Date : </label></td>
					<td> <input type="date" name="date"> </td>
				</tr>			
				<tr>
				<td> Status </td>
					<td>
					<select name="status">
							<option value="none">None</option>
							<option value="active">Active</option>
							<option value="inactive">Inactive</option>
						</select>
					</td>
				</tr>
					<tr>
					<td colspan=2 align=center><input type="submit" value="Update"/></td>
				</tr>
				
			</table>
			

</form>
</body>
</html>