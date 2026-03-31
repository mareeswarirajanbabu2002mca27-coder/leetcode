function longestPalindrome(s: string): string {
    if (s.length < 1) return "";
    
    let start = 0;
    let end = 0;

    for (let i = 0; i < s.length; i++) {
        // Check for odd-length palindromes (single character center)
        const len1 = expandAroundCenter(s, i, i);
        // Check for even-length palindromes (gap between characters center)
        const len2 = expandAroundCenter(s, i, i + 1);
        
        const maxLen = Math.max(len1, len2);
        
        // Update the boundaries of the longest palindrome found so far
        if (maxLen > end - start) {
            start = i - Math.floor((maxLen - 1) / 2);
            end = i + Math.floor(maxLen / 2);
        }
    }

    return s.substring(start, end + 1);
}

function expandAroundCenter(s: string, left: number, right: number): number {
    while (left >= 0 && right < s.length && s[left] === s[right]) {
        left--;
        right++;
    }
    // Return the length of the palindrome found
    return right - left - 1;
}
