<#import "patterns/common.ftlh" as common>
<@common.page>
    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Новости</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Главная /</a></span>
                                <span class="item colored">Новости</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!--site-banner-->

    <section class="post-grid margin-large border-bottom">
        <div class="container">
            <div class="row">
                <#if news?size gt 0>
                    <#list news as ns>
                        <div class="col-md-4 mb-5">
                            <a href="/circus/news/${ns.id}">
                                <img src="${ns.urllogonews}" alt="blog" class="postImg mb-3">
                            </a>
                            <div class="content">
                                <div class="meta-tags flex-container color-secondary mb-3">
                                    <span class="border-right"><i class="icon icon-calendar mr-2"></i>${ns.date_publication}</span>
                                    <span><i class="icon icon-envelope-o mr-2"></i>Новости</span>
                                </div><!--meta-tags-->

                                <h2 class="post-title"><a href="/circus/news/${ns.id}"">${ns.newsName}</a></h2>
                                <p>Тег: <#if ns.tagNews==1>
                                        ОБЩЕЕ
                                    </#if>
                                    <#if ns.tagNews==2>
                                        ПОПУЛЯРНО
                                    </#if>
                                    <#if ns.tagNews==3>
                                        СРОЧНО
                                    </#if>
                                    <#if ns.tagNews==4>
                                        АКЦИИ
                                    </#if></p>

                                <div class="pix_btn">
                                    <a href="/circus/news/${ns.id}" class="btn-hvr-effects mt-3">Подробнее</a>
                                </div>
                            </div><!--content-->
                        </div><!--col-md-4-->
                    </#list>
                    <#else>
                    Новостей на данный момент нет.
                </#if>
            </div>
        </div>
    </section>
</@common.page>