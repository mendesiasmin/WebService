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

  public int execute() {
    int result = 0;
    for(int index = 0; index < row.size(); index++) {
      result += (row.get(index) * column.get(index));
    }
    return result;
  }

  public void generateTasks(Matrix a, Matrix b) {
    b = b.transposed();
    int size = a.matrix.get(0).size();
    ArrayList<Integer> row_a;
    ArrayList<Integer> column_b;
    Task task;
    int i = 0;

    for(int index_a = 0; index_a < size; index_a++){
      row_a = a.matrix.get(index_a);
      for(int index_b = 0; index_b < size; index_b++){
        column_b = b.matrix.get(index_b);
        task = new Task(row_a, column_b);
    		// webserver.pairIn(i++, task);
      }
    }
  }

  public Task generateTask(Matrix a, Matrix b, int index_a, int index_b) {

    ArrayList<Integer> row_a;
    ArrayList<Integer> column_b;

    row_a = a.matrix.get(index_a);
    column_b = b.matrix.get(index_b);
    return (new Task(row_a, column_b));
  }
}
