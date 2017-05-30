//SIB - Service Implementation Bean

package webserver;

import java.util.Date;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "webserver.WebServer")

public class WebServerImplement implements WebServer {

	ArrayList<Pair> queue;

	public WebServerImplement() {
		queue = new ArrayList<Pair>();
	}

	public void pairIn(int key, Task task) {
		System.out.println("Entrou");
		System.out.println("R: " + task.row.size());
		System.out.println("C: " + task.column.size());
		Pair pair = new Pair(key, task);
		queue.add(pair);
	}

	public void pairOut(int key) {
		int index = 0;
		for(Pair pair : queue){
			if(pair.key == key){
				queue.remove(index);
				return;
			}
			index++;
		}
	}

	public Task readPair(int key) {
		for(Pair pair : queue){
			if(pair.key == key){
				return pair.task;
			}
		}
		return null;
	}

	public void printQueue() {
		System.out.println("");
		for(Pair pair : queue){
				System.out.println(pair.key + ": " + pair.task.row.size() + " " + pair.task.column.size());
			}
	}
}
