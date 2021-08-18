public static int getMaxProfit(int[] stockPrices){
	int max = Integer.MIN;
	// O(n^2)
	for(int i = 0; i < stockPrices.length; i++){
		for(int j = i+1; j < stockPrices.length; j++){
			int diff = stockPrices[i] - stockPrices[j];
			max = Math.max(max, diff);
}
}
}
 
public static int getMAxProfit(int[] stockPrices){
	// index of the array
int min1 = 0; // 1st min
int min2 = 0; // 2nd min
 
 
for(int i = 1; i < stockPrices; i++){
	if(stockPrices[min1] > stockPrices[i]){
		min2 = min1;
		min1 = i;
}
}
int min = min1;
if(min1 == stockPrices-1){
	min = min2;
}
 
int max = 0;
for(int i = min+1; i < stockPrices; i++){
	if(stockPrices[max] < stockPrices[i]){
		max = i;
}
}
return stockPrices[max] - stockPrices[min];
}
 
 
public static int getMaxProfit(int[] stockPrices){
	int minPrice = stockPrices[0];
	int maxProfit = stockPrices[1] - stockPrices[0];
	
	for(int i = 1; i < stockPrices.length; i++){
		int currPrice = stockPrices[i];
		int potentialProfit = currPrice - minPrice;
		maxProfit = Math.max(maxProfit, potentialProfit);
		minPrice =Math.min(minPrice, currPrice);
}
 
return maxProfit;
}
