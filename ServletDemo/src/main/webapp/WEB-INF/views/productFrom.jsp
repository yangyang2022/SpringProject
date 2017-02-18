<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/17
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductFrom</title>
</head>
<body>
    <div id="global">
        <form action="/product/save" method="post">
            <fieldset>
                <legend>Add a product</legend>
                <label for="name">Product Name: </label>
                <input type="text" id="name" name="name" value="" tabindex="1"><br/>
                <label for="description">Description: </label>
                <input type="text" id="description" name="description" tabindex="2"><br/>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price" tabindex="3"><br/>
                <div id="bottons">
                    <input id="reset" type="reset" tabindex="4">
                    <input id="submit" type="submit" tabindex="5" value="Add Product">
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>
