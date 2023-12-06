import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String []args)throws FileNotFoundException {
        File file =new File("input.txt");
        Scanner scanner = new Scanner(file);
        List<String> listInput= new ArrayList<>();
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            listInput.add(input);
        }
        System.out.println("input");
        int num[][]=new int[listInput.size()][];
        int mark[][]=new int[listInput.size()][];


        for(int rowArr=0;rowArr< listInput.size();rowArr++){
            String s = listInput.get(rowArr);
            String newArr[] = s.split("");
            num[rowArr]= new int[newArr.length];
            mark[rowArr]= new int[newArr.length];
            for(int columnArr =0;columnArr<newArr.length;columnArr++){
                int value = Integer.parseInt(newArr[columnArr]);
                num[rowArr][columnArr]=value;
                System.out.print(num[rowArr][columnArr]+" ");

            }
            System.out.println(" ");


        }

         for( int row=0;row<num.length;row++){
              int max1 = num[row][0];
              int max2 = num[row][num[row].length-1];
              max1=findMaxRow(row,0,num,max1,mark);
              max2=findMaxRowBack(row,num[row].length-1,num,max2,mark);

           }

         for( int column=0;column<num[0].length;column++ ){
             int max3 =num[0][column];
             int max4 = num[num.length-1][column];
             max3=findMaxColumn(0,column,num,max3,mark);
             max4=findMaxColumnBack(num.length-1,column,num,max4,mark);

         }

        int sum = disPlaySum(mark);
        System.out.println("output "+sum);

    }
    public static Integer findMaxRow(int row,int column,int num[][],int max1,int mark[][]){

        if(column > num[row].length-1){
           return max1;
       }
        int current = num[row][column];
        if(current>max1){
            max1 = current;
            mark[row][column] = 1;
        }
        if(row==0||column==0||row==num.length-1||column==num[row].length-1){
            mark[row][column] = 1;
        }
        return findMaxRow(row,column+1,num,max1,mark);
    }
    public static Integer findMaxRowBack(int row,int column,int num[][],int max2,int mark[][]){

        if(column<0){
            return max2;
        }
        int current = num[row][column];
        if(current>max2){
            max2 = current;
            mark[row][column] = 1;
        }
        if(row==0||column==0||row==num.length-1||column==num[row].length-1){
            mark[row][column] = 1;
        }
        return findMaxRowBack(row,column-1,num,max2,mark);
    }
    public static Integer findMaxColumn(int row,int column,int num[][],int max3,int mark[][]){

        if(row > num.length-1){
            return max3;
        }
        int current = num[row][column];
        if(current>max3){
            max3 = current;
            mark[row][column] = 1;
        }
        if(row==0||column==0||row==num.length-1||column==num[row].length-1){
            mark[row][column] = 1;
        }
        return findMaxColumn(row+1,column,num,max3,mark);
    }
    public static Integer findMaxColumnBack(int row,int column,int num[][],int max4,int mark[][]){

        if(row < 0){
            return max4;
        }
        int current = num[row][column];
        if(current>max4){
            max4 = current;
            mark[row][column] = 1;

        }

        if(row==0||column==0||row==num.length-1||column==num[row].length-1){
            mark[row][column] = 1;
        }
        return findMaxColumnBack(row-1,column,num,max4,mark);
    }
    public static  void disPlay(int temp[][]){
        for(int r =0 ;r < temp.length ; r++){
            for(int col = 0; col< temp[r].length;col++){
                System.out.print(" "+temp[r][col]);
            }
            System.out.println(" ");

        }
    }
    public static  Integer disPlaySum(int temp[][]){
        int sum =0;
        for(int r =0 ;r < temp.length ; r++){
            for(int col = 0; col< temp[r].length;col++){
                sum=sum+temp[r][col];


            }
        }
        return sum;
    }


}
