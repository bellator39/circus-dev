<#import "pattern/common.ftlh" as common>
<@common.page>

    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content colored">
                            <h1>Работники</h1>
                            <div class="breadcum-items mt-2">
                                <span class="item color-primary"><a href="/">Работники /</a></span>
                                <span class="item colored">Список работников</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="display:block; margin: 0 auto; max-width: 1050px; margin-top: 50px" class="table-responsive">
        <#if workerList??>
            <table class="table table-dark">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Имя</th>
                    <th scope="col">Фамилия</th>
                    <th scope="col">Должность</th>
                    <th scope="col">Описание</th>
                    <th scope="col">Ссылка на facebook</th>
                    <th scope="col">Дата создания</th>
                    <th scope="col">Ссылка на фото</th>
                    <th scope="col">Изменить</th>
                    <th scope="col">Удалить</th>
                </tr>
                </thead>
                <tbody>
                <#list workerList as ts>
                    <tr>
                        <th scope="row">${ts?index}</th>
                        <td>${ts.name}</td>
                        <td>${ts.soname}</td>
                        <td>${ts.work_position}</td>
                        <td>${ts.describe}</td>
                        <td>${ts.link_facebook}</td>
                        <td>${ts.date_create}</td>
                        <td>${ts.urlphoto}</td>
                        <td><a href="/manager/edit/worker/${ts.id}" class="btn-accent">Редактировать</a></td>
                        <td><a href="/manager/delete/worker/${ts.id}" class="btn-danger">Удалить</a></td>
                    </tr>
                </#list>
                </tbody>
            </table>
        <#else>
            <p>На данный момент работников нет.</p>
        </#if>
    </div>
</@common.page>