package model;

import exceptions.ExistingNodeException;

/**
 *
 * @author Patricia
 */
public class MainVertex {
    private String value;
    private MainVertex next;
    private AdjVertex adjHead;

    public MainVertex() {
    }

    public MainVertex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MainVertex getNext() {
        return next;
    }

    public void setNext(MainVertex next) {
        this.next = next;
    }

    public AdjVertex getAdjListHead() {
        return adjHead;
    }

    public void setAdjListHead(AdjVertex adjListHead) {
        this.adjHead = adjListHead;
    }
    
    public void addLast(AdjVertex node) throws ExistingNodeException{
        if (searchAdjacentVertex(node.getValue())!=null)
            throw new ExistingNodeException("Ya existe el vertice en la lista adyacente");
        if (getAdjListHead()==null)
            setAdjListHead(node);
        else{
            AdjVertex q=getAdjListHead();
            while(q.getNext()!=null){
                q=q.getNext();
            }
            q.setNext(node);
        }
    }
    public AdjVertex searchAdjacentVertex(String value){
        AdjVertex q=getAdjListHead();
        while(q!=null){
            if (q.getValue().equalsIgnoreCase(value))
                return q;
            q=q.getNext();
       }
       return null;
    }
}
