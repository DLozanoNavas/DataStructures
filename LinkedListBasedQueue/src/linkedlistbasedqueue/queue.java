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

        int TotalPayments = 0;
        int TotalPaymentGas = 0;
        int TotalPaymentLight = 0;
        int TotalPaymentWater = 0;
        int TotalWaterCustomers = 0;
        int TotalGasCustomers = 0;
        int TotalLightCustomers = 0;

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
                    System.out.println("Digite el servicio a pagar: \n1. Gas.\n2. Luz.\n3. Agua. ");

                    int service = scan.nextInt();
                    newCustomer.setService(service);
                    switch (service) {
                        case 1:
                            System.out.println("Digite el valor de su pago de gas: ");
                            double paymentGas = scan.nextDouble();
                            TotalPaymentGas += paymentGas;
                            TotalGasCustomers++;
                            newCustomer.setPayment(paymentGas);
                            break;
                        case 2:
                            System.out.println("Digite el valor de su pago de agua: ");
                            double paymentLight = scan.nextDouble();
                            newCustomer.setPayment(paymentLight);
                            TotalPaymentLight += paymentLight;
                            TotalLightCustomers++;
                            break;
                        case 3:
                            System.out.println("Digite el valor de su pago de luz: ");
                            double paymentWater = scan.nextDouble();
                            newCustomer.setPayment(paymentWater);
                            TotalPaymentWater += paymentWater;
                            TotalLightCustomers++;
                            break;

                    }

                    System.out.println("Ha sido agregado correctamente a la lista de espera.\n");

                    Queue.enqueue(newCustomer);
                    break;

                case 2:
                    Customer cust = Queue.dequeue();
                    TotalPayments += cust.getPayment();
                    System.out.println("El cliente ha sido atendido satisfactoriamente.");
                    break;

                case 3:
                    // Print Status
                    System.out.println("Clientes por atender: " + Queue.size());
                    System.out.println("Total clientes en cola [luz]: " + TotalLightCustomers);
                    System.out.println("Total clientes en cola [gas]: " + TotalGasCustomers);
                    System.out.println("Total clientes en cola [Agua]: " + TotalWaterCustomers);
                    break;

                case 4:
                    // Print Totals
                    System.out.println("\n //-------------------------------------------------//");
                    System.out.println("Total recibido: " + TotalPayments);
                    System.out.println("Total pago en cola [gas] " + TotalPaymentGas);
                    System.out.println("Total pago en cola [Agua]: " + TotalPaymentWater);
                    System.out.println("Total pago en cola [Luz]: " + TotalPaymentLight);

                    System.out.println("//-------------------------------------------------//\n ");
                    break;
            }
        }

    }

}
