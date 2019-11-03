<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="../../resources/static/material.min.css">
    <link rel="stylesheet" href="../../resources/static/style.css">
    <script src="../../resources/static/material.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>

<body>
    <!-- Uses a header that scrolls with the text, rather than staying
  locked at the top -->
    <div class="mdl-layout mdl-js-layout">
        <header class="mdl-layout__header mdl-layout__header--scroll">
            <div class="mdl-layout__header-row">
                <!-- Title -->
                <span class="mdl-layout-title">ShareMe</span>
                <!-- Add spacer, to align navigation to the right -->
                <div class="mdl-layout-spacer"></div>
                <!-- Navigation -->
                <nav class="mdl-navigation">
                    <a class="mdl-navigation__link" href="${pageContext.request.contextPath}/recent/post">Browse</a>
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
                            <input class="mdl-textfield__input" type="text" name="sample" id="fixed-header-drawer-exp">
                        </div>
                    </div>
                    <div class="mdl-layout-spacer"></div>
                    <!-- Right aligned menu below button -->
                    <button id="demo-menu-lower-right"
                            class="mdl-button mdl-js-button mdl-button--icon">
                        <i class="material-icons">more_vert</i>
                    </button>

                    <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
                        for="demo-menu-lower-right">
                        <li class="mdl-menu__item" id="addBook">Add Book</li>
                        <li class="mdl-menu__item">Add Movie</li>
                        <li disabled class="mdl-menu__item">Add Web Link</li>
                        <li class="mdl-menu__item">Add Web Series</li>
                    </ul>
                </nav>
                
                <%--modal--%>
                <div id="myModal" class="modal">
                    <!-- Modal content -->
                    <div class="modal-container">
                        <span class="close">&times;</span>
                        <div class="modal-content">
                            <p>Some text in the Modal..</p>
                        </div>
                        <div class="modal-button">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" type="button">Close</button>
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" type="button">Save</button>
                        </div>
                    </div>
                </div>

                <script>
                    var modal = document.getElementById("myModal");
                    var btn = document.getElementById("addBook");
                    var span = document.getElementsByClassName("close")[0];
                    btn.onclick = function () {
                        modal.style.display = "block";
                    };
                    span.onclick = function () {
                        modal.style.display = "none";
                    };
                    // When the user clicks anywhere outside of the modal, close it
                    window.onclick = function (event) {
                        if (event.target === modal) {
                            modal.style.display = "none";
                        }
                    }
                </script>
            </div>
        </header>
        <div class="mdl-layout__drawer">
            <span class="mdl-layout-title">Browse</span>
            <nav class="mdl-navigation">
                <a class="mdl-navigation__link" href="#">My List</a>
                <a class="mdl-navigation__link" href="#">Archive</a>
                <a class="mdl-navigation__link" href="#">Favourites</a>
                <a class="mdl-navigation__link" href="#">Tags</a>
            </nav>
        </div>
        <main class="mdl-layout__content">
            <div class="page-content">
                <!-- Your content goes here -->
            </div>
        </main>
    </div>

    <!-- content panel -->
    <div id="content">
        <!-- add cards inside -->
        <c:forEach var="bookmark" items="${bookmarks}">
            <div class="card demo-card-square mdl-card mdl-shadow--2dp">
                <div class="mdl-card__title mdl-card--expand">
                    <h2 class="mdl-card__title-text">${bookmark.title}</h2>
                </div>
                <div class="mdl-card__supporting-text description">
                    ${bookmark.description}
                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                        View Post
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</body>

</html>