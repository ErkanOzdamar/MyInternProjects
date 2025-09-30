package G_Class;

import java.util.Scanner;

public class Attention{

    public static void notHesaplama(int[] arr){
        for(int i = 0; i<arr.length; i++){
            if(arr[i]< 30){
                System.out.println(arr[i]+" Notunuz CC");
            }else if(arr[i] >= 30 && arr[i] < 50){
                System.out.println(arr[i]+" Notunuz CB");
            }else{
                System.out.println(arr[i]+" Notunuz AA");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Kaç not girilecek:");
        int n = scan.nextInt();
        int arr[] = new int[n];
        System.out.println("Notları giriniz:");
        for(int i = 0; i<n; i++){
            System.out.print("*:");
            int value = scan.nextInt();
            System.out.println();
            arr[i] = value;
        }
        notHesaplama(arr);
        System.out.println("Notlar bitti!");
        scan.close();
    }
}