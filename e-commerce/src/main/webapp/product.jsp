<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Home Page</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style>
        table,th,td
        {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Product</h1>
<table>
    <tbody>
    <tr>
        <th>ID</th><th>Name</th><th>Price</th>
        <th>Storage</th><th>Description</th>
    </tr>
    <tr>
        <td><c:out value="${requestScope.product.id}"/></td>
        <td><c:out value="${requestScope.product.name}"/></td>
        <td><c:out value="${requestScope.product.price}"/></td>
        <td><c:out value="${requestScope.product.storage}"/></td>
        <td><c:out value="${requestScope.product.description}"/></td>
    </tr>
    </tbody>
</table>
<br><br>
</body>
</html>