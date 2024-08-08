class Solution(object):
    def searchRange(self, nums, target):
        l=[]
        for i in range(len(nums)):
            if nums[i] == target:
                l.append(i)
        if len(l)==0:
            return [-1,-1]
        elif len(l)==1:
            return [l[0],l[0]]
        elif len(l)>2:
            return [l[0],l[-1]]
        return l
