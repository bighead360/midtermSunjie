/**
 * Created by <a href="davidsunjie.sun@gmail.com">jerrysun</a> on 5/18/16.
 */
public class ChangesApp {

    int quarter = 25;
    int dime = 10;
    int nickel = 5;
    int penny = 1;

    static int[] coins = {1,5,10,25};



    static int numberOfWaysToMakeExactChange(int [] coins, int i, int amount){
        if(amount==0){
            return 1;
        }
        if(i < 0){
            return 0;
        }
        if(amount < coins[i]){
            return numberOfWaysToMakeExactChange(coins, i-1, amount);
        }else{
            return numberOfWaysToMakeExactChange(coins, i-1, amount) + numberOfWaysToMakeExactChange(coins, i, amount-coins[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeExactChange(coins,3,10));
    }
}
