
class TrieNode{
    boolean isEnd;
    TrieNode[] pointers;
    
    TrieNode(){
        isEnd = false;
        pointers = new TrieNode[26];
    }

}


class Trie {
    //It can also be done using recursion
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;

        for(char c:word.toCharArray()){
            if(temp.pointers[c-'a'] != null)
                temp = temp.pointers[c-'a'];
            else{
                temp.pointers[c-'a'] = new TrieNode();
                temp = temp.pointers[c-'a'];
            }
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;

        for(char c:word.toCharArray()){
            if(temp.pointers[c-'a'] == null)
                return false;
            temp = temp.pointers[c-'a'];
        }
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;

        for(char c:prefix.toCharArray()){
            if(temp.pointers[c-'a'] == null)
                return false;
            temp = temp.pointers[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */