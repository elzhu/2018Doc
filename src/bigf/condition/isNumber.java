package bigf.condition;

public class isNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0)
            return false;
        boolean hasE, hasFirst, hasDot, hasDigit;
        hasE = hasFirst = hasDot = hasDigit = false;
        char c;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                hasFirst = true;
                hasDigit = true;
                continue;
            }
            switch (c) {

                case 'e':
                    if (hasE || !hasDigit) {
                        return false;
                    }
                    hasE = true;
                    // reset for the exponential number
                    hasFirst = hasDigit = false;
                    hasDot = true;
                    continue;
                case '+':
                case '-':
                    if (hasFirst) {
                        return false;
                    }
                    hasFirst = true;
                    continue;
                case '.':
                    if (hasDot) {
                        return false;
                    }
                    hasFirst = hasDot = true;
                    continue;
                default:
                    return false;
            }
        }
        
        return hasDigit;

    }

}
