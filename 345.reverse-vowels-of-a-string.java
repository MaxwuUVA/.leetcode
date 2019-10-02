/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */
class Solution {
    public String reverseVowels(String s) {
        if(s.isEmpty()) return s;
        char[] a = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            
            if(!isVowels(a[start])) start++;
            else if( !isVowels(a[end])) end--;
            else{
                
                swapChar(a,start,end);
                start++;
                end--;
                
            }
            
        }
        return new String(a);
        
    }
    private void swapChar(char[] a,int i,int j){
        
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        
    }
    private boolean isVowels(char a){
        
        a = Character.toLowerCase(a);
        if(a =='a'|| a =='e'||a =='i'||a =='o'||a =='u') return true;
        else return false;
           
    }
    
}

