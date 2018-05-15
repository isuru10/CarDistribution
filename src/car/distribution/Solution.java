/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package car.distribution;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 *
 * @author isuru
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        
        int result = carDistribution(n, ar);
        System.out.println(result);
    }

    private static int carDistribution(int n, int[] ar) {
        HashMap<Integer, Integer> numberAppearance = new HashMap<Integer, Integer>();
        for (int i : ar) {
            if(numberAppearance.containsKey(i)) {
                int counter = numberAppearance.get(i);
                counter = counter+1;
            numberAppearance.put(i, counter);
            } else {
                numberAppearance.put(i, 1);
            }
        }
        
        int maxKey = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int key: numberAppearance.keySet()){
            if(numberAppearance.get(key) > maxValue){
                maxValue = numberAppearance.get(key);
                maxKey = key;
            }else if(numberAppearance.get(key) == maxValue){
                if(key < maxKey){
                    maxKey = key;
                    maxValue = numberAppearance.get(key);
                }
            }
        }
        
        for(int key : numberAppearance.keySet()){
            System.out.println(key + " appeared " + numberAppearance.get(key) + " times");
        }
        return maxKey;
    }
    
}
