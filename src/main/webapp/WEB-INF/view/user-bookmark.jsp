<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <title>ShareMe - My List</title>

    <script>
        $(window).load(function () {
            // Animate loader off screen
            $(".loader").fadeOut("slow");
            setNavigationHighlight();
        });
    </script>
</head>

<body>
<!-- MDL Progress Bar with Indeterminate Progress -->
<div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate loader"></div>

<!-- Uses a header that scrolls with the text, rather than staying locked at the top -->
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

    <%--side nav-bar drawer--%>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Browse</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/user_bookmark/list">My List</a>
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/user_bookmark/saved/list">Saved</a>
            <a class="mdl-navigation__link" href="#">Archived</a>
            <a class="mdl-navigation__link" href="#">Favourites</a>
        </nav>
    </div>
    <div id="content">
        <!-- add cards inside -->
        <c:forEach var="bookmark" items="${bookmarks}">
            <c:set var="bookmarkType" value="${fn:toLowerCase(bookmark.bookmarkType)}"/>

            <div class="card demo-card-square mdl-card mdl-shadow--4dp">
                <div style="background: url(${bookmark.imageURL}) left top;
                        background-size: 100% 140%;"
                     class="mdl-card__title mdl-card--expand">
                </div>
                <div class="mdl-card__supporting-text description">
                    <b style="font-size: 15px">${bookmark.title}</b>: ${bookmark.description}

                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <div align="right">
                        <a style="min-width: initial;" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            View Post
                        </a>

                        <!-- Right aligned menu on top of button  -->
                        <button id="demo-menu-top-right-${bookmark.id}"
                                class="mdl-button mdl-js-button mdl-button--icon">
                            <div id="actions-${bookmark.id}"><i class="material-icons">more_vert</i></div>
                            <div class="mdl-tooltip" for="actions-${bookmark.id}">Actions</div>
                        </button>

                        <ul class="mdl-menu mdl-menu--top-right mdl-js-menu mdl-js-ripple-effect"
                            data-mdl-for="demo-menu-top-right-${bookmark.id}">
                            <li>
                                <a class="mdl-menu__item"
                                   href="${pageContext.request.contextPath}/${bookmarkType}/update?bookmarkId=${bookmark.id}">
                                    Edit
                                </a>
                            </li>
                            <li>
                                <a class="mdl-menu__item"
                                   href="${pageContext.request.contextPath}/${bookmarkType}/delete?bookmarkId=${bookmark.id}">
                                    Delete
                                </a>
                            </li>
                            <li><a disabled class="mdl-menu__item">Share</a></li>
                            <li><a disabled class="mdl-menu__item">Archive</a></li>
                            <li><a disabled class="mdl-menu__item">Favourite</a></li>
                            <li><a disabled class="mdl-menu__item">Tag</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>

</html>