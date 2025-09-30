package G_Class;

public class sıralama {

    public static void bubblesort(int arr[], int n){
        
        
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<n-1; j++){
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j+1]+arr[j];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j]-arr[j+1];
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 10;
        int arr[] = {12, 16 ,21, 3, 7, 8, 12 ,56, 34, 13};
        bubblesort(arr, n);

        for(int i = 0; i<n; i++){
            System.out.print(arr[i]+"-");
        }
        
    }
}
