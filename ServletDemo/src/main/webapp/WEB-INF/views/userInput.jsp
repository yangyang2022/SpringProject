<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/20
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>UserInput</title>
</head>
<body>
    <sf:form commandName="user" action="signIn" method="post">
        Username: <sf:input path="username" /><sf:errors path="username" /><br/>
        Password: <sf:input path="password" /><sf:errors path="password" /><br/>
        <input type="submit" value="SignIn">
    </sf:form>
</body>
</html>
