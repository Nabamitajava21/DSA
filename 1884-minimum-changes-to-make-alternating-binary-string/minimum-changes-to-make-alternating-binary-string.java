class Solution {
    public int minOperations(String s) {
              //Nabamita
        int countStartWithZero = 0;
        int countStartWithOne = 0;

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            
            if (current != (i % 2 == 0 ? '0' : '1')) {
                countStartWithZero++;
            }

          
            if (current != (i % 2 == 0 ? '1' : '0')) {
                countStartWithOne++;
            }
        }

        return Math.min(countStartWithZero, countStartWithOne);
    }
}