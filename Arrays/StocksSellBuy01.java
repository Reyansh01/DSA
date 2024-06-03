package Arrays;

public class StocksSellBuy01 {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 7, 4, 9, 3};
        System.out.println(buyAndSell(arr));
    }

    public static int buyAndSell(int[] arr) {
        int maxProf = 0;
        int minSoFar = arr[0];
        for(int i = 0; i < arr.length; i++) {
            minSoFar = Math.min(minSoFar, arr[i]);
            int profit = arr[i] - minSoFar;
            maxProf = Math.max(maxProf, profit);
        }
        return maxProf;
    }

}
