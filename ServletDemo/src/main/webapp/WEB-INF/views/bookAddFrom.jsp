<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/17
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>BookAdd</title>
</head>
<body>
<sf:form commandName="book" action="save" method="post">
    <sf:errors path="*" /><br/>
    ISBN: <sf:input path="isbn" /><sf:errors path="isbn"/><br/>
    TITLE: <sf:input path="title" /><sf:errors path="title"/><br/>
    AUTHOR: <sf:input path="author" /><sf:errors path="author" /><br/>
    ReadDate: <sf:input path="readDate" /><sf:errors path="readDate" /><br/>
    Category: <sf:select path="category.id" items="${cats}" itemLabel="name" itemValue="id" /><br/>
    <input type="submit" value="Add Book">
</sf:form>
</body>
</html>
