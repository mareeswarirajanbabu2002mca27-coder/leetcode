import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        // Map to store: Sorted String -> List of original Anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // 1. Sort the characters of the string to create a key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            
            // 2. Add the original string to the corresponding list in the map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        // 3. Return all the lists grouped in the map
        return new ArrayList<>(map.values());
    }
}
