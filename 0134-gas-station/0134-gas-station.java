class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int tank = 0;
        int start = 0;
        int totalgas =0;
        int totalcost = 0;

        for(int i = 0 ; i < gas.length ; i++){

            totalgas += gas[i];

            totalcost += cost[i];
             
            tank += gas[i] - cost[i];


              if(tank < 0){
            start = i + 1;
            tank = 0;
         }
        }

        // hum chahte hum vha se strt jhn running tank mein utni postive accumulated gas honi chiye to complete the circuit

        // if(tank < 0){
        //     start = i + 1;
        //     tank = 0;
        // }

        // now we have starting point but circuit tbhi complete eaxctly one tym visit kr skta agr uske pass enough gas ho agr enough gas he nhi ahi to vo circuit ko kbhi complete nhi kr pyga 

        if(totalgas < totalcost){
            // hum kbhi janhi skte
            return -1;

        }

        return start;
        


    }
}

// this ques simply states that ki hr ek gas station pr itni gas available to move next station how much gas we spend that represents cost[i]

// remaining we have that amount of gas gas[i] - how much we spend to reach the next station cost[i]  = gas[i] - cost[i]
// remains in the tank 
// starting point +ve hona chiye yh rule nhi ahi it simple Starting from that station, the accumulated gas must never become negative before completing the circuit.