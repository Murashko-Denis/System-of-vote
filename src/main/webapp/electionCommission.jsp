<%--
    Document   : index
    Created on : 14.11.2016, 12:06:55
    Author     : Denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ page import="SystemOfVote.VotingSystemLocal" %>
<%@ page import="SystemOfVote.VotingSystem" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="SystemOfVote.Candidate" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>

    <%!
        VotingSystemLocal system;
    %>
    <%
        Context context = new InitialContext();
        system = (VotingSystemLocal) context.lookup("java:global/Denis/VotingSystem");
    %>
    <h1><h:outputText value="Voting System"/></h1>
    <!--<h1><h:outputText value="Enter passport data:"/></h1>
    Number:<br>
    <input type="text" name="number" value="">
    <br>
    Serial:<br>
    <input type="text" name="serial" value="">-->
    <h1><h:outputText value="Election Commission:"/></h1>
    <!-- jsp:useBean id="reg" class="SystemOfVote.VotingSystem" scope="application"/ -->
    <form action="facade4" method="post">
        <input type="submit" name="startVote" value="Start Vote" /><br><br>
        <input type="submit" name="FinishVote" value="Finish Vote" /><br><br>
    </form>
    <form action="facade2" method="post">
        Surname:<br>
        <input type="text" name="surname" value="">
        <br>
        Name:<br>
        <input type="text" name="name" value=""><br><br>
        <input type="submit" name="add" value="Add Candidate" />
    </form>
        <form action="facade3" method="post">
            Surname:<br>
            <input type="text" name="surname2" value="">
            <br>
            Name:<br>
            <input type="text" name="name2" value=""><br><br>
        <input type="submit" name="del" value="Delete Candidate" /><br><br>

        </form>
    <!--<form action="facade5" method="post">
        <input type="submit" name="finishVote" value="Finish Vote" /><br><br>
    </form>-->
        <div><a href="/Denis/faces/results.jsp">Get Results</a></div>

    </td>
    </tr>
    </body>
    </html>
</f:view>
