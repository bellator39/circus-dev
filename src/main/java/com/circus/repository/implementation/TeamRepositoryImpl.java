package com.circus.repository.implementation;

import com.circus.domain.Contacts;
import com.circus.domain.TeamCircus;
import com.circus.repository.api.TeamRepositoryApi;
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
public class TeamRepositoryImpl implements TeamRepositoryApi {

    private final JdbcTemplate database;

    private final static String SAVE_TEAM = "insert into circusteam(name, soname, work_position, describe, link_facebook, date_create,urlphoto) " +
            "values(?,?,?,?,?,?,?)";
    private final static String UPDATE_TEAM = "update circusteam set name=?,soname=?,work_position=?,describe=?,link_facebook=? where id=?";
    private final static String GET_TEAM_BY_ID = "select * from circusteam where id=?";
    private final static String FIND_ALL_TEAM= "select * from circusteam";
    private final static String DELETE_TEAM = "delete from circusteam where id=?";
    @Override
    public boolean saveTeam(TeamCircus teamCircusSave) {
        log.info("Save team circus with name {} in {}",teamCircusSave.getSoname() + " " + teamCircusSave.getName(),new Date());
        return database.update(SAVE_TEAM,teamCircusSave.getName(),teamCircusSave.getSoname(),teamCircusSave.getWork_position(),teamCircusSave.getDescribe(),
                teamCircusSave.getLink_facebook(),teamCircusSave.getDate_create(),teamCircusSave.getUrlphoto())>0;
    }

    @Override
    public boolean updateTeam(TeamCircus teamCircusUpdate) {
        log.info("Update team circus with id {} in {}",teamCircusUpdate.getId(),new Date());
        return database.update(UPDATE_TEAM,teamCircusUpdate.getName(),teamCircusUpdate.getSoname(),teamCircusUpdate.getWork_position(),
                teamCircusUpdate.getDescribe(),teamCircusUpdate.getLink_facebook(),teamCircusUpdate.getId())>0;
    }

    @Override
    public TeamCircus getTeamById(Long idTeam) {
        try {
            log.info("Get team by id {} in {}",idTeam,new Date());
            return database.queryForObject(GET_TEAM_BY_ID,new BeanPropertyRowMapper<>(TeamCircus.class),idTeam);
        }catch (DataAccessException exception){
            log.error("Error get team by id {} with {} in {}",idTeam,exception.getMessage(),new Date());
            return null;
        }
    }

    @Override
    public List<TeamCircus> findAllTeam() {
        log.info("Find all team circus in {}",new Date());
        return database.query(FIND_ALL_TEAM,new BeanPropertyRowMapper<>(TeamCircus.class));
    }

    @Override
    public boolean deleteTeam(Long idTeam) {
        log.info("Delete team with id {} in {}",idTeam,new Date());
        return database.update(DELETE_TEAM,idTeam)>0;
    }
}
