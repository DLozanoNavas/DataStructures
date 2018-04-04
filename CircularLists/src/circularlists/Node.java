/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlists;

/**
 *
 * @author dlozanonavas
 */
public class Node {
    int data =0;
    Node Sig;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getSig() {
        return Sig;
    }

    public void setSig(Node Sig) {
        this.Sig = Sig;
    }
    
}
