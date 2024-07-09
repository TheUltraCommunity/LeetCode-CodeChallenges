class Solution{
  static int findSecondGreatestNumber(List<int> arr){
    int ans = 0;
    int greatest = 0;
    if(arr.length <= 1){
      return -1;
    }
    for (final i in arr){
      if(greatest < i){
        ans = greatest;
        greatest = i;
      }else if(ans < i && greatest != i){
        ans = i;
      }
    }
    return ans;
  }
}
