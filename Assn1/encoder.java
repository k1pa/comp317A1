import java.io.IOException;
import java.util.*;
import java.lang.NumberFormatException;

public class encoder{
  public static void main(String[] args){
    trie tr = new trie();
    byte inByte;
    int max = 0xffff;
	int input = 0;

    //do not need a dictionary as we can just output straight from the while loop, using System.out.write.
    try{
		long start = System.currentTimeMillis();
		input = System.in.read();
		if(args.length == 1){
          max = (int) Math.pow(2, Double.parseDouble(args[0])) - 1;}
      while(input != -1){
		  
		  inByte = (byte) input;
        if(tr.isMax(max)){
			tr = new trie();
			System.out.println("0 0");}
        tr.insertNode(inByte);
		input = System.in.read();
      }
	  //need this line incase we were trying to find next byte to match but instead found end of file
	  if(tr.previous != null && tr.currentNode != null) System.out.println(tr.previous.getPhase() + " " + tr.currentNode.getByte());
		long time = System.currentTimeMillis() - start;
				System.err.println(time);
	}
    catch(IOException e){
      System.err.println("error reading");
    }
}
}





