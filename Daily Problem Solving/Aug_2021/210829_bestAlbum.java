import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> genrePlay = new HashMap<>();
        HashMap<Integer, Integer> song = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            genrePlay.put(genres[i], genrePlay.getOrDefault(genres[i], 0) + plays[i]);
            song.put(i, plays[i]);
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genrePlay.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        
        List<Map.Entry<Integer, Integer>> songList = new LinkedList<>(song.entrySet());
        songList.sort(new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                return o2.getValue() - o1.getValue();
            }
        });
        
        for(Map.Entry<String, Integer> entry: entryList){
            String genre = entry.getKey();
            int count = 0;
            for(Map.Entry<Integer, Integer> songEntry: songList){
                if(count == 2)
                    break;
                int key = songEntry.getKey();
                if(genre.compareTo(genres[key]) == 0){
                    count++;
                    answerList.add(key);
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        
        return answer;
    }
}