package org.surthi.app.ws.moderate;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding
public interface TeamServer {
  @WebMethod
  Team getTeam(String teamName);

  @WebMethod
  List<Team> getTeams();

}
