package com.circus.repository.implementation;

import com.circus.domain.Testimonals;
import com.circus.repository.api.TestimonalsRepositoryApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class TestimonalsRepositoryImpl implements TestimonalsRepositoryApi {

    private final JdbcTemplate database;

    private final static String SAVE_TESTIMONALS = "insert into testimonals(name, soname, text, rating, date_send) values(?,?,?,?,?)";
    private final static String DELETE_TESTIMONALS = "delete from testimonals where id = ?";
    private final static String FIND_ALL_TESTIMONALS = "select * from testimonals";
    @Override
    public boolean saveTestimonals(Testimonals testimonals) {
        log.info("Save testimonals with name {} in {}",testimonals.getName(),new Date());
        return database.update(SAVE_TESTIMONALS,testimonals.getName(),testimonals.getSoname(),
                testimonals.getText(),testimonals.getRating(),testimonals.getDate_send())>0;
    }

    @Override
    public boolean deleteTestimonals(Long id) {
        log.info("Save testimonals with id {} in {}",id,new Date());
        return database.update(DELETE_TESTIMONALS,id)>0;
    }

    @Override
    public List<Testimonals> listTestimonals() {
        log.info("Get all testimonals {}",new Date());
        return database.query(FIND_ALL_TESTIMONALS,new BeanPropertyRowMapper<>(Testimonals.class));
    }
}
