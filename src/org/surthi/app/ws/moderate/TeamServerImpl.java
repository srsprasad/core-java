package org.surthi.app.ws.moderate;

import java.util.List;

import javax.jws.WebService;

@WebService(endpointInterface = "org.surthi.app.ws.moderate.TeamServer")
public class TeamServerImpl implements TeamServer {

  private TeamUtility teamUtility;

  public TeamServerImpl() {
    teamUtility = new TeamUtility();
  }

  @Override
  public Team getTeam(String teamName) {
    return teamUtility.getTeam(teamName);
  }

  @Override
  public List<Team> getTeams() {
    return teamUtility.getTeams();
  }
}
