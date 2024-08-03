class Solution(object):
    def search(self, nums, target):
        for i in range(len(nums)):
            if nums[i] == target:
                return i
        else:
            return -1
        