class Solution:
    def isValid(self, s: str) -> bool:
        l = []
        d = { ")" : "(", "]" : "[", "}" : "{"}
        for element in s:
            if element in d:
                if l and l[-1] == d[element]:
                    l.pop()
                else:
                    return False
            else:
                l.append(element)
        if l:
            return False
        else:
            return True