<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Save Bookmark</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-bookmark-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>ShareMe</h2>
    </div>
</div>

<div id="container">
    <h3>Save Bookmark</h3>

    <form:form action="save" modelAttribute="movie" method="post">
        <%--embed id for update --%>
        <form:hidden path="id"/>
        <table>
            <tr>
                <td><lable>Title: </lable></td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td><lable>Description: </lable></td>
                <td><form:input path="description"/></td>
            </tr>
            <tr>
                <td><lable>Release Year: </lable></td>
                <td><form:input path="releaseYear"/></td>
            </tr>
            <tr>
                <td><lable>IMDB Rating: </lable></td>
                <td><form:input path="imdbRating"/></td>
            </tr>
            <tr>
                <form:select path="genre">
                    <form:options items="${movie.genreOptions}"/>
                </form:select>
            </tr>
            <tr>
                <td><lable>Director: </lable></td>
                <td><form:input path="directors"/></td>
            </tr>
            <tr>
                <td><lable>Actors: </lable></td>
                <td><form:input path="actors"/></td>
            </tr>

        </table>
        <input type="submit" value="Save" class="add-button"/>
    </form:form>
</div>
</body>
</html>
