import javax.swing.*;

public class FCFSAlgorithm {
    private QueueImplementation<Process> queue;

    public FCFSAlgorithm(QueueImplementation<Process> queue) {
        this.queue = queue;
    }

    public void run() {
        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        StringBuilder results = new StringBuilder();
        while(!queue.isEmpty()) {
            Process current = queue.dequeue();

            if (currentTime < current.getArrivalTime()) {
                currentTime = current.getArrivalTime();
            }

            int waitingTime = currentTime - current.getArrivalTime();
            int turnaroundTime = waitingTime + current.getBurstTime();

            currentTime += current.getBurstTime();

            results.append("Process P").append(current.getProcessID())
                    .append("<<...>> Arrival Time ► ").append(current.getArrivalTime())
                    .append("<<...>> Waiting Time ► ").append(waitingTime)
                    .append("<<...>> Turnaround Time ► ").append(turnaroundTime)
                    .append("\n");

            totalWaitingTime += waitingTime;
            totalTurnAroundTime += turnaroundTime;
            processCount++;
        }

        JOptionPane.showMessageDialog(null, results.toString(), "Results", JOptionPane.INFORMATION_MESSAGE);

        double averageWaitingTime = (double) totalWaitingTime /processCount;
        double averageTurnaroundTime = (double) totalTurnAroundTime/processCount;

        String averageResults = "Average Waiting Time ► " + averageWaitingTime + "\n" + "Average Turnaround Time ► " + averageTurnaroundTime;

        JOptionPane.showMessageDialog(null, averageResults, "Averages", JOptionPane.INFORMATION_MESSAGE);


    }
}
