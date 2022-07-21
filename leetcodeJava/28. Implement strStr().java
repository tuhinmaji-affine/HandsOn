/*
28. Implement strStr()
Easy

4423

3762

Add to List

Share
Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
*/
//Solution 1
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}


//Solution 2

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i=0;i<haystack.length();i++){
            int index1=i;
            int index2=0;
            while(index1<haystack.length() && index2<needle.length()){
                if(haystack.charAt(index1)==needle.charAt(index2)){
                    index1++;
                    index2++;
                    if (index2==needle.length()){
                        return i;
                    }
                }else{
                    break;
                }
            }
                
        }
        return -1;
    }
}