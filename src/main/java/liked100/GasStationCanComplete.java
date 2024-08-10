package liked100;

import java.util.ArrayList;

public class GasStationCanComplete {



    public int canCompleteCircuit(int[] gas, int[] cost) {
        // total gas should be greater than total cost

        int totalGasForAllStation = 0;

        int totalGasStartingFromParticularStation = 0;

        int startStation = 0;
        for(int i =0; i<gas.length; i++) {
            totalGasForAllStation = totalGasForAllStation + gas[i] - cost[i];
            totalGasStartingFromParticularStation = totalGasStartingFromParticularStation + gas[i] -cost[i];
            // if it become negative means be can not go to next station, so better start from this station
            if(totalGasStartingFromParticularStation <0) {
                startStation = i+1;
                totalGasStartingFromParticularStation = 0;
            }
        }

        return totalGasForAllStation < 0? -1: startStation;

    }
    // greedy, giving time limit exceed
    public int canCompleteCircuitMy(int[] gas, int[] cost) {
        ArrayList<Integer> possibleStartingStation = new ArrayList();

        for(int i =0 ; i<gas.length; i++) {
            if(gas[i] >= cost[i]) {
                possibleStartingStation.add(i);
            }
        }


        for(Integer stationIndex : possibleStartingStation) {

            int tank = 0;
            int startingStationIndex = stationIndex;

            int startingFromIndex = startingStationIndex;

            tank = tank + gas[startingStationIndex];

            while(tank >= cost[startingFromIndex]) {
                int reachedNextStation;
                if (startingFromIndex == gas.length-1) {
                    reachedNextStation = 0;
                } else {
                    reachedNextStation = startingFromIndex + 1;
                }

                tank = tank - cost[startingFromIndex] + gas[reachedNextStation];

                if(reachedNextStation == startingStationIndex) {
                    return startingStationIndex;
                }

                if(tank < 0) {
                    break;
                }

                startingFromIndex = reachedNextStation;

            }


        }

        return -1;
    }
}
