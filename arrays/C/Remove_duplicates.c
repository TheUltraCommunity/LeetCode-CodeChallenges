int removeDuplicates(int* nums, int numsSize) {
    if(numsSize==0){
        return 0;
    }
    long arr[10000];
    int count = 1;
    arr[0] = nums[0];
    for(int i=1;i<numsSize;i++){
        if(nums[i]!=nums[i-1]){
            arr[count] =  nums[i];
            count =  count+1;
        }
    }
    for(int i=0;i<count;i++){
        nums[i] =  arr[i];
    }
    return count;

}
// 26. Remove Duplicates from Sorted Array-Leetcode