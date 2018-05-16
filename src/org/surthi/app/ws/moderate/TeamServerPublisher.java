package org.surthi.app.ws.moderate;

import javax.xml.ws.Endpoint;

public class TeamServerPublisher {
    public static void main(String...args) {
        Endpoint.publish("http://127.0.0.1:9090/teams" , new TeamServerImpl());
    }
}
