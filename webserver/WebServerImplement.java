//SIB - Service Implementation Bean

package webserver;

import java.util.Date;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService(endpointInterface = "webserver.WebServer")

public class WebServerImplement implements WebServer {

	ArrayList<Pair> queue;
	ArrayList<ResultTask> results;
	Task invalid_task;

	public WebServerImplement() {
		System.out.println("Initialize server...");
		queue = new ArrayList<Pair>();
		results = new ArrayList<ResultTask>();
		invalid_task = new Task(null, null);
	}

	public void pairIn(int key, Task task) {
		System.out.println("Add pair " + key);
		Pair pair = new Pair(key, task);
		queue.add(pair);
	}

	public void pairOut(int key) {
		System.out.println("Remove pair " + key);
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
		return invalid_task;
	}

	public void printQueue() {
		System.out.println("");
		for(Pair pair : queue){
				System.out.println(pair.key + ": " + pair.task.row.size() + " " + pair.task.column.size());
			}
	}

	public void sendTaskResult(int key, int result) {
		ResultTask task_result = new ResultTask(key, result);
		results.add(task_result);
	}

	public int getResultTask(int key) {
		int index = 0;
		int value;
		for(ResultTask result : results){
			if(result.key == key){
				value = result.result;
				results.remove(index);
				return value;
			}
			index++;
		}
		return -1;
	}
}
