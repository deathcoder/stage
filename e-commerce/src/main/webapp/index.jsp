<%@ page import="it.objectway.corsi.ecommerce.impl.DaoProductImpl" %>
<%@ page import="it.objectway.corsi.ecommerce.interfaces.DaoProduct" %>
<%@ page import="it.objectway.corsi.ecommerce.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<b>The Demo Object Names Are:- </b>
    <br>
    <%
        DaoProduct dao = new DaoProductImpl();
        /*Map<Integer,String> products = dao.getProductList();*/
    %>
    <table>
        <% List<Product> products = dao.getProductList(); %>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.getId()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>