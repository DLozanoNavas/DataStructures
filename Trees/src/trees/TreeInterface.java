/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author dlozanonavas
 * @param <T>
 */
public interface TreeInterface<T> {
    public boolean add (T value);
    public boolean isStored(T value);
    public T remove (T value);
    public void clear();
    public int size();
    public boolean validate();
    public java.util.Collection<T> toCollection();
}
