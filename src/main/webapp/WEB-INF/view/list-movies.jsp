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
                <th>Movie Title</th>
                <th>Description</th>
                <th>Release Year</th>
                <th>IMDB Rating</th>
                <th>Genre</th>
                <th>Director</th>
                <th>Actor</th>
                <th>Action</th>
            </tr>
            <c:forEach var="movie" items="${movies}">
                <%--create url for update with embedded customer id--%>
                <c:url var="updateLink" value="/movie/update">
                    <c:param name="bookmarkId" value="${movie.id}"/>
                </c:url>

                <%--create url to delete with embedded customer id--%>
                <c:url var="deleteLink" value="/movie/delete">
                    <c:param name="bookmarkId" value="${movie.id}"/>
                </c:url>
                <tr>
                    <td>${movie.title}</td>
                    <td>${movie.description}</td>
                    <td>${movie.releaseYear}</td>
                    <td>${movie.imdbRating}</td>
                    <td>${movie.genre}</td>
                    <td>${fn:join(movie.directors.toArray(), ",")}</td>
                    <td>${fn:join(movie.actors.toArray(), ",")}</td>
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
