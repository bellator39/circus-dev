package com.circus.repository.api;

import com.circus.domain.CircusNews;
import com.circus.domain.Contacts;
import com.circus.domain.TagNews;

import java.util.List;

public interface CircusNewsRepositoryApi {
    boolean saveCircusNews(CircusNews circusNewsSave);
    boolean updateCircusNews(CircusNews circusNewsUpdate);
    CircusNews getCircusNewsById(Long idCircusNews);
    List<CircusNews> findAllCircusNews();
    boolean deleteCircusNews(Long idCircusNews);
    List<CircusNews>findAllByTag(TagNews tagNews);
}
