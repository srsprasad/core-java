package org.surthi.app.ws.moderate;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.surthi.app.ws.moderate.TeamServer")
public class TeamServerImpl implements TeamServer{

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
