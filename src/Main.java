import java.util.Arrays;

public class Main {
    private static int[] b;

    public static void main(String[] args) {
        int[] a = {5, 2, 4, 6, 1, 3, 2, 6};

        sort(a, 1, a.length);

    }

    private static void sort(int[] a, int p, int r) {

        if (p < r) {
            int q = (p + r) / 2;
            sort(a, 1, q);
            sort(a, q + 1, r);
            b = merge(a, p, q, r);
        }
    }

    private static int[] merge(int[] a, int p, int q, int r) {
        int size = a.length;
        if (size == 1) {
            return a;
        }
        int[] left = Arrays.copyOfRange(a, 0, r / 2);
        int[] right = Arrays.copyOfRange(a, r / 2, r);
        int[] leftSorted = merge(left, p, (p + left.length) / 2, left.length);
        int[] rightSorted = merge(right, p, (p + right.length) / 2, right.length);
        return sortMerge(leftSorted, rightSorted);
    }

    private static int[] sortMerge(int[] t0, int[] t1) {
        int it0 = 0;
        int it1 = 0;
        int iMerge = 0;
        int[] merged = new int[t0.length + t1.length];

        while (it0 < t0.length || it1 < t1.length) {
            if (it0 == t0.length) {
                merged[iMerge] = t1[it1];
                it1++;
            } else if (it1 == t1.length) {
                merged[iMerge] = t0[it0];
                it0++;
            } else {
                if (t0[it0] <= t1[it1]) {
                    merged[iMerge] = t0[it0];
                    it0++;
                } else {
                    merged[iMerge] = t1[it1];
                    it1++;
                }
            }
            iMerge++;
            if (iMerge > merged.length) {
                break;
            }
        }
        return merged;
    }
}