<#import "patterns/common.ftlh" as common>
<#include "patterns/security.ftlh"/>
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

    <section class="bg-sand padding-large">
        <a class="btn-accent" href="/circusshow/testimonals">Оставить отзыв</a>
        <div class="container">
            <div class="row">

                <div class="col-md-6">
                    <a href="#" class="product-image"><img src="${circusShowCurr.urlPathLogoPhoto}"></a>
                </div>
                <div class="col-md-6 pl-5">
                    <div class="product-detail">
                        <h5 class="pt-4"><a href="#">${circusShowCurr.name}</a></h5>
                        <p>${circusShowCurr.dateShow}</p>
                        <span class="price colored">$ ${circusShowCurr.priceShow}</span>
                        <p>${circusShowCurr.describe}</p>
                        <label class="screen-reader-text" for="qty">Количество билетов:</label>
                        <#if circusShowCurr.CompareDate() && circusShowCurr.countAvailableTicket gt 0>
                        <form action="/ticket/buy/${circusShowCurr.id}/${currentUserId}" method="post">
                        <input type="number" id="qty" class="input-text qty text" step="1" min="1" max="10"
                               name="count" value="1" title="Qty" size="4" placeholder="" inputmode="numeric">
                        <button type="submit" name="add-to-cart" value="27545" class="button">Оформить</button>
                        </form>
                            <#else>
                            <p>На данный момент продажи билетов нет! Скоро мы возобновим!</p>
                        </#if>
                    </div>
                </div>

            </div>
        </div>
    </section>
</@common.page>