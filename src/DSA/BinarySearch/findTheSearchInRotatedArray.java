package DSA.BinarySearch;

public class findTheSearchInRotatedArray {
    public static void main(String[] args) {

        int[] arr ={
                6,8,9,11,12,13,13,-6,-5,2,2,3,3,4,5,5,6,6,6,6
        };
        int key =13;

        System.out.println(search(arr,key)+1);
        System.out.println(search(new int[]{1},0));


    }

    public static int search(int[] arr, int key) {

        int r= findAmountOfRoataion(arr);
        int n = arr.length;
        int low= 0,high=arr.length-1;
        while (low<=high){
            int mid= (low+high)/2;

            if(arr[(mid+r)%n]<=key){
                low= mid+1;
            }
            else {
                high= mid-1;
            }
        }
        int index= low-1;
        if(index>=0 && arr[(index+r)%n]==key){
            return (index+r)%n;
        }
        return -1;
    }
    public static int findAmountOfRoataion(int[] arr){

        int low= 0,high=arr.length-1;
        int n =arr.length;
        int ans=-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>arr[n-1]){
                ans=mid;
                low= mid+1;
            }
            else{
                high= mid-1;
            }
        }
        return ans+1;
    }
}
