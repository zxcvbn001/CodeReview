<%@ page import="java.io.*,java.util.*" %>
<%
    String title = "Accessing Request Param";
%>
<html>
<head>
    <title><% out.print(title); %></title>
</head>
<body>
<center>
    <h1><% out.print(title); %></h1>
</center>
<div align="center">
    <p>${param["username"]}</p>
</div>
</body>
</html>