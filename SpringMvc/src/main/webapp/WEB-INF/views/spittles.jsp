<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/23
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>spittles</title>
</head>
<body>
    spittles: ${hello}<br/>
    <table border="1" cellpadding="0" cellspacing="1">
       <tr>
           <td>ID</td>
           <td>Message</td>
           <td>Time</td>
           <td>Edit</td>
       </tr>
        <c:forEach items="${sps}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.message}</td>
                <td>${e.time}</td>
                <td>edit</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
