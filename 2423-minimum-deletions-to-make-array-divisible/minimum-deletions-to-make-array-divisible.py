def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

class Solution(object):
    def minOperations(self, nums, numsDivide):
        # Find the GCD of numsDivide manually
        gcd_numsDivide = numsDivide[0]
        for num in numsDivide[1:]:
            gcd_numsDivide = gcd(gcd_numsDivide, num)
        
        # Sort nums to check from smallest to largest
        nums.sort()
        
        deletions = 0
        for num in nums:
            if gcd_numsDivide % num == 0:
                return deletions
            deletions += 1
        
        # If no number in nums divides all elements in numsDivide
        return -1
