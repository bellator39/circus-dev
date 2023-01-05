package com.circus.repository.implementation;

 import com.circus.domain.CircusNews;
 import com.circus.domain.Contacts;
 import com.circus.domain.TagNews;
 import com.circus.repository.api.CircusNewsRepositoryApi;
 import lombok.RequiredArgsConstructor;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.dao.DataAccessException;
 import org.springframework.jdbc.core.BeanPropertyRowMapper;
 import org.springframework.jdbc.core.JdbcTemplate;
 import org.springframework.stereotype.Repository;

 import java.util.Date;
 import java.util.List;


@Repository
@Slf4j
@RequiredArgsConstructor
public class CircusNewsImpl implements CircusNewsRepositoryApi {

    private final JdbcTemplate database;

    private final static String SAVE_CIRCUS_NEWS="insert into circusnews(newsname, newstext, date_publication, idauthor, tagnews,urllogonews)" +
            "values(?,?,?,?,?,?)";
    private final static String UPDATE_CIRCUS_NEWS="update circusnews set newsname=?,newstext=?,tagnews=? where id=?";
    private final static String GET_BY_ID_CIRCUS_NEWS="select * from circusnews where id =?";
    private final static String FIND_ALL_CIRCUS_NEWS="select * from circusnews";
    private final static String DELETE_CIRCUS_NEWS="DELETE FROM circusnews where id=?";

    private final static String FIND_ALL_BY_TAG_CIRCUS_NEWS="select * from circusnews where tagnews=?";



    @Override
    public boolean saveCircusNews(CircusNews circusNewsSave) {
        log.info("Save circus news with name {} in {}",circusNewsSave.getNewsName(),new Date());
        return database.update(SAVE_CIRCUS_NEWS,circusNewsSave.getNewsName(),circusNewsSave.getNewsText(),circusNewsSave.getDate_publication(),
                circusNewsSave.getIdAuthor(),circusNewsSave.getTagNews(),circusNewsSave.getUrllogonews())>0;
    }

    @Override
    public boolean updateCircusNews(CircusNews circusNewsUpdate) {
        log.info("Update circus news with id {} in {}",circusNewsUpdate.getId(),new Date());
        return database.update(UPDATE_CIRCUS_NEWS,circusNewsUpdate.getNewsName(),circusNewsUpdate.getNewsText(),
                circusNewsUpdate.getTagNews(),circusNewsUpdate.getId())>0;
    }

    @Override
    public CircusNews getCircusNewsById(Long idCircusNews) {
        try {
            log.info("Get circus news by id {} in {}", idCircusNews, new Date());
            return database.queryForObject(GET_BY_ID_CIRCUS_NEWS, new BeanPropertyRowMapper<>(CircusNews.class), idCircusNews);
        }catch (DataAccessException exception){
            log.error("Error with get by id {} with {} in {}",idCircusNews,exception.getMessage(),new Date());
            return null;
        }
    }

    @Override
    public List<CircusNews> findAllCircusNews() {
        log.info("Get all circus news in {}", new Date());
        return database.query(FIND_ALL_CIRCUS_NEWS,new BeanPropertyRowMapper<>(CircusNews.class));
    }

    @Override
    public boolean deleteCircusNews(Long idCircusNews) {
        log.warn("Delete circus news with id {} in {}",idCircusNews,new Date());
        return database.update(DELETE_CIRCUS_NEWS,idCircusNews)>0;
    }

    @Override
    public List<CircusNews> findAllByTag(TagNews tagNews) {
        log.info("Find all news by tag {} in {}",tagNews.getTagName(),new Date());
        return database.query(FIND_ALL_BY_TAG_CIRCUS_NEWS,new BeanPropertyRowMapper<>(CircusNews.class),tagNews.getId());
    }
}
