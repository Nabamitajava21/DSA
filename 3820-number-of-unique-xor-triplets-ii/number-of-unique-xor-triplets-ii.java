class Solution {
    public int uniqueXorTriplets(int[] nums) {
        //Nabamita
        boolean[] present = new boolean[2048];

        
        for (int num : nums) {
            present[num] = true;
        }

        
        int[] values = new int[2048];
        int m = 0;
        for (int i = 0; i < 2048; i++) {
            if (present[i]) {
                values[m++] = i;
            }
        }

        
        boolean[] pairXor = new boolean[2048];

        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                pairXor[values[i] ^ values[j]] = true;
            }
        }

       
        boolean[] tripletXor = new boolean[2048];

        for (int i = 0; i < 2048; i++) {
            if (pairXor[i]) {
                for (int j = 0; j < m; j++) {
                    tripletXor[i ^ values[j]] = true;
                }
            }
        }

       
        int ans = 0;
        for (boolean x : tripletXor) {
            if (x) ans++;
        }

        return ans;
    }
}
    
