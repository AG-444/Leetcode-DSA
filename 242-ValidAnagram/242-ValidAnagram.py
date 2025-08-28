# Last updated: 8/28/2025, 9:58:13 AM
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        if sorted(s) == sorted(t): return True
        return False
        
        