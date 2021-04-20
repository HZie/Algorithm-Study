// DFS
// 원래 코드 출처: https://devham76.github.io/algorithm/Permutation-post/

import java.util.*;

public class Permutation{
    public void main(){
        int[] arr = {1,2,3};
        int[] output = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        perm(arr, output, visited, 0, arr.length, 3);
    }

    // 순서를 지키면서 n개 중 r개를 뽑는 경우
    void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r){

        // exit code
        // (깊이는 뽑은 개수) 뽑은 개수가 뽑을 개수와 같다면 종료
        if(depth == r){
            // 배열 출력
            for(int i = 0; i < r; i++){
                System.out.println(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        // 1. 모든 원소를 순회한다
        for(int i = 0; i < n; i++){
            // 2. 방문하지 않은 원소를 찾는다
            if(visited[i] == false){
                visited[i] = true;  // 방문 표시
                output[depth] = arr[i]; // 결과값 배열의 해당 깊이 자리에 방문하지 않는 원소를 삽입

                // 삽입 후 한단계 깊은 노드로 이동하여 output에 값 추가
                perm(arr, output, visited, depth+1, n, r); 
                // 한단계 깊은 노드 삽입이 끝나고 부모 노드로 왔을 때 arr[]의 다음 원소를 해당 자리에 넣을 수 있음
                visited[i] = false;
            }
        }
    }
}