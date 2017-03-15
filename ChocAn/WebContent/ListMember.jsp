<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>

<%@ page import="application.MemberDb" %>
<jsp:useBean id="search" class="application.Member"/>

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
 <h2 align = "center" >Maintain Member</h2>
         <table border=1 align="center">
        <thead>
            <tr>
                <th>Member Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Street Address</th>
                <th>City</th>
				<th>State</th>
				<th>Date of Joining</th>
				<th>Status</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
        <% 
         List<MemberDb> members = search.getAllMemberDbs();
         Iterator it = members.iterator();
   		 MemberDb memberdb;
 		 while ( it.hasNext() ) {
 		 memberdb=(MemberDb)it.next();
        %>
        <tr>
        <td><% out.println(memberdb.getMemid()); %></td>
        <td><% out.println(memberdb.getFirstName()); %></td>
        <td><% out.println(memberdb.getLastName()); %></td>
        <td><% out.println(memberdb.getStreetAdd()); %></td>
        <td><% out.println(memberdb.getCity()); %></td>
        <td><% out.println(memberdb.getState()); %></td>
         <td><% out.println(memberdb.getJoinDate()); %></td>
        <td><% out.println(memberdb.getStatus()); %></td>
       <td><a href="MemberController?action=edit&memid=<% out.println(memberdb.getMemid()); %>">Update</a>&nbsp&nbsp
        <a href="MemberController?action=delete&memid=<% out.println(memberdb.getMemid()); %>">Delete</a></td>
                </tr>
       <%} %>
        </tbody>
    </table>
    <div align="center">
    <input  type="button" value="Addmember" name="AddMember" 
onclick="openPage('MemberController?action=insert')" />
    <input  type="button" value="Back" name="Back" 
onclick="openPage('ChocoAn.jsp')" />
</div>
      
</body>
</html>