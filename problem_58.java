//Length of Last Word
// Date: 01/sep/2024

/*
 * Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal 
substring
 consisting of non-space characters only.
 */

public class problem_58{
    public int lengthOfLastWord(String s) {
        int j=s.length()-1;
        while(j>=0 && s.charAt(j) == ' ')j--;
        int i=j;
        while(i>=0 && s.charAt(i) != ' ')i--;
        return j-i;
    }
}