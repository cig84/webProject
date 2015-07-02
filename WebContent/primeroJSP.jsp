<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import='java.util.Date' %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hola Mundo</title>
</head>
<body>
<p>Hola, esta es una página JSP.</p>
<p>La hora del servidor es <%= new Date() %></p>
<!--  <p><%@include file = "/SesionesActivas" %> -->
<p><jsp:include page="/SesionesActivas"></jsp:include>
</body>
</html>