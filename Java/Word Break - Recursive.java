public class Solution {
	private int stack = 0;

	public boolean wordBreak(String s, Set<String> dict) {
		for (String value : dict) {
			boolean tf = true;
			if (s.contains(value)) {
				String substr = s.replaceAll(value, "");
				if (substr.equals("")) {
					return true;
				}
				stack++;
				tf = tf && wordBreak(substr, dict);
				stack--;
				if (stack == 0 && tf) {
					return true;
				}
				if (tf) {
					return true;
				}
			}
		}
		return false;
	}
}
