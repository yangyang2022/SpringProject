<%--
  Created by IntelliJ IDEA.
  User: syy
  Date: 2017/2/17
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductDetail</title>
</head>
<body>
    <div id="global">
        <h4>The product has been saved</h4>
        <p>
            <h5>Details: </h5>
            Product Name: ${product.name}<br/>
            Product Desc: ${product.description}<br/>
            Product Price: ${product.price}<br/>
        </p>
    </div>
</body>
</html>
