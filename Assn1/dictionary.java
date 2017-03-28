import java.util.*;

public class dictionary{
  LinkedList<node> dict = new LinkedList<node>();
  node hold = null;
  Iterator<node> li;
  Stack<Character> stack = new Stack<Character>();

  dictionary(){}

  void reset(){
    dict = new LinkedList<node>();
  }

  void insert(int num, byte inChar){
    hold = new node(num,inChar);
    dict.add(hold);
    print();
    }

  void stacking()
  {
    stack.push(hold.getChar());
    while(true)
    {
      hold = dict.get(hold.getPhase() - 2);
      stack.push((Character) hold.getChar());
      if(hold.getPhase() == 0)
        break;
    }

    while(!(stack.empty())){
      System.out.print(stack.pop());
    }
  }
  void print(){
    if(hold.getPhase() == 0)
      System.out.print(hold.getChar());
    else stacking();
  }
}
