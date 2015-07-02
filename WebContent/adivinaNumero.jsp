<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.lang.Math" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adivinar numero</title>
</head>
<body>

<%
int min = (Integer)session.getAttribute("min");
int max = (Integer)session.getAttribute("max");
if(null != session.getAttribute("num")){
	String x = request.getParameter("submit");
	if(x.contentEquals("Menor")){
		max = (Integer)session.getAttribute("num");
	}
	else {
		min = (Integer)session.getAttribute("num");
	}
}
int num = (int)Math.floor(Math.random()*(max-1+min)+min); 
session.setAttribute("min", min);
session.setAttribute("max", max);
%>
<%session.setAttribute("num", num); %>
<p>Es este?</p>
<form>
<input type="text" value=<%= num %>>
</form>
<form action="enhorabuenaPaMi.html">
<input type="submit" value="Si"/>
</form>
<form action="minOmax.jsp">
<input type="submit" value="No"/>
</form>
</body>
</html>