<#import "patterns/common.ftlh" as common>
<@common.page>
    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content text-center">
                            <span style="color: #4DB6AC"><i class="icon icon-calendar mr-2"></i>${curNews.date_publication}</span>
                            <h2 style="color: #4DB6AC">${curNews.newsName}</h2>

                            <div style="color: #4DB6AC" class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Главная /</a></span>
                                <span class="item color-primary"><a href="/circus/news">Новости /</a></span>
                                <span class="item colored">${curNews.newsName}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!--site-banner-->


    <div class="content-area margin-large border-bottom">
        <div class="container">
            <div class="row">

                <main class="main-content col-md-9">
                    <div class="post-detail mb-5">
                        <a href="#">
                            <img src="${curNews.urllogonews}" alt="blog" class="mb-3">
                        </a>
                        <div class="post-content text-hover">
                            <p>${curNews.newsText}</p>

                        </div><!--post-content-->
                    </div><!--post-detail-->

                </main>

                <aside class="right-sidebar col-md-3">
                    <div class="container">
                        <div class="row">

                            <div class="meta-person bg-alabaster p-4 text-center">
                                <img src="/static/publicpage/images/ceo.jpg" alt="person" class="personImg">
                                <h3 class="colored mt-3">Директор цирка</h3>
                                <p></p>
                            </div>

                            <div class="sidebar-box">
                                <h3>Поиск</h3>
                                <div class="search-box d-flex">
                                    <input type="text" name="search" class="border" class="mt-3">
                                    <a href="#" class="btn-search btn-hvr-effects"><i class="icon icon-search"></i></a>
                                </div><!--search-box-->
                            </div>

                            <div class="recent-post-box sidebar-box">
                                <h3>Последние новости</h3>
                                <#if recNews?size gt 0>
                                    <#list recNews as rn>
                                        <div class="d-flex mb-3 mt-3">
                                            <div class="post-image">
                                                <img src="${rn.urllogonews}" class="rpImg">
                                            </div>
                                            <div class="text-block">
                                                <a href="#">${rn.newsName}</a>
                                                <span class="date">	${rn.date_publication}</span>
                                            </div>

                                        </div>
                                    </#list>
                                <#else>
                                    На данный момент новостей нет.
                                </#if>
                            </div><!--.recent-post-box-->

                            <div class="post-tags-box sidebar-box">
                                <h3>Теги</h3>
                                <div class="tags">
                                    <#if tags?size gt 0>
                                        <#list tags as tg>
                                            <a href="/circus/news/${tg.id}/${tg.tagName}">
                                                <#if tg.id==1>
                                                    ОБЩЕЕ ${crsr.findAllByTag(tg)?size}
                                                </#if>
                                                <#if tg.id==2>
                                                    ПОПУЛЯРНО ${crsr.findAllByTag(tg)?size}
                                                </#if>
                                                <#if tg.id==3>
                                                    СРОЧНО ${crsr.findAllByTag(tg)?size}
                                                </#if>
                                                <#if tg.id==4>
                                                    АКЦИИ ${crsr.findAllByTag(tg)?size}
                                                </#if>
                                            </a>
                                        </#list>
                                    <#else>
                                        На данный момент тегов нет.
                                    </#if>
                                </div>
                            </div><!--.tags-box-->

                        </div><!--container-->
                    </div>
                </aside>

            </div>
        </div>
    </div><!--content-area-->
</@common.page>