<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>

<%@ page import="application.ProviderDb" %>
<jsp:useBean id="search" class="application.Provider"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>
<title>Show All Users</title>
</head>
<body background="images/green-nature-dual-monitor-other.jpg">
<h1 align="center">Chocoholics Anonymous</h1>
 <h2 align = "center" >Maintain Provider</h2>
         <table border=1 align="center">
        <thead>
            <tr>
                <th>Provider Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Street Address</th>
                <th>City</th>
				<th>State</th>
				<th>Date of Joining</th>
				<th>Type</th>
				<th>Status</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
        <% 
         List<ProviderDb> Providers = search.getAllProviderDbs();
         Iterator it = Providers.iterator();
   		 ProviderDb Providerdb;
 		 while ( it.hasNext() ) {
 		 Providerdb=(ProviderDb)it.next();
        %>
        <tr>
        <td><% out.println(Providerdb.getproid()); %></td>
        <td><% out.println(Providerdb.getFirstName()); %></td>
        <td><% out.println(Providerdb.getLastName()); %></td>
        <td><% out.println(Providerdb.getStreetAdd()); %></td>
        <td><% out.println(Providerdb.getCity()); %></td>
        <td><% out.println(Providerdb.getState()); %></td>
         <td><% out.println(Providerdb.getJoinDate()); %></td>
         <td><% out.println(Providerdb.getType()); %></td>
        <td><% out.println(Providerdb.getStatus()); %></td>
       <td><a href="ProviderController?action=edit&proid=<% out.println(Providerdb.getproid()); %>">Update</a>&nbsp&nbsp
        <a href="ProviderController?action=delete&proid=<% out.println(Providerdb.getproid()); %>">Delete</a></td>
                </tr>
       <%} %>
        </tbody>
    </table>
    <div align="center">
    <input  type="button" value="AddProvider" name="AddProvider" 
onclick="openPage('ProviderController?action=insert')" />
    <input  type="button" value="Back" name="Back" 
onclick="openPage('ChocoAn.jsp')" />
</div>
      
</body>
</html>