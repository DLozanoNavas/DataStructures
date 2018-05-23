package model;

import exceptions.ExistingNodeException;
import exceptions.NonExistingNodeException;

/**
 *
 * @author Patricia
 */
public class Graph {
    private MainVertex head;
    
    public Graph(){ 
    }

    public MainVertex getHead() {
        return head;
    }

    public void setHead(MainVertex head) {
        this.head = head;
    }
   public String printGraph(){
       StringBuilder text = new StringBuilder();
       MainVertex m = getHead();
       AdjVertex a;
       while(m!=null){
           text.append(m.getValue());
           text.append(" => ");
           a=m.getAdjListHead();
           while (a!=null){
               text.append("[");
               text.append(a.getValue());
               text.append(" - ");
               text.append(a.getDistance());
               text.append("]");
               a=a.getNext();
           }
           text.append("\n");
           m=m.getNext();
       }
       return text.toString();
   }
   public MainVertex searchMainVertex(String value){
        MainVertex q = getHead();
        while (q!=null){
            if(q.getValue().equalsIgnoreCase(value))
                return q;
            q=q.getNext();
        }
        return null;
       
   }
   public void addMainVertex(String value) throws ExistingNodeException{
       if (searchMainVertex(value)!=null)
           throw new ExistingNodeException("Ya existe el vertice en la lista principal");
       MainVertex node = new MainVertex(value);
       if (getHead()==null){
           setHead(node);
       }else{
           MainVertex q = getHead();
           while(q.getNext()!=null){
               q=q.getNext();
           }
           q.setNext(node);
       }
   }
   public void addAdjVertex(AdjVertex adjNode,String valueMainVertex) throws ExistingNodeException, NonExistingNodeException{
       MainVertex mainNode = searchMainVertex(valueMainVertex); 
       if (mainNode != null){
           mainNode.addLast(adjNode);
       } else
           throw new NonExistingNodeException("No existe el nodo principal");
       
   }
}