class Solution(object):
    def reverseWords(self, s):
        b = s.split()
        a= b[::-1]
        sentence = ' '.join(a)
        return sentence  
