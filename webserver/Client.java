package webserver;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.ArrayList;

class Client {

	public static void main(String args[]) throws Exception {
		URL url = new URL("http://127.0.0.1:3000/webserver?wsdl");
		QName qname = new QName("http://webserver/","WebServerImplementService");
		Service ws = Service.create(url, qname);
		WebServer webserver = ws.getPort(WebServer.class);

		ArrayList<Integer> teste = new ArrayList<Integer>();
		teste.add(1);
		teste.add(2);
		teste.add(3);
		teste.add(4);

		Task task = new Task(teste, teste);
		webserver.pairIn(30, task);
		webserver.pairIn(40, task);
		webserver.pairIn(50, task);
		webserver.pairIn(60, task);
		webserver.printQueue();

		webserver.pairOut(30);
		webserver.printQueue();

		Task search = webserver.readPair(50);
		System.out.println(search.row.size());

	}
}
