/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandox;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author dlozanonavas
 */
public class StackSandox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int max = 0;
        Scanner S = new Scanner(System.in);
        Stack<Product> Products = new Stack<Product>();
        Stack<Product> ProductsAux = new Stack<Product>();
        System.out.println("Numero de productos a agregar: ");
        int N = S.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.println("Nombre del producto: ");
            String name = S.next();
            System.out.println("Cod del producto: ");
            int cod = S.nextInt();
            System.out.println("Stock del producto: ");
            int stock = S.nextInt();
            Product a = new Product(name,cod,stock); 
            Products.push(a);
        }
System.out.println("\nProductos con Stock menor a 10: ");
        while (!Products.isEmpty()) {
            Product tmp = Products.peek();
            ProductsAux.push(tmp);
            if (tmp.getStock() < 10) {
                tmp.print();  
            }
            Products.pop();
        }
        while(!ProductsAux.isEmpty()){
            Products.push(ProductsAux.pop());
        }
    }
}
