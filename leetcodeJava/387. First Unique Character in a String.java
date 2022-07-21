/*
387. First Unique Character in a String
Easy

5252

205

Add to List

Share
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
*/
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(map.containsKey(cur)){
                map.put(cur,-1);
            }
            else{
                map.put(cur,i);
            }
        }
        int minIndex=s.length();
        for(char c : map.keySet()){
            if(map.get(c)>-1 && map.get(c)<minIndex){
                minIndex=map.get(c);
                
            }
        }
        return minIndex==s.length() ? -1: minIndex;
    }
}