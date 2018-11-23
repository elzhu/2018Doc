package old;

public class Amazon {

/*
    UTF-8 is a variable byte character encoding, where each character is represented by between 1 and 4 bytes. Each byte starts with 1-5 bits that
    represent whether the byte is a new character or the continuation of a character, and in the former case represents how many bytes the character
    is. The remaining data bits may be either 0 or 1, and are represented by x's below.

    Characters are represented as follows:

    Single byte character: 0xxxxxxx
    Two byte character:    110xxxxx 10xxxxxx
    Three byte character:  1110xxxx 10xxxxxx 10xxxxxx
    Four byte character:   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx


    Examples:
            00001100          - Valid:   this is a one byte character.
            11001101 10110100 - Valid:   this is a two byte character where the first byte begins with 110, and the second byte begins with 10.
            11001101 11010100 - Invalid: the first byte indicates that it's the first of 2 bytes, but the second byte is not a continuation character
    because it does not start with "10".


    Problem: Write a method that validates whether a given multi-byte input is valid UTF-8.
    exmps:
            0xxxxxxx, 110xxxxx, 10xxxxxx, 11110xxx, 10xxxxxx, 10xxxxxx, 10xxxxxx
 0xxxxxxx, 0xxxxxxx, 10xxxxxx

 11000101, 11110010
*/
    public boolean isValid(byte[] words) {
        if (words == null || words.length == 0) {
            return false;
        }
        boolean isValid = true;
        int i = 0;
        // 11000000 = 192
        // 11100000 = 224
        // 11110000 = 240
        // 11111000 = 248
        while (i < words.length) {
            if (isValid == false) {
                return false;
            }
            if (words[i] > 248) {
                return false;
            }
            if (words[i] >= 240) {
                if (i + 3 < words.length) {
                    isValid = words[i + 1] >= 128 && words[i + 2] >= 128 && words[i + 3] >= 128;
                    i = i + 4;
                } else {
                    return false;
                }
            } else if (words[i] >= 224) {
                if (i + 2 < words.length) {
                    isValid = words[i + 1] >= 128 && words[i + 2] >= 128;
                    i = i + 3;
                } else {
                    return false;
                }
            } else if (words[i] >= 192) {
                if (i + 1 < words.length) {
                    isValid = words[i + 1] >= 128;
                    i = i + 2;
                } else {
                    return false;
                }
            } else if (words[i] <= 128) {
                i++;
            }

        }
        return isValid;
    }

    /*
int array => 1 2 2 2 2 3 4 5 5 6 .................. target number = 5

Give me freq of target number,
*/


/*
1-) Force
2-) Binary search 
3-) HashMap
*/

    public int getFreq(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int freq = 0;
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                freq++;
                int index = mid;
                while (mid > 0) {
                    if (arr[mid - 1] == arr[mid]) {
                        freq++;
                        mid--;
                    } else {
                        break;
                    }
                }
                while (index < arr.length) {
                    if (arr[index + 1] == arr[index]) {
                        freq++;
                        index++;
                    } else {
                        break;
                    }
                }
            }
        }
        return freq;
    }



/*

4 5 1 2 3 target= 2 findex of it, better than O(N)
 2 2 3 4 6 7 1
8 1 1 1 1 0 1 2

*/

//    public int getTarget(int[] arr, int target) {
//        if (arr == null || arr.length == 0) {
//            return 0;
//        }
//        int start = 0, end = arr.length - 1;
//        while (start < end) {
//            int mid = (start + end) / 2;
//            if (arr[mid] > target) {
//                if (arr[mid] > arr[mid - 1]) {
//                    end = mid;
//                } else {
//                    return -1;
//                }
//            } else if (arr[mid] < target) {
//                if (arr[mid + 1] > arr[mid]) {
//                    start = mid;
//                } else {
//                    return -1;
//                }
//
//            } else {
//                return mid;
//            }
//        }
//    }


}
