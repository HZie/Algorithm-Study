public static int maxProduct(int[] arr){
	int highest = Math.max(arr[0], arr[1]);
	int highest2 = arr[0] * arr[1];
	int highest3 = arr[0] * arr[1] * arr[2];

	int lowest = Math.min(arr[0], arr[1]);
	int lowest2 = arr[0] * arr[1];
	
for(int i = 2; i < arr.length; i++){
		highest3 = Math.max(highest3, highest2 * arr[i], lowest2 * arr[i]);	
		
		 highest2 = Math.max(highest2, highest * arr[i], lowest * arr[i]);
		lowest2 = Math.min(lowest2, lowest * arr[i], higheset * arr[i]);

highest = Math.max(highest, arr[i]);
		lowest = Math.min(lowest, arr[i]);	
}

return highest3;
}

