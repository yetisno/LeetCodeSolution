/*
https://oj.leetcode.com/problems/max-points-on-a-line/
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
	public int maxPoints(Point[] points) {
		HashMap<String, HashSet<String>> pointCount = new HashMap<String, HashSet<String>>();
		int max = 0;
		if (points == null) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				Point a = points[i];
				Point b = points[j];
				Double r = getRatio(a, b);
				Double c = getC(r, a);
				String tmps;
				if (r.equals(Double.POSITIVE_INFINITY)) {
					tmps = "V " + a.x;

				} else if (r.equals(Double.NaN)) {
					tmps = "H " + a.y;
				} else {
					tmps = r + " " + c;
				}
				if (!pointCount.containsKey(tmps)) {
					pointCount.put(tmps, new HashSet<String>());
				}
				pointCount.get(tmps).add(a.x + " " + a.y + " " + i);
				pointCount.get(tmps).add(b.x + " " + b.y + " " + j);
			}
		}
		for (Map.Entry<String, HashSet<String>> entry : pointCount.entrySet()) {
			HashSet<String> hashSet = entry.getValue();
			if (hashSet.size() > max) {
				max = hashSet.size();
			}
		}
		return max;
	}

	protected Double getRatio(Point a, Point b) {
		double x = b.x - a.x;
		double y = b.y - a.y;
		if (x == 0) {
			return Double.POSITIVE_INFINITY;
		}
		if (y == 0) {
			return Double.NaN;
		}
		return y / x;

	}

	protected Double getC(Double ratio, Point a) {
		if (ratio.equals(Double.POSITIVE_INFINITY)) {
			return Double.POSITIVE_INFINITY;
		}
		if (ratio.equals(Double.NaN)) {
			return Double.NaN;
		}
		return a.y - (ratio * a.x);
	}
}
