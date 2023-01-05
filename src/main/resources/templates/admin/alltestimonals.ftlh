<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Отзывы</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Отзывы /</a></span>
                                <span class="item colored">Список отзывов</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display:block; margin: 0 auto; max-width: 1050px; margin-top: 50px" class="table-responsive">
        <table class="table table-dark">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Имя</th>
                <th scope="col">Фамилия</th>
                <th scope="col">Текст</th>
                <th scope="col">Рейтинг</th>
                <th scope="col">Дата отправки</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>
            <#if testimonalsList??>
                <#list testimonalsList as ts>
                    <tr>
                        <th scope="row">${ts?index}</th>
                        <td>${ts.name}</td>
                        <td>${ts.soname}</td>
                        <td style="    height: 134px;
    overflow: hidden;
    display: -webkit-box;
    -webkit-line-clamp: 4;
    -webkit-box-orient: vertical;">${ts.text}</td>
                        <td>${ts.rating}</td>
                        <td>${ts.date_send}</td>
                         <td><a href="/moderator/testimonals/delete/${ts.id}" class="btn-danger">Удалить</a></td>
                    </tr>
                </#list>
            <#else>
               <p>На данный момент отзывов нет!</p>
            </#if>
            </tbody>
        </table>
    </div>
</@common.page>