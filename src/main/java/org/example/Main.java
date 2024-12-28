package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Main main = new Main();
        int[] array = main.productExceptSelf(new int[]{1,2,3,4,0,0});

        for (int i : array){
            System.out.println(i);
        }

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