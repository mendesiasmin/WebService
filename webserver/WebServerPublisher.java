package webserver;

import javax.xml.ws.Endpoint;
import javax.xml.soap.SOAPMessage;

public class WebServerPublisher {

	public static void main(String[] args)
	{
		Endpoint.publish("http://127.0.0.1:3000/webserver",
		new WebServerImplement());
	}
}
