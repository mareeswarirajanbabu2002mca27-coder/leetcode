import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int totalNumbers = 1 << n; // 2^n
        
        for (int i = 0; i < totalNumbers; i++) {
            // Formula to convert binary index 'i' to its Gray code
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}
