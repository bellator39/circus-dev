package com.circus.repository.implementation;

import com.circus.domain.Circus;
import com.circus.domain.TypeShow;
import com.circus.repository.api.CircusShowRepository;
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
public class CircusShowRepositoryImpl implements CircusShowRepository {

    private final JdbcTemplate database;

    private final static String SAVE_CIRCUS_SHOW = "insert into circusshow(name, describe, urlpathlogophoto, countavailableticket, dateshow, priceshow, typeshow)" +
            "values(?,?,?,?,?,?,?)";
    private final static String UPDATE_CIRCUS_SHOW = "update circusshow set name=?,describe=?,urlpathlogophoto=?,countavailableticket=?,dateshow=?,priceshow=?,typeshow=? where id=?";
    private final static String GET_CIRCUS_SHOW_BY_ID = "select * from circusshow where id=?";
    private final static String FIND_ALL_CIRCUS_SHOW = "select * from circusshow";
    private final static String DELETE_CIRCUS_SHOW = "delete from circusshow where id =?";
    private final static String FIND_ALL_CIRCUS_SHOW_BY_TYPE_SHOW = "select * from circusshow typeshow=?";

    @Override
    public boolean saveCircusShow(Circus circusSave) {
        log.info("Save circus with name {} in {}",circusSave.getName(),new Date());
        return database.update(SAVE_CIRCUS_SHOW, circusSave.getName(), circusSave.getDescribe(), circusSave.getUrlPathLogoPhoto(),
                circusSave.getCountAvailableTicket(), circusSave.getDateShow(), circusSave.getPriceShow(), circusSave.getTypeShow()) > 0;
    }

    @Override
    public boolean updateCircusShow(Circus circusUpdate) {
        log.info("Update circus with id {} in {}",circusUpdate.getId(),new Date());
        return database.update(UPDATE_CIRCUS_SHOW, circusUpdate.getName(), circusUpdate.getDescribe(), circusUpdate.getUrlPathLogoPhoto(),
                circusUpdate.getCountAvailableTicket(), circusUpdate.getDateShow(), circusUpdate.getPriceShow(), circusUpdate.getTypeShow(), circusUpdate.getId()) > 0;
    }

    @Override
    public Circus getCircusShowById(Long idCircusShow) {
        try {
            log.info("Get circus by id {} in {}",idCircusShow,new Date());
            return database.queryForObject(GET_CIRCUS_SHOW_BY_ID, new BeanPropertyRowMapper<>(Circus.class), idCircusShow);
        } catch (DataAccessException exception) {
            log.error("Error get circus by id {} with {} in {}",idCircusShow,exception.getMessage(),new Date());
            return null;
        }
    }

    @Override
    public List<Circus> findAllCircusShow() {
        log.info("Get all circus in {}",new Date());
        return database.query(FIND_ALL_CIRCUS_SHOW,new BeanPropertyRowMapper<>(Circus.class));
    }

    @Override
    public boolean deleteCircusShow(Long idCircusShow) {
        log.info("Delete circus with id {} in {}",idCircusShow,new Date());
        return database.update(DELETE_CIRCUS_SHOW,idCircusShow)>0;
    }

    @Override
    public List<Circus> findAllCircusShowByTypeShow(TypeShow typeShow) {
        log.info("Get all circus bv type {} in {}",typeShow.getTypeShowname(),new Date());
        return database.query(FIND_ALL_CIRCUS_SHOW_BY_TYPE_SHOW,new BeanPropertyRowMapper<>(Circus.class),typeShow.getId());
    }
}
