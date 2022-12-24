package com.circus.service.api;

import com.circus.domain.TagNews;

import java.util.List;

public interface TagNewsServiceApi {
    boolean saveTag(TagNews tagNewsSave);
    boolean updateTag(TagNews tagNewsUpdate);
    List<TagNews> findAllTagNews();
    boolean deleteTagNews(Long idTagNews);
}
