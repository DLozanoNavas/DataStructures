/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dllparcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dlozanonavas
 */
public class DoublyLinkedList {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private DoubleNode head;
    private DoubleNode tail;
    public int size;

    /**
     * Constructs a new DoublyLinkedList object with head and tail as null
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addCarAtEnd(Car c) {
        DoubleNode n = new DoubleNode(c, tail, null);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setLinkNext(n);
            tail = n;
        }
        size++;
    }

    public void addCarAtFront(Car c) {
        DoubleNode n = new DoubleNode(c, null, head);
        if (isEmpty()) {
            head = tail = n;
        } else {
            head.setLinkPrev(n);
            head = n;
        }
        size++;
    }

    public Car removeCarFromFront() {
        Car ch = head.getData();
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.getLinkNext();
                head.setLinkPrev(null);
            }
        }
        size--;
        return ch;
    }

    public Car removeCarAtEnd() {
        Car ch = tail.getData();

        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.getLinkPrev();
                tail.setLinkNext(null);
            }
        }
        size--;
        return ch;
    }

    public void display() {
        DoubleNode ptr = head;
        
        System.out.print("\nVehiculos en inventario:\n ");
        
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }

        if (head.getLinkNext() == null) {
            System.out.println("Placa: " + head.getData().getPlate() + " - Precio: " + head.getData().getCost() + " - Marca: " + head.getData().getBrand() + " - Modelo: " + head.getData().getYear() + "\n");
            return;
        }

        System.out.print("Placa: " + head.getData().getPlate() + " - Precio: " + head.getData().getCost() + " - Marca: " + head.getData().getBrand() + " - Modelo: " + head.getData().getYear() + "\n");
        ptr = head.getLinkNext();

        while (ptr.getLinkNext() != null) {
            System.out.print("Placa: " + ptr.getData().getPlate() + " - Precio: " + ptr.getData().getCost() + " - Marca: " + ptr.getData().getBrand() + " - Modelo: " + ptr.getData().getYear() + "\n");
            ptr = ptr.getLinkNext();
        }
        System.out.print("Placa: " + ptr.getData().getPlate() + " - Precio: " + ptr.getData().getCost() + " - Marca: " + ptr.getData().getBrand() + " - Modelo: " + ptr.getData().getYear() + "\n");
    }

    public void GetTotals() {
        double Totals = head.getData().getCost();
        System.out.print("\nVehiculos en inventario:\n ");

        if (size == 0) {
            System.out.print("Ninguno.\n");
            return;
        }

        if (head.getLinkNext() == null) {
            System.out.println("Precio del inventario total: " + head.getData().getCost() + "\n");
            return;
        }

        
        DoubleNode ptr = head;

        while (ptr.getLinkNext() != null) {
            ptr = ptr.getLinkNext();
            Totals += ptr.getData().getCost();
        }
        
        System.out.print("Precio del inventario total: " + Totals + "\n");
    }

    public int countNodes() {
        DoubleNode cn = head;
        int count = 0;
        
        while (cn != null) {
            count++;
            cn = cn.getLinkNext();
        }
        
        return count;
    }

    public boolean deleteCar() throws IOException {
        System.out.println("Digite la placa del vehiculo a eliminar: ");
        String DeletePlate = input.readLine();
        DoubleNode cn = head;
        
        while (!cn.getData().getPlate().equalsIgnoreCase(DeletePlate)) {
            cn = cn.getLinkNext();
        }
        
        if (cn != null) {
            if (cn.getLinkPrev() == null) {
                head = cn.getLinkNext();
                if (!isEmpty()) {
                    head.setLinkPrev(null);
                }
            } else if (cn.getLinkNext() == null) {
                tail = cn.getLinkPrev();
                if (!isEmpty()) {
                    tail.setLinkNext(null);
                }
            } else {
                cn.getLinkPrev().setLinkNext(cn.getLinkNext());
                cn.getLinkNext().setLinkPrev(cn.getLinkPrev());
            }
        }
        return cn != null;
    }

    public void GetMinMax() {
        double Min = 0;
        double Max = head.getData().getCost();
        DoubleNode ptr = head;
        DoubleNode minptr = head;

        if (size == 0) {
            System.out.print("Ninguno.\n");
            return;
        }

        if (head.getLinkNext() == null) {
            System.out.println("Precio mayor: " + head.getData().getCost() + "\n");
            return;
        }

        while (ptr.getLinkNext() != null) {
            if (Max < ptr.getData().getCost()) {
                Max = ptr.getData().getCost();
                ptr = ptr.getLinkNext();
            }
            ptr = ptr.getLinkNext();
        }

        while (minptr.getLinkNext() != null) {
            if (Min > minptr.getData().getCost()) {
                Min = minptr.getData().getCost();
                minptr = minptr.getLinkNext();
            }
            minptr = minptr.getLinkNext();
        }
        System.out.print("Precio Mayor: " + Max + "\n");
        System.out.print("Precio Menor: " + Min + "\n");
    }

    public void Search() throws IOException {
        System.out.println("Digite la placa a buscar: ");
        String SearchPlate;
        SearchPlate = input.readLine();
        DoubleNode searchptr = head;

        if (size == 0) {
            System.out.print("Actualmente no existen vehiculos en el inventario.\n");
            return;
        }

        while (searchptr.next != null) {
            if (SearchPlate.equals(searchptr.getData().getPlate())) {
                System.out.print("Placa: " + searchptr.getData().getPlate() + " - Precio: " + searchptr.getData().getCost() + " - Marca: " + searchptr.getData().getBrand() + " - Modelo: " + searchptr.getData().getYear() + "\n");
                break;
            } else if (!SearchPlate.equals(searchptr.getData().getPlate())) {
                searchptr = searchptr.getLinkNext();
            } else {
                System.out.println("Vehiculo no encontrado en el inventario.");
            }
        }
    }
}
