
package org.surthi.app.ws.moderate.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.*;


/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035 Generated source version:
 * 2.2
 * 
 */
@WebServiceClient(name = "TeamServerImplService",
    targetNamespace = "http://moderate.ws.app.surthi.org/",
    wsdlLocation = "http://127.0.0.1:9090/teams?wsdl")
public class TeamServerImplService extends Service {

  private final static URL TEAMSERVERIMPLSERVICE_WSDL_LOCATION;
  private final static WebServiceException TEAMSERVERIMPLSERVICE_EXCEPTION;
  private final static QName TEAMSERVERIMPLSERVICE_QNAME =
      new QName("http://moderate.ws.app.surthi.org/", "TeamServerImplService");

  static {
    URL url = null;
    WebServiceException e = null;
    try {
      url = new URL("http://127.0.0.1:9090/teams?wsdl");
    } catch (MalformedURLException ex) {
      e = new WebServiceException(ex);
    }
    TEAMSERVERIMPLSERVICE_WSDL_LOCATION = url;
    TEAMSERVERIMPLSERVICE_EXCEPTION = e;
  }

  public TeamServerImplService() {
    super(__getWsdlLocation(), TEAMSERVERIMPLSERVICE_QNAME);
  }

  public TeamServerImplService(WebServiceFeature... features) {
    super(__getWsdlLocation(), TEAMSERVERIMPLSERVICE_QNAME, features);
  }

  public TeamServerImplService(URL wsdlLocation) {
    super(wsdlLocation, TEAMSERVERIMPLSERVICE_QNAME);
  }

  public TeamServerImplService(URL wsdlLocation, WebServiceFeature... features) {
    super(wsdlLocation, TEAMSERVERIMPLSERVICE_QNAME, features);
  }

  public TeamServerImplService(URL wsdlLocation, QName serviceName) {
    super(wsdlLocation, serviceName);
  }

  public TeamServerImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
    super(wsdlLocation, serviceName, features);
  }

  private static URL __getWsdlLocation() {
    if (TEAMSERVERIMPLSERVICE_EXCEPTION != null) {
      throw TEAMSERVERIMPLSERVICE_EXCEPTION;
    }
    return TEAMSERVERIMPLSERVICE_WSDL_LOCATION;
  }

  /**
   *
   * @return returns TeamServer
   */
  @WebEndpoint(name = "TeamServerImplPort")
  public TeamServer getTeamServerImplPort() {
    return super.getPort(new QName("http://moderate.ws.app.surthi.org/", "TeamServerImplPort"),
        TeamServer.class);
  }

  /**
   *
   * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.
   *        Supported features not in the <code>features</code> parameter will have their default
   *        values.
   * @return returns TeamServer
   */
  @WebEndpoint(name = "TeamServerImplPort")
  public TeamServer getTeamServerImplPort(WebServiceFeature... features) {
    return super.getPort(new QName("http://moderate.ws.app.surthi.org/", "TeamServerImplPort"),
        TeamServer.class, features);
  }

}
