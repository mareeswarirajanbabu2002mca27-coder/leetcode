import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;
        
        while (i < n) {
            // Find the range of words that can fit into the current line
            int j = i + 1;
            int lineLength = words[i].length();
            
            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }
            
            StringBuilder sb = new StringBuilder();
            int numWords = j - i;
            
            // Case 1: It is the last line or a line with only 1 word (Left Justified)
            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                // Pad the remaining spaces at the end
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } 
            // Case 2: A normal middle line (Fully Justified)
            else {
                int totalSpaces = maxWidth - (lineLength - (numWords - 1));
                int baseSpaces = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);
                
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        // Append base spaces
                        for (int s = 0; s < baseSpaces; s++) {
                            sb.append(" ");
                        }
                        // Distribute extra spaces to the left slots first
                        if (k - i < extraSpaces) {
                            sb.append(" ");
                        }
                    }
                }
            }
            
            result.add(sb.toString());
            i = j; // Move pointer to the start of the next line
        }
        
        return result;
    }
}
