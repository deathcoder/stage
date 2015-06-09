<%@ page import="it.objectway.corsi.ecommerce.models.Product" %>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Home Page</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <style type="text/css">
        table,th,td
        {
            border: 1px solid black;
            width: 100%;
        }

        table {
            width: 50%;
        }
        td,th {
            width: 10%;
            text-align: center;
        }

        td.descrcol {
            width: 60%;
        }

        p {
            width: 100%;
            text-align: center;
        }

        p.limit {
            text-overflow: ellipsis; /* will make [...] at the end */
            width: 370px; /* change to your preferences */
            white-space: nowrap; /* paragraph to one line */
            overflow:hidden; /* older browsers */
        }

        #prods tr > *:nth-child(1) {
            display: none;
        }
        input.amount {
            width: auto;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Product</h1>
<table id="prods">
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
        <td onmouseover="document.getElementById('descr').className = ''"
            onmouseout="document.getElementById('descr').className = 'limit'"
            class="descrcol">
            <p class="limit" id="descr">
                <c:out value="${requestScope.product.description}"/>
            </p>
        </td>
    </tr>
    </tbody>
</table>
<br/>
<form action="basket" method="post">
    <input class="amount" type="number" min="1" name="amount" value="1"/>
    <input type="hidden" name="id" value="<c:out value="${requestScope.product.id}"/>"/>
    <input type="submit" value="Add to Basket"/>
</form>
<br><br>
</body>
</html>