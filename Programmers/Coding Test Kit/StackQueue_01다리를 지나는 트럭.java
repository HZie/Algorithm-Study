import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++)
            bridge.add(0);
        
        int currTruck = 0;
        
        while(bridge.peek() != null){
            answer++;
            currWeight -= bridge.poll();

            int truck = 0;
            if(currTruck < truck_weights.length){
                truck = truck_weights[currTruck];
            }
            else{
                continue;
            }
                        
            if(currWeight + truck <= weight){
                currWeight += truck;
                currTruck++;
                bridge.add(truck);
            }
            else
                bridge.add(0);
        }
        
        return answer;
    }
}