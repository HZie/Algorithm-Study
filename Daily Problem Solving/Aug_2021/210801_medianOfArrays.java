public double medianOfArrays(int[] arr1, int[] arr2){
		
		if(arr1.length == 0 && arr2.length == 0){
			return 0;
}
else if(arr1.length == 0){
int mid = arr2.length/2;
	if(arr2.length % 2 == 0){
		return ((double)arr2[mid-1] + arr2[mid])/2
}
else
	return (double)arr2[mid];
}
else if(arr2.length == 0){
	int mid = arr1.length/2;
	if(arr1.length %2 == 0){
		return ((double) arr1[mid-1] + arr1[mid])/2;
}
else return (double)arr1[mid];
}
		int a1 = 0, a2 = 0;
		int length = arr1.length + arr2.length;
		int median = length / 2;
		boolelan needTwoVal = (length % 2 == 0);
		int mid1 = Math.min(arr1[0], arr2[0]), mid2 = mid1;
		
	
		for(int i = 0; i < median; i++){
			mid1 = mid2;
			if(arr1[a1] < arr2[a2]){
				mid2 = arr[a2];
				a1++;
}
else{
	mid2 = arr[a1];
	a2++;
}
}

if(needTwoVal){
	return (double) (mid1 + mid2) / 2;
}
else
	return (double) mid2;
		
}
	
