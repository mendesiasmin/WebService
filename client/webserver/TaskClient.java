package webserver;

import java.util.List;
import javax.xml.bind.annotation.*;
import webserver.Task;
import webserver.Task.*;

// @XmlRootElement
// @XmlAccessorType(XmlAccessType.FIELD)
public class TaskClient {

  // @XmlElementWrapper
  // @XmlElement(name="row")
  public List<Integer> row;

  // @XmlElementWrapper
  // @XmlElement(name="column")
  public List<Integer> column;

  public TaskClient(){}
  public TaskClient(List<Integer> row, List<Integer> column) {
    this.column = column;
    this.row = row;
  }

  public Task generateTask(Matrix a, Matrix b, int index_a, int index_b) {

    List<Integer> row_a;
    List<Integer> column_b;

    row_a = a.matrix.get(index_a);
    column_b = b.matrix.get(index_b);
    Task task = new Task();

    for(int i = 0; i < column_b.size(); i++){
      task.getColumn().getColumn().add(column_b.get(i));
    }

    for(int i = 0; i < row_a.size(); i++){
      task.getRow().getRow().add(row_a.get(i));
    }

    return task;
  }
}
