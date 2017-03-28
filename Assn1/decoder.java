import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

public class decoder{
  public static void main(String[] args){
    dictionary s = new dictionary();
    int num = 0;
    byte inChar = '\0';
    BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
    String line;
    String[] parts;
    Stack stak = new Stack();
    try{
      while((line = rdr.readLine()) != null){
        parts = line.split(" ");

        num = Integer.parseInt(parts[0]);
        if(num == 1){
          s = new dictionary();
          return;}
        inChar = Byte.valueOf(parts[1]);
        s.insert(num,inChar);
      }
    }
    catch (IOException e){
      System.err.println("error reading");
    }
  }
}
