
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dlozanonavas
 */

public final class MenuFrame extends JFrame {

    ImagePanel panel = new ImagePanel();
    JButton newGame = new JButton(panel.imageNewGame);
    JButton back = new JButton(panel.imageBack);

    public MenuFrame() {
        init();
        addMenuFrameActionListener();
    }

    public void init() {
        newGame.setBounds(300, 250, 200, 45);
        newGame.setBorder(null);
        back.setBounds(300, 300, 200, 45);
        back.setBorder(null);

        this.add(newGame);
        this.add(back);
        this.add(panel);
    }

    public void addMenuFrameActionListener() {


        newGame.addActionListener(new newGameAction());
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });



        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public class ImagePanel extends JPanel {

        private ImageIcon imageNewGame = new ImageIcon("images/newgame.jpg");
        private ImageIcon imageBack = new ImageIcon("images/back.jpg");

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }
}

class newGameAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GameHold mDraw = new GameHold("Tower Of Hanoi", 1);
    }
}
