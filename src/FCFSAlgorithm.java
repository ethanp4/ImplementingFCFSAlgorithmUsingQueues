import javax.swing.*;

public class FCFSAlgorithm {
    private QueueImplementation<Process> queue;

    public FCFSAlgorithm(QueueImplementation<Process> queue) {
        this.queue = queue;
    }

    public void run() {
        int currentTime = 0;          // Tracks the current time in the CPU timeline
        int totalWaitingTime = 0;     // Accumulates waiting time across all processes
        int totalTurnAroundTime = 0;  // Accumulates turnaround time across all processes
        int processCount = 0;         // Counts how many processes were executed

        StringBuilder results = new StringBuilder();

        // Process each item in the queue in FCFS order (first in, first out)
        while (!queue.isEmpty()) {
            Process current = queue.dequeue(); // get the next process

            // If the CPU is idle before this process arrives, fast-forward time to its arrival
            if (currentTime < current.getArrivalTime()) {
                currentTime = current.getArrivalTime();
            }

            // Waiting time = time the process waited before the CPU started executing it
            int waitingTime = currentTime - current.getArrivalTime();

            // Turnaround time = total time from arrival to completion (waiting + execution)
            int turnaroundTime = waitingTime + current.getBurstTime();

            // Advance the clock by this process's burst time (how long it runs)
            currentTime += current.getBurstTime();

            // Append this process's stats to the results summary
            results.append("Process P").append(current.getProcessID())
                    .append("  |  Arrival Time ► ").append(current.getArrivalTime())
                    .append("  |  Waiting Time ► ").append(waitingTime)
                    .append("  |  Turnaround Time ► ").append(turnaroundTime)
                    .append("\n");

            totalWaitingTime += waitingTime;
            totalTurnAroundTime += turnaroundTime;
            processCount++;
        }

        // Show results per process
        JOptionPane.showMessageDialog(null, results.toString(), "Results", JOptionPane.INFORMATION_MESSAGE);

        // Calculate averages across all processes
        double averageWaitingTime = (double) totalWaitingTime / processCount;
        double averageTurnaroundTime = (double) totalTurnAroundTime / processCount;

        String averageResults = "Average Waiting Time ► " + averageWaitingTime + "\n"
                + "Average Turnaround Time ► " + averageTurnaroundTime;

        // Show the averages in a new dialog
        JOptionPane.showMessageDialog(null, averageResults, "Averages", JOptionPane.INFORMATION_MESSAGE);
    }
}