package org.surthi.app.ws.moderate;

import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team() {}

    public Team(String name, List<Player> players){
        setName(name);
        setPlayers(players);
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
