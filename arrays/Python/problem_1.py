class Solution:
    def largest(self, n : int, arr : List[int]) -> int:
        # code here
        max=0
        for i in range(len(arr)):
            if max<arr[i]:
                max=arr[i]
        return max
