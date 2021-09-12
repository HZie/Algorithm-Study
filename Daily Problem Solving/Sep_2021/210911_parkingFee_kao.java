import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> fee = new HashMap<>();
        
        for(int i = 0; i < records.length; i++){
            String stat = records[i].split(" ")[2];
            String time = records[i].split(" ")[0];
            String car = records[i].split(" ")[1];
            
            if(stat.compareTo("IN") == 0){
                map.put(car, toMin(time));
            }
            else{
                int parkedTime = toMin(time) - map.get(car);
                fee.put(car, fee.getOrDefault(car, 0)+parkedTime);
                map.remove(car);
            }
        }
        
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String car = entry.getKey();
            int parkedTime = toMin("23:59") - entry.getValue();
            fee.put(car, fee.getOrDefault(car, 0)+parkedTime);
        }
        
        Object[] mapKey = fee.keySet().toArray();
        Arrays.sort(mapKey);
        
        int[] answer = new int[mapKey.length];
        for(int i = 0; i < answer.length; i++){
            int mon = getPay(fee.get(mapKey[i]), fees[0], fees[1], fees[2], fees[3]);
            answer[i] = mon;
        }
        
        return answer;
    }
    
    public int toMin(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        
        return hour*60+min;
    }
    
    public int getPay(int parkedTime, int basicTime, int basicPrice, int plusTime, int plusPrice){
        int price = basicPrice;
        if(parkedTime > basicTime){
            parkedTime -= basicTime;
            price += plusPrice * (parkedTime / plusTime);
            if(parkedTime % plusTime != 0)
                price += plusPrice;
        }
        return price;
    }
}