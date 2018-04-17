/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistbasedqueue;

import java.util.Scanner;

/**
 *
 * @author dlozanonavas
 */
public class queue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedListBasedQueue Queue = new LinkedListBasedQueue();
        Scanner scan = new Scanner(System.in);
        
        int TotalPayments =0;

        
        while (true) {
            System.out.println("1. Agregar cliente a la cola de espera.\n2. Atender cliente.\n3. Imrimir estado del servicio.\n4. Imprimir totales.\n");
            int option = scan.nextInt();
            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    // Get Customer data and enqueue
                    Customer newCustomer = new Customer();
                    System.out.println("Digite su identificacion: ");
                    newCustomer.setID(scan.nextDouble());
                    System.out.println("Digite su nombre: ");
                    String Name = scan.next();
                    newCustomer.setName(Name);
                    System.out.println("Digite el servicio a pagar: ");
                    newCustomer.setService(scan.next());
                    System.out.println("Digite el valor de su pago: ");
                    newCustomer.setPayment(scan.nextDouble());
                    
                    Queue.enqueue(newCustomer);
                    break;

                case 2:
                    
                    Customer cust = Queue.dequeue();
                    TotalPayments += cust.getPayment();
                    System.out.println("El cliente ha sido atendido satisfactoriamente.");
                    break;

                case 3:
                    // Print Status
                    System.out.println("Clientes por atender: "+Queue.size());
                    break;

                case 4:
                    // Print Totals
                    System.out.println("Total recibido: " + TotalPayments);
                    break;

            }
        }

    }

}
