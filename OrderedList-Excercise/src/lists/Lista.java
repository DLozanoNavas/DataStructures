/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

/**
 *
 * @author dlozanonavas
 */
public class Lista {

    private Nodo cabeza = null;

    void insertar(double x) {
        Nodo nuevo = new Nodo();
        nuevo.cedula = x;
        if (cabeza == null) {
            cabeza = nuevo;
        } else if (nuevo.cedula < cabeza.cedula) {
            nuevo.sig = cabeza;
            cabeza = nuevo;
        } else if (cabeza.cedula <= nuevo.cedula) {
            nuevo.sig = null;
            cabeza.sig = nuevo;
        }
    }

    public void borrarPrimero() {
        if (cabeza != null) {
            cabeza = cabeza.sig;
        }
    }

    public void borrarSegundo() {
        if (cabeza != null) {
            if (cabeza.sig != null) {
                Nodo tercero = cabeza.sig;
                tercero = tercero.sig;
                cabeza.sig = tercero;
            }
        }
    }

    public void borrarUltimo() {
        if (cabeza != null) {
            if (cabeza.sig == null) {
                cabeza = null;
            } else {
                Nodo aux = cabeza.sig;
                Nodo atras = aux;
                while (aux.sig != null) {
                    atras = aux;
                    aux = aux.sig;
                }
                atras.sig = null;
            }
        }

    }

    public void imprimir() {
        Nodo aux = cabeza;
        while (aux != null) {
            System.out.print(aux.cedula + " - ");
            aux = aux.sig;
        }
        System.out.println();
    }

    public void borrarMayor() {
        if (cabeza != null) {
            Nodo aux = cabeza;
            double may = cabeza.cedula;
            while (aux != null) {
                if (aux.cedula > may) {
                    may = aux.cedula;
                }
                aux = aux.sig;
            }
            aux = cabeza;
            Nodo atras = cabeza;
            while (aux != null) {
                if (aux.cedula == may) {
                    if (aux == cabeza) {
                        cabeza = cabeza.sig;
                        atras = cabeza;
                        aux = cabeza;
                    } else {
                        atras.sig = aux.sig;
                        aux = aux.sig;
                    }
                } else {
                    atras = aux;
                    aux = aux.sig;
                }
            }
        }
    }

    public class Nodo {

        double cedula;
        Nodo sig;
    }

}
