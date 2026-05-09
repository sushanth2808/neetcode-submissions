class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        for (char c : t.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            Map<Character,Integer> map = new HashMap<>(map1);

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                }

                boolean ok = true;
                for (int val : map.values()) {
                    if (val > 0) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                    break; // no need to expand further
                }
            }
        }
        return ans;
    }
}
