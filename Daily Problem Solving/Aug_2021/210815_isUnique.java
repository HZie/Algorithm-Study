public boolean isUnique(String str){
char[] str_char = str.toCharArray();
Arrays.sort(str_char); // O(nlogn)
char prev = str_char[0];
char curr = str_char[0];
// O(n)
for(int i = 1; i < str_char.length; i++){
curr = str_char[i];
if(prev == curr)
return false; // not unique
prev = curr;
}
return true;
}
