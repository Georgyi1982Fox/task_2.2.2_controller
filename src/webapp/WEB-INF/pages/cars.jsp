<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: georg
  Date: 18.04.2020
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<html>

<head>
    <title>Car Application</title>
</head>


<body>

<center>
    <h1>Cars</h1>
</center>


<div align="center">

    <table border="1" cellpadding="5">


        <caption><h1>${local} </h1></caption>

        <tr>
            <th>Name</th>
            <th>Number</th>
            <th>Price</th>

        </tr>

        <c:forEach var="car" items="${carList}">
            <tr>
                <td><c:out value="${car.name}" /></td>
                <td><c:out value="${car.number}" /></td>
                <td><c:out value="${car.price}" /></td>

            </tr>
        </c:forEach>


    </table>

    </form>


</div>


</body>
</html>











