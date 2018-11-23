package old;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        boolean allCap = true, allLow = true, capLow = true;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                allCap = false;
            }
            if (Character.isUpperCase(c)) {
                allLow = false;
            }
            if (i == 0 && Character.isLowerCase(c) || i != 0 && Character.isUpperCase(c)) {
                capLow = false;
            }
        }
        return allCap || allLow || capLow;
    }
}
