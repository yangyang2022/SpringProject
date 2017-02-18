<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/17
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FileDetails</title>
</head>
<body>
        <h1>File Details: </h1>
        ProductName: ${product.name}<br/>
        Desc: ${product.description}<br/>
        Price: ${product.price}<br/>
    <h2>Follow File are upload successfully</h2>
    <ol>
        <c:forEach items="${product.images}" var="image">
            <li>${image.originalFilename}
                <img width="100" src="<c:url value="/image/"/>">${image.originalFilename}
            </li>
        </c:forEach>
    </ol>
</body>
</html>
