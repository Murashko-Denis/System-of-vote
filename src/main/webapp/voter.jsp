<%-- 
    Document   : index
    Created on : 14.11.2016, 12:06:55
    Author     : Denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ page import="SystemOfVote.VotingSystemLocal" %>
<%@ page import="SystemOfVote.VotingSystem" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>

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

    <h1><h:outputText value="Vote for your candidate:"/></h1>
    <!-- jsp:useBean id="reg" class="SystemOfVote.VotingSystem" scope="application"/ -->
    <form action="facade" method="post">
        <h1><h:outputText value="Enter passport data:"/></h1>
        Number:<br>
        <input type="text" name="number" value="">
        <br>
        Serial:<br>
        <input type="text" name="series" value="">
        <br><br>
        <% for (int i = 0; i < system.getCntCands(); i++) { %>
        <input type="radio" name="cand" id="myRadio" value="<%=i%>"> <%=system.getCandString(i) %> <br>
        <% } %>
        <input type="submit" name="vote" value="Vote"/><br><br>

        <div><a href="/Denis/faces/results.jsp">Get Results</a></div>
    </form>
    <br>
    </tr>
    </body>
    </html>
</f:view>
