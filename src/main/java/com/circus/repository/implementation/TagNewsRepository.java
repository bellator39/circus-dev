package com.circus.repository.implementation;

import com.circus.domain.TagNews;
import com.circus.repository.api.TagNewsRepositoryApi;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TagNewsRepository implements TagNewsRepositoryApi {

    private final JdbcTemplate dataBase;

    private final static String SAVE_TAG_NEWS = "insert into tagnews(tagname) values(?)";
    private final static String UPDATE_TAG_NEWS = "update tagnews set tagname=? where id =?";
    private final static String FIND_ALL_TAG_NEWS = "select * from tagnews";
    private final static String DELETE_TAG_NEWS = "delete from tagnews where id=?";

    @Override
    public boolean saveTag(TagNews tagNewsSave) {
        log.info("Save new tag with name {} in {}",tagNewsSave.getTagName(),new Date());
        return dataBase.update(SAVE_TAG_NEWS,tagNewsSave.getTagName())>0;
    }

    @Override
    public boolean updateTag(TagNews tagNewsUpdate) {
        log.info("Update tag with id {} in {}",tagNewsUpdate.getId(),new Date());
        return dataBase.update(UPDATE_TAG_NEWS,tagNewsUpdate.getTagName(),tagNewsUpdate.getId())>0;
    }

    @Override
    public List<TagNews> findAllTagNews() {
        log.info("Find all tag in {}",new Date());
        return dataBase.query(FIND_ALL_TAG_NEWS,new BeanPropertyRowMapper<>(TagNews.class));
    }


    @Override
    public boolean deleteTagNews(Long idTagNews) {
        log.info("Delete tag with id {} in {}",idTagNews,new Date());
        return dataBase.update(DELETE_TAG_NEWS,idTagNews)>0;
    }
}
