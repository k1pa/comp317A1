import java.io.IOException;
import java.util.*;
import java.lang.NumberFormatException;

public class encoder{
  public static void main(String[] args){
    trie tr = new trie();
    byte inByte;
	byte prev = 0;
    int max = 0xffff;

    try{
      if(args.length == 1){
          max = (int) Math.pow(2, Double.parseDouble(args[0])) - 1;}
    }catch(NumberFormatException e){
      System.err.println(e.getMessage());}

    //do not need a dictionary as we can just output straight from the while loop, using System.out.write.
    try{
      while((inByte = (byte) System.in.read()) != -1){
        if(tr.isMax(max)){tr = new trie();}
        tr.insertNode(inByte);
		prev = inByte;
      }
	  //need this line incase we were trying to find next byte to match but instead found end of file
	  if(tr.previous != null) System.out.println(tr.previous.getPhase() + " " + tr.currentNode.getByte());
    }
    catch(IOException e){
      System.err.println("error reading");
    }
}
}





