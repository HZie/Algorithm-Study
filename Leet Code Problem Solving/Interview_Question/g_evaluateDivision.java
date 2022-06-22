class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
HashMap<String, Double> map = new HashMap<>();
double[] ans = new double[queries.size()];

for(int i = 0; i < values.length; i++){
String var1 = equations.get(i).get(0);
String var2 = equations.get(i).get(1);
// var1 / var2 = val;
// var1 = val * var2;
// var2 = var1 / val;	

double num1 = map.getOrDefault(var1, -1.0);
double num2 = map.getOrDefault(var2, -1.0);
double val = values[i];	

if(num1 == -1){
  if(num2 == -1){
    // first variables
    map.put(var1, val);
    map.put(var2, 1.0);
}
else{
map.put(var1, val * num2);
}
}
else {
map.put(var2, num1 / val);
}
}

for(int i = 0; i < queries.size(); i++){
String var1 = queries.get(i).get(0);
String var2 = queries.get(i).get(1);
double  res = -1;

if(map.containsKey(var1) && map.containsKey(var2)){
  res = map.get(var1) / map.get(var2);
}
ans[i] = res;
}

return ans;

  }
}
