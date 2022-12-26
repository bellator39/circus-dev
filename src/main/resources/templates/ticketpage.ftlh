<#import "patterns/common.ftlh" as common>
<#include "patterns/security.ftlh"/>

<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Ваши билеты</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Главная /</a></span>
                                <span class="item colored">Ваши билеты</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display:block; margin: 0 auto; max-width: 1000px; margin-top: 50px" class="table-responsive">
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название шоу</th>
                <th scope="col">Количество билетов</th>
                <th scope="col">Сумма</th>
                <th scope="col">Дата шоу</th>
                <th scope="col">Дата покупки</th>
                <th scope="col">Статус</th>
            </tr>
            </thead>
            <tbody>
            <#if tickets??>
                <#list tickets as ts>
                    <tr>
                        <th scope="row">${ts?index}</th>
                        <td><a style="color: white"
                               href="/circusshow/${ts.idShow}">${circusShowService.getCircusShowById(ts.idShow).name}</a>
                        </td>
                        <td>${ts.countTicket}</td>
                        <td>${(ts.countTicket*circusShowService.getCircusShowById(ts.idShow).priceShow)?string}</td>
                        <td>${circusShowService.getCircusShowById(ts.idShow).dateShow}</td>
                        <td>${ts.dateBuy}</td>
                        <td><#if circusShowService.getCircusShowById(ts.idShow).CompareDate()>
                                <p style="color:green;">СКОРО</p>
                            <#else>
                                <p style="color: red">ПРОШЛО</p>
                            </#if></td>

                    </tr>
                </#list>
            <#else>
                <tr>
                    <td>
                        На данный момент билетов нет.
                    </td>
                </tr>
            </#if>
            </tbody>
        </table>
    </div>
    <#if message??>
        <script>
            alert('Сообщение с инструкцией по оплате отправленно Вам на почту. Спасибо что вы с нами!')
        </script>
    </#if>
</@common.page>