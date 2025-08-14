class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(t)<len(s): return False

        for i in s:
            t = t.replace(i,"",1)

        
        if len(t) == 0: return True
        return False
        
        