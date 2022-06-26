class TrieNode{
  char character;
  HashMap<Character, TrieNode> children;
  boolean terminate;

  public TrieNode(){
    this.children = new HashMap<>();
  }

  public TrieNode(char c){
    this();
    character = c;
  }

  public char getChar(){
    return character;
  }

  public void addWord(String word){
    if(word == null || word.isEmpty())
      return;

    char firstChar = word.charAt(0);
    TrieNode child = children.get(firstChar);
    if(child == null){
      child = new TrieNode(firstChar);
      children.put(firstChar, child);
    }

    if(word.length() > 1){
      child.addWord(word.substring(1));
    }
    else{
      child.setTerminate(true);
    }
    
  }

  public TrieNode getChild(char c){
    return children.get(c);
  }

  public void setTerminate(boolean val){
    this.terminate = val;
  }

  public boolean isEnd(){
    return this.terminate;
  }

}

public class Trie {
  private TrieNode root;

  public TrieNode(ArrayList<String> list){
    root = new TrieNode();
    for(String word: list){
      root.addWord(word);
    }
  }

  public TrieNode(String[] list){
    root = new TrieNoe();
    for(String word: list){
      root.addWord(word);
    }
  }

  public boolean contains(String prefix){
    TrieNode node = root;

    for(int i = 0; i < prefix.length(); i++){
      node = node.getChild(prefix.charAt(i));
      if(node == null) return false;
    }
    return node.isEnd();
  }

  public boolean remove(String word){
    return remove(root, word, 0);

  }

  public boolean remove(TrieNode node, String word, int index){
    if(index == word.length()){
      if(!node.isEnd())
        return false;
      // is empty라면 해당 노드를 삭제해도 됨
      node.setTerminate(true);
      return node.children.isEmpty();
    }

    TrieNode nextNode = node.getChild(word.charAt(index));
    if(nextNode == null)
      return false;

      // remove 해도 되고, nextNode가 end이면 다음 노드를 삭제함
    if(remove(nextNode, word, index) && nextNode.isEnd()){
      node.children.remove(word.charAt(index));
      return node.children.isEmpty();
    }

    return false;
  }

  public void add(String word){
    TrieNode prev = root, node = root;
    int i;
    for(i = 0; i < word.length(); i++){
      prev = node;
      node = node.getChild(word.charAt(i));
      if(node ==  null){
        break;
      }
    }
    prev.addWord(word.substring(i));
  }

  public TrieNode getRoot(){
    return this.root;
  }
}
