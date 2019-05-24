package leetcode;

public class S_134_GasStation {
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
        	int j = i+1, gascount = gas[i] - cost[i];
        	while(j < i+gas.length){
        		if(gascount<0)
        			break;
        		gascount += gas[j%gas.length] - cost[j%gas.length];
        	}
        	if(j == i + gas.length && gascount >= 0)
        		return i;
        }
        return -1;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr_tank = 0, total_tank = 0, ret = 0;
    	for(int i = 0; i < gas.length; i++){
    		total_tank += gas[i] - cost[i];
        	curr_tank += gas[i] - cost[i];
        	if(curr_tank < 0){
        		ret = i+1;
        		curr_tank = 0;
        	}
    	}      
        return total_tank>=0 ? ret:-1;
    }
}
