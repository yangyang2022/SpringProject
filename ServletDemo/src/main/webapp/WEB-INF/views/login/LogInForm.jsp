<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <sf:form commandName="login" action="login" method="post">
        <fieldset>
            <legend>Login</legend><br/>
            <label for="username">Username:</label>
            <sf:input path="username" id="username"/><br/>

            <label for="password">Password: </label>
            <sf:input path="password" id="password" />

            <input type="submit" value="Login">
        </fieldset>
    </sf:form>
</body>
</html>
