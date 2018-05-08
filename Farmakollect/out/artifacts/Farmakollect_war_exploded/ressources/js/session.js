function navbar() {

    var idRole = sessionStorage.getItem('userRole');

    var navbar = "<nav class='navbar navbar-expand-lg navbar-light ml-auto fixed-top' style='background-color: #91dbdb'>" +
        "<a class='navbar-brand ml-auto' href='accueil.html'>Bonjour " + sessionStorage.getItem('userName')+ "</a>" +
        "<ul class='navbar-nav'>";
    if (idRole == 0){
        navbar = navbar +
            "<li class='nav-item ecart'>" +
            "<a href='manage.html' class='btn btn-block btn-outline-info'><span class='fa fa-user-plus' title='Espace Administrateur'></span></a>" +
            "</li>";
    }

    if (idRole < 4){
        navbar = navbar +
            "<li class='nav-item ecart'>" +
            "<a href=\"\" class='btn btn-block btn-outline-info'><span class='fa fa-shopping-basket' title='Panier'></span></a>" +
            "</li>" +
            "<li class='nav-item ecart'>" +
            "<a href=\"\" class='btn btn-block btn-outline-info'><span class='fa fa-history' title='Historique'></span></a>" +
            "</li>";
    }
    navbar = navbar +
    "<li class='nav-item ecart'>" +
    "<a href=\"\" class='btn btn-block btn-outline-info'><span class='fa fa-cog' title='Réglages'></span></a>" +
    "</li>" +
    "<li class='nav-item ecart'>" +
    "<a onclick='logOut()' class='btn btn-block btn-outline-info'><span class='fa fa-sign-out-alt'></span> Se déconnecter</a>" +
    "</li>" +
    "</ul>" +
    "</nav>";
    $('#navbar').html(navbar);
}

function logOut() {
    sessionStorage.clear();
    window.location.href = "login.html";
}

function logCheck() {
    var user = sessionStorage.getItem('userRole');
    if (user == null){
        window.location.href = "error.html";
    }
}