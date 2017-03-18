<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/20
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>UserInput</title>
</head>
<body>
    <form:form commandName="user" action="signIn" method="post">
        Error: <form:errors path="*" /><br/>
        Username: <form:input path="username" /><form:errors path="username" /><br/>
        Password: <form:input path="password"/><form:errors path="password" /><br/>
        <input type="submit" value="SignIn">
    </form:form>
</body>
</html>
