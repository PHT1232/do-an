<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phatn
  Date: 11/16/2021
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>Dashboard | Front - Admin &amp; Dashboard Template</title>

    <!-- Favicon -->
    <link rel="shortcut icon" href="<c:url value="/resource/img/favicon.ico"></c:url>">
    <!-- Font -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="<c:url value="/resource/css/vendor.min.css"></c:url>">
    <link rel="stylesheet" href="<c:url value="/resource/css/style.css"></c:url>">
    <link rel="stylesheet" href="<c:url value="/resource/css/myStyle.css"></c:url>">
    <link rel="stylesheet" href="<c:url value="/resource/css/phong.css"></c:url>">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- CSS Front Template -->
    <link rel="stylesheet" href="<c:url value="/resource/css/theme.min.css?v=1.0"></c:url>">

    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

</head>
<body>
<script src="<c:url value="/resource/js/hs-navbar-vertical-aside-mini-cache.js"></c:url>"></script>
<header id="header" class="navbar navbar-expand-lg navbar-bordered flex-lg-column px-0">
    <div class="navbar-dark w-100">
        <div class="container">
            <div class="navbar-nav-wrap">
                <div class="navbar-brand-wrapper">
                    <!-- Logo -->
                    <a class="navbar-brand" href="./index.html" aria-label="Front">
                        <img class="navbar-brand-logo" src="<c:url value="/resource/img/logo-white.svg"></c:url>" alt="Logo">
                    </a>
                    <!-- End Logo -->
                </div>

                <div class="navbar-nav-wrap-content-left">
                    <!-- Search Form -->
                    <div class="d-none d-lg-block">
                        <form class="position-relative">
                            <!-- Input Group -->
                            <div class="input-group input-group-merge input-group-borderless input-group-hover-light navbar-input-group">
                                <div class="input-group-prepend">
                                    <div class="input-group-text">
                                        <i class="tio-search"></i>
                                    </div>
                                </div>
                                <input type="search" class="js-form-search form-control" placeholder="Search in front" aria-label="Search in front" data-hs-form-search-options="{
                         &quot;clearIcon&quot;: &quot;#clearSearchResultsIcon&quot;,
                         &quot;dropMenuElement&quot;: &quot;#searchDropdownMenu&quot;,
                         &quot;dropMenuOffset&quot;: 20,
                         &quot;toggleIconOnFocus&quot;: true,
                         &quot;activeClass&quot;: &quot;focus&quot;
                       }">
                                <a class="input-group-append" href="javascript:;">
                                        <span class="input-group-text">
                    <i id="clearSearchResultsIcon" class="tio-clear" style="display: none;"></i>
                  </span>
                                </a>
                            </div>
                            <!-- End Input Group -->

                            <!-- Card Search Content -->
                            <div id="searchDropdownMenu" class="hs-form-search-menu-content card dropdown-menu dropdown-card overflow-hidden animated hs-form-search-menu-hidden hs-form-search-menu-initialized">
                                <!-- Body -->
                                <div class="card-body-height py-3">

                                    <div class="dropdown-divider my-3"></div>

                                    <small class="dropdown-header mb-n2">Tutorials</small>

                                    <a class="dropdown-item my-2" href="./index.html">
                                        <div class="media align-items-center">
                                                <span class="icon icon-xs icon-soft-dark icon-circle mr-2">
                        <i class="tio-tune"></i>
                      </span>

                                            <div class="media-body text-truncate">
                                                <span>How to set up Gulp?</span>
                                            </div>
                                        </div>
                                    </a>

                                    <a class="dropdown-item my-2" href="./index.html">
                                        <div class="media align-items-center">
                                                <span class="icon icon-xs icon-soft-dark icon-circle mr-2">
                        <i class="tio-paint-bucket"></i>
                      </span>

                                            <div class="media-body text-truncate">
                                                <span>How to change theme color?</span>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <!-- End Body -->

                                <!-- Footer -->
                                <a class="card-footer text-center" href="./index.html">
                                    See all results
                                    <i class="tio-chevron-right"></i>
                                </a>
                                <!-- End Footer -->
                            </div>
                            <!-- End Card Search Content -->
                        </form>
                    </div>
                    <!-- End Search Form -->
                </div>

                <!-- Secondary Content -->
                <div class="navbar-nav-wrap-content-right">
                    <!-- Navbar -->
                    <ul class="navbar-nav align-items-center flex-row">
                        <li class="nav-item d-lg-none">
                            <!-- Search Trigger -->
                            <div class="hs-unfold">
                                <a class="js-hs-unfold-invoker btn btn-icon btn-ghost-light rounded-circle" href="javascript:;" data-hs-unfold-options="{
                     &quot;target&quot;: &quot;#searchDropdown&quot;,
                     &quot;type&quot;: &quot;css-animation&quot;,
                     &quot;animationIn&quot;: &quot;fadeIn&quot;,
                     &quot;hasOverlay&quot;: &quot;rgba(46, 52, 81, 0.1)&quot;,
                     &quot;closeBreakpoint&quot;: &quot;md&quot;
                   }" data-hs-unfold-target="#searchDropdown" data-hs-unfold-invoker="">
                                    <i class="tio-search"></i>
                                </a>
                            </div>
                            <!-- End Search Trigger -->
                        </li>
                        <li class="nav-item">
                            <!-- Account -->
                            <div class="hs-unfold">
                                <a class="js-hs-unfold-invoker navbar-dropdown-account-wrapper" href="javascript:;" data-hs-unfold-options="{
                     &quot;target&quot;: &quot;#accountNavbarDropdown&quot;,
                     &quot;type&quot;: &quot;css-animation&quot;
                   }" data-hs-unfold-target="#accountNavbarDropdown" data-hs-unfold-invoker="">
                                    <div class="avatar avatar-sm avatar-circle">
                                        <img class="avatar-img" src="<c:url value="/resource/img/img6.jpg"></c:url>" alt="Image Description">
                                        <span class="avatar-status avatar-sm-status avatar-status-success"></span>
                                    </div>
                                </a>

                                <div id="accountNavbarDropdown" class="hs-unfold-content dropdown-unfold dropdown-menu dropdown-menu-right navbar-dropdown-menu navbar-dropdown-account hs-unfold-hidden hs-unfold-content-initialized hs-unfold-css-animation animated" style="width: 16rem; animation-duration: 300ms;"
                                     data-hs-target-height="0" data-hs-unfold-content="" data-hs-unfold-content-animation-in="slideInUp" data-hs-unfold-content-animation-out="fadeOut">
                                    <div class="dropdown-item">
                                        <div class="media align-items-center">
                                            <div class="avatar avatar-sm avatar-circle mr-2">
                                                <img class="avatar-img" src="<c:url value="/resource/img/img6.jpg"></c:url>" alt="Image Description">
                                            </div>
                                            <div class="media-body">
                                                <span class="card-title h5">${name}</span>
                                                <span class="card-text">${username}</span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="dropdown-divider"></div>

                                    <a class="dropdown-item" href="#">
                                        <span class="text-truncate pr-2" title="Settings">Settings</span>
                                    </a>
                                    <a class="dropdown-item" href="/logout">
                                        <span class="text-truncate pr-2" title="Sign out">Sign out</span>
                                    </a>
                                </div>
                            </div>
                            <!-- End Account -->
                        </li>

                        <li class="nav-item">
                            <!-- Toggle -->
                            <button type="button" class="navbar-toggler btn btn-ghost-light rounded-circle" aria-label="Toggle navigation" aria-expanded="false" aria-controls="navbarNavMenu" data-toggle="collapse" data-target="#navbarNavMenu">
                                <i class="tio-menu-hamburger"></i>
                            </button>
                            <!-- End Toggle -->
                        </li>
                    </ul>
                    <!-- End Navbar -->
                </div>
                <!-- End Secondary Content -->
            </div>
        </div>
    </div>

    <div id="searchDropdown" class="hs-unfold-content dropdown-unfold search-fullwidth d-md-none hs-unfold-content-initialized hs-unfold-css-animation animated fadeIn" data-hs-target-height="0" data-hs-unfold-content="" data-hs-unfold-content-animation-in="fadeIn"
         data-hs-unfold-content-animation-out="fadeOut" style="animation-duration: 300ms;">
        <form class="input-group input-group-merge input-group-borderless">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <i class="tio-search"></i>
                </div>
            </div>

            <input class="form-control rounded-0" type="search" placeholder="Search in front" aria-label="Search in front">

            <div class="input-group-append">
                <div class="input-group-text">
                    <div class="hs-unfold">
                        <a class="js-hs-unfold-invoker" href="javascript:;" data-hs-unfold-options="{
                   &quot;target&quot;: &quot;#searchDropdown&quot;,
                   &quot;type&quot;: &quot;css-animation&quot;,
                   &quot;animationIn&quot;: &quot;fadeIn&quot;,
                   &quot;hasOverlay&quot;: &quot;rgba(46, 52, 81, 0.1)&quot;,
                   &quot;closeBreakpoint&quot;: &quot;md&quot;
                 }" data-hs-unfold-target="#searchDropdown" data-hs-unfold-invoker="">
                            <i class="tio-clear tio-lg"></i>
                        </a>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="container">
        <nav class="js-mega-menu flex-grow-1 hs-menu-initialized hs-menu-horizontal">
            <!-- Navbar -->
            <div class="navbar-nav-wrap-navbar collapse navbar-collapse col-12" id="navbarNavMenu">
                <div class="navbar-body col-lg-12">
                    <ul class="navbar-nav flex-grow-1 col-lg-12">

                        <li class="nav-item">
                            <a class="nav-link active" href="#">Lớp</a>
                        </li>

                    </ul>
                </div>
            </div>
            <!-- End Navbar -->
        </nav>
    </div>
