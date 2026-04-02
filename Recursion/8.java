class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        int ans = 0;
        int i = 0;
        if (s.charAt(i) == '+')
            i++;
        else if (s.charAt(i) == '-') {
            sign *= -1;
            i++;
        }
        while (i < s.length()) {
            char curr = s.charAt(i);
            if (!Character.isDigit(curr))
                break;
            else {
                int digit = curr - '0';
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans = ans * 10 + digit;
                i++;
            }

        }
        return ans * sign;
    }
}