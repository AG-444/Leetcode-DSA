# Last updated: 9/13/2025, 3:37:09 PM
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1, n2 = len(nums1), len(nums2)
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        left_half = (n1+n2+1)//2
        left, right = 0, n1
        while left <= right:
            part1 = (left+right)//2
            part2 = left_half - part1

            leftMax_1 = -float('inf') if part1 == 0 else nums1[part1-1]
            rightMin_1 = float('inf') if part1 == n1 else nums1[part1]
            leftMax_2 = -float('inf') if part2 == 0 else nums2[part2-1]
            rightMin_2 = float('inf') if part2 == n2 else nums2[part2]

            if leftMax_1 <= rightMin_2 and leftMax_2 <= rightMin_1:
                if (n1+n2)%2 == 0:
                    return (max(leftMax_1, leftMax_2) + min(rightMin_1, rightMin_2))/2
                else:
                    return max(leftMax_1, leftMax_2) 
            elif leftMax_1 > rightMin_2:
                right = part1-1
            else:
                left = part1+1