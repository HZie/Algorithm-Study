void mergesort(int[] array){
    int[] helper = new int[array.length];   // temp같은 아이
    mergesort(array, helper, 0, array.length-1);    // 오버로드 함수 호출
}

void mergesort(int[] array, int[] helper, int low, int high){
    if(low < high){ // 분할 가능한 배열
        int middle = (low + high) / 2;
        
        // 2개의 배열로 분할한 후 정렬
        mergesort(array, helper, low, middle);      // 왼쪽 절반 정렬
        mergesort(array, helper, middle+1, high);   // 오른쪽 절반 정렬
        
        // 병합
        merge(array, helper, low, middle, high);
    }
}

void merge(int[] array, int[] helper, int low, int middle, int high){
    // 비교해야 할 분할 된 두 배열의 합을 helper 배열에 복사해서 저장해둠
    for(int i = low; i <= high; i++){
        helper[i] = array[i];
    }

    // left: 왼쪽 배열의 가장 왼쪽 수, 
    // right: 오른쪽 배열의 가장 왼쪽 수
    // curr: 합쳐질 배열의 가장 왼쪽 수
    int left = low;
    int right = middle+1;
    int curr = low;

    // left가 왼쪽 배열을 가리키고, right가 오른쪽 배열을 가리키는 동안
    while(left <= middle && right <= high){

        // 아래 if/else 부분이 정렬 핵심 (이 경우 오름차순)
        if(compareRule(helper[left], helper[right])){
            array[curr] = helper[left];
            left++;
        }
        else{
            array[curr] = helper[right];
            right++;
        }
        
        curr++;
    }

    // 왼쪽 배열의 남은 수를 원래 배열에 복사함
    // 오른쪽 배열의 남은 수들은 이미 그 자리에 있기 때문에 따로 복사할 필요 X
    while(left <= middle){
        array[curr] = helper[left];
        curr++;
        left++;
    }
}

boolean compareRule(int left, int right){
    if(left <= right)
        return true;
    return false;
}