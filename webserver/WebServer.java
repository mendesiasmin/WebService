//SEI - Service Endpoint Interface

package webserver;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.ArrayList;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServer {

	@WebMethod void pairIn(int key, Task task);
	@WebMethod void pairOut(int key);
	@WebMethod Task readPair(int key);
	@WebMethod void printQueue();

}
