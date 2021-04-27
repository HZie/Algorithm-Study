// https://leetcode.com/discuss/interview-question/421787/

// Given a hotel which has 10 floors [0-9] and each floar has 26 rooms [A-Z]
// + means booked, - means freed the room
// have to find which room is booked maximum num of times

// constraints
// - N (length of input) : [1,600]
// - each element of input array is a string consisting of three char: "+/-", "0-9", "A-Z"(upper case)
// - the sequence is correct == every booked was previously free and every freed was previously booked

// Example
// Input: ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]
// Output: "1A"
// explanation: 1A since it has been booked 2 times

class Solution{
    public String mostBookedRoom(String[] input){
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < input.length; i++){
            char status = input[i].charAt(0);
            String key = input[i].substring(1);
            if(status == '+')
                map.put(key, map.getOrDefault(key, 0)+1);
        }

        int max = -1;

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
                answer = entry.getKey();
            }
        }

        return answer;
    }
}