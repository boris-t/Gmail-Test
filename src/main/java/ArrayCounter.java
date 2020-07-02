public class ArrayCounter {

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{0, 1, 3, 4}));
    }

    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }
}
