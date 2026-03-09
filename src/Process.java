public class Process {
    private int processID;
    private int arrivalTime;
    private int burstTime;

    //constructor for a process
    public Process(int processID, int arrivalTime, int burstTime) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getProcessID() {
        return processID;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime() {
        this.burstTime = burstTime;
    }

    @Override
    public String toString() {
        return "Process: " + processID + " Arrival Time: " + arrivalTime + " Burst Time: " + burstTime;
    }
}
