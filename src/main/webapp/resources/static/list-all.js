function setNavigationHighlight() {
    for (var i = 0; i < document.links.length; i++) {
        if (document.links[i].href === document.URL) {
            if (document.URL.indexOf("user_bookmark") > -1)
                document.links[i].className += " active_2";
            else
                document.links[i].className += " active";
        }
    }
}

function showElementOnPage(pageLink, elementId, isVisible) {
    if (!(window.location.href.indexOf(pageLink) > -1)) {
        var elementById = document.getElementById(elementId);
        //show button
        if(isVisible === false)
            elementById.style.display = "block";
        else
            elementById.style.display = "inline";
    }
}

function stopRKey(event) {
    var evt = (event) ? event : ((event) ? event : null);
    if ((evt.keyCode === 13))  {return false;}
}

function setFileChooserText(btnId, fieldId) {
    document.getElementById(btnId).onchange = function () {
        document.getElementById(fieldId).value = this.files[0].name;
    };
}