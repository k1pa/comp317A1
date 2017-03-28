import java.util.*;

class trieNode {
  int phase;
  byte c;
  public LinkedList<trieNode> childNodes = null;

  trieNode(int ph, byte ch){
    phase = ph;
    c = ch;
  }

  int getPhase(){return phase;}

  byte getByte(){return c;}

  void addNode(trieNode n){
    if(childNodes == null)
      childNodes = new LinkedList<trieNode>();
    childNodes.add(n);
  }
}
