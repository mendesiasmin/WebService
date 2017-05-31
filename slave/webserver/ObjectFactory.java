
package webserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Task_QNAME = new QName("http://webserver/", "task");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link Task.Row }
     * 
     */
    public Task.Row createTaskRow() {
        return new Task.Row();
    }

    /**
     * Create an instance of {@link Task.Column }
     * 
     */
    public Task.Column createTaskColumn() {
        return new Task.Column();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Task }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webserver/", name = "task")
    public JAXBElement<Task> createTask(Task value) {
        return new JAXBElement<Task>(_Task_QNAME, Task.class, null, value);
    }

}
