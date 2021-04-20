class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] status = new int[n];
        
        for(int s: lost){
            status[s-1]--;
        }
        for(int s: reserve){
            status[s-1]++;
        }
        
        for(int i = 0; i < status.length; i++){
            if(status[i] < 0){
                if(i == 0){
                    if(status[i+1] > 0){
                        status[i]++;
                        status[i+1]--;
                    }
                }
                else if(i == status.length-1){
                    if(status[i-1] > 0){
                        status[i]++;
                        status[i-1]--;
                    }
                }
                else{
                    if(status[i-1] > 0){
                        status[i]++;
                        status[i-1]--;
                    }
                    else if(status[i+1] > 0){
                        status[i]++;
                        status[i+1]--;
                    }
                }
            }
        }
        
        for(int s: status){
            if(s >= 0)
                answer++;
        }
        
        return answer;
    }
}

/*
// 다른 사람 풀이
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
}
*/