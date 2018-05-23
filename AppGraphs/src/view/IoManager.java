package view;

import javax.swing.JOptionPane;

public class IoManager {
    
  
    public String readString(String message){
        return (JOptionPane.showInputDialog(null, message));
    }
    
    public int readInt(String message){
        int valueInt;
        String value = JOptionPane.showInputDialog(null, message);
        valueInt = Integer.parseInt(value);
        return valueInt;
        
    }
    
    public int readMenu(){
        String menuText = "1. Adicionar vertice principal\n"
                + "2. Adicionar vertice adyacente\n"
                + "3. Imprimir grafo\n"
                + "4. Salir\n";
        return readInt(menuText);
    }
    public double readDouble(String message){
        double valueDouble; 
        String value = JOptionPane.showInputDialog(null, message);
        valueDouble = Double.parseDouble(value);
        return valueDouble;
    }
    
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public String readPositionToInsert(){
        Object position = JOptionPane.showInputDialog(null,"Posicion para insertar hijo",
        "POSICION", JOptionPane.QUESTION_MESSAGE, null,
        new Object[] {"Izquierda","Derecha"},"Izquierda");
        return position.toString();
    }
}
