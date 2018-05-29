package org.surthi.app.ws.moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeamUtility {
  private Map<String, Team> teams = new HashMap<>();

  public TeamUtility() {
    create_test_store();
  }

  public Team getTeam(String name) {
    return teams.get(name);
  }

  public List<Team> getTeams() {
    return new ArrayList<>(teams.values());
  }

  public void create_test_store() {
    List<Player> players =
        Stream.of("Ravi", "Shankar", "Prasad").map(Player::new).collect(Collectors.toList());
    List<Player> players2 =
        Stream.of("kisore", "kumar", "manmohan").map(Player::new).collect(Collectors.toList());
    Team team1 = new Team("HYD", players);
    Team team2 = new Team("BMB", players2);
    teams.put(team1.getName(), team1);
    teams.put(team2.getName(), team2);
  }
}
