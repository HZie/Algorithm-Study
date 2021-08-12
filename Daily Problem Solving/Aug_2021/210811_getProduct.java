public static int[] getProduct(int[] arr){
	int[] prev = new int[arr.length];
	int[] post = new int[arr.length];

	for(int i = 0; i < arr.length; i++){
		prev[i] = 1;
		post[i] = 1;
}

for(int i = 1; i < arr.length; i++){
	prev[i] = prev[i-1] * arr[i-1];
}

for(int i = arr.length-1; i >= 1; i--){
	post[i-1] = post[i] * arr[i];
}
int[] ans = new int[arr.length];

for(int i = 0; i < arr.length; i++){
	ans[i] = prev[i] * post[i];
}

return ans;

}
