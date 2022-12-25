<#import "patterns/common.ftlh" as common>
<@common.page>
    <div class="site-banner">
        <div class="banner-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="colored">
                            <h1>О нас</h1>
                            <div class="breadcum-items">
                                <span class="item"><a href="/">Главная /</a></span>
                                <span style="color:#c0c0c0 !important;" class="item colored">О нас</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div><!--site-banner-->

    <section class="chief-detail padding-large">
        <div class="container">
            <div class="row">
                <div class="single-image col-md-6">
                    <img width="150px" height="150px" src="/static/publicpage/images/ceo.jpg" alt="ceo"
                         class="singleImg">
                </div>
                <div class="col-md-6 p-5 text-center align-self-center">
                    <h2 class="section-title text-center mb-3">Директор</h2>
                    <p>Гуринович Егор Сергеевич, директор цирка, гуру циркового ремесла.</p>
                </div>
            </div>
        </div>
    </section>

    <section class="our-team bg-sand padding-large">
        <h2 class="section-title text-center mb-4">Наша команда</h2>
        <div class="container">
            <div class="row">
                <#if teams??>
                    <#list teams as tm>
                        <div class="col-md-3 text-center">
                            <div class="team-member text-center">
                                <figure>
                                    <img src="${tm.urlphoto}" alt="post" class="member-image">
                                </figure>
                                <div class="member-details text-center">
                                    <h4>${tm.name} ${tm.soname}</h4>
                                    <div class="designation colored">${tm.work_position}</div>
                                    <p>${tm.describe}</p>
                                    <div class="social-links color-primary">
                                        <a href="${tm.link_facebook}" class="icon icon-facebook pr-10"></a>
                                        <a href="${tm.link_facebook}" class="icon icon-twitter pr-10"></a>
                                        <a href="${tm.link_facebook}" class="icon icon-pinterest-p"></a>
                                    </div>
                                </div><!--text-content-->
                            </div>
                        </div><!--col-md-3-->
                    </#list>
                <#else>
                    <p>Команда сейчас пуста.</p>
                </#if>

            </div>
        </div>
    </section>

    <section class="our-targets padding-large">
        <div class="container">
            <h2 class="section-title text-center mb-5">Наши цели</h2>
            <div class="row">
                <img src="/static/publicpage/images/m_slide_1.jpg" alt="flower">

                <div class="accordion accordion-flush mt-3" id="target-accordion">
                    <div class="accordion-item">
                        <div class="accordion-header">
                            <h4 class="accordion-title">
                                <a role="button" data-bs-toggle="collapse" data-bs-target="#target0" class=""
                                   aria-expanded="true">Демонстрировать Вам</a>
                            </h4>
                        </div>
                        <div id="target0" class="accordion-collapse collapse show" aria-expanded="true">
                            <div class="accordion-body">
                                <div class="target-detail">
                                    <p>Это эстетическая красота, демонстрация чувств и возможностей человека.</p>
                                </div>
                            </div>
                        </div>
                    </div><!--panel-->

                    <div class="accordion-item">
                        <div class="accordion-header">
                            <h4 class="accordion-title">
                                <a role="button" data-bs-toggle="collapse" data-bs-target="#target1" class=""
                                   aria-expanded="true">Демонстрировать Вам</a>
                            </h4>
                        </div>
                        <div id="target1" class="accordion-collapse collapse" aria-expanded="true">
                            <div class="accordion-body">
                                <div class="target-detail">
                                  <p>Это эстетическая красота, демонстрация чувств и возможностей человека.</p>
                                </div>
                            </div>
                        </div>
                    </div><!--panel-->

                    <div class="accordion-item">
                        <div class="accordion-header">
                            <h4 class="accordion-title">
                                <a role="button" data-bs-toggle="collapse" data-bs-target="#target2" class=""
                                   aria-expanded="true">Демонстрировать Вам</a>
                            </h4>
                        </div>
                        <div id="target2" class="accordion-collapse collapse" aria-expanded="true">
                            <div class="accordion-body">
                                <div class="target-detail">
                                    <p>Это эстетическая красота, демонстрация чувств и возможностей человека.</p>
                                </div>
                            </div>
                        </div>
                    </div><!--panel-->

                </div><!--panel-group-->

            </div>
        </div>
    </section>

    <section class="our-achivement bg-sand padding-large">
        <div class="container">
            <h2 class="section-title text-center mb-5">Наши достижения</h2>

            <div class="row">

                <div class="achivement-block text-center col-md-4">
                    <img src="/static/publicpage/images/badge.png" width="100px" height="149px" alt="badge">
                    <div class="mt-3">
                        <h3>Лучшие выступления с животными</h3>
                        <span class="date">2018 - 2020</span>
                    </div>
                </div><!--achivement-block-->
                <div class="achivement-block text-center col-md-4">
                    <img src="/static/publicpage/images/badge1.png" width="100" height="149" alt="badge">
                    <div class="mt-3">
                        <h3>Лучшая дрессировка</h3>
                        <span class="date">2018 - 2022</span>
                    </div>
                </div><!--achivement-block-->
                <div class="achivement-block text-center col-md-4">
                    <img src="/static/publicpage/images/badge2.png"  width="100" height="149" alt="badge">
                    <div class="mt-3">
                        <h3>Лучшая постановка номеров</h3>
                        <span class="date">2018 - 2022</span>
                    </div>
                </div><!--achivement-block-->

            </div>
        </div>
    </section>
</@common.page>