</header>
<script src="<c:url value="/resource/js/demo.js"></c:url>"></script>

<!-- END ONLY DEV -->

<!-- ========== MAIN CONTENT ========== -->
<!-- Navbar Vertical -->



<!-- End Navbar Vertical -->


<main id="content" role="main" class="main pointer-event">
    <div class="content container-fluid">
        <div class="row">
            <div class="col-8">
                <div class="row">
                    <div class="col">
                        <h2>${tenBaiTap}</h2>
                        <span style="float: right">
                                Đến hạn: ${denHan}
                            </span>
                        <br>
                        <hr>
                    </div>
                </div>
                ${noiDungBaiTap}
            </div>
            <div class="col-4">
                <form action="#" id="formNop" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col">
                                <span id="nopFile">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-paperclip" viewBox="0 0 16 16">
                                        <path d="M4.5 3a2.5 2.5 0 0 1 5 0v9a1.5 1.5 0 0 1-3 0V5a.5.5 0 0 1 1 0v7a.5.5 0 0 0 1 0V3a1.5 1.5 0 1 0-3 0v9a2.5 2.5 0 0 0 5 0V5a.5.5 0 0 1 1 0v7a3.5 3.5 0 1 1-7 0V3z"/>
                                    </svg>
                                    Nộp file
                                    <br>
                                    <input type="file" name="file" class="btn btn-sm btn-white">
                                </span>
                            <br>
                            <span id="lienKet" style="display: none">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-link" viewBox="0 0 16 16">
                                        <path d="M6.354 5.5H4a3 3 0 0 0 0 6h3a3 3 0 0 0 2.83-4H9c-.086 0-.17.01-.25.031A2 2 0 0 1 7 10.5H4a2 2 0 1 1 0-4h1.535c.218-.376.495-.714.82-1z"/>
                                        <path d="M9 5.5a3 3 0 0 0-2.83 4h1.098A2 2 0 0 1 9 6.5h3a2 2 0 1 1 0 4h-1.535a4.02 4.02 0 0 1-.82 1H12a3 3 0 1 0 0-6H9z"/>
                                    </svg>
                                    Liên kết
                                    <input class="form-control" type="text" />
                                </span>
                            <br>
                            <span id="lienKetSpan" style="cursor: pointer;" onclick="lienket()">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-link" viewBox="0 0 16 16">
                                        <path d="M6.354 5.5H4a3 3 0 0 0 0 6h3a3 3 0 0 0 2.83-4H9c-.086 0-.17.01-.25.031A2 2 0 0 1 7 10.5H4a2 2 0 1 1 0-4h1.535c.218-.376.495-.714.82-1z"/>
                                        <path d="M9 5.5a3 3 0 0 0-2.83 4h1.098A2 2 0 0 1 9 6.5h3a2 2 0 1 1 0 4h-1.535a4.02 4.02 0 0 1-.82 1H12a3 3 0 1 0 0-6H9z"/>
                                    </svg>
                                    Liên kết
                                </span>
                            <span id="inputSpand" style="cursor: pointer; display: none;" onclick="inputSpan()">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-paperclip" viewBox="0 0 16 16">
                                        <path d="M4.5 3a2.5 2.5 0 0 1 5 0v9a1.5 1.5 0 0 1-3 0V5a.5.5 0 0 1 1 0v7a.5.5 0 0 0 1 0V3a1.5 1.5 0 1 0-3 0v9a2.5 2.5 0 0 0 5 0V5a.5.5 0 0 1 1 0v7a3.5 3.5 0 1 1-7 0V3z"/>
                                    </svg>
                                    Nộp file
                                </span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col">
                            <div style="cursor: pointer;" onclick="submitForm()">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                                </svg>
                                <span>nộp bài tập<span>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->

    <div class="footer">
        <div class="row justify-content-between align-items-center">
            <div class="col">
                <p class="font-size-sm mb-0">&copy; Front. <span class="d-none d-sm-inline-block">2020 Htmlstream.</span></p>
            </div>
            <div class="col-auto">
                <div class="d-flex justify-content-end">
                    <!-- List Dot -->
                    <ul class="list-inline list-separator">
                        <li class="list-inline-item">
                            <a class="list-separator-link" href="#">FAQ</a>
                        </li>

                        <li class="list-inline-item">
                            <a class="list-separator-link" href="#">License</a>
                        </li>

                        <li class="list-inline-item">
                            <!-- Keyboard Shortcuts Toggle -->
                            <div class="hs-unfold">
                                <a class="js-hs-unfold-invoker btn btn-icon btn-ghost-secondary rounded-circle" href="javascript:;" data-hs-unfold-options='{
                              "target": "#keyboardShortcutsSidebar",
                              "type": "css-animation",
                              "animationIn": "fadeInRight",
                              "animationOut": "fadeOutRight",
                              "hasOverlay": true,
                              "smartPositionOff": true
                             }'>
                                    <i class="tio-command-key"></i>
                                </a>
                            </div>
                            <!-- End Keyboard Shortcuts Toggle -->
                        </li>
                    </ul>
                    <!-- End List Dot -->
                </div>
            </div>
        </div>
    </div>

    <!-- End Footer -->
</main>

<!-- JS Implementing Plugins -->
<script src="<c:url value="/resource/js/vendor.min.js"></c:url>"></script>
<script src="<c:url value="/resource/js/theme.min.js"></c:url>"></script>
<script src="<c:url value="/resource/js/index.js"></c:url>"></script>
<script>
    var nopfile = document.getElementById("nopFile");
    var lienketInptut = document.getElementById("lienKet");
    var lienketSpan = document.getElementById("lienKetSpan");
    var inputSpand = document.getElementById("inputSpand");
    var formNop = document.getElementById("formNop");

    function lienket() {
        nopfile.style.display = "none";
        lienketSpan.style.display = "none";
        lienketInptut.style.display = "block";
        inputSpand.style.display = "block";
    }

    function inputSpan() {
        nopfile.style.display = "block";
        lienketSpan.style.display = "block";
        lienketInptut.style.display = "none";
        inputSpand.style.display = "none";
    }

    function submitForm() {
        formNop.submit();
    }
</script>
</body>
</html>
