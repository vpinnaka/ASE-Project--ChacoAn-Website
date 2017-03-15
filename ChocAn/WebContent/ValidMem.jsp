<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Verify Member</title>
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>
</head>
<body background="images/green-nature-dual-monitor-other.jpg">
<h1 align="center">Chocoholics Anonymous</h1>
<h2 align = "center"> Verify Member</h2>
<div align="center">
<%if(request.getAttribute("isvalid").equals("yes")){ %> 
<h3>Member is active</h3>
<%}else if(request.getAttribute("isvalid").equals("no")){ %>
<h3>Member is inactive</h3>
<%} %>
<input  type="button" value="Back" name="Back" onclick="openPage('ChocoAn.jsp')" />
</div>
</body>
</html>