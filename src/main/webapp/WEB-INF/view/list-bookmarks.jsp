<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Sayantan
  Date: 9/30/2019
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>ShareMe</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <%--button to add customer--%>
        <input type="button" value="Add Bookmark"
               onclick="window.location.href='form'; return false;" class="add-button"/>

        <table>
            <tr>
                <th>Book Title</th>
                <th>Description</th>
                <th>Publication Year</th>
                <th>Amazon Rating</th>
                <th>Genre</th>
                <th>Publishers</th>
                <th>Authors</th>
                <th>Action</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <%--create url for update with embedded customer id--%>
                <c:url var="updateLink" value="/book/update">
                    <c:param name="bookmarkId" value="${book.id}"/>
                </c:url>

                <%--create url to delete with embedded customer id--%>
                <c:url var="deleteLink" value="/book/delete">
                    <c:param name="bookmarkId" value="${book.id}"/>
                </c:url>
                <tr>
                    <td>${book.title}</td>
                    <td>${book.description}</td>
                    <td>${book.publicationYear}</td>
                    <td>${book.amazonRating}</td>
                    <td>${book.genre}</td>
                    <td>${fn:join(book.publishers.toArray(), ",")}</td>
                    <td>${fn:join(book.authors.toArray(), ",")}</td>
                    <td>
                        <a href="${updateLink}"><u>Update</u> | </a><a href="${deleteLink}"><u>Delete</u></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
