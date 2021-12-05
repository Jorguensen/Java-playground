import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyPanel<martian> extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    private Image martian;
    private Image resizeMartian;
    private Image backgroundImage;
    private Image resizeBackground;
    private Timer timer;
    private int xVelocity = 1;
    private int yVelocity = 2;
    private int x = 0;
    private int y = 0;



    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        martian = new ImageIcon("martian.png").getImage();
        resizeMartian = martian.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        backgroundImage = new ImageIcon("spacebackground.png").getImage();
        resizeBackground = backgroundImage.getScaledInstance(500,500, Image.SCALE_SMOOTH);

        timer = new Timer(10, this::actionPerformed);
        timer.start();


    }

    public void paint (Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D= (Graphics2D) g;
        g2D.drawImage(resizeBackground, 0, 0, null);
        g2D.drawImage(resizeMartian, x, y, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (x >= PANEL_WIDTH - resizeMartian.getWidth(null) || x < 0) {
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;

        if (y >= PANEL_HEIGHT - resizeMartian.getHeight(null) || y < 0)
            yVelocity = yVelocity * -1;
        y = y + yVelocity;

        repaint();
    }




    }

