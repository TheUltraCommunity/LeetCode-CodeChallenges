class Solution(object):
    def nextGreaterElements(self ,nums):
        n = len(nums)
        r = [-1] * n
        s = []

        for i in range(2 * n):
            c_num = nums[i % n]
            while s and nums[s[-1]] < c_num:
                r[s.pop()] = c_num
            if i < n:
                s.append(i)

        return r
