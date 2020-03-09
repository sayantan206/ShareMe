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

    <title>ShareMe - Add Movie</title>

    <script>
        $(window).load(function () {
            // Animate loader off screen
            $(".loader").fadeOut("slow");
        });


        //disable form submission on enter key
        document.onkeypress = stopRKey;
    </script>

</head>

<body>
<!-- MDL Progress Bar with Indeterminate Progress -->
<div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate loader"></div>

<div class="mdl-layout mdl-js-layout">
    <header class="mdl-layout__header mdl-layout__header--scroll">
        <div class="mdl-layout__header-row header-row">
            <!-- Title -->
            <span class="mdl-layout-title hover-pointer" onclick="window.location.href='/recent/list'; return false;">
                ShareMe
            </span>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation -->
            <nav id="nav-header" class="mdl-navigation">
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/recent/list">Browse</a>
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/book/list">Book</a>
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/movie/list">Movie</a>
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/#">Web Link</a>
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/#">Web Series</a>
                <div class="mdl-layout-spacer"></div>

                <%--search field--%>
                <div style="padding-right: 15px;" class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="fixed-header-drawer-exp">
                        <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                        <input class="mdl-textfield__input" name="sample" id="fixed-header-drawer-exp">
                    </div>
                </div>

                <%--user account menu--%>
                <i id="demo-menu-lower-right"
                   class="material-icons md-36 hover-pointer">account_circle</i>

                <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
                    for="demo-menu-lower-right">
                    <li disabled class="mdl-menu__item">View Profile</li>
                    <li disabled class="mdl-menu__item">Settings</li>
                    <form:form action="${pageContext.request.contextPath}/logout"
                               method="POST" class="mdl-menu__item">
                        <input style="padding: 0; width: 100%" class="mdl-menu__item" type="submit" value="Logout"/>
                    </form:form>
                </ul>
            </nav>
        </div>
    </header>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Browse</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/user_bookmark/list">My List</a>
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/user_bookmark/saved/list">Saved</a>
            <a class="mdl-navigation__link" href="">Archived</a>
            <a class="mdl-navigation__link" href="">Favourites</a>
        </nav>
    </div>
    <div id="add-form">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">Add Movie</h2>
            </div>


            <div class="mdl-card__supporting-text">
                <form:form action="save" modelAttribute="movie" method="post">
                    <%--embedded id for update--%>
                    <form:hidden path="id"/>
                    <form:hidden path="bookmarkType"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="imageURL" class="mdl-textfield__input" placeholder="Image" type="text"
                                    id="uploadFile"/>
                        <div class="mdl-button mdl-button--primary mdl-button--icon mdl-button--file">
                            <i class="material-icons">attach_file</i><input type="file" id="uploadBtn">
                        </div>
                    </div>
                    <form:errors path="imageURL" cssClass="error"/>

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
                            <form:options items="${movie.genreOptions}"/>
                        </form:select>
                        <label class="mdl-textfield__label" for="sample3">Genre</label>
                    </div>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="releaseYear" class="mdl-textfield__input" type="text"/>
                        <label class="mdl-textfield__label" for="sample3">Release Year</label>
                    </div>
                    <form:errors path="releaseYear" cssClass="error"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="imdbRating" class="mdl-textfield__input" type="text"/>
                        <label class="mdl-textfield__label" for="sample3">IMDB Rating</label>
                    </div>
                    <form:errors path="imdbRating" cssClass="error"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="directors" class="mdl-textfield__input" type="text"/>
                        <label class="mdl-textfield__label" for="sample3">Directors</label>
                    </div>
                    <form:errors path="directors" cssClass="error"/>

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="actors" class="mdl-textfield__input mdl-chip__text" type="text"/>
                        <label class="mdl-textfield__label" for="sample3">Actors</label>
                    </div>
                    <form:errors path="actors" cssClass="error"/>


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
