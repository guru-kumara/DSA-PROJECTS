
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class StackQueueVisualizer extends JFrame {
    private Stack<Integer> stack = new Stack<>();
    private Queue<Integer> queue = new LinkedList<>();
    private JTextArea displayArea = new JTextArea(10, 30);

    public StackQueueVisualizer() {
        setTitle("Stack and Queue Visualizer");
        setLayout(new FlowLayout());

        JButton pushButton = new JButton("Push to Stack");
        JButton popButton = new JButton("Pop from Stack");
        JButton enqueueButton = new JButton("Enqueue to Queue");
        JButton dequeueButton = new JButton("Dequeue from Queue");

        pushButton.addActionListener(e -> {
            stack.push(new Random().nextInt(100));
            display();
        });

        popButton.addActionListener(e -> {
            if (!stack.isEmpty()) stack.pop();
            display();
        });

        enqueueButton.addActionListener(e -> {
            queue.add(new Random().nextInt(100));
            display();
        });

        dequeueButton.addActionListener(e -> {
            if (!queue.isEmpty()) queue.poll();
            display();
        });

        add(pushButton);
        add(popButton);
        add(enqueueButton);
        add(dequeueButton);
        add(new JScrollPane(displayArea));

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void display() {
        displayArea.setText("Stack: " + stack + "\nQueue: " + queue);
    }

    public static void main(String[] args) {
        new StackQueueVisualizer();
    }
}
