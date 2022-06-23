import java.util.*;

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


class Solution {
    // using graph → each pair is a path, val is a weight
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
    double[] ans = new double[queries.size()];
    HashSet<String> variables = new HashSet<>();
    HashMap<String, Double> weightMap = new HashMap<>();
  for(int i = 0;  i < equations.size(); i++){
    String start = equations.get(i).get(0);
    String end = equations.get(i).get(1);

    variables.add(start);
    variables.add(end);

    weightMap.put(start+"/"+end, values[i]);
    weightMap.put(end+"/"+start, 1/values[i]);
  }

  for(int i = 0; i < queries.size(); i++){
    String start = queries.get(i).get(0);
    String dest = queries.get(i).get(1);
    // variable not exists
    if(!variables.contains(start) || !variables.contains(dest)){
      ans[i] = -1.0;
      continue;
  }
  HashSet<String> visit = new HashSet<>();
  ans[i] = findPath(variables, weightMap, visit, start, dest);
  }

  return ans;

  }

  // BFS
  public double findPath(HashSet<String> variables, HashMap<String, Double> weightMap, HashSet<String> visit, String start, String dest){
    String originalKey = start+"/"+dest;

    if(weightMap.containsKey(originalKey)){
      return weightMap.get(originalKey);
    }
    visit.add(start);
    Queue<String> q = new LinkedList<>();
    Queue<Double> weightQ = new LinkedList<>();
    q.add(start);
    weightQ.add(1.0);

    while(!q.isEmpty()){
      double calc = weightQ.poll();
      String s = q.poll();
    // do something

      String key = s+"/"+dest;
      if(weightMap.containsKey(key)){
        calc *= weightMap.get(key);
        weightMap.put(originalKey, calc);
        return calc;
      }

      for(String v: variables){
        key = s + "/" + v;
        if(weightMap.containsKey(key) && !visit.contains(v)){
          visit.add(v);
          q.add(v);
          weightQ.add(calc*weightMap.get(key));
        }
      } 
    }
    
    return -1.0;
  }

}
