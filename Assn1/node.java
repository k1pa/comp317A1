public class node{
  int phase = 0;
  byte ch;

  node(int p, byte b){
    phase = p;
    ch = b;
  }

  int getPhase(){return phase;}

  byte getByte(){return ch;}
}