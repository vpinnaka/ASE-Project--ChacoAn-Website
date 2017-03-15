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
<script>

function validateForm() {
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
        alert("type must be entered");
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
<title>Add Provider</title>
</head>
<body background="images/green-nature-dual-monitor-other.jpg">
<h1 align="center">Chocoholics Anonymous</h1>
<h2 align = "center"> Add Provider</h2>
<form name="add" action='ProviderController?action=add' onsubmit="return validateForm()" method=post>

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
					<td><label> Date : </label></td>
					<td> <input type="date" name="date"> </td>
				</tr>		
				<tr>
				<td> Type </td>
					<td>
					<select name="type">
							<option value="none">None</option>
							<option value="Dietician">Dietician</option>
							<option value="Internists">Internists</option>
							<option value="Exercise Specialist">Exercise Specialist</option>
						</select>
					</td>
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
					<td colspan=2 align=center><input type=submit value="Submit"></td>
				</tr>
				
			</table>
			
				</form>
</body>
</html>