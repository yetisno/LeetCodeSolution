/*
    https://oj.leetcode.com/problems/two-sum/
*/
public class Solution {

	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			int tValue = target - numbers[i];
			if (map.containsKey(tValue)) {
				if (map.get(tValue) > i) {
					return new int[]{i + 1, map.get(tValue) + 1};
				} else if (i > map.get(tValue)) {
					return new int[]{map.get(tValue) + 1, i + 1};
				} else {
					continue;
				}
			}
			if (tValue >= 0) {
				map.put(numbers[i], i);
			}
		}
		return null;
	}
}
