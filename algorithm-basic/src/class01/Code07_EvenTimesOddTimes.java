package class01;

public class Code07_EvenTimesOddTimes {

    //  数组中有一个数出现了奇数次，其他的数都是偶数次，怎么找到这个出现奇数次的数
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // 数组中有2个数出现了奇数次，其他的数都是偶数次，怎么找到这2个出现奇数次的数
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //假设是a、b两个数是奇数，则最终的结果一定是 eor = a ^ b
        // eor != 0  eor必然有一个位置上是1
        // 0110010000
        // 0000010000
        int rightOne = eor & (~eor + 1); // 提取出最右的1
        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            //  arr[1] =  111100011110000
            // rightOne=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    // 记录一个数中 1出现的个数
    public static int bit1counts(int N) {
        int count = 0;

        //   011011010000
        //   000000010000     1

        //   011011000000
        //

        while (N != 0) {
            int rightOne = N & ((~N) + 1);
            count++;
            N ^= rightOne;
        }

        return count;

    }


    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        //交换两个数  例如a=甲；b=乙
        a = a ^ b;  // a=甲 ^ 乙;
        b = a ^ b;  // b=甲 ^ 乙 ^ 乙=甲;
        a = a ^ b;  // a=甲 ^ 乙 ^ 甲=乙;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        printOddTimesNum2(arr2);

    }

}
