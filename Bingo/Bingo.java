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

    public static int[][] check(int[][] arr, int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < arr.length; j++){
                for(int k = 0; k < arr[0].length; k++){
                    if(nums[i] == arr[j][k]){
                        arr[j][k] = 0;
                    }
                }
            }
        }return arr;
    }

    public static boolean isGame(int[][] arr){
        for(int i = 0; i < 5; i++){
            int counter = 0;
            for(int j = 0; j < 5; j++){
                if(arr[i][j] == 0){
                    counter++;
                }if(counter == 5){
                    return false;
                }
            }
        }

        for(int i = 0; i < 5; i++){
            int counter = 0;
            for(int j = 0; j < 5; j++){
                if(arr[j][i] == 0){
                    counter++;
                }if(counter == 5){
                    return false;
                } 
            }
        }

        for(int i = 0; i < 5; i++){
            int counter = 0;
            if(arr[i][i] == 0){
                counter++;
            }if(counter == 5){
                return false;
            }
        }

        for(int i = 4; i >= 0; i--){
            int counter = 0;
            if(arr[i][i] == 0){
                counter++;
            }if(counter == 5){
                return false;
            }
        }
        return true;
    }


    public static int[][] copyArr(int[][] arr) {
        int[][] temp = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                temp[i][j] = arr[i][j];
            }
        }return temp;
    }   
    public static void main(String[] args) {
        System.out.println("This is Your Board!");
        boolean gameState = true;
        int rolls = 0;
        int[][] board = makeBoard();
        int [][] arr = copyArr(board);
        int[] bingNums = new int[0];
        printBoard(arr);
        System.out.println("\nCommands available are 'roll', 'printStartingBoard', and 'printBingoList'\n");
        while(gameState == true){
            System.out.println("Next Command? \n");
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();
            if(command.equals("roll")){
                rolls++;
                int[] temp = new int[5];
                temp = generateBingo(bingNums);
                bingNums = appendArray(bingNums, temp);
                System.out.println("New Numbers are");
                printNums(temp);
                check(arr, temp);
                System.out.println("\nUpdated Board:\n");
                printBoard(arr);
                gameState = isGame(arr);
            }
            
            
            else if(command.equals("printStartingBoard")){
                System.out.println("\nStarting Board is\n");
                printBoard(board);
                System.out.println("\n");
            }
            
            
            else if(command.equals("printBingoList")){
                System.out.println("\nBingo List is\n");
                printNums(bingNums);;
                System.out.println("\n");
            }

            else{
                System.out.println("Invalid Command. \nCommands available are 'roll', 'printStartingBoard', and 'printBingoList'");
            }
        }System.out.println("Finished! Congrats!  It took you " + rolls + " rolls!");
    }












}