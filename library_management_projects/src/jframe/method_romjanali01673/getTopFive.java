/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe.method_romjanali01673;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class getTopFive {
        int [] arr1= {0,0,0,0,0};
        int [] arr2= {0,0,0,0,0};
        public void setValue(int []arr){
            
            findTop5Frequencies(arr, arr1, arr2);
        }
        public int[]getID(){
            return arr1;
        }
        public int[]getValue(){
            return arr2;
        }
        
        private void findTop5Frequencies(int[] arr, int[]arr1, int []arr2) {
        // Step 1: Count frequencies using HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a PriorityQueue (min-heap) to keep track of top 5 elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > 5) {
                minHeap.poll(); // Remove the element with the smallest frequency
            }
        }

        // Step 3: Extract the top 5 elements from the PriorityQueue
        int i =0;
        while (!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            this.arr1[i]=entry.getKey();
            this.arr2[i]=entry.getValue();
            i++;
        }
    }
    
}
