package webserver;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import webserver.WebServer;
import webserver.Task;
import webserver.WebServerImplementService;

class Slave {

	public static void main(String args[]) throws Exception {

		WebServerImplementService sib = new WebServerImplementService();
		WebServer webserver = sib.getWebServerImplementPort();

		Task task;
    TaskSlave task_slave = new TaskSlave();
    int key_task = 0;

    while(key_task > -1) {

			// Search Task
      task = webserver.readPair(key_task);
			if (task.getRow() == null)
			{
				System.out.println("Not found key task");
				//Sleep for a random time
				Random time = new Random();
				Thread.sleep(time.nextInt(4000));
			} else {
	        try {
	          int result = task_slave.execute(task.getRow().getRow(), task.getColumn().getColumn());
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
