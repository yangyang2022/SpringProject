<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/17
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>BookEditForm</title>
</head>
<body>
    <sf:form commandName="book" action="/book/update" method="post">
        <fieldset>
            <legend>Edit a book</legend>
            <sf:hidden path="id"/>
            <label for="category">Category:</label>
            <sf:select id="category" path="category.id" items="${cats}" itemLabel="name" itemValue="id" />
            <br/>

            <label for="title">Title: </label>
            <sf:input path="title" id="title"/>
            <br/>

            <label for="author">Author: </label>
            <sf:input path="author" id="author" />
            <br/>

            <label for="isbn">ISBN: </label>
            <sf:input path="isbn" id="isbn" />
            <br/>

            <label for="readDate">ReadDate: </label>
            <sf:input path="readDate" id="readDate" />
            <br />
            <input type="submit" value="Update Book">

        </fieldset>
    </sf:form>
</body>
</html>
