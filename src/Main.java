import javax.swing.*;
import java.awt.*;

void main() {
    JFrame frame = new JFrame("FCFS Simulator");
    frame.setSize(800,800);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    JOptionPane.showMessageDialog(frame,
            "the FCFS (First-Come-First-Serve) Scheduling Simulation! \n\n" +
            "Press OK to Start",
            "Welcome to",
            JOptionPane.INFORMATION_MESSAGE);

    int numberOfProcesses = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of processes: "));
    for (int i = 0; i < numberOfProcesses; i++) {
        Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter arrival time for process " + (i + 1)));
        Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter burst time for process " + (i + 1)));
    }



}

