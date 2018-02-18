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

public class Sequence {
    
    static void Sequence() {}
    static int count = 0;
    
    public static int computeIterative(int n) {
        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
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
    
    public static int computeRecursive(int n) {
        count++;
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else{
            return 2 * computeRecursive(n - 1) + computeRecursive(n - 2);
        }
    }
    
    public static int getCount() {
        return count;
    }
    
}
