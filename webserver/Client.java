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

		Matrix matrix_A = new Matrix("input/matrix_C.txt");
		Matrix matrix_B = new Matrix("input/matrix_D.txt");

		Matrix transposed_B = matrix_B.transposed();
		int size = matrix_A.matrix.size();
    int i = 0;
		Task task = new Task();

    for(int index_a = 0; index_a < size; index_a++){
      for(int index_b = 0; index_b < size; index_b++){
        task = task.generateTask(matrix_A, transposed_B, index_a, index_b);
    		webserver.pairIn(i++, task);
      }
    }

		int result;
		int key = 0;
		Matrix matrix_result = new Matrix();
		matrix_result.initializeResultMatrix(size);

		do {
			result = webserver.getResultTask(key);
			if (result != -1) {
				int number_row = matrix_result.calcNumberRow(key);
				int number_column = matrix_result.calcNumberColumn(key);
				matrix_result.addElement(result, number_row, number_column);
				key++;
			}
    }while(key != size*size);

		System.out.println("Result:\n");
		matrix_result.printMatrix();
	}
}
