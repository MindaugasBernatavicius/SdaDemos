package cf.mindaugas.sdademos.codingfundamentals.algorithms.simple;

public class JobInterviewAlg {
    public static void main(String args[]) {

        String testStr = "AAABBCCCCV";
        int res1 = calcMaxNumberOfRepeatingLetters(testStr);
        System.out.println(res1);

        String[] testStrArr = {"AAABBCCCCV", "", "GGGGHHHH"};
        // String[] testStrArr = {""};
        String[] resArr = getStringsWithMaxNumberOfRepeatingLetters(testStrArr);
        for(String s : resArr)
            System.out.print(s + " ");
    }

    // a. Parašykite metodą, kuris priima tekstą kaip argumentą,
    // o grąžina daugiausiai iš eilės pasikartojančių raidžių skaičių.
    // Šiai užduoties daliai masyvai negali būti naudijami.
    private static int calcMaxNumberOfRepeatingLetters(String text){
        int max = 0;
        int counter = 1;

        // iterate over the text
        for (int i = 0; i < text.length(); i++) {
            // check for repetition or chars. Stop before last character
            if (i < text.length() - 1 && text.charAt(i) == text.charAt(i + 1)){
                counter++;
            } else{
                // when next char is different from current
                // check if we have a new max and reset counter
                if (counter > max) {
                    max = counter;
                }
                counter = 1;
            }
        }
        return max;
    }

    // b. Parašykite metodą, kuris priima tekstų masyvą kaip argumentą,
    // o grąžina masyvą tekstų, turinčių daugiausiai iš eilės pasikartojančių raidžių.
    private static String[] getStringsWithMaxNumberOfRepeatingLetters(String[] strings){
        int max = 0, currentMax, maxCounter = 0, currentMaxPossition = 0;

        // calculate the max, where the first max is and how many there are
        for(int i = 0; i < strings.length; i++){
            currentMax = calcMaxNumberOfRepeatingLetters(strings[i]);
            if(max < currentMax){
                max = currentMax;
                currentMaxPossition = i;
                maxCounter = 1;
            } else if (max == currentMax) {
                maxCounter++;
            }
        }

        // initialize the result array and assign the first max
        String[] res = new String[maxCounter];
        res[0] = strings[currentMaxPossition];

        // if there are more string with max repeated chars - find them
        if(maxCounter > 1){
            int possitionInRes = 1;
            for(int i = currentMaxPossition + 1; i < strings.length; i++){
                if(calcMaxNumberOfRepeatingLetters(strings[i]) == max){
                    res[possitionInRes] = strings[i];
                    possitionInRes++;
                }
            }
        }

        return res;
    }
}