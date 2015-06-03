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
            height: 30px;
            width: 20%;
            text-align: center;
        }
        td.id {
            width: 10%;
        }
    </style>
</head>
<body>
<%-- Using JSTL forEach and out to loop a list and display items in table --%>
<h1>Product List</h1>
<table>
    <tbody>
    <tr><th>ID</th><th>Name</th><th>Price</th></tr>
    <c:forEach items="${requestScope.prodList}" var="prod">
            <td class="id"><a href="prod/?id=<c:out value="${prod.id}"/>">
                <c:out value="${prod.id}"/>
                </a>
            </td>
            <td><c:out value="${prod.name}"/></td>
            <td><c:out value="${prod.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--

<br><br>
&lt;%&ndash; simple c:if and c:out example with HTML escaping &ndash;%&gt;
<c:if test="${requestScope.htmlTagData ne null }">
    <c:out value="${requestScope.htmlTagData}" escapeXml="true"/>
</c:if>
<br><br>
&lt;%&ndash; c:set example to set variable value &ndash;%&gt;
<c:set var="id" value="5" scope="request"/>
<c:out value="${requestScope.id }" />
<br><br>
&lt;%&ndash; c:catch example &ndash;%&gt;
<c:catch var ="exception">
    <% int x = 5/0;%>
</c:catch>

<c:if test = "${exception ne null}">
   <p>Exception <i></i>s : ${exception} <br />
   Exception <Messag></Messag>e: ${exception.message}</p>
</c:if>
<br><br>
&lt;%&ndash; c:url example &ndash;%&gt;
<a href="<c:url value="${requestScope.url }"></c:url>">JournalDev</a>
--%>

</body>
</html>