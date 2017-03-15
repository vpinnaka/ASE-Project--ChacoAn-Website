<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>
<title>Chocoholics Anonymous</title>
</head>
<body background="images/green-nature-dual-monitor-other.jpg">
<h1 align="center">Chocoholics Anonymous</h1>
<h2 align = "center"> Verify Member</h2>
<form name="verify" action='MemberController?action=verify'  method="POST">

			<table align="center">
				<tr>
					<td><label> Member ID : </label></td>
					<td> <input type="text" name="memid"> </td>
				</tr>
				<tr>
					<td colspan=2  align=center><input type=submit value="Verify">&nbsp&nbsp<input  type="button" value="Back" name="Back" 
onclick="openPage('ChocoAn.jsp')" /></td>
				</tr>
				
			</table>
			
				</form>
				

</body>
</html>