<#include "security.ftlh"/>
<#macro page>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Circus</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="format-detection" content="telephone=no">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="author" content="">
        <meta name="keywords" content="">
        <meta name="description" content="">
        <link type="image/png" sizes="16x16" rel="icon" href="/static/publicpage/images/brand3.png">

        <link rel="stylesheet" type="text/css" href="/static/publicpage/fonts/icomoon/icomoon.css">
        <link rel="stylesheet" type="text/css" href="/static/publicpage/css/slick.css"/>
        <link rel="stylesheet" type="text/css" href="/static/publicpage/css/slick-theme.css"/>
        <link rel="stylesheet" type="text/css" href="/static/publicpage/css/magnific-popup.css"/>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

        <link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@0,400;0,700;1,400;1,700&display=swap"
              rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="/static/publicpage/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="/static/publicpage/css/style.css">
    </head>

    <body>

    <div id="main-wrapper" class="overflow-hidden">
        <div id="header-wrap">
            <div class="header-top-menu bg-black color-secondary">
                <div class="container">
                    <div class="row">
                        <div class="wrap flex-container padding-small">
                            <div class="contact-block">
                                <span class="pr-50"><i class="icon icon-phone"></i><a href="tel:375333280891">375333280891</a></span>
                                <span class="color-secondary"><i class="icon icon-envelope-o"></i><a
                                            href="mailto:egorgurinovich@gmail.com"> egorgurinovich@gmail.com</a></span>
                            </div>

                            <div class="header-top-right">
                                <ul class="list-unstyled d-flex color-secondary">
                                    <li><a href="/contactus">????????????</a></li>
                                </ul>
                            </div>
                        </div><!--flex-container-->
                    </div>
                </div>
            </div><!----top-menu---->

            <header id="header">
                <div class="container">
                    <div class="row">

                        <nav class="navbar navbar-expand-lg col-md-12">

                            <div class="navbar-brand">
                                <a href="/">
                                    <img width="90" height="80" src="/static/publicpage/images/logo_circus.jpg"
                                         alt="logo">
                                </a>
                            </div>

                            <button class="navbar-toggler collapsed" type="button" data-toggle="collapse"
                                    data-target="#slide-navbar-collapse" aria-controls="slide-navbar-collapse"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"><i class="icon icon-navicon"></i></span>
                            </button>

                            <div class="navbar-collapse collapse" id="slide-navbar-collapse">
                                <ul class="navbar-nav list-inline text-uppercase">
                                    <li class="nav-item text-hover active"><a href="/" class="nav-link"
                                                                              data-effect="Home">??????????????</a></li>
                                    <li class="nav-item text-hover"><a href="/aboutus" class="nav-link"
                                                                       data-effect="About Us">?? ??????</a></li>
                                    <li class="nav-item text-hover"><a href="/circus/news" class="nav-link"
                                                                       data-effect="Blogs">??????????????</a></li>
                                    <li class="nav-item text-hover"><a href="/contactus" class="nav-link"
                                                                       data-effect="Contact">????????????????</a></li>
                                    <li class="nav-item text-hover"><a href="/gallery" class="nav-link"
                                                                       data-effect="Contact">??????????????</a></li>
                                    <#if user??>
                                        <#if isModerator>
                                            <li class="nav-item text-hover"><a href="/moderator/allnews"
                                                                               class="nav-link" data-effect="Contact">??????????????????|????????????</a>
                                            </li>
                                        </#if>
                                        <#if isManager>
                                            <li class="nav-item text-hover"><a href="/manager/allfeedback"
                                                                               class="nav-link" data-effect="Contact">????????????????|????????????</a>
                                            </li>
                                        </#if>
                                        <#if isAdmin>
                                            <li class="nav-item text-hover"><a href="/manager/allfeedback"
                                                                               class="nav-link" data-effect="Contact">??????????|????????????</a>
                                            </li>
                                        </#if>
                                    </#if>
                                    <li class="nav-item dropdown">
                                        <a href="#" data-bs-toggle="dropdown" aria-expanded="false"
                                           class="nav-link dropdown-toggle">?????????????? ??????????????</a>
                                        <ul class="dropdown-menu">
                                            <li><a href="/circusshow" class="dropdown-item">???????????? ??????????????</a></li>
                                            <li><a href="/circusshow/type/1" class="dropdown-item">????????????????</a></li>
                                            <li><a href="/circusshow/type/2" class="dropdown-item">??????????????????????</a></li>
                                            <li><a href="/circusshow/type/3" class="dropdown-item">????????????????</a></li>
                                        </ul>
                                    </li>

                                </ul>
                            </div>
                            <div class="action-menu">
                                <div class="searchbar">
                                    <a href="#" class="search-button search-toggle" data-selector=".navbar">
                                        <i class="icon icon-search"></i>
                                    </a>
                                    <form role="search" method="post" class="search-box" action="/circusshow/find">
                                        <input name="name" class="search-field text search-input" placeholder="??????????"
                                               type="search" style="color:black">
                                    </form>
                                </div>
                                <div class="shopping-cart">
                                    <#if user??>
                                        <a href="/myticket/${currentUserId}">
                                            <i class="icon icon-shopping-cart"></i>
                                        </a>
                                        <form method="post" action="/logout">
                                            <button class="btn btn-common" type="submit"><i class="icon icon-arrow-thin-left"></i></button>
                                        </form>
                                        <#else>
                                        <a href="/login"><i class="icon icon-arrow-thin-right"></i></a>
                                    </#if>
                                </div>
                            </div><!--action-menu-->

                        </nav>

                    </div>
                </div>

            </header>

        </div><!--header-wrap-->

        <#nested/>

        <footer id="footer">
            <div class="container">
                <div class="row">
                    <div class="wrap flex-container">

                        <div class="col-md-3 footer-logo text-center mb-3">
                            <img src="/static/publicpage/images/logo_circus.jpg" class="mb-3">
                            <p>???????????? ???????? ?? ????????????!</p>
                        </div>

                        <div class="col-md-5 mr-5 mb-3">
                            <div class="working-schedule">
                                <h4 class="widget-title">???????? ?????????? ????????????</h4>
                                <div class="time-list d-flex">
                                    <ul class="list-unstyled mr-5">
                                        <li>?????????????????????? - ??????????????</li>
                                        <li>8:00 - 23:30</li>
                                    </ul>
                                    <ul class="list-unstyled">
                                        <li>?????????????? - ??????????????????????</li>
                                        <li>10:00 - 00:00</li>
                                    </ul>
                                </div>
                            </div>
                        </div><!--col-md-4-->

                        <div class="col-md-2">
                            <div class="quick-links">
                                <h4 class="widget-title">????????</h4>
                                <div class="footer-menu">
                                    <ul class="list-unstyled">
                                        <li><a href="/">??????????????</a></li>
                                        <li><a href="/aboutus">?? ??????</a></li>
                                        <li><a href="/gallery">??????????????</a></li>
                                        <li><a href="/circusshow">?????????????? ??????????????</a></li>
                                        <li><a href="/circus/news">??????????????</a></li>
                                        <li><a href="/contactus">????????????????</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div><!--flex-container-->

                </div>
            </div>
        </footer>

        <div class="footer-bottom">
            <div class="container">
                <div class="wrap flex-container padding-small">
                    <div class="payment-card">
                        <span>???? ??????????????????:</span>
                        <img src="/static/publicpage/images/visa.png" class="cardImg">
                        <img src="/static/publicpage/images/american-express.png" class="cardImg">
                        <img src="/static/publicpage/images/master-card.png" class="cardImg">
                    </div>
                </div>
            </div>
        </div>

    </div>
    <script src="/static/publicpage/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="/static/publicpage/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="/static/publicpage/js/slick.min.js"></script>
    <script type="text/javascript" src="/static/publicpage/js/jquery.magnific-popup.min.js"></script>
    <script type="text/javascript" src="/static/publicpage/js/script.js"></script>

    </body>
    </html>

</#macro>