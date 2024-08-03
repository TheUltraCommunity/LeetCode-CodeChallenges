class Solution:
    def print2largest(self, arr):
        arr = list(set(arr))
        arr.sort(reverse= True)
        if arr[0]==arr[1]:
            return -1
        else:
            return arr[1]
