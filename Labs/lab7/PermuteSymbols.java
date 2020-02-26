public class PermuteSymbols {
    private int permuteSymbols(int a, int b, int c, int wild) {
                 
        // Base Case: No more "wild" symbols to distribute
        if(wild == 0) return a * a + b * b + c * c + Math.min(Math.min(a,b),c) * 7;
         
        int max = 0;
         
        // For each possible permutation of the three science symbols
        max = Math.max(permuteSymbols(a + 1, b    , c    , wild - 1), max);
        max = Math.max(permuteSymbols(a    , b + 1, c    , wild - 1), max);
        max = Math.max(permuteSymbols(a    , b    , c + 1, wild - 1), max);
         
        return max;
         
    }
    public static void main(String args[]) {
        // hello  
    }    
}