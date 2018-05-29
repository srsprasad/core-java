package org.surthi.app.ws.moderate.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TeamClient {
  public static void main(String... args) throws MalformedURLException {
    URL url = new URL("http://127.0.0.1:9090/teams?wsdl");
    QName qName = new QName("http://moderate.ws.app.surthi.org/", "TeamServerImplService");
    Service service = Service.create(url, qName);
    TeamServer teamServer = service.getPort(TeamServer.class);
    for (Team team : teamServer.getTeams()) {
      System.out.print("Team: " + team.getName() + ", Players: { ");
      for (Player p : team.getPlayers()) {
        System.out.print("\"" + p.getName() + "\" ");
      }
      System.out.print("} \r\n");
    }
    System.out.print("HYD Team Players: ");
    teamServer.getTeam("HYD").getPlayers().forEach(player -> {
      System.out.print("\"" + player.getName() + "\" ");
    });
  }
}
