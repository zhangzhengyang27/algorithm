package class08;

//归并排序 递归方法实现
public class MergeSort1 {

    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上，请让这个范围上的数，有序！
    public static void process(int[] arr, int L, int R) {
        //只有一个数
        if (L == R) {
            return;
        }
        // int mid = (L + R) / 2  如果数据过大，数值会越界
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        //两个有序的合并
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {

        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L; // p1指向左边数组
        int p2 = M + 1;

        //存在一组已经全部放进去了，另外一组还剩很多的数据
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 要么p1越界，要么p2越界
        // 不可能出现：共同越界
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    //  步长为1、步长为2、 步长为4、8、16.....n    时间复杂度n*logn
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int step = 1;
        int N = arr.length;
        while (step < N) {
            // L是左边的起始位置
            int L = 0;
            while (L < N) {
                int M = 0;
                // 末尾最后一组还剩几个数；这样处理是避免越界
                if (N - L >= step) {
                    M = L + step - 1;
                } else {
                    M = N - 1;
                }
                if (M == N - 1) {
                    break;
                }
                int R = 0;
                // （N-1）-（M+1）+1
                if (N - 1 - M >= step) {
                    R = M + step;
                } else {
                    R = N - 1;
                }
                merge(arr, L, M, R);
                // 如果还越界
                if (R == N - 1) {
                    break;
                } else {
                    L = R + 1;
                }
            }
            // 怕数值越界 N / 2会向下取整
            if (step > N / 2) {
                break;
            }
            step *= 2;
        }

    }

    //	---------------------------------------------------------------------
    // 生成随机的数组 for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // 深拷贝一个数组
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
