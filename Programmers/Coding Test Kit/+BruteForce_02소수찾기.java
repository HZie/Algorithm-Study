import java.util.*;

class Solution {
    public int solution(String numbers) {
        int[] nums = new int[numbers.length()];
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = numbers.charAt(i) - '0';
        }
        
        int answer = composeNum(nums);
      
        return answer;
    }
    
    // 여기 famous_algorithm/permutation.java 참고해서 작성하기 - 210419/16:25
    public int composeNum(int[] nums){
        boolean[] visited = new boolean[nums.length];
        ArrayList<Integer> composed = new ArrayList<>();

        for(int i = 1; i <= nums.length; i++){
            composeNum(nums, 0, visited, 0, nums.length, i, composed);
        }

        return composed.size();
    }
    

    // 여기서 isPrime 사용하여 애초에 Prime Number만 리스트에 넣기
    public void composeNum(int[] nums, int created, boolean[] visited, int depth, int n, int r, ArrayList<Integer> list){
        if(depth == r){
            if(isPrime(created) && !list.contains(created)){
                list.add(created);
            }
            return;
        }

        // 1. 모든 원소를 순회한다
        for(int i = 0; i < n; i++){
            // 2. 방문하지 않은 원소를 찾는다
            if(visited[i] == false){
                visited[i] = true;  // 방문 표시
                created *= 10;
                created += nums[i];

                // 삽입 후 한단계 깊은 노드로 이동하여 output에 값 추가
                composeNum(nums, created, visited, depth+1, n, r, list); 
                // 한단계 깊은 노드 삽입이 끝나고 부모 노드로 왔을 때 arr[]의 다음 원소를 해당 자리에 넣을 수 있음
                visited[i] = false;
                created -= nums[i];
                created /= 10;
            }
        }

    }
    
    public boolean isPrime(int num){
        //System.out.println("num at isPrime: "+num);
        if(num == 2)
            return true;
        if(num == 1 || num % 2 == 0)
            return false;
            
        int divider = 3;
        while( divider <= (int)Math.sqrt(num)){
            
            if(num%divider == 0)
                return false;
            
                divider += 2;
        }

        return true;
    }
    
}