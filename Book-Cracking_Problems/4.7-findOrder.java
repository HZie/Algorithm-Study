

/*
 * [a,b,c,d,e,f]
 * [ [a,d], [f,b], [b,d], [f,a], [d,c] ] 
 * res: f e a b d c
 * 
 * map: { d:[a], b:[f], d:[b], a:[f], c:[d] }
 * q: a b c d e f
 * 
 * visit: {}
 * 
 * p = a
 * q: b c d e f f a
 * 
 * p = b
 * q: c d e f f a f b 
 * 
 * p = c
 * q: d e f f a f b d c
 * 
 * p = d
 * q: e f f a f b d c b d
 * 
 * p = e
 * q: f f a f b d c b d
 * visit = {e}
 * answer: e
 * 
 * p = f 
 * q: f a f b d c b d
 * visit = {e, f}
 * answer: e f
 * 
 * p = f
 * q: a f b d c b d
 * 
 * p = a
 * q: f b d c b d
 * visit = {e, f, a}
 * answer: e f a
 * 
 * p = f
 * q: b d c b d
 * 
 * p = b
 * q: d c b d 
 * visit: {e, f, a, b}
 * answer: e f a b
 * 
 * p = d
 * q: c b d
 * visit: {e, f, a, b, d}
 * answer: e f a b d
 * 
 * p = c
 * q: b d
 * visit : {e f a b d c}
 * answer: e f a b d c
 * 
 * p = b
 * q: d
 * 
 * p = d
 * q: null
 * 
 */

public ArrayList<String> findOrder(String[] projects, ArrayList<ArrayList<String>> subPrograms) {
  ArrayList<String> answer = new ArrayList<>();

  // key: sub program, value: main program
  HashMap<String, ArrayList<String>> map = new HashMap<>();

  for(int i = 0; i< subPrograms.size(); i++){
    String sup = subPrograms.get(i).get(0);
    String sub = subPrograms.get(i).get(1);
    map.put(sub, map.getOrDefault(sub, new ArrayList<>()).add(sup));
  }

  HashSet<String> visit = new HashSet<>();

  Queue<String> q = new LinkedList<>();
  
  for(int i = 0; i < projects.length; i++){
    if(!map.containsKey(projects[i]))
      answer.add(projects[i]);
    else
      q.add(projects[i]);
  }

  while(!q.isEmpty()){
    String p = q.poll();
    visit.add(p);

    if(visit.contains(p))
      return null;
    
    boolean isComplete = true;
    
    if(map.containsKey(p)){
      for(String s: map.get(p)){
        if(!visit.contains(s)){
          isComplete = false;
          if(!q.contains(s))
            q.add(s);
        }
      }
    }

    if(isComplete){
      answer.add(p);
    }
    else{
      visit.remove(p);
      if(q.contains(p)){
        q.remove(p);
      }
      q.add(p);
    }
  }


  return answer;
}
