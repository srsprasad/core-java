package org.surthi.app.ws.basic.client;

import org.surthi.app.ws.basic.TimeServer;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class TimeServerClient {
    public static void main(String...args) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:9090/ts?wsdl");
        QName name = new QName("http://basic.ws.app.surthi.org/","TimeServerImplService");
        Service service = Service.create(url, name);
        TimeServer timeServer = service.getPort(TimeServer.class);
        System.out.println("Time as String: "+ timeServer.getTimeAsString());
        System.out.println("Tims as Elapsed: "+ timeServer.getTimeAsElapsed());
    }
}
