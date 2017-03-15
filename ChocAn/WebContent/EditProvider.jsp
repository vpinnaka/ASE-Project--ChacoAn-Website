<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="java.util.*"%>

<%@ page import="application.ProviderDb" %>
<jsp:useBean id="search" class="application.Provider"/>
<title>Edit Provider</title>
<script>function validateForm() {
    var x = document.add.firstname;
    var y= document.add.lastname;
    var z= document.forms["add"]["date"].value;
    var l= document.forms["add"]["status"].value;
    var m= document.forms["add"]["type"].value;
    
    if (x.value == null || x.value == "") {
        alert("First Name must be filled out");
        return false;
    }
    else
    {
    allLetter(x);
    }
    if (y.value == null || y.value == "") {
        alert("Last Name must be filled out");
        return false;
    }
     else
    {
    allLetter(y);
    }
    if (z == null || z == "") {
        alert("Joining date must be entered");
        return false;
    }
     if (l == "none" || l == "") {
        alert("Status must be entered");
        return false;
    }
     if (m == "none" || m == "") {
        alert("Type must be entered");
        return false;
    }
}
function allLetter(uname)  
{   
var letters = /^[A-Za-z]+$/;  
if(uname.value.match(letters))  
{  
return true;  
}  
else  
{  
alert('Username must have alphabet characters only');  
uname.focus();  
return false;  
}  
} 
</script>

</head>
<body background="images/green-nature-dual-monitor-other.jpg">
<h1 align="center">Chocoholics Anonymous</h1>
<h2 align = "center">Edit Provider</h2>
<%

ProviderDb pro = search.getProviderDbById(Integer.parseInt(request.getParameter("proid"))); %>
<form  name="add" onsubmit="return validateForm()" action='ProviderController?action=update&proid=<% out.println(pro.getproid()); %>&date=<% out.println(pro.getJoinDate()); %>' method=post>

			<table align="center">
			<tr>
					<td><label> Provider ID : </label></td>
					<td><input type=text name="proid" value="<%= pro.getproid()%>" disabled/></td>
				</tr>
				<tr>
					<td><label> First Name : </label></td>
					<td> <input type=text name="firstname" value="<%= pro.getFirstName()%>" disabled/> </td>
				</tr>
				<tr>
					<td><label> Last Name : </label></td>
					<td> <input type=text name="lastname" value="<%= pro.getLastName()%>" disabled/></td>
				</tr>
				<tr>
					<td><label> Street Address : </label></td>
					<td> <input name="stadd" value="<%= pro.getStreetAdd()%>"/> </td>
				</tr>
				<tr>
					<td><label> City : </label></td>
					<td> <input name="city" value="<%= pro.getCity() %>"/> </td>
				</tr>	
				<tr>
					<td><label> State : </label></td>
					<td> <input name="state" value="<%= pro.getState()%>"/> </td>
				</tr>	
				<tr>
					<td><label> Date : </label></td>
					<td> <input type=text name="date" value="<%= pro.getJoinDate()%>" disabled/> </td>
				</tr>			
				<tr>
				<td> Type </td>
					<td>
					<select name="type">
					<% if(pro.getType().equals("dietician")){ %>
							<option value="none" >None</option>
							<option value="dietician" selected>dietician</option>
							<option value="internist">internist</option>
							<option value="exercise specialist">exercise specialist</option>
							<%}else if(pro.getType().equals("internist")){ %>
							<option value="none" >None</option>
							<option value="dietician" >dietician</option>
							<option value="internist" selected>internist</option>
							<option value="exercise specialist">exercise specialist</option>
							<%}else if(pro.getType().equals("exercise specialist")){ %>
							<option value="none" >None</option>
							<option value="dietician" >dietician</option>
							<option value="internist" >internist</option>
							<option value="exercise specialist" selected>exercise specialist</option>
							<%} else{%>
							<option value="none">None</option>
							<option value="dietician">dietician</option>
							<option value="internist">internist</option>
							<option value="exercise specialist">exercise specialist</option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr>
				<td> Status </td>
					<td>
					<select name="status">
					<% if(pro.getStatus().equals("active")){ %>
							<option value="none" >None</option>
							<option value="active" selected>Active</option>
							<option value="inactive">Inactive</option>
							<%}else if(pro.getStatus().equals("inactive")){ %>
							<option value="none" >None</option>
							<option value="active" >Active</option>
							<option value="inactive" selected>Inactive</option>
							<%} else{%>
							<option value="none">None</option>
							<option value="active">Active</option>
							<option value="inactive">Inactive</option>
							<%} %>
						</select>
					</td>
				</tr>
					<tr> 
					<td colspan=2 align=center><input type=submit value="Submit"></td>
				</tr>
				
			</table>
			
			
				</form>
</body>
</html>