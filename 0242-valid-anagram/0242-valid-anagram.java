class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        if(n1 != n2) return false;

        int[] count = new int[26];

        for(int i=0; i<n1; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int j=0; j<26; j++) {
            if(count[j] != 0) return false;
        }

        return true;
    }
}