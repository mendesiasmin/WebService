package webserver;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Matrix {

  public ArrayList<ArrayList<Integer>> matrix;

  public Matrix(){
    matrix = new ArrayList<ArrayList<Integer>>();
  }

  public Matrix(String file) {
    matrix = new ArrayList<ArrayList<Integer>>();
    readFile(file);
  }

  public void readFile(String file) {
    try {
      FileReader open_file = new FileReader(file);
      BufferedReader read_file = new BufferedReader(open_file);

      String line = read_file.readLine();
      while (line != null) {
        newRow(line);
        line = read_file.readLine();
      }

      open_file.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
  }

  public void newRow(String line) {

    Integer value;
    String[] brokenLine = line.split(" ");
    ArrayList<Integer> row = new ArrayList<Integer>();

    for(int index = 0; index < brokenLine.length; index++){
      value = Integer.parseInt(brokenLine[index]);
      row.add(value);
    }
    matrix.add(row);
  }

  public void printMatrix() {

    ArrayList<Integer> row;

    for(int index = 0; index < matrix.size(); index++){
      row = matrix.get(index);
      for(int j = 0; j < row.size(); j++){
        System.out.print(row.get(j) + "\t");
      }
      System.out.println();
    }
    System.out.println();
  }

  public void printMatrix(Matrix m) {

    ArrayList<Integer> row;
    ArrayList<ArrayList<Integer>> matrix = m.matrix;

    for(int index = 0; index < matrix.size(); index++){
      row = matrix.get(index);
      for(int j = 0; j < row.size(); j++){
        System.out.print(row.get(j) + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public Matrix transposed() {

    Matrix transposed = new Matrix();
    ArrayList<Integer> row = matrix.get(0);
    ArrayList<Integer> newRow;

    for(int index = 0; index < row.size(); index++){
      newRow = getColumn(index);
      transposed.matrix.add(newRow);
    }
    return transposed;
  }

  public ArrayList<Integer> getColumn(int column_index) {
    ArrayList<Integer> column = new ArrayList<Integer>();
    ArrayList<Integer> row;

    for(int index = 0; index < matrix.size(); index++){
      row = matrix.get(index);
      column.add(row.get(column_index));
    }
    return column;
  }

  public void addElement(int result, int i, int j){
    ArrayList<Integer> row = matrix.get(i);
    row.set(j, result);
  }

  public int calcNumberRow(int key) {
    int number_rows =  matrix.get(0).size();
    return key / number_rows;
  }

  public int calcNumberColumn(int key) {
    int number_columns =  matrix.get(0).size();
    return key % number_columns;
  }

  public void initializeResultMatrix(int size) {
    for(int index_row = 0; index_row < size; index_row++){
      ArrayList<Integer> row = new ArrayList<Integer>();
      for(int index_column = 0; index_column < size; index_column++){
        row.add(0);
      }
      matrix.add(row);
    }
  }
}
