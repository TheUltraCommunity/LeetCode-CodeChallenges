class Solution{
  static int findGreatestNumber(List<int> arr){
    // Create a variable to store the answer
    int ans = 0;
    //Run a for loop iterating through the list
    for (final i in arr){
      if(ans < i){ //Check if the number is greater than the current answer
        ans = i; // If true, replace the answer with i
      }
    }
    return ans; // Return the greatest number
  }
}
