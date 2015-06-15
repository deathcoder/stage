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

    tr.hidden {
      display: none;
    }
  </style>
  <script type="text/javascript">
    function hideIfZero(element) {
      if(element.value == 0) {
        element.type = "hidden";
        document.getElementById(element.id).className = "hidden";
      }
    }
  </script>
</head>
<body>
<%@ include file="header.jsp" %>
<%-- Using JSTL forEach and out to loop a list and display items in table --%>
<h1>Shopping basket</h1>
<form action="basket" method="post">
  <table id="prods">
    <tbody>
      <tr><th>ID</th><th>Name</th><th>Price</th><th>Amount</th></tr>
      <c:forEach items="${basket.basketProducts}" var="product">
        <tr id="row<c:out value="${product.id}"/>">
          <td class="id">
            <input type="hidden" name="product" value="<c:out value="${product.id}"/>"/></td>
          <td>
            <a href="product?id=<c:out value="${product.id}"/>">
                <c:out value="${product.name}"/>
            </a>
          </td>
          <td><c:out value="${product.price}"/></td>
          <td><input id="row<c:out value="${product.id}"/>" type="number" min="0" name="amount" value="<c:out value="${product.amount}"/>" title="amount" onchange="hideIfZero(this)"/>
          </td>
        </tr>
    </c:forEach>
    </tbody>
  </table>
  <input type="hidden" name="action" value="update">
  <input type="submit" value="save">
</form>
<%@ include file="footer.jsp" %>
</body>
</html>