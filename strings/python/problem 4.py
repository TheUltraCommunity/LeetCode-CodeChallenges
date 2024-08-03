class Solution(object):
    def arrayStringsAreEqual(self, word1, word2):
        b=""
        a=""
        for i in word1:
            b+=i
        for j in word2:
            a+=j
        if a==b:
            return True
        else:
            return False
        