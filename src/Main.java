import javax.swing.*;
import java.awt.*;


public class Main {
    //used to check if the user actually inputted numbers. helper method for error handling
    static Boolean isStringInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //Prompt for non-negative integers. helper method for error handling
    static int promptForNonNegativeInt(String message, JFrame frame) {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, message);
            if (input == null) System.exit(0); //user pressed cancel
            input = input.trim();
            if (input.isEmpty() || !isStringInt(input)) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid integer.");
                continue;
            }
            int value = Integer.parseInt(input);
            if (value < 0) {
                JOptionPane.showMessageDialog(frame, "Please enter a non-negative integer.");
                continue;
            }
            return value;
        }
    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("FCFS Simulator");

        //Set main window to be invisible since we arent using it
        frame.setVisible(false);

        // Create the queue for storing the processes to be used with the FCFS algorithm
        QueueImplementation<Process> queue = new QueueImplementation<>();
        JOptionPane.showMessageDialog(frame,
                """
                        the FCFS (First-Come-First-Serve) Scheduling Simulation!\s
                        
                        Press OK to Start""",
                "Welcome to",
                JOptionPane.INFORMATION_MESSAGE);

        int noOfProc = 0, arrivalTime = 0, burstTime = 0;
        String noOfProcInput, arrivalTimeInput, burstTimeInput;
        //Gather information for processes

        // Gather the user input until it is not an empty string
        do {
            noOfProcInput = String.valueOf(promptForNonNegativeInt("Enter the number of processes: ", frame));
        } while (!isStringInt(noOfProcInput));
        noOfProc = Integer.parseInt(noOfProcInput);

        // Gather arrivalTime and burstTIme for every process
        for (int i = 0; i < noOfProc; i++) {
            do {
                arrivalTimeInput = String.valueOf(promptForNonNegativeInt("Enter arrival time for process " + (i + 1), frame));
            } while (!isStringInt(arrivalTimeInput));
            arrivalTime = Integer.parseInt(arrivalTimeInput);


            do {
                burstTimeInput = String.valueOf(promptForNonNegativeInt("Enter burst time for process " + (i + 1), frame));
            } while (!isStringInt(burstTimeInput));
            burstTime = Integer.parseInt(burstTimeInput);

            Process process = new Process(i + 1, arrivalTime, burstTime);
            queue.enqueue(process);
        }

        //RUN FCFS
        FCFSAlgorithm fcfs = new FCFSAlgorithm(queue);
        fcfs.run();
        //window hangs around so exit the program manually
        System.exit(0);
    }
}

