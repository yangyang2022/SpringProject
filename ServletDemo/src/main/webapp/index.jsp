<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/17
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <form action="file" enctype="multipart/form-data" method="post">
        Select a file: <input type="file" name="file" multiple>
        <input type="submit" value="UploadFile">
    </form>
</body>
</html>
