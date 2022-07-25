/*
1154. Day of the Year
Easy

257

329

Add to List

Share
Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

 

Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.
Example 2:

Input: date = "2019-02-10"
Output: 41
 

Constraints:

date.length == 10
date[4] == date[7] == '-', and all other date[i]'s are digits
date represents a calendar date between Jan 1st, 1900 and Dec 31th, 2019.
*/
class Solution {
    public int dayOfYear(String date) {
        String[] date_parts=date.split("-");
        int year=Integer.parseInt(date_parts[0]);
        int month=Integer.parseInt(date_parts[1]);
        int day=Integer.parseInt(date_parts[2]);
        int totalDays=0;
        for(int i=1;i<month;i++){
            if(i==2){
                if (isLeapYear(year)){
                    totalDays+=29;
                }
                else{
                    totalDays+=28;
                }
            }else if(i<8 && i%2==0){
                totalDays+=30;
            }else if(i<8 && i%2!=0){
                totalDays+=31;
            }else if(i>=8 && i%2==0){
                totalDays+=31;
            }else{
                totalDays+=30;
            }
        }
        totalDays+=day;
        return totalDays;
    }
    public boolean isLeapYear(int year){
        if(year%400==0){
            return true;
        }else if(year%100==0){
            return false;
        }else if (year%4==0){
            return true;
        }else{
            return false;
        }
    }
}