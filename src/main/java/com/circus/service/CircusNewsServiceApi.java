package com.circus.service;

import com.circus.domain.CircusNews;
import com.circus.domain.TagNews;

import java.util.List;

public interface CircusNewsServiceApi {
    boolean saveCircusNews(CircusNews circusNewsSave);
    boolean updateCircusNews(CircusNews circusNewsUpdate);
    CircusNews getCircusNewsById(Long idCircusNews);
    List<CircusNews> findAllCircusNews();
    boolean deleteCircusNews(Long idCircusNews);
    List<CircusNews>findAllByTag(TagNews tagNews);
}
