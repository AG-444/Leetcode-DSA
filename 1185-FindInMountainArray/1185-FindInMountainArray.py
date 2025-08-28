# Last updated: 8/28/2025, 9:57:55 AM
class Solution(object):
    def findInMountainArray(self, target, mountainArr):
        """
        :type target: integer
        :type mountain_arr: MountainArray
        :rtype: integer
        """
        def find_peak():
            left, right = 0, mountainArr.length() - 1
            while left < right:
                mid = (left + right) // 2
                if mountainArr.get(mid) < mountainArr.get(mid + 1):
                    left = mid + 1
                else:
                    right = mid
            return left

        def binary_search_ascending(left, right):
            while left <= right:
                mid = (left + right) // 2
                mid_val = mountainArr.get(mid)
                if mid_val == target:
                    return mid
                elif mid_val < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return -1

        def binary_search_descending(left, right):
            while left <= right:
                mid = (left + right) // 2
                mid_val = mountainArr.get(mid)
                if mid_val == target:
                    return mid
                elif mid_val > target:
                    left = mid + 1
                else:
                    right = mid - 1
            return -1

        # Find the peak of the mountain array
        peak = find_peak()
        
        # Search in the ascending part
        result = binary_search_ascending(0, peak)
        if result != -1:
            return result
        
        # If not found in ascending part, search in descending part
        return binary_search_descending(peak + 1, mountainArr.length() - 1)
