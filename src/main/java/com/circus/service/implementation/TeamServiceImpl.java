package com.circus.service.implementation;

import com.circus.domain.TeamCircus;
import com.circus.repository.api.TeamRepositoryApi;
import com.circus.service.api.TeamServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamServiceApi {

    private final TeamRepositoryApi teamRepository;

    @Override
    public boolean saveTeam(TeamCircus teamCircusSave) {
        if(teamCircusSave!=null){
            teamCircusSave.setDate_create(LocalDateTime.now());
            log.info("Save team circus with service, name {} in {}",teamCircusSave.getName(), new Date());
            return teamRepository.saveTeam(teamCircusSave);
        }else{
            log.error("Cannot save team circus, equals null in {}",new Date());
            return false;
        }
    }

    @Override
    public boolean updateTeam(TeamCircus teamCircusUpdate) {
       if(teamCircusUpdate.getId()!=null){
           log.info("Update team circus with service, id {} in {}",teamCircusUpdate.getId(), new Date());
           return teamRepository.updateTeam(teamCircusUpdate);
       }else{
           log.error("Cannot update team circus id, equals null in {}",new Date());
           return false;
       }
    }

    @Override
    public TeamCircus getTeamById(Long idTeam) {
        if(idTeam!=null){
            log.info("Get team circus by id with service, id {} in {}",idTeam, new Date());
            return teamRepository.getTeamById(idTeam);
        }else{
            log.error("Cannot get team circus by id, equals null in {}",new Date());
            return null;
        }
    }

    @Override
    public List<TeamCircus> findAllTeam() {
        log.info("Get all team circus with service, in {}",new Date());
        return teamRepository.findAllTeam();
    }

    @Override
    public boolean deleteTeam(Long idTeam) {
       if(idTeam!=null){
           log.info("Delete team circus by id with service, id {} in {}",idTeam, new Date());
           return teamRepository.deleteTeam(idTeam);
       }else{
           log.error("Cannot delete team circus by id, equals null in {}",new Date());
           return false;
       }
    }
}
