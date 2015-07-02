<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menor o mayor</title>
</head>
<body>
<p>Es el número pensado por usted menor o mayor de <%= (Integer)session.getAttribute("num") %>?</p>
<form action="adivinaNumero.jsp">
<input type="submit" value="Menor"/>
</form>
<form action="adivinaNumero.jsp">
<input type="submit" value="Mayor"/>
</form>
</body>
</html>