package model;

/**
 *
 * @author Patricia
 */
public class AdjVertex {
    private String value;
    private int distance;
    private AdjVertex next;

    public AdjVertex() {
    }

    public AdjVertex(String value, int distance) {
        this.value = value;
        this.distance = distance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public AdjVertex getNext() {
        return next;
    }

    public void setNext(AdjVertex next) {
        this.next = next;
    }
    
    
    
}
