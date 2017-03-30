import java.util.*;

class trie{
  trieNode newNode;
  int countTrie = 1;
  trieNode currentNode = null;
  LinkedList<trieNode> root = new LinkedList<trieNode>();
  Iterator<trieNode> li;
  int maxPhase = 0xff;
  String output;
  trieNode previous;

  trie(){}

  boolean isMax(int c){
    if((countTrie - 1) == c){
      countTrie = 1;
      return true;}
    return false;
  }



  //search for a byte, if found return byte else return null
	void insertNode(byte b){
    //either adding first node or root nodes, or just inserted a match
    if(currentNode == null){
      li = root.listIterator(0);

      while(li.hasNext()){
      newNode = li.next();
      if(newNode.getByte() == b){
        previous = currentNode;
        currentNode = newNode;
        return;
        }
      }
	  previous = null;
      countTrie++;
      newNode = new trieNode(countTrie, b);
      root.add(newNode);
      System.out.println("1" + " " +  b);
      return;
    }

    //means we are currently in a matched byte and need to either find the next match or insert the node.
    else{
      if(currentNode.childNodes != null){
        li = currentNode.childNodes.listIterator(0);

        while(li.hasNext()){
        newNode = li.next();
        if(newNode.getByte() == b){
          previous = currentNode;
          currentNode = newNode;
          return;
          }
        }
		previous = null;
      }
      countTrie++;
      newNode = new trieNode( countTrie, b);
      currentNode.addNode(newNode);
      System.out.println(currentNode.getPhase() + " " + b);
      currentNode = null;
      return;
      }
    }

}
