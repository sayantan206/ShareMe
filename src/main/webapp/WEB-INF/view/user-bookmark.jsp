<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">ShareMe</span>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation -->
            <nav id="nav-header" class="mdl-navigation">
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/recent/list">Browse</a>
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/book/list">Book</a>
                <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/movie/list">Movie</a>
                <a class="mdl-navigation__link" href="#">Web Link</a>
                <a class="mdl-navigation__link" href="#">Web Series</a>
                <div class="mdl-layout-spacer"></div>

                <%--search field--%>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable
                  mdl-textfield--floating-label mdl-textfield--align-right">
                    <label class="mdl-button mdl-js-button mdl-button--icon" for="fixed-header-drawer-exp">
                        <i class="material-icons">search</i>
                    </label>
                    <div class="mdl-textfield__expandable-holder">
                        <input class="mdl-textfield__input" name="sample" id="fixed-header-drawer-exp">
                    </div>
                </div>
            </nav>
        </div>
    </header>

    <%--side nav-bar drawer--%>
    <div class="mdl-layout__drawer">
        <span class="mdl-layout-title">Browse</span>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/user_bookmark/list">My List</a>
            <a class="mdl-navigation__link" href="#">Archive</a>
            <a class="mdl-navigation__link" href="#">Favourites</a>
            <a class="mdl-navigation__link" href="#">Tags</a>
        </nav>
    </div>
    <div id="content">
        <!-- add cards inside -->
        <c:forEach var="bookmark" items="${bookmarks}">
            <c:set var="bookmarkType" value="${fn:toLowerCase(bookmark.bookmarkType)}"/>

            <div class="card demo-card-square mdl-card mdl-shadow--2dp">
                <div class="mdl-card__title mdl-card--expand">
                    <h2 class="mdl-card__title-text">${bookmark.title}</h2>
                </div>
                <div class="mdl-card__supporting-text description">
                        ${bookmark.description}
                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <div align="right">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                            View Post
                        </a>

                        <!-- Right aligned menu on top of button  -->
                        <button id="demo-menu-top-right-${bookmark.id}"
                                class="mdl-button mdl-js-button mdl-button--icon">
                            <i class="material-icons">more_vert</i>
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
                        </ul>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>

</html>