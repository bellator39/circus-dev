<#import "patterns/common.ftlh" as common>
<@common.page>
    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="colored">
                            <h1>Каталог событий</h1>
                            <div class="breadcum-items">
                                <span class="item"><a href="/">Главная /</a></span>
                                <span class="item colored">Каталог событий</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!--site-banner-->

    <section class="our-team bg-sand padding-large">
        <div class="container">
            <div class="row">
                <#if circusShow?size gt 0>
                    <#list circusShow as cs>
                        <div class="product-item col-md-3 pl-0">
                            <a href="single-product.html" class="product-image"><img
                                        src="${cs.urlPathLogoPhoto}"></a>
                            <div class="text-comtent text-center text-hover">
                                <h5 class="pt-4"><a href="single-product.html">${cs.name}</a></h5>
                                <p>Дата шоу - ${cs.dateShow}</p>
                                <span class="price colored">$ ${cs.priceShow}</span>
                            </div>
                        </div>
                    </#list>
                    <#else>
                    На данный момент событий нет.
                </#if>
            </div>
        </div>
    </section>
</@common.page>