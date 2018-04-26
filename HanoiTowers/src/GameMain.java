import javax.swing.JFrame;

/**
 *
 * @author dlozanonavas
 */

public class GameMain {

    
    public static void main(String[] args) {
        JFrame frame = new FirstPage();
        frame.setTitle("Tower Of Hanoi");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
