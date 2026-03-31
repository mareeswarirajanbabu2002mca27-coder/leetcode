function lengthOfLongestSubstring(s: string): number {
    let maxLength = 0;
    let start = 0;
    const charMap = new Map<string, number>();

    for (let end = 0; end < s.length; end++) {
        const char = s[end];

        // If the character is a duplicate and within the current window
        if (charMap.has(char) && charMap.get(char)! >= start) {
            // Move start to the right of the previous occurrence
            start = charMap.get(char)! + 1;
        }

        // Update the last seen index of the character
        charMap.set(char, end);
        
        // Calculate the current window size
        maxLength = Math.max(maxLength, end - start + 1);
    }

    return maxLength;
}
