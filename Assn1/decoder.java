import java.io.*;
import java.util.*;
import java.lang.NumberFormatException;

public class decoder{
  public static void main(String[] args){
    int num = 0;
    byte inChar = '\0';
    BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
    String line;
    String[] parts = new String[2];
	ArrayList<node> dict = new ArrayList<node>();
	Stack<Byte> stack = new Stack<Byte>();
	node current = null;
	
    try{
      while((line = rdr.readLine()) != null){
        parts = line.split(" ");

        num = Integer.parseInt(parts[0]);
        if(num == 0){
          dict.clear();}
        else{ 
			inChar = Byte.valueOf(parts[1]);
			current = new node(num,inChar);
			dict.add(current);
			
			if(num == 1) System.out.write(inChar);
			else{
				stack.push(inChar);
				current = dict.get(num - 2);
				while(true){
					stack.push(current.getByte());
					if(current.getPhase() == 1)
						break;
					current = dict.get(current.getPhase() - 2);
				}
				while(!(stack.empty())){
					System.out.write(stack.pop());
				}
				System.out.flush();
				
			}
		}
      }
    }
    catch (IOException e){
      System.err.println("error reading");
    }
  }
}
