package class01;

public class Test {

    public static void main(String[] args) {
        int a = 6;
        int b = 6;


        //交换两个数  例如a=甲；b=乙
        a = a ^ b;  // a=甲 ^ 乙;
        b = a ^ b;  // b=甲 ^ 乙 ^ 乙=甲;
        a = a ^ b;  // a=甲 ^ 乙 ^ 甲=乙;


        System.out.println(a);
        System.out.println(b);


        int[] arr = {3, 1, 100};

        System.out.println(arr[0]);
        System.out.println(arr[2]);

        //不能写两个一样的内存地址
        swap(arr, 0, 0);

        System.out.println(arr[0]);
        System.out.println(arr[2]);


    }


    public static void swap(int[] arr, int i, int j) {
        // arr[0] = arr[0] ^ arr[0];
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
