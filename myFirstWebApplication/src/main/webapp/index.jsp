<%@page import="java.util.ArrayList"%>
<%@page import="jakarta.servlet.http.Cookie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5>${msg}</h5>
	<h1>index.jsp</h1>
	<a href="products"><h3>Products</h3></a>
	
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(int i=0; i<cookies.length-1; i++){
				out.print(cookies[i].getName()+" : " + cookies[i].getValue() + "<br>" );
			}
		}
	%>
	
	<form action ="cookieHandler" method="POST">
		<input type = "text" name= "name" placeholder="Name"><br>
		<input type = "text" name= "address" placeholder="Address"><br>
		<input type = "submit" value ="submit">
	</form>
	
	<a href="cookieHandler">\clear cookie</a>
	
	<form action ="sessionHandler" method="POST">
		<input type = "text" name= "item" placeholder="Item"><br>
		
		<input type = "submit" value ="Add Item">
	</form>
	<ul>
<%-- 	<%
		ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
		if(items!=null){
			for(String item:items){
				out.print("<li>"+item+"</li>");
			}
		}
	
	%> --%>
	</ul>
	<h2> Add Product Form </h2>
	<form action="products" method="POST">
		<input type = "text" name= "name" placeholder="Name"><br>
		<input type = "text" name= "manufacturer" placeholder="Manufacturer"><br>
		<input type = "text" name= "description" placeholder="Description"><br>
		<input type = "number" name= "price" placeholder="Price"><br>
		In Stock: 
		<input type = "radio" name= "inStock" value="true"/>Yes
		<input type = "radio" name= "inStock" value="false"/>No<br>
		<input type = "submit" value ="submit">
	
	</form>
</body>
</html>