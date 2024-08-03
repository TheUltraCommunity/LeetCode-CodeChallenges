class Solution {
  int search(List<int> nums, int target) {
   
    if(nums.length == 0 || (nums.last < target && nums.first > target)){
        return -1;
    }else{
        //it exists
        int index = -1;
        if(nums.first < target){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == target){
                    index = i;
                    break;
                }
            }
        }else{
            for(int i = nums.length - 1; i >= 0; i--){
                if(nums[i] == target){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
  }
}
