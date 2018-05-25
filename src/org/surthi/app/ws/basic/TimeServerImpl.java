package org.surthi.app.ws.basic;

import javax.jws.WebService;
import java.util.Date;

@WebService(endpointInterface = "org.surthi.app.ws.basic.TimeServer")
public class TimeServerImpl {

    public String getTimeAsString() { return new Date().toString();}

    public long getTimeAsElapsed() { return new Date().getTime(); }
}
