package DSA.BinarySearch;

public class FindFirstAndLastPositionInTheArray {



        public int[] searchRange(int[] nums, int target) {
            int f_index = -1,l_index=-1;


            f_index= findFirstPosition(nums,target);
            l_index = findLastPosition(nums,target);



            // int low= 0,high = nums.length-1;

            // while(low<=high){
            //        int mid = (low+high)/2;
            //        if(nums[mid]==target){
            //            f_index= mid;
            //            l_index= mid;
            //           while(f_index >0 && nums[f_index]==nums[f_index-1]){
            //                f_index--;
            //           }
            //           while(l_index<nums.length-1 && nums[l_index]==nums[l_index+1]){
            //                l_index++;
            //           }
            //           break;
            //        }
            //        else if(nums[mid]<target){
            //          low = mid+1;
            //        }
            //        else{
            //           high=mid-1;
            //        }



            // }

            return new int[]{f_index,l_index};
        }


        public static int findFirstPosition(int[] nums, int target){
            int low= 0,high = nums.length-1;
            int ans = -1;
            while(low<=high){
                int mid = (low+high)/2;
                if(nums[mid]==target){
                    ans = mid;
                    high=mid-1;
                }
                else if(nums[mid]<target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }



            }
            return ans;
        }
        public static int findLastPosition(int[] nums, int target){
            int low= 0,high = nums.length-1;
            int ans = -1;
            while(low<=high){
                int mid = (low+high)/2;
                if(nums[mid]==target){
                    ans = mid;
                    low=mid+1;
                }
                else if(nums[mid]<target){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }



            }
            return ans;
        }


}


