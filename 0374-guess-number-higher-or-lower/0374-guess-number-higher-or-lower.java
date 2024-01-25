
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n, mid = 1;
        while(low<=high){
            mid = low + (high-low)/2;
            int g = guess(mid);
            if(g==0)
                return mid;
            else if(g == 1)
                low = ++mid;
            else
                high = --mid;
        }
        return mid;
    }
}