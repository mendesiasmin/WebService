package webserver;

import java.util.List;
import javax.xml.bind.annotation.*;

public class TaskSlave {

  public TaskSlave(){}

  public int execute(List<Integer> row, List<Integer> column) {
    int result = 0;
    for(int index = 0; index < row.size(); index++) {
      result += (row.get(index) * column.get(index));
    }
    return result;
  }
}
