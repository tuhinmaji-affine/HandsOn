/*
169. Majority Element
Easy

10472

357

Add to List

Share
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> cnt=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int count=cnt.containsKey(nums[i])? cnt.get(nums[i]):0;
            if(count==0){
                cnt.put(nums[i],1);
            }else if(count+1>nums.length/2){
                return nums[i];
                
            }else{
                cnt.put(nums[i],count+1);
            }
        }
        return nums[0];
    }
}