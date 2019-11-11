<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Sayantan
  Date: 11/4/2019
  Time: 7:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="../../resources/static/material.min.css">
    <link rel="stylesheet" href="../../resources/static/style.css">
    <script src="../../resources/static/material.min.js"></script>
    <script src="../../resources/static/list-all.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>

    <script>
        $(window).load(function () {
            // Animate loader off screen
            $(".loader").fadeOut("slow");
        });


        //disable enter key for form submission
        document.onkeypress = stopRKey;
    </script>

</head>

<body>
<!-- MDL Progress Bar with Indeterminate Progress -->
<div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate loader"></div>

<div class="mdl-layout mdl-js-layout">
    <header class="mdl-layout__header mdl-layout__header--scroll">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">Share Me</span>
        </div>
    </header>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Browse</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="">My List</a>
            <a class="mdl-navigation__link" href="">Archive</a>
            <a class="mdl-navigation__link" href="">Favourites</a>
            <a class="mdl-navigation__link" href="">Tags</a>
        </nav>
    </div>
    <div id="add-form">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Add Book</h2>
            </div>


            <div class="mdl-card__supporting-text">
                <form:form action="save" modelAttribute="book" method="post">
                    <%--embedded id for update--%>
                    <form:hidden path="id"/>
                    <form:hidden path="bookmarkType"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="title" class="mdl-textfield__input" type="text" id="sample3"/>
                        <label class="mdl-textfield__label" for="sample3">Title</label>
                    </div>
                    <form:errors path="title" cssClass="error"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:textarea path="description" class="mdl-textfield__input" type="text" rows="3"
                                       id="sample5"/>
                        <label class="mdl-textfield__label" for="sample5">Description</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:select path="genre" class="mdl-textfield__input" type="text">
                            <form:options items="${book.genreOptions}"/>
                        </form:select>
                        <label class="mdl-textfield__label" for="sample3">Genre</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="publicationYear" class="mdl-textfield__input" type="text"/>
                        <label class="mdl-textfield__label" for="sample3">Publication Year</label>
                    </div>
                    <form:errors path="publicationYear" cssClass="error"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="amazonRating" class="mdl-textfield__input" type="text"/>
                        <label class="mdl-textfield__label" for="sample3">Amazon Rating</label>
                    </div>
                    <form:errors path="amazonRating" cssClass="error"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="publishers" class="mdl-textfield__input" type="text"/>
                        <label class="mdl-textfield__label" for="sample3">Publishers</label>
                    </div>
                    <form:errors path="publishers" cssClass="error"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="authors" class="mdl-textfield__input mdl-chip__text" type="text"/>
                        <label class="mdl-textfield__label" for="sample3">Authors</label>
                    </div>
                    <form:errors path="authors" cssClass="error"/>


                    <div style="padding-top:15px; float: right;">
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect"
                                onclick="window.location.href='list'; return false;">
                            Cancel
                        </button>
                        <button id="saveBtn" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect">
                            Save
                        </button>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
