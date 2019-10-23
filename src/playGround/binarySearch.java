package playGround;

public class binarySearch {
    static int findElement(int[] array, int target) {
        int pivot, left = 0, right = array.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (array[pivot] == target) {
                return pivot;
            }
            if (array[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

    static int findFirstElementNotLessThanTarget(int[] array, int target) {
        int pivot, left = 0, right = array.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (array[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return right;
    }

    static int findFirstElemenGreaterThanTarget(int[] array, int target) {
        int pivot, left = 0, right = array.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (array[pivot] <= target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return (right + 1 > array.length - 1) ? -1 : right + 1;
    }

    static int findFirstElemenGreaterThanTarget2(int[] array, int target) {
        int pivot, left = 0, right = array.length;
        while (left < right) {
            pivot = left + (right - left) / 2;
            if (array[pivot] <= target) {
                left = pivot + 1;
            } else {
                right = pivot ;
            }
        }
        return (right > array.length - 1) ? -1 : right;
    }

    public static void main(String[] args) {
        int[] t1 = {1, 2, 2, 3, 4, 5};
        int[] t2 = {1, 2, 2, 3, 3,  3, 4, 5};

        System.out.println(findElement(t1, 3));
        System.out.println(findElement(t2, 3));
        System.out.println("-----------------------------------");
        System.out.println(findFirstElementNotLessThanTarget(t1, 4));
        System.out.println(findFirstElementNotLessThanTarget(t2, 4));
        System.out.println("-----------------------------------");

        System.out.println(findFirstElemenGreaterThanTarget(t1, 4));
        System.out.println(findFirstElemenGreaterThanTarget(t2, 4));
        System.out.println(findFirstElemenGreaterThanTarget(t1, 5));
        System.out.println(findFirstElemenGreaterThanTarget(t2, 5));
        System.out.println("-----------------------------------");
        System.out.println(findFirstElemenGreaterThanTarget2(t1, 4));
        System.out.println(findFirstElemenGreaterThanTarget2(t2, 4));
        System.out.println(findFirstElemenGreaterThanTarget2(t1, 5));
        System.out.println(findFirstElemenGreaterThanTarget2(t2, 5));

    }
}
