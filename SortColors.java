class Solution {
    public void sortColors(int[] nums) {
        
        int low=0;
        int high=nums.length-1;
        
        while(low<high){
            
            if(nums[low]==0) low++;
            if(nums[high]==2) high--;
            if(nums[low]==1 && nums[high]==1){
                int i=low+1;

                while(i<high && nums[i]==1){
                    i++;
                }
                
                if(i>=high) break;
                else{
                    if(nums[i]==0) swap(nums, low, i);
                    else swap(nums,high,i);
                }
                
            }
            else if(low<high) swap(nums,low,high);
            
            }            
    }
    
    public void swap(int[] nums, int i, int j){
        
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        
    }
}
