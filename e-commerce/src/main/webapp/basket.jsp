<%--
  Created by IntelliJ IDEA.
  User: stageusr2015
  Date: 05/06/2015
  Time: 12:24
  To change this template use File | Settings | File Templates.
  TODO: refactor product list, look at map.values()
  TODO: refactor footer
  TODO: refactor header
--%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <title>Shopping Basket</title>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <style type="text/css">
    table,th,td
    {
      border: 1px solid black;
      height: 30px;
      width: 20%;
      text-align: center;
    }
    table {
      width: 50%;
    }
    td.id {
      width: 10%;
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
<%-- Using JSTL forEach and out to loop a list and display items in table --%>
<h1>Shopping basket</h1>
<form action="basket" method="put"> cant do this ._.
  <table id="prods">
    <tbody>
      <tr><th>ID</th><th>Name</th><th>Price</th><th>Amount</th></tr>
      <c:forEach items="${sessionScope.basket}" var="entry">
        <tr>
          <td class="id"><c:out value="${entry.value.id}"/></td>
          <td>
            <a href="product?id=<c:out value="${entry.value.id}"/>">
                <c:out value="${entry.value.name}"/>
            </a>
          </td>
          <td><c:out value="${entry.value.price}"/></td>
          <td><input class="amount" type="number" min="1" name="amount" value="<c:out value="${entry.value.amount}"/>"></td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
  <input type="submit" value="save">
</form>
</body>
</html>