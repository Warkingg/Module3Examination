<%--
  Created by IntelliJ IDEA.
  User: STO
  Date: 3/22/2021
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<h1>Edit Product</h1>
<div class="container" style="margin-top: 20px">
    <form method="post" style="padding-top: 50px" action="/productController?ac=update">
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="inputName">Product Id</label>
                <input type="text" name="productId" class="form-control" id="inputId" value="${product.getProductId()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="inputName">Product Name</label>
                <input type="text" name="productName" class="form-control" id="inputName" placeholder="${product.getProductName()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="inputPrice">Product Price</label>
                <input type="text" name="productPrice" class="form-control" id="inputPrice" placeholder="${product.getPrice()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="inputQuantity">Product Quantity</label>
                <input type="text" name="productQuantity" class="form-control" id="inputQuantity" placeholder="${product.getQuantity()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="inputColor">Product Color</label>
                <input type="text" name="productColor" class="form-control" id="inputColor" placeholder="${product.getColor()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="textarea">Description</label><br/>
                <textarea id="textarea" style="min-height: 200px;max-height: 200px;min-width: 1110px;max-width: 1110px">
                    S???a ??i nh??n v??o ????y l??m g???
                </textarea>
            </div>
        </div>
        <div class="form-group col-md-13">
            <label for="inputState">Category</label>
            <select id="inputState" class="form-control" name="categoryName">
                <option>Phone</option>
                <option>Television</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Update</button>
        <a href="/productController">
            <button type="button" class="btn btn-secondary">Back</button>
        </a>
    </form>
</div>
</body>
</html>
