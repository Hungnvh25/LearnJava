import java.util.Scanner;

public class Main {

    public static boolean check(char[][] arr,int choose){
        int row = (choose -1) / arr.length;
        int col = (choose-1) % arr[0].length;

        if(arr[row][col] == 'X' || arr[row][col] == 'O' ){
            return true;
        }
        return false;
    }

    public static boolean index(char[][] arr, int choose,char player){
        int row = (choose -1) / arr.length;
        int col = (choose-1) % arr[0].length;

        arr[row][col] = player;

        for (int i = 0;i<arr.length;i++){
            for (int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 'X' || arr[i][j] == 'O'){
                    System.out.print(arr[i][j] + "|");
                }else {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }

         if(arr[row][0] == player && arr[row][1] == player && arr[row][2] == player){
             return false;
         }

        if(arr[0][col] == player && arr[1][col] == player && arr[2][col] == player){
            return false;
        }

        if(row == col){
            if(arr[0][0] == player && arr[1][1] == player && arr[2][2] == player){
                return false;
            }
        }

        if(row + col == 2){
            if(arr[0][2] == player && arr[1][1] == player && arr[2][0] == player){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        char[][] gameStart = new char[3][3];
        boolean gameOver = false;
        char player = 'X';
        int choose = 0;

        int i=1;
        System.out.println("Hay chon Vi tri ban muon danh trong bang");
        for (int row = 0;row<board.length;row++){
            for (int col = 0;col<board[0].length;col++){
                System.out.print("|"+ i++ + "|");
            }
            System.out.println();
        }



        while (!gameOver){
            choose = 0;
            while (choose < 1 || choose > 9){
                System.out.print("Nguoi choi "+player+" vui long chon vi tri tu 1->9: ");
                choose = scanner.nextInt();

                if(choose < 1 || choose > 9){
                    System.out.println("Vui Long Nhap tu 1 -> 9");
                }
            }

            if(check(board,choose)){
                System.out.println("Vi tri da duoc chon");
                continue;
            }

            if(!index(board,choose,player)){
                gameOver = true;
                System.out.println("Nguoi choi "+player+" da chien thang");
            }

            player = (player == 'X')? 'O': 'X';

        }


    }
}