<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Новости</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Новости /</a></span>
                                <span class="item colored">Список новостей</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display:block; margin: 0 auto; max-width: 1050px; margin-top: 50px" class="table-responsive">
        <#if newsList?size gt 0>
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название новости</th>
                <th scope="col">Текст новости</th>
                <th scope="col">Дата публикации</th>
                <th scope="col">Номер автора</th>
                <th scope="col">Тег новости</th>
                <th scope="col">Логотип новоти</th>
                <th scope="col">Редактировать</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>

                <#list newsList as ns>
                    <tr>
                        <th scope="row">${ns?index}</th>
                        <td>${ns.newsName}</td>
                        <td style="    height: 134px;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 4;
    -webkit-box-orient: vertical;">${ns.newsText}</td>
                        <td>${ns.date_publication}</td>
                        <td>${ns.idAuthor}</td>
                        <td>${tagService.getTagById(ns.tagNews).tagName}</td>
                        <td><img width="40" height="30" src="${ns.urllogonews}" alt="Not find"/></td>
                        <td><a href="/moderator/edit/${ns.id}" class="btn-common">Редактировать</a></td>
                        <td><a href="/moderator/delete/${ns.id}" class="btn-danger">Удалить</a></td>
                    </tr>
                </#list>

            </tbody>
        </table>
            <#else>
            <p>На данный момент новостей нет.</p>
        </#if>
    </div>
</@common.page>