package webserver;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

  @XmlElementWrapper
  @XmlElement(name="row")
  public ArrayList<Integer> row;

  @XmlElementWrapper
  @XmlElement(name="column")
  public ArrayList<Integer> column;

  public Task(){}
  public Task(ArrayList<Integer> row, ArrayList<Integer> column) {
    this.column = column;
    this.row = row;
  }
}
