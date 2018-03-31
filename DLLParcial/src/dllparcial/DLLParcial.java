/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dllparcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author dlozanonavas
 */
public class DLLParcial {

    /**
     * @param a
     * @throws java.io.IOException
     */
    public static void main(String a[]) throws IOException {
        DoublyLinkedList list = new DoublyLinkedList();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int Option;
            String Brand;
            String Plate;
            double Cost;
            int Year;
            System.out.println("\n1. Insertar vehiculo a la Lista\n2. Contar vehiculos.\n3. Borrar vehiculo.\n4. Obtener Totales.\n5. Mostrar inventario.\n6. Imprimir mayor - Menor.\n7. Buscar.\n0. Salir.\n  ");
            Option = Integer.parseInt(input.readLine());
            switch (Option) {
                case 0:
                    System.out.println("Bye. ");
                    System.exit(0);
                case 1:
                    //Add cars
                    try {
                        System.out.println("Digite el costo del vehiculo: ");
                        Cost = Double.parseDouble(input.readLine());
                        System.out.println("Digite la marca del vehiculo");
                        Brand = input.readLine();
                        System.out.println("Digite la placa del vehiculo");
                        Plate = input.readLine();
                        System.out.println("Digite el modelo del vehiculo");
                        Year = Integer.parseInt(input.readLine());
                        Car Car = new Car(Cost, Brand, Plate, Year);
                        list.addCarAtEnd(Car);
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    // Count Cars
                    try {
                        System.out.println("Actualmente tenemos " + list.countNodes() + " vehiculos en inventario.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    //  Delete Car
                    try {
                        list.deleteCar();
                    } catch (IOException e) {
                        e.getMessage();
                    }
                    break;
                case 4:
                    //Get Total Value
                    list.GetTotals();
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    //Get the less and more expensive
                    list.GetMinMax();
                    break;
                case 7:
                    //TODO: Implement Search
                    list.Search();
                    break;
            }
        }
    }
}
