public static void plusMinus(List<Integer> arr) {
    // Write your code here
        int[] count = new int[3];   // 0: plus, 1: minus, 2: zero
        
        for(int i = 0; i < arr.size(); i++){
            int num = arr.get(i);
            if(num > 0)
                count[0]++;
            else if(num < 0)
                count[1]++;
            else
                count[2]++;
        }
        
        for(int i = 0; i < count.length; i++){
            System.out.printf("%.6f\n", (double)count[i]/arr.size());
        }
    }

