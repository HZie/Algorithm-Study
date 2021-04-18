// mergesort를 직접 구현해서 짰다

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // for(int i : numbers)
        //     System.out.println(i);
        
        mergesort(numbers);
        // System.out.println();
        
        for(int i : numbers)
            answer += (i+"");
        
        // 0으로 시작하는 경우: {0}*인 경우이므로
        // 0을 리턴해줌
        if(answer.startsWith("0"))
            return 0+"";
        
        
        return answer;
    }
    
    public void mergesort(int[] arr){
        int[] helper = new int[arr.length];
        mergesort(arr, helper, 0, arr.length-1);
        // System.out.println("\nmergesort(int[] arr)");
        // for(int i : arr)
        //     System.out.println(i);        
    }
    
    public void mergesort(int[] arr, int[] helper, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergesort(arr, helper, low, mid);
            mergesort(arr, helper, mid+1, high);
            merge(arr, helper, low, mid, high);
        }
    }
    
    public void merge(int[] arr, int[] helper, int low, int mid, int high){
        for(int i = low; i <= high; i++){
            helper[i] = arr[i];
        }
        
        int left = low;
        int right = mid + 1;
        int curr = low;
        
        while(left <= mid && right <= high){
            
            if(compareRule(helper[left],helper[right])){
                arr[curr] = helper[left];
                left++;
            }
            else{
                arr[curr] = helper[right];
                right++;
            }
            
            curr++;
            
        }
        
        while(left <= mid){
            arr[curr] = helper[left];
            left++;
            curr++;
        }
        
    }
    
    // 여기가 핵심
    public boolean compareRule(int a, int b){
        String str_ab = a + "" + b;
        String str_ba = b + "" + a;
        // System.out.println("\nstr_ab: "+str_ab);
        // System.out.println("str_ba: "+str_ba);
        // System.out.println("str_ab.compareTo(str_ba): "+str_ab.compareTo(str_ba));
        if(str_ab.compareTo(str_ba) >= 0){
            //System.out.println("\ncompareRule: true\n");
            return true;
        }
        //System.out.println("\ncompareRule: false\n");
        return false;
    }
    
}