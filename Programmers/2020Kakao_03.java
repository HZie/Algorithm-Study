class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int k_len = key.length;
        int l_len = lock.length;
        int k_count = 0, l_count = 0;
        for(int i = 0; i < k_len; i++){
            for(int j = 0; j < k_len; j++){
                if(key[i][j] == 1)
                    k_count++;
            }
        }
        
        for(int i = 0; i < l_len; i++){
            for(int j = 0; j <l_len; j++){
                if(lock[i][j] == 0)
                    l_count++;
            }
        }
        
        if(l_count == 0)
            return true;
        if(l_count > k_count)
            return false;
        
        // lock에 패딩을 붙임
        int[][] p_lock = addPadding(lock, l_len, k_len);
        
        // key를 rotate함
        for(int i = 0; i < 4; i++){
            // key를 위아래로 움직임
            for(int s_i = 0; s_i <= p_lock.length - k_len; s_i++){
                for(int s_j = 0; s_j <= p_lock.length - k_len; s_j++){
                    // 만약 맞으면 true를 반환
                    if(isMatch(p_lock, key, s_i, s_j, k_len, l_len))
                        return true;
                }
            }
            key = rotateKey(key, k_len);
        }
        
        return false;
    }
    
    public boolean isMatch(int[][] p_lock, int[][] key, int s_i, int s_j, int k_len, int l_len){
        int [][] a_lock = new int[p_lock.length][p_lock.length];
        for(int i = 0; i < p_lock.length; i++) {
        	for(int j = 0; j < p_lock.length; j++) {
        		a_lock[i][j] = p_lock[i][j];
        	}
        }
        
        for(int i = s_i; i < s_i+k_len; i++){
            for(int j = s_j; j < s_j+k_len; j++){
                a_lock[i][j] = p_lock[i][j] + key[i - s_i][j - s_j];
            }
        }
        
        for(int i = k_len -1 ; i < k_len-1 + l_len; i++){
            for(int j = k_len - 1; j < k_len-1 + l_len; j++){
                if(a_lock[i][j] == 2 || a_lock[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    
    public int[][] addPadding(int[][] lock, int l_len, int k_len){
        int[][] p_lock = new int[l_len + (k_len-1)*2][l_len + (k_len-1)*2];
        
        for(int i = k_len - 1; i < k_len - 1 + l_len; i++){
            for(int j = k_len - 1; j < k_len - 1 + l_len; j++){
                p_lock[i][j] = lock[i - k_len + 1][j - k_len + 1];
            }
        }
        return p_lock;
    }

    public int[][] rotateKey(int[][] key, int k_len){
        int[][] newKey = new int[k_len][k_len];
        
        for(int i = 0; i < k_len; i++){
            for(int j = 0; j < k_len; j++){
                newKey[i][j] = key[k_len-1 - j][i];
            }
        }
        return newKey;
    }
    
}

