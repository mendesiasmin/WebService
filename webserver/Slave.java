package webserver;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

class Slave {

	public static void main(String args[]) throws Exception {

		URL url = new URL("http://127.0.0.1:3000/webserver?wsdl");
		QName qname = new QName("http://webserver/","WebServerImplementService");
		Service ws = Service.create(url, qname);
		WebServer webserver = ws.getPort(WebServer.class);

    Task task;
    int key_task = 0;

    while(key_task > -1) {

			// Search Task
      task = webserver.readPair(key_task);
			if (task.row == null)
			{
				System.out.println("Not found key task");
				//Sleep for a random time
				Random time = new Random();
				Thread.sleep(time.nextInt(4000));
			} else {
	        try {
	          int result = task.execute();
						System.out.println("Key Task: " + key_task + " Soluction: " + result);
	          webserver.sendTaskResult(key_task, result);
	          webserver.pairOut(key_task);
	        } catch(Exception e) {
	          //Nothing do
	        }
			}
      key_task++;
    }
	}
}
