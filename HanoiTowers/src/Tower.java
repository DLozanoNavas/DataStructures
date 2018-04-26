
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author dlozanonavas
 */
public class Tower extends JPanel implements MouseListener, MouseMotionListener {

    ImagePanel imagePanel = new ImagePanel();
    int moveCount = 0;
    int numberOfpeg;
    Stack<Rectangle2D.Double> stack[] = new Stack[3];
    //LinkedListBasedStack s1= new LinkedListBasedStack();
      //  LinkedListBasedStack s2 = new LinkedListBasedStack();
        //LinkedListBasedStack s3 = new LinkedListBasedStack();
    int disk[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    Stack<Color> colorOfDisk[] = new Stack[3];
    Rectangle2D.Double top = null;
    Color topColor = null;
    double ax, ay, height, width;
    boolean dragable = false;
    boolean begin = false;

    JLabel bestMove, move, noOfPeg;
    JLabel bestMovetxt, moveTxt, noOfPegTxt;

    JButton back = new JButton(imagePanel.imageBack);
    JButton restart = new JButton(imagePanel.imageRestart);
    JButton exit = new JButton(imagePanel.imageexit);
    JLabel levno = new JLabel();
    JPanel Separator1 = new JPanel();
    JPanel Separator2 = new JPanel();
    JPanel Separator3 = new JPanel();
    JPanel Separator4 = new JPanel();

    JLabel T1 = new JLabel("T 1");
    JLabel T2 = new JLabel("T 2");
    JLabel T3 = new JLabel("T 3");

    public Tower(int l) {
        this.setLayout(null);
        bestMove = new JLabel("Movimientos minimos");
        move = new JLabel("Movimientos realizados");
        noOfPeg = new JLabel("Numero de discos");

        noOfPegTxt = new JLabel("0");
        bestMovetxt = new JLabel("0");
        moveTxt = new JLabel("0");

        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        noOfPeg.setFont(labelFont);
        move.setFont(labelFont);
        bestMove.setFont(labelFont);

        Font resultFont = new Font("Arial", Font.BOLD, 30);
        noOfPegTxt.setFont(resultFont);
        moveTxt.setFont(resultFont);
        bestMovetxt.setFont(resultFont);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(30, 120, 250, 120);
        noOfPeg.setBounds(50, 10, 150, 40);
        noOfPegTxt.setBounds(110, 60, 150, 40);
        panel1.add(noOfPeg);
        panel1.add(noOfPegTxt);
        this.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(325, 120, 250, 120);
        bestMove.setBounds(70, 10, 150, 40);
        bestMovetxt.setBounds(110, 60, 150, 40);
        panel2.add(bestMovetxt);
        panel2.add(bestMove);
        this.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(620, 120, 250, 120);
        move.setBounds(70, 10, 150, 40);
        moveTxt.setBounds(110, 60, 150, 40);
        panel3.add(move);
        panel3.add(moveTxt);
        this.add(panel3);
        restart.setBounds(606, 40, 65, 45);
        restart.setBorder(null);
        this.add(restart);
        exit.setBounds(807, 40, 65, 45);
        exit.setBorder(null);
        this.add(exit);
        Font labelNo = new Font("Arial", Font.PLAIN, 25);
        levno.setForeground(Color.white);

        levno.setBounds(110, 12, 30, 20);
        levno.setFont(labelFont);

        Separator1.setBounds(0, 573, 20, 17);
        this.add(Separator1);
        Separator1.setBackground(Color.GRAY);
        Separator1.setBorder(null);
        Separator2.setBounds(279, 573, 39, 17);
        this.add(Separator2);
        Separator2.setBackground(Color.GRAY);
        Separator2.setBorder(null);
        Separator3.setBounds(577, 573, 39, 17);
        this.add(Separator3);
        Separator3.setBackground(Color.GRAY);
        Separator3.setBorder(null);
        Separator4.setBounds(874, 573, 20, 17);
        this.add(Separator4);
        Separator4.setBackground(Color.GRAY);
        Separator4.setBorder(null);

        Font pole = new Font("Arial", Font.BOLD, 30);
        T1.setForeground(Color.white);
        T1.setBounds(105, 600, 100, 30);
        T1.setFont(pole);
        this.add(T1);
        T2.setForeground(Color.white);
        T2.setBounds(405, 600, 100, 30);
        T2.setFont(pole);
        this.add(T2);
        T3.setForeground(Color.white);
        T3.setBounds(705, 600, 100, 30);
        T3.setFont(pole);
        this.add(T3);

        begin = true;
        System.out.println("inside Tower: " + l);
        init(l);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        addTowerActionListener();
    }

    public void addTowerActionListener() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameHold.sevisiblex();
                init(1);
                moveCount = 0;
                String str = Integer.toString(moveCount);
                moveTxt.setText(str);
            }
        });

        restart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                init(Integer.parseInt(levno.getText()));
                moveCount = 0;
                String str = Integer.toString(moveCount);
                moveTxt.setText(str);
            }
        });

    }

    public class ImagePanel extends JPanel {

        private ImageIcon imageIcon = new ImageIcon("images/untitle.jpg");
        private ImageIcon imageBack = new ImageIcon("images/backgame.jpg");
        private ImageIcon imageRestart = new ImageIcon("images/restart.jpg");
        private ImageIcon imageexit = new ImageIcon("images/exitgame.jpg");
        private Image image = imageIcon.getImage();

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void init(int level) {
        
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
        stack[2] = new Stack<>();
        colorOfDisk[0] = new Stack<>();
        colorOfDisk[1] = new Stack<>();
        colorOfDisk[2] = new Stack<>();
        moveCount = 0;
        int numberOfDisks = disk[level - 1];
        levno.setText(Integer.toString(level));
        Color pegColor[] = {Color.black, Color.red, Color.yellow, Color.cyan, Color.blue, Color.green, Color.orange, Color.pink, Color.MAGENTA, Color.lightGray};

        for (int i = 0; i < numberOfDisks; i++) {
            Rectangle2D.Double rect = new Rectangle2D.Double();
            double x = getWidth() / 6;
            if (x == 0) {
                x = 150;
            }
            double wr = numberOfDisks * 25 - 20 * i;
            rect.setFrame(x - wr / 2, 553 - i * 20, wr, 20);
            stack[0].push(rect);
            //s1.peek();
            colorOfDisk[0].push(pegColor[i]);
            //s1.push(pegColor[i]);
        }

        top = null;
        topColor = null;
        ax = 0.0;
        ay = 0.0;
        height = 0.0;
        width = 0.0;
        dragable = false;
        repaint();

        String str = Integer.toString(numberOfDisks);
        noOfPegTxt.setText(str);

        int best = (int) (Math.pow(2, numberOfDisks) - 1);
        str = Integer.toString(best);
        bestMovetxt.setText(str);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g1 = (Graphics2D) g;
        g1.setColor(Color.GRAY);
        g1.fillRect(0, 0, getWidth(), getHeight());

        int baseX = getWidth() / 6;
        int baseY1 = getHeight() - 10 * 40;
        int baseY2 = getHeight() - 90;

        g1.setColor(Color.WHITE);
        g1.setStroke(new BasicStroke(15));

        g1.drawLine(baseX, baseY1, baseX, baseY2);
        g1.drawLine(3 * baseX, baseY1, 3 * baseX, baseY2);
        g1.drawLine(5 * baseX, baseY1, 5 * baseX, baseY2);

        g1.drawLine(0, baseY2, getWidth(), baseY2);
        g1.setStroke(new BasicStroke(1));
        g1.setColor(topColor);

        if (dragable == true && top != null) {
            g1.fill(top);
        }

        drawTower(g1, 0);
        drawTower(g1, 1);
        drawTower(g1, 2);
    }

    private void drawTower(Graphics2D g, int n) {
        if (stack[n].empty() == false) {
            for (int i = 0; i < stack[n].size(); i++) {
                g.setColor(colorOfDisk[n].get(i));
                g.fill(stack[n].get(i));
            }
        }
    }

    private int currentTower(Point p) {
        Rectangle2D.Double rA = new Rectangle2D.Double();
        Rectangle2D.Double rB = new Rectangle2D.Double();
        Rectangle2D.Double rC = new Rectangle2D.Double();

        rA.setFrame(0, 0, getWidth() / 3, getHeight());
        rB.setFrame(getWidth() / 3, 0, getWidth() / 3, getHeight());
        rC.setFrame(2 * getWidth() / 3, 0, getWidth() / 3, getHeight());

        if (rA.contains(p)) {
            return 0;
        } else if (rB.contains(p)) {
            return 1;
        } else if (rC.contains(p)) {
            return 2;
        } else {
            return -1;
        }
    }

    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        int n = currentTower(p);
        if (!stack[n].empty()) {
            //s1.push(top);
            top = stack[n].peek();
            if (top.contains(p)) {
                top = stack[n].pop();
                //s2.pop();
                topColor = colorOfDisk[n].pop();
                ax = top.getX();
                ay = top.getY();
                width = p.getX() - ax;
                dragable = true;
            } else {
                top = null;
                topColor = Color.BLACK;
                dragable = false;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent ev) {
        int cx = ev.getX();
        int cy = ev.getY();
        if (top != null && dragable == true) {
            top.setFrame(cx - width, cy - height, top.getWidth(), top.getHeight());
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent ev) {

    }

    @Override
    public void mouseClicked(MouseEvent ev) {

    }

    @Override
    public void mouseEntered(MouseEvent ev) {

    }

    @Override
    public void mouseExited(MouseEvent ev) {

    }

    @Override
    public void mouseReleased(MouseEvent ev) {
        if (top != null && dragable == true) {
            int tower = currentTower(ev.getPoint());
            double x, y;
            if (!stack[tower].empty()) {
                if (stack[tower].peek().getWidth() > top.getWidth()) {
                    y = stack[tower].peek().getY() - 20;
                    moveCount++;
                    String str = Integer.toString(moveCount);
                    moveTxt.setText(str);
                } else {
                    JOptionPane.showMessageDialog(this, "Movimiento incorrecto", "Torre de Hanoi", JOptionPane.ERROR_MESSAGE);
                    tower = currentTower(new Point((int) ax, (int) ay));
                    if (!stack[tower].empty()) {
                        y = stack[tower].peek().getY() - 20;
                    } else {
                        y = getHeight() - 118;
                    }
                }
            } else {
                y = getHeight() - 118;
                moveCount++;
                String str = Integer.toString(moveCount);
                moveTxt.setText(str);
            }
            x = (int) (getWidth() / 6 + (getWidth() / 3) * tower - top.getWidth() / 2);
            top.setFrame(x, y, top.getWidth(), top.getHeight());
            stack[tower].push(top);
            colorOfDisk[tower].push(topColor);
            top = null;
            topColor = Color.black;
            dragable = false;
            repaint();
        }

        if (stack[0].empty() && stack[1].empty()) {
            int best = Integer.parseInt(bestMovetxt.getText());
            int playerMove = Integer.parseInt(moveTxt.getText());
            System.out.println("Mejor: " + best);
            System.out.println("Movimiento del jugador: " + playerMove);
            if (best == playerMove) {
                int l = Integer.parseInt(levno.getText());
                String msg = "Has completado este nivel\nSiguiente nivel: " + (l + 1);
                JOptionPane.showMessageDialog(this, msg, "Torre de Hanoi", JOptionPane.INFORMATION_MESSAGE);

                l++;
                levno.setText(Integer.toString(l));
                init(l);
                moveTxt.setText("0");
            } else {
                int extra = playerMove - best;
                String msg = "Game Over. Te tomó " + extra + " movimientos extra.";
                JOptionPane.showMessageDialog(this, msg, "Torre de Hanoi", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Intenta de nuevo", "Torre de Hanoi", JOptionPane.INFORMATION_MESSAGE);
                init(Integer.parseInt(levno.getText()));
                moveCount = 0;
                String str = Integer.toString(moveCount);
                moveTxt.setText(str);
            }
        }

        if (Integer.parseInt(levno.getText()) >= 10) {
            JOptionPane.showMessageDialog(this, "Has completado el nivel en el mínimo número de pasos.", "Torre de Hanoi", JOptionPane.INFORMATION_MESSAGE);
            init(1);
            moveCount = 0;
            String str = Integer.toString(moveCount);
            moveTxt.setText(str);
        }
    }
}
