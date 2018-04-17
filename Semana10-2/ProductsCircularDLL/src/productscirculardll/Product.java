/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productscirculardll;

/**
 *
 * @author dlozanonavas
 */
public class Product {

    public class Producto {

        private Node cab;
        String nom;
        float ivaLegal = 0.19F;
        float ivaProducto;
        float valorConIva;
        int PrecioUnitario, cantidad, valor, Todo, ID;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public float getIvaLegal() {
            return ivaLegal;
        }

        public void setIvaLegal(float ivaLegal) {
            this.ivaLegal = ivaLegal;
        }

        public float getIvaProducto() {
            return ivaProducto;
        }

        public void setIvaProducto(float ivaProducto) {
            this.ivaProducto = ivaProducto;
        }

        public float getValorConIva() {
            return valorConIva;
        }

        public void setValorConIva(float valorConIva) {
            this.valorConIva = valorConIva;
        }

        public Producto() {
            cab = null;
        }

        public float getIva() {
            return ivaLegal;
        }

        public int getValor() {
            return valor;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public int getPrecioUnitario() {
            return PrecioUnitario;
        }

        public void setPrecioUnitario(int PrecioUnitario) {
            this.PrecioUnitario = PrecioUnitario;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public void Calcularvalortotal() {

            valor = PrecioUnitario * cantidad;
        }

        public void CalcularValorconiva() {
            this.ivaProducto = (this.getValor() * this.getIvaLegal());
            float t = this.getValor() + this.getIvaProducto();
            this.setValorConIva(t);
        }

        public void calcularTodo() {
            System.out.println("Total unitario");
            Todo = valor + valor;
        }

        public int getTodo() {
            return Todo;
        }

    }
}
