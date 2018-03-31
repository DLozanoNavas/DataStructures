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

    private Nodo cabeza;

    public Lista() {
        cabeza = null;
    }

    void insertarPrimero(double x, String Name) {
        Nodo nuevo = new Nodo();
        nuevo.cedula = x;
        nuevo.nombre = Name;
        nuevo.sig = cabeza;
        cabeza = nuevo;
    }

    public void insertarUtlimo(double x, String Name) {
        Nodo nuevo = new Nodo();
        nuevo.cedula = x;
        nuevo.nombre =Name;
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = nuevo;
        }
    }

    public void insertarSegundo(double x, String Name) {
        if (cabeza != null) {
            Nodo nuevo = new Nodo();
            nuevo.cedula = x;
            nuevo.nombre = Name;
            if (cabeza.sig == null) {
                //Hay un solo nodo.1
                
                cabeza.sig = nuevo;
            } else {
                nuevo.sig = cabeza.sig;
                cabeza.sig = nuevo;
            }
        }
    }

    public void insertarAnteUltimo(double x, String Name) {
        if (cabeza != null) {
            Nodo nuevo = new Nodo();
            nuevo.cedula = x;
            nuevo.nombre =Name;
            if (cabeza.sig == null) {
                //Hay un solo nodo.
                nuevo.sig = cabeza;
                cabeza = nuevo;
            } else {
                Nodo atras = cabeza;
                Nodo aux = cabeza.sig;
                while (aux.sig != null) {
                    atras = aux;
                    aux = aux.sig;
                }
                nuevo.sig = atras.sig;
                atras.sig = nuevo;
            }
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
            System.out.print("\n" + aux.cedula + " - " + aux.nombre+"\n");
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
}
