<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<table>
    <c:forEach items="${products}" var="product">
<tr>
    <td>
        ${product.name}
    </td>
</tr>
    </c:forEach>
</table>
</body>
</html>