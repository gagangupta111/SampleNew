package org.example;

public class Sample1 {


    public int numIslands(char[][] grid) {

        int length = grid.length;
        int breadth = grid[0].length;
        int[][] visited = new int[length][breadth];

        int noi = 0;
        for (int i = 0 ; i < length; i++){
            for (int j = 0; j < breadth; j++){

                if (grid[i][j] == '1' && visited[i][j] == 0){
                    visit(visited, grid, i, j, length, breadth);
                    noi++;
                }
            }
        }
        return noi;
    }

    public void visit(int[][] visited, char[][] grid, int i, int j, int length, int breadth) {

        // visit current one
        visited[i][j] = 1;

        // up
        if (i - 1 > -1){
            if (grid[i-1][j] == '1'){
                if (visited[i-1][j] == 0) {
                    visit(visited, grid, i-1, j, length, breadth);
                }
            }
        }
        // right
        if (j + 1 < breadth){
            if (grid[i][j+1] == '1'){
                if (visited[i][j+1] == 0) {
                    visit(visited, grid, i, j+1, length, breadth);
                }
            }
        }
        // down
        if (i + 1 < length){
            if (grid[i+1][j] == '1'){
                if (visited[i+1][j] == 0) {
                    visit(visited, grid, i+1, j, length, breadth);
                }
            }
        }

        // left
        if (j - 1 > -1){
            if (grid[i][j-1] == '1'){
                if (visited[i][j-1] == 0) {
                    visit(visited, grid, i, j-1, length, breadth);
                }
            }
        }

        return;

    }

    public int pivotIndex(int[] nums) {

        // anytime leftSum is always ready,

        // find right sum, if exceeds then quit
        // before quitting, if current is not that index,
        // then add current int to this leftSum

        // i++

        int length = nums.length;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0 ; i < length; i++){
            rightSum += nums[i];
        }

        for (int i = 0 ; i < length; i++){

            rightSum -= nums[i];

            if (rightSum == leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public int[] sortArrayByParityII(int[] nums) {

        int length = nums.length;
        for (int i = 0; i < length; i++){

            // i is even but num is not
            if (i % 2 == 0 && nums[i] % 2 != 0 ){
                // find same opposite
                int j = i+1;
                while (j < length){
                    if (j % 2 != 0 && nums[j] % 2 == 0 ){
                        // replace
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                    j++;
                }
                // replace
            }

            if (i % 2 != 0 && nums[i] % 2 == 0 ){
                // find same opposite
                int j = i+1;
                while (j < length){
                    if (j % 2 == 0 && nums[j] % 2 != 0 ){
                        // replace
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                    j++;
                }
                // replace
            }

        }
        return nums;
    }


    public static void main(String[] args){

        char[][] grid = {
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        };

        Sample1 sample1 = new Sample1();
        System.out.println(sample1.numIslands(grid));
    }

}
