<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int max = 100;
int min = 1;
session.setAttribute("min", min);
session.setAttribute("max", max); %>
Hola. Esta aplicación adivinará el número al cual usted pensará
<form action="adivinaNumero.jsp">
<input type="submit" value="Inicio"/>
</form>
</body>
</html>