import java.awt.*;
import javax.swing.*;

public class SortingVisualizer extends JPanel {
    private int[] array = {50, 30, 70, 10, 90, 20, 60, 80, 40};
    private int currentIndex = -1; 

    public void bubbleSort() {
        new Thread(() -> {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    currentIndex = j;
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                    repaint();
                    sleep(400); 
                }
            }
            currentIndex = -1;  
            repaint();
        }).start();
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / array.length;
        for (int i = 0; i < array.length; i++) {
            if (i == currentIndex || i == currentIndex + 1) {
                g.setColor(Color.RED);  
            } else {
                g.setColor(Color.BLUE);
            }
            g.fillRect(i * width + 10, getHeight() - array[i], width - 20, array[i]);
            g.setColor(Color.BLACK);
            g.drawRect(i * width + 10, getHeight() - array[i], width - 20, array[i]);  
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        SortingVisualizer panel = new SortingVisualizer();
        frame.add(panel);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.bubbleSort();  
    }
}
