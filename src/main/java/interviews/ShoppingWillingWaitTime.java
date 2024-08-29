package interviews;


import java.util.PriorityQueue;

// N counters
// M persons
// [0, ,1,2,3] arrival time of each person
// return minimum time each person need to wait
public class ShoppingWillingWaitTime {
    public int[] waitTime(int counter, int persons, int[] arrivalTimes) {

        PersonForCounter[] personArray = new PersonForCounter[persons];

        for(int i=0; i<arrivalTimes.length; i++) {
            personArray[i] = new PersonForCounter(arrivalTimes[i], 0);
        }

        PriorityQueue<Integer> counters = new PriorityQueue<>();

        for(int i =0; i<counter; i++) {
            counters.offer(0);
        }

        int[] waitTimes = new int[persons];

        for(int i=0; i<personArray.length; i++) {

            PersonForCounter person = personArray[i];
            int arrivalTime = person.getArrivalTime();

            int earliestPossibleAvailableTime = counters.poll();

            int waitTime = Math.max(1, earliestPossibleAvailableTime - arrivalTime);

            person.setWaitTime(waitTime);
            waitTimes[i] = waitTime;

            counters.offer(arrivalTime + waitTime + 1);
        }

        return waitTimes;
    }
}

class PersonForCounter {
    int arrivalTime;
    int waitTime;

    public PersonForCounter(int arrivalTime, int waitTime) {
        this.arrivalTime = arrivalTime;
        this.waitTime = waitTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}
