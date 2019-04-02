/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs343_hw3;

import static java.awt.PageAttributes.MediaType.B;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author rachh
 */
public class CS343_HW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random ran = new Random();

        int[] A = new int[100];
        int[] B = new int[100];
        int k = 10;
        
        for (int i = 0; i < 100; i++) {
            A[i] = ran.nextInt(10);
        }
        
        int p = 0;
        int r = A.length - 1;
        
        long countStartTime = System.nanoTime();
        int[] sortedArray = counting_sort(A, B, k);
        long countEndTime = System.nanoTime();
        long countTotalTime = countEndTime - countStartTime;
        
        System.out.println(Arrays.toString(sortedArray));
        
    
        
        System.out.println("quick time = " + countTotalTime/(Math.pow(10,9))); 
    }

    private static int[] counting_sort(int[] A, int[] B, int k) {
        int[] C = new int[k];
        int a_length = A.length;
        for (int i = 0; i < k; i++) {
            C[i] = 0;
        }
        for (int j = 1; j < a_length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }
        for (int i = 1; i < k; i++) {
            C[i] = C[i]+ C[i-1];
        }
        for (int j = a_length-1; j >=1; j--) {
            B[C[A[j]]] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
        return B;
    }
    
    
    
}
