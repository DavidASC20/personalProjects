import java.util.ResourceBundle.Control;
import java.util.Scanner;



public class Bingo{
    public static void printBoard(int[][] arr) {                        //prints out the board
        String temp = "";
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(j == 0){
                    temp += "[";
                }if(j < 4){
                    temp += arr[i][j] + ", ";
                }else{
                    temp += arr[i][j] + "]\n";
                }
            }
        }
        System.out.print(temp);
    }

    public static void printNums(int[] arr){                              //can print both the big array and newly generated nums array
        String temp = "";
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                temp += "[";
            }if(i < arr.length - 1){
                temp += arr[i] + ", ";
            }else{
                temp += arr[i] + "]\n";
                }
        }
        System.out.print(temp);
    }

    public static int[][] makeBoard(){                                     //generates bingo board
        int[][] arr = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                double rand = Math.random() * 100;
                arr[i][j] = (int)rand + 1;
            }
        }return arr;
    }

    public static int[] generateBingo(int[] nums){                          //generates numbers to check against bingo board
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++){
            int temp = 0;
            double rand = Math.random() * 100;
            temp = (int)rand + 1;
            if(contains(nums, temp)){
                i -= 1;
            }else{
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static int[] appendArray(int[] nums, int[] new_nums){            //adds newly generated numbers into the big array with all the numbers that were chosen
        int totalSize = nums.length + new_nums.length;
        int [] temp = new int[totalSize];
        int counter = 0;
        for(int i = 0; i < totalSize; i++){
            if(i < totalSize - new_nums.length){
                temp[i] = nums[i];
            }else{
                temp[i] = new_nums[counter];
                counter++;
            }
        }
        return temp;
    }

    public static boolean contains(int[] arr, int key){                    //checks if newly generated numbers are already present in the big array
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                return true;
            }
        }return false;
    }

    
    public static boolean containsDouble(int[][] arr, int key){           //checks if double array contains the key
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(arr[i][j] == key){
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println("This is Your Board!");
        boolean gameState = true;
        int rolls = 0;
        int[][] arr = makeBoard();
        printBoard(arr);
        while(gameState == true){
            System.out.println("Next Command? \n");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();

            if(command == "WIN"){
                gameState = false;
            }
        }System.out.println("Finished! Congrats!");
        // int[][] arr = new int[5][5];
        // arr[0][0] = 1;
        // arr[1][0] = 2;
        // ar   r[2][0] = 3;
        // arr[3][0] = 4;
        // arr[4][0] = 5;
        // arr[0][1] = 6;
        // arr[1][1] = 7;
        // arr[2][1] = 8;
        // arr[3][1] = 9;
        // arr[4][1] = 10;

        int[][] arr = makeBoard();
        printBoard(arr);
    }












}