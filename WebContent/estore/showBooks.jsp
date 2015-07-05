<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.eagle.bean.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>showBooks.jsp</title>
</head>
<body>
	<h3>${msg }</h3>
	<%
		Object o=request.getSession().getAttribute("books");
		List<Book> books=(List<Book>)o;
	%>
	<table>
		<tr>
			<td>id</td>
			<td>bookname</td>
			<td>price</td>
		</tr>
		<c:forEach items="${books }" var="book">
			<tr>
				<td>${book.id }</td>
				<td>${book.name }</td>
				<td>${book.price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>