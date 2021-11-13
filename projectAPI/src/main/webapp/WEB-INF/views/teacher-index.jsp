<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <!-- Required Meta Tags Always Come First -->
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


    <!-- CSS Front Template -->
    <link rel="stylesheet" href="<c:url value="/resource/css/theme.min.css?v=1.0"></c:url>">
</head>

<body class="   footer-offset">
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
                                        <a class="dropdown-item" href="<c:url value="/logout"></c:url>">
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
                                <a class="nav-link active" href="#">Khóa học của tôi</a>
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
        <div class="content container-fluid btn-add-course">
            <a href="add-course.html" class="btn btn-success" style="color: white!important; font-weight: bold;">
                Thêm khóa học mới
            </a>
        </div>

        <div class="content container-fluid d-flex">
            <!-- Table -->
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Address</th>
                        <th scope="col">Phone number</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${lsDTO}" var="lsDTO">
                    <tr>
                        <th scope="row">${lsDTO.id}</th>
                        <td>${lsDTO.name}</td>
                        <td>${lsDTO.age}</td>
                        <td>${lsDTO.address}</td>
                        <td>${lsDTO.sdt}</td>
                        <td>
                            <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButtonLight" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Hành động
                              </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonLight">
                                <a class="dropdown-item" href="#">Xem chi tiết</a>
                                <a class="dropdown-item" href="#">Gán lớp học</a>
                                <a class="dropdown-item" href="#">Chỉnh sửa</a>
                                <a class="dropdown-item" href="#">Gỡ</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!-- End Table -->
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

</body>

</html>