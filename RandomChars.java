public class RandomChars {
    public static void main(String[] args) {
        System.out.print("\n");
        generateNums();
        System.out.print("\n");
    }
    public static void generateNums() {
        char letter = 65;
	// Extra variable totalChars to keep count of characters
	int totalChars = 0;
        int upperCaseLetters[] = new int[26];
        for (int i = 0; i < 1000; i++) {
            int randomNum = (int) (Math.random() * 26) + 65;
            upperCaseLetters[randomNum - 65] += 1;
        }
        for (int i = 0; i < upperCaseLetters.length; i++){
            System.out.printf("\n%c : %d", letter, upperCaseLetters[i]);
            letter += 1;
	    // Extra Line to accumulate number of Characters.
	    totalChars += upperCaseLetters[i];
        }
	// Prints numbers of characters
	System.out.printf("\n\nTotal Characters: %d\n", totalChars);
    }
}
