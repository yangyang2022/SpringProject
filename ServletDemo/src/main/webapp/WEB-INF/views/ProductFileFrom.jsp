<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/17
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>ProductFileFrom</title>
</head>
<body>
<sf:form commandName="product" action="/file/save" enctype="multipart/form-data">
    Name: <sf:input path="name" /><br/>
    description: <sf:input path="description" /><br/>
    price: <sf:input path="price" /><br/>
    Image: <input type="file" name="images" multiple><br/>
    <input type="submit" value="Add File">
</sf:form>

</form>
</body>
</html>
