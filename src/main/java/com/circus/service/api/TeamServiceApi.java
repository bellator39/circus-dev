package com.circus.service.api;

import com.circus.domain.TeamCircus;

import java.util.List;

public interface TeamServiceApi {
    boolean saveTeam(TeamCircus teamCircusSave);
    boolean updateTeam(TeamCircus teamCircusUpdate);
    TeamCircus getTeamById(Long idTeam);
    List<TeamCircus> findAllTeam();
    boolean deleteTeam(Long idTeam);
}
