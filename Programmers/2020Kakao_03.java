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
        
        // 자물쇠에 홈이 없다면 굳이 열쇠가 없어도 true가 된다.
        if(l_count == 0)
            return true;
        // 자물쇠의 홈의 갯수가 키의 돌기의 갯수보다 많다면 해결할 수 없다.
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
    
    // s_i, s_j는 p_lock에서 열쇠의 시작 위치를 나탄낸다.
    public boolean isMatch(int[][] p_lock, int[][] key, int s_i, int s_j, int k_len, int l_len){
        int [][] a_lock = new int[p_lock.length][p_lock.length];
        // 일단 a_lock에 p_lock을 옮김
        for(int i = 0; i < p_lock.length; i++) {
        	for(int j = 0; j < p_lock.length; j++) {
        		a_lock[i][j] = p_lock[i][j];
        	}        
        }
        
        for(int i = s_i; i < s_i+k_len; i++){
            for(int j = s_j; j < s_j+k_len; j++){
                // a_lock에 p_lock과 key를 더한 값을 넣음
                a_lock[i][j] = p_lock[i][j] + key[i - s_i][j - s_j];
            }
        }
        
        // 실제 자물쇠의 위치에서 2나 0이 있을 경우 자물쇠와 열쇠가 맞지 않은 것
        for(int i = k_len -1 ; i < k_len-1 + l_len; i++){
            for(int j = k_len - 1; j < k_len-1 + l_len; j++){
                if(a_lock[i][j] == 2 || a_lock[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    
    // 위 아래, 양 옆에 key_length - 1 크기의 0으로된 패딩을 붙인다.
    public int[][] addPadding(int[][] lock, int l_len, int k_len){
        int[][] p_lock = new int[l_len + (k_len-1)*2][l_len + (k_len-1)*2];
        
        // 한 가운데에는 실제 자물쇠를 위치 시킨다.
        for(int i = k_len - 1; i < k_len - 1 + l_len; i++){
            for(int j = k_len - 1; j < k_len - 1 + l_len; j++){
                p_lock[i][j] = lock[i - k_len + 1][j - k_len + 1];
            }
        }
        return p_lock;
    }

    // key를 돌린다.
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

/*
// 열쇠 자체를 옮긴다고 한다면 다음과 같이 짤 수 있지만 이는 올바른 풀이를 이끌지 못한다.
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int m = key.length;
        int[][] rKey = new int[m][m];
        int[][] mrKey = new int[m][m];
        int[][] mdKey = new int[m][m];
        
        rKey = key;
        mrKey = rKey;
        mdKey = mrKey;
        
        for(int r = 0; r < 4; r++){
            for(int d = 0; d <= m; d++){
                for(int s = 0; s <= m; s++){
                    mrKey = moveRight(mdKey, s);
                    if(isMatch(mrKey,lock))
                        return true;
                }
                mdKey = moveDown(rKey,d);
            }
            rKey = rotateKey(rKey);
        }
        return false;
    }
    
    public boolean isMatch(int[][] key, int[][] lock){
        int m = key.length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(key[i][j] == lock[i][j])
                    return false;
            }
        }
        return true;
    }
    
    public int[][] rotateKey(int[][] key){
        int lastIdx = key.length - 1;
        int m = key.length;
        int[][] newKey = new int[m][m];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                newKey[i][j] = key[lastIdx - j][i];
            }
        }
        return newKey;
    }
    
    public int[][] moveDown(int[][] key, int moveStep){
        int m = key.length;
        int [][] newKey = new int[m][m];
        int moved = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(moved < moveStep){
                    newKey[i][j] = 0;
                }
                else{
                    newKey[i][j] = key[i-moveStep][j];
                }
            }
            moved++;
        }
        return newKey;
    }
    
    public int[][] moveRight(int[][] key, int moveStep){
        int m = key.length;
        int moved = 0;
        int[][] newKey = new int[m][m];
        
        for(int j = 0; j < m; j++){
            for(int i = 0; i < m; i++){
                if(moved < moveStep){
                    newKey[i][j] = 0;
                }
                else{
                    newKey[i][j] = key[i][j-moveStep];
                }
            }
            moved++;
        }
        return newKey;
    }
}
 */