public static int[] getProductsOfAllIntsExceptAtIndex(int[] arr(){
	int[] productsofAllIntsBeforeIndex = new int[arr.length];
	int[] productsofAllIntAfterIndex = new int[arr.length];
	int[] ans = new int[arr.length];

	int beforeProduct = 1;
	int afterProduct = 1;
	for(int i = 0; i < arr.length; i++){
		productsofAllIntsBeforeIndex[i] = beforeProductr;
		productsofAllIntsAfterIndex[arr.lenght - 1 - i] = afterProduct; 
		beforeProduct *= arr[i];
		afterProduct *= arr[arr.length - 1 - i];
}

for(int i = 0; i < ans.length; i++){
	ans[i] = productsofAllIntsBeforeIndex[i] * productsofAllIntsAfterIndex[i];
}

return ans;
}
