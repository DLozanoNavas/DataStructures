package controller;

import exceptions.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

import view.IoManager;

public class Control {

    private IoManager io;
    private Graph graph;

    public Control() {
        io = new IoManager();
        graph = new Graph();
    }

    public void menu() {
        int op = 0;
        do {
            try {
                op = io.readMenu();
                switch (op) {
                    case 1:
                        insertMainVertex();
                        break;
                    case 2:
                        insertAdjVertex();
                        break;
                    case 3:
                        printGraph();
                        break;
                    case 4:
                        break;
                    default:
                        io.showErrorMessage("Opcion incorrecta");
                }
            } catch (NumberFormatException e) {
                io.showErrorMessage("Debe ser un valor entero");
            }
        } while (op != 4);

    }

    public void insertMainVertex() {
        try {
            String value = io.readString("Vertice principal a adicionar");
            graph.addMainVertex(value);
            io.showMessage("El vertice principal fue adicionado");
        } catch (ExistingNodeException e) {
            io.showErrorMessage(e.getMessage());
        }

    }

    public void insertAdjVertex() {
        try {
            String valueMainVertex = io.readString("Vertice principal");
            if (graph.searchMainVertex(valueMainVertex)== null){
                throw new NonExistingNodeException("No existe el vertice principal");
            }
            String valueToInsert = io.readString("Vertice adyacente a adicionar");
            if (graph.searchMainVertex(valueToInsert)== null){
                graph.addMainVertex(valueToInsert);
            }
            int distance = io.readInt("Distancia del vertice adyacente");
            AdjVertex adjNode = new AdjVertex(valueToInsert, distance);
            graph.addAdjVertex(adjNode, valueMainVertex);
            io.showMessage("El vertice adyacente fue adicionado");
        } catch (ExistingNodeException | NonExistingNodeException e) {
            io.showErrorMessage(e.getMessage());
        }
    }

    public void printGraph() {
        io.showMessage(graph.printGraph());
    }

    

}
