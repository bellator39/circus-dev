package com.circus.repository.api;

import com.circus.domain.TagNews;

import java.util.List;

public interface TagNewsRepositoryApi {
    boolean saveTag(TagNews tagNewsSave);
    boolean updateTag(TagNews tagNewsUpdate);
    List<TagNews> findAllTagNews();
    boolean deleteTagNews(Long idTagNews);
}
