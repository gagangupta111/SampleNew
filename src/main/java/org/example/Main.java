package org.example;

import java.util.*;

class Employee{
    public int id;
    public int salary;
    public int department;
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  }



public class Main {

    public int trap(int[] height) {

        int water  = 0;
        int length = height.length;
        List<Integer> taken = new ArrayList<Integer>();
        Set<Integer> set = getNextIndexes(height, length, taken, Integer.MAX_VALUE);

        int size = set.size();
        if (size > 1){

        }
        return water;
    }

    public Set<Integer> getNextIndexes(int[] height, int length, List<Integer> taken, int lowerThanThis)  {

        int max = Integer.MIN_VALUE;
        Set<Integer> indexes = new HashSet<>();

        for (int i = 0 ; i < length; i++){
            if (!taken.contains(i)){
                if (height[i] > max){
                    indexes = new HashSet<>();
                    indexes.add(i);
                }else if (height[i] == max){
                    indexes.add(i);
                }
            }
        }
        return indexes;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int length = nums.length;
        int[] result = new int[length - k + 1];
        int resultIndex = 0;

        int start = 0;
        int end = start + k - 1;

        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        int[] maxArray = getMax(nums, start, end);
        maxIndex = maxArray[0];
        max = maxArray[1];
        start++;
        end++;

        result[resultIndex++] = max;

        while (end < length){

            int next = nums[end];
            if (next >= max ){
                maxIndex = end;
                max = next;
            }else {
                if (maxIndex == start-1){
                    maxArray = getMax(nums, start, end);
                    maxIndex = maxArray[0];
                    max = maxArray[1];
                }
            }

            result[resultIndex++] = max;

            start++;
            end++;
        }

        return result;
    }

    public int[] getMax(int[] nums, int start, int end){
        end++;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = start; i < end; i++){
            if (nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return new int[]{maxIndex, max};
    }

    public int numberOfOnes(int n, Map<Integer, Integer> map) {

        Integer value = map.get(n);
        if (value != null){
            return value;
        }

        if(n == 1){
            map.put(n, 1);
            return 1;
        }

        if (n < 10){
            map.put(n, 0);
            return 0;
        }

        int noOfOnes = 0;
        int remainder = 0;
        int multi = n;
        while (multi > 9){
            remainder = multi % 10;
            if (remainder == 1){
                noOfOnes++;
            }
            multi = multi / 10;
        }
        noOfOnes += numberOfOnes(multi, map);
        map.put(n, noOfOnes);
        return noOfOnes;
    }

    public int countDigitOne(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        int noOfOnes = 0;
        for (int i = 1; i <= n; i++){
            noOfOnes += numberOfOnes(i, map);
        }
        return noOfOnes;

    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null;
        ListNode current = null;
        int length = 0;

        length = lists == null ? length : lists.length;

        int index = findShortest(lists, length);
        if (index == -1){
            return null;
        }
        head = lists[index];
        current = head;

        lists[index] = lists[index].next;

        index = findShortest(lists, length);
        while (index != -1){
            current.next = lists[index];
            current = current.next;
            lists[index] = lists[index].next;
            index = findShortest(lists, length);
        }
        return head;
    }

    public int findShortest(ListNode[] lists, int length) {

        int index = 0;
        ListNode shortest = lists[0];
        for (int i = 0 ; i < length ; i++){
            if (lists[i] == null){
                continue;
            }
            if (shortest == null || lists[i].val < shortest.val){
                shortest = lists[i];
                index = i;
            }
        }
        if (shortest == null){
            return -1;
        }
        return index;
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here

        int currentApple = 0;
        int currentOrange= 0;

        int totalApple = 0;
        int totalOrange = 0;

        for (int apple : apples){
            if (apple >= 0){
                currentApple = a + apple;
                if (currentApple >= s && currentApple <= t){
                    totalApple++;
                }
            }
        }

        for (int orange : oranges){
            if (orange <= 0){
                currentOrange = b - (-orange);
                if (currentOrange >= s && currentOrange <= t){
                    totalOrange++;
                }
            }
        }
        System.out.println(totalApple);
        System.out.println(totalOrange);

    }

    public static int birthday(List<Integer> s, int sum, int range) {
        // Write your code here

        int total = 0;
        int currentRemoval = 0;
        int nextElement = range;
        int size = s.size();

        int currentSum = 0;
        int currentIndex = 0;
        while (currentIndex < range){
            currentSum += s.get(currentIndex++);
        }

        if (currentSum == sum){
            total++;
        }

        while (range < size){
            currentSum += s.get(range);
            currentSum -= s.get(currentRemoval);
            currentRemoval++;
            range++;
            if (currentSum == sum){
                total++;
            }
        }

        return total;
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {

        // Write your code here

        int total = 0;
        for (int i = 0 ; i < n; i++){
            int first = ar.get(i);
            for (int j = i+1 ; j < n; j++){
                int second = ar.get(j);
                if ((first+second)%k == 0){
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.department = 100;
        employee1.id = 101;
        employee1.salary = 1000;

    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {


        int length = arr1.length;
        int length2 = arr2.length;

        int i = length-length2-1;
        int j = length2-1;
        int k = length-1;

        while (i > -1 && j > -1){
            if (arr1[i] > arr2[j]){
                arr1[k] = arr1[i];
                i--;
            }else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }
        return arr1;
    }
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int length = arr.size();
        int firstDiagonal = 0;

        int secondi = 0;
        int secondJ = length-1;

        int firstSum = 0;
        int secondSum = 0;

        while (firstDiagonal < length){

            firstSum += arr.get(firstDiagonal).get(firstDiagonal);
            secondSum += arr.get(secondi).get(secondJ);

            firstDiagonal++;
            secondi++;
            secondJ--;
        }

        return firstSum > secondSum ? firstSum-secondSum : secondSum - firstSum;
    }

    public int[] productExceptSelf(int[] nums) {

        int allProduct = 1;
        int zeros = 0;
        int length = nums.length;
        int zeroIndex = -1;

        for (int i = 0 ;i < length; i++){
            if (nums[i] == 0){
                if (zeros > 0){
                    for (int j = 0 ;j < length; j++) {
                        nums[j] = 0;
                    }
                    return nums;
                    }else {
                    zeros++;
                    zeroIndex = i;
                }
            }else {
                allProduct *= nums[i];
            }
        }

        if (zeros > 0){
            for (int j = 0 ;j < length; j++) {
                nums[j] = 0;
            }
            nums[zeroIndex] = allProduct;
            return nums;
        }

        for (int i = 0 ;i < length; i++){

            if (nums[i] == 0){
                nums[i] = allProduct;
            }else {
                nums[i] = allProduct / nums[i];
            }

        }
        return nums;
    }
}
