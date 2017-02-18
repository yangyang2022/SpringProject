<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/17
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>BookListForm</title>
</head>
<body>
    <h1>Book List</h1>
    <a href="<c:url value="/book/input"/>">Add Book</a><br/>
    <table>
        <tr>
            <td>Category</td>
            <td>Title</td>
            <td>ISBN</td>
            <td>Author</td>
            <td>ReadDate</td>
            <td>&nbsp;</td>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.category.name}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td>${book.readDate}</td>
                <td>
                    <a href="edit/${book.id}">Edit</a>&nbsp;
                    <a href="delete/${book.id}">Delete</a>&nbsp;
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
