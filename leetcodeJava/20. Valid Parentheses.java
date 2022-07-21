/*
20. Valid Parentheses
Easy

13945

648

Add to List

Share
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
class Solution {
    public boolean isValid(String s) {
        String open="({[";
        String close=")}]";
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(open.indexOf(ch)>=0){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }else{
                   char ch2=st.pop();
                    
                    if(open.indexOf(ch2)!=close.indexOf(ch))
                        return false;
                 
                }
            }
        }
        return st.isEmpty();
    }
}