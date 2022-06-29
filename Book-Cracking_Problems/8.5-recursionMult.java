int recursionMultiple(int a, int b){
	if( a == 0 || b == 0)	return 0;
	if( a == 1 )	return b;
	if( b == 1 )	return a;

	int shift = 0;
	int big = Math.max(a,b);	// 13
	int small = Math.min(a,b);	// 11
	int mult = 1;
	while((small - mult) > mult){
		mult *= 2;
		shift++;
	}
	small -= mult;
	big <<= shift;

	return big + recursionMultiple(Math.max(a,b), small);
}
