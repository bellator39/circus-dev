<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Представления</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Представления /</a></span>
                                <span class="item colored">Список представлений</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display:block; margin: 0 auto; max-width: 1050px; margin-top: 50px" class="table-responsive">
        <#if circusShowList?size gt 0>
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Название шоу</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Ссылка на фото</th>
                    <th scope="col">Количество доступных билетов</th>
                    <th scope="col">Дата шоу</th>
                    <th scope="col">Цена за билет</th>
                    <th scope="col">Тип шоу</th>
                    <th scope="col">Изменить</th>
                    <th scope="col">Удалить</th>
                </tr>
                </thead>
                <tbody>
                <#list circusShowList as ts>
                    <tr>
                        <th scope="row">${ts?index}</th>
                        <td>${ts.name}</td>
                        <td>${ts.describe}</td>
                        <td><img width="80" height="50" src="${ts.urlPathLogoPhoto}"></td>
                        <td>${ts.countAvailableTicket}</td>
                        <td>${ts.dateShow}</td>
                        <td>${ts.priceShow}</td>
                        <td>
                            <#if ts.typeShow==1>
                                Шоу с животными
                            <#elseif ts.typeShow==2>
                                Музыкальные шоу
                            <#elseif ts.typeShow==3>
                                Огненные шоу
                            </#if>
                        </td>
                        <td><a href="/admin/edit/show/${ts.id}" class="btn-accent">Редактировать</a></td>
                        <td><a href="/admin/delete/show/${ts.id}" class="btn-danger">Удалить</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        <#else>
            <p>На данный момент шоу нет.</p>
        </#if>
    </div>
</@common.page>