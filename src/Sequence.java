/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ldough
 */

import java.util.ArrayList;

public final class Sequence {
    
    private void Sequence() {}
   
    static int count;
    
    public static Integer computeIterative(int n) {
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
    
    public static Integer computeRecursive(int n) {
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
