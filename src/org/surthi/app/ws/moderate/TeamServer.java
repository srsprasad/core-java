package org.surthi.app.ws.moderate;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding
public interface TeamServer {
    @WebMethod
    public Team getTeam(String teamName);
    @WebMethod
    public List<Team> getTeams();

}
