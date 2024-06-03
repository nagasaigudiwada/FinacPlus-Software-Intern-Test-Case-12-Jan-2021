/*
Write a special cipher that is a combination of Caesar’s cipher followed by a simple
RLE. The function should receive a string and the rotation number as parameters.
Input: special Cipher(“AABCCC”, 3) Output: D2EF3
  */



public class Caesarcipher {
    public static void main(String[] args) {
        String input = "AABCCC";
        int rotation = 3;
        String result = specialCipher(input, rotation);
        System.out.println(result);  
    }

    public static String specialCipher(String input, int rotation) {
        StringBuilder caesarCiphered = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (c + rotation);
                if (Character.isUpperCase(c) && shifted > 'Z' || Character.isLowerCase(c) && shifted > 'z') {
                    shifted -= 26;
                }
                caesarCiphered.append(shifted);
            } else {
                caesarCiphered.append(c);
            }
        }

        StringBuilder encoded = new StringBuilder();
        int count = 1;
        for (int i = 1; i < caesarCiphered.length(); i++) {
            if (caesarCiphered.charAt(i) == caesarCiphered.charAt(i - 1)) {
                count++;
            } else {
                encoded.append(caesarCiphered.charAt(i - 1));
                if (count > 1) {
                    encoded.append(count);
                }
                count = 1;
            }
        }
        encoded.append(caesarCiphered.charAt(caesarCiphered.length() - 1));
        if (count > 1) {
            encoded.append(count);
        }

        return encoded.toString();
    }
}
