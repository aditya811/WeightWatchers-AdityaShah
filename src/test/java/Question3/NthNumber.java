package Question3;

import java.util.Arrays;
import java.util.Random;

/**
 * @author  Aditya Shah
 * @version 1.0
 *
 */
public class NthNumber {

    public static void main(String[]args){
        System.out.println(getNthSmallest(5));
    }


    public static int getNthSmallest(int n){
        Random random = new Random();
        int[] randArray = new int[500];

        for(int i=0; i<500; i++){
            randArray[i] = random.nextInt(5000)+1;
        }
        Arrays.sort(randArray);
        return randArray[n-1];

    }
}
