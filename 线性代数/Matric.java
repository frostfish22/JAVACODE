package 线性代数;

import java.util.Scanner;

public class Matric {
    public int[][] createMatrix(int row,int colum){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int array[][] = new int[row][colum];
        for(int i=0;i<row;i++){
            for(int j=0;j<colum;j++){
                array[i][j] =scanner.nextInt();
            }
        }
        return array;
    }
    public int[][] matricAdd(int matric1[][],int matric2[][]){
        int matric3[][] = new int[matric1.length][matric1[0].length];
        if(matric1.length!=matric2.length||matric1[0].length!=matric2[0].length){
            System.out.println("输入格式有误");
            System.exit(0);
        }else{
            for(int i=0;i<matric3.length;i++){
                for(int j=0;j<matric3[0].length;j++){
                    matric3[i][j]=matric1[i][j]+matric2[i][j];
                }
            }
        }
        return matric3;
    }
    
    public int[][] matricJian(int matric1[][], int matric2[][]) {
        int matric3[][] = new int[matric1.length][matric1[0].length];
        if (matric1.length != matric2.length || matric1[0].length != matric2[0].length) {
            System.out.println("输入格式有误");
            System.exit(0);
        } else {
            for (int i = 0; i < matric3.length; i++) {
                for (int j = 0; j < matric3[0].length; j++) {
                    matric3[i][j] = matric1[i][j] - matric2[i][j];
                }
            }
        }
        return matric3;
    }
    public int[][] matricCheng(int matric1[][], int matric2[][]){
        int matric3[][] = new int[matric1.length][matric1[0].length];
        if (matric1.length != matric2.length || matric1[0].length != matric2[0].length) {
            System.out.println("输入格式有误");
            System.exit(0);
        } else {
            for (int i = 0; i < matric3.length; i++) {
                for (int j = 0; j < matric3[0].length; j++) {
                    for(int k=0;k<matric2.length;k++){
                        matric3[i][j]+=matric1[i][k]*matric2[k][j];
                    }
                }
            }
        }
        return matric3;
    }
    
    public int[][] matricReserve(int matric[][]) {
        int matric3[][] = new int[matric[0].length][matric.length];
        for (int i = 0; i < matric.length; i++) {
            for (int j = 0; j < matric[0].length; j++) {
                matric3[j][i] = matric[i][j];
            }
        }
        return matric3;
    }
    
    public int[][] matricShuCheng(int matric[][], int x) {
        for (int i = 0; i < matric.length; i++)
            for (int j = 0; j < matric[0].length; j++) {
                matric[i][j] = matric[i][j] * x;
            }
        return matric;
    }
    
    public void inputMatric(int matric[][]) {
        System.out.println("运算结果为:");
        for (int i = 0; i < matric.length; i++) {
            for (int j = 0; j < matric[0].length; j++) {
                System.out.print(matric[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
