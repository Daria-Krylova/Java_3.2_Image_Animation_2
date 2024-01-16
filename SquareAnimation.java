import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SquareAnimation extends JPanel implements ActionListener {

    private static final int WIDTH = 800;   // Ширина окна
    private static final int HEIGHT = 600;  // Высота окна
    private static final int SQUARE_SIZE =  250; // Размер квадрата
    private static final int DURATION = 2000; // Продолжительность движения (в миллисекундах)

    private BufferedImage image;
    private int x, y;
    private Timer timer;

    public SquareAnimation() {
        try {
            // Загрузка изображения
            image = ImageIO.read(new File("Praying_racoon.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Начальные координаты изображения
        x = 0;
        y = 0;

        // Создание таймера
        timer = new Timer(DURATION, this);
        timer.setInitialDelay(0);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Отображение изображения
        g.drawImage(image, x, y, SQUARE_SIZE, SQUARE_SIZE, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Обработка действия таймера (движение квадрата)
        x += SQUARE_SIZE;
        if (x >= WIDTH) {
            x = 0;
            y += SQUARE_SIZE;
            if (y >= HEIGHT) {
                y = 0;
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Анимация: Енотик молится перед экзаменом..");
        SquareAnimation squareAnimation = new SquareAnimation();
        frame.add(squareAnimation);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
