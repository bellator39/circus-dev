package com.circus.repository.api;

import com.circus.domain.Contacts;
import com.circus.domain.TeamCircus;

import java.util.List;

public interface TeamRepositoryApi {
    boolean saveTeam(TeamCircus teamCircusSave);
    boolean updateTeam(TeamCircus teamCircusUpdate);
    TeamCircus getTeamById(Long idTeam);
    List<TeamCircus> findAllTeam();
    boolean deleteTeam(Long idTeam);
}
