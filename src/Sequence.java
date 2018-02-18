/**
 * 
 * @filename Sequence.java
 * @author ldough
 * @date 02/18/2018
 * This Utility class creates methods for calculating a series of numbers and 
 * returning a value, as well as a count of how many iterations or recursive
 * calls were necessary to complete the calculation.
 */

import java.util.ArrayList;

public final class Sequence {
    
    private void Sequence() {}
   
    static int count;
    
     //Iteratively computes the sequence of numbers described as "each term of 
    //the sequence is twice the previous term plus the second previous term."
    public static long computeIterative(int n) {
        Integer val1 = 0;
        Integer val2 = 0;
        Integer val3 = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            if (i < 3) {
                array.add(i);
            } else {
                val1 = array.get(i - 1);
                val2 = array.get(i - 2);
                val3 = val1 * 2 + val2;
                array.add(val3);
            }
            count++;
        }
        
        
        return array.get(array.size() - 1);
    }
    
    //Recursively computes the sequence of numbers described as "each term of 
    //the sequence is twice the previous term plus the second previous term."
    public static long computeRecursive(int n) {
        if (n == 0) {
            count ++;
            return 0;
        }
        else if (n == 1) {
            count++;
            return 1;
        }
        else {
            count++;
            return 2 * computeRecursive(n - 1) + computeRecursive(n - 2);
        }
    }
 
    public static Integer getEfficiency() {
        return count;
    }
    
}
