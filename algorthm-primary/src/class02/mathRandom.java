package class02;

public class mathRandom {
    public static void main(String[] args) {
        // Math.random() -> double -> [0,1)  0.4025083375524148  等概率的返回
        System.out.println(Math.random());

        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("------------------------------------------------");

        // [0,1) -> [0,8)
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);  // 0.6250669
        System.out.println((double) 5 / (double) 8);  // 0.625


        // 返回 [0,8]等概率返回任意一个整数
        int K = 9;
        // [0,K) -> [0,8]
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            int ans = (int) (Math.random() * K); // [0,K-1]
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }
        /*
        0这个数，出现了 1110090 次
        1这个数，出现了 1110319 次
        2这个数，出现了 1112852 次
        3这个数，出现了 1110384 次
        4这个数，出现了 1111769 次
        5这个数，出现了 1112197 次
        6这个数，出现了 1111370 次
        7这个数，出现了 1111795 次
        8这个数，出现了 1109224 次
        */

        System.out.println("=========");

        count = 0;
        double x = 0.17;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println("平方的测试" + (double) count / (double) testTimes);
        System.out.println(Math.pow(x, 2));
        // System.out.println((double) 1 - Math.pow((double) 1 - x, 2));

        System.out.println(y());
    }

    // 返回[0,1)的一个小数
    // 任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
    // 要求两次都落在0-x范围上，就是x*x
    public static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }
    //    public static double xToXPower2() {
    //        return Math.min(Math.random(), Math.random());
    //    }

    // lib里的，不能改！ [0,5]  等概率返回[1,5]
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    // 随机机制，只能用f1，等概率返回0和1,各50%
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 得到二进制000 ~ 111，三次调用f2()形成一个3位数的2进制 做到等概率 0 ~ 7等概率返回一个
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + f2();
    }

    // 0 ~ 6等概率返回一个
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    //	等概率得到1~7
    public static int g() {
        return f4() + 1;
    }



    // 你只能知道，x会以固定概率返回0和1，但是x的内容，你看不到！
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 等概率返回0和1
    // 调用两次x()如果是一样的就重做
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        //	ans=0  1
        //	ans=1  0
        return ans;
    }
}
