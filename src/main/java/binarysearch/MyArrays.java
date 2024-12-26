package binarysearch;

import java.util.Comparator;

/**
 * Класс MyArrays предоставляет методы для выполнения бинарного поиска
 * в массивах примитивных типов и объектов. Реализация аналогична стандартному
 * классу Arrays, но включает пользовательские методы.
 */
public class MyArrays {

    /**
     * Обобщенный метод для выполнения бинарного поиска в массивах примитивных типов.
     * @param array массив для поиска
     * @param fromIndex начальный индекс (включительно)
     * @param toIndex конечный индекс (исключительно)
     * @param key ключ для поиска
     * @param comparator интерфейс для сравнения элементов
     * @param <T> тип элементов массива
     * @return индекс найденного ключа или отрицательное значение, если ключ не найден
     */
    @SuppressWarnings("unchecked")
    private static <T> int binarySearchGeneric(T array, int fromIndex, int toIndex, T key, ComparePrimitive<T> comparator) {
        if (fromIndex > toIndex || fromIndex < 0 || toIndex > java.lang.reflect.Array.getLength(array)) {
            throw new IllegalArgumentException("Invalid range: [" + fromIndex + ", " + toIndex + "]");
        }

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = comparator.compare(java.lang.reflect.Array.get(array, mid), key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    @FunctionalInterface
    private interface ComparePrimitive<T> {
        int compare(Object o1, Object o2);
    }
    // 1. Byte array
    public static int binarySearch(byte[] a, byte key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 2. Byte array (from-to)
    public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) {
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> Byte.compare((byte) o1, (byte) o2));
    }

    // 3. Char array
    public static int binarySearch(char[] a, char key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 4. Char array (from-to)
    public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) {
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> Character.compare((char) o1, (char) o2));
    }


    // 5. Double array
    public static int binarySearch(double[] a, double key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 6. Double array (from-to)
    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> Double.compare((double) o1, (double) o2));
    }

    // 7. Float array
    public static int binarySearch(float[] a, float key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 8. Float array (from-to)
    public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) {
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> Float.compare((float) o1, (float) o2));
    }
    // 9. Int array
    public static int binarySearch(int[] a, int key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 10. Int array (from-to)
    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> Integer.compare((int) o1, (int) o2));
    }

    // 11. Long array
    public static int binarySearch(long[] a, long key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 12. Long array (from-to)
    public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) {
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> Long.compare((long) o1, (long) o2));
    }

    // 13. Short array
    public static int binarySearch(short[] a, short key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 14. Short array (from-to)
    public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) {
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> Short.compare((short) o1, (short) o2));
    }

    // 15. Generic objects using Comparator
    public static <T> int binarySearch(T[] a, T key, Comparator<? super T> c) {
        return binarySearch(a, 0, a.length, key, c);
    }

    // 16. Generic objects using Comparator (from-to)
    public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c) {
        if (a == null || c == null || key == null) {
            throw new NullPointerException("Array, comparator, or key is null");
        }
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> c.compare((T) o1, (T) o2));
    }

    // 17. Generic objects using Comparable
    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T key) {
        return binarySearch(a, 0, a.length, key);
    }

    // 18. Generic objects using Comparable (from-to)
    public static <T extends Comparable<? super T>> int binarySearch(T[] a, int fromIndex, int toIndex, T key) {
        if (a == null || key == null) {
            throw new NullPointerException("Array or key is null");
        }
        return binarySearchGeneric(a, fromIndex, toIndex, key, (o1, o2) -> ((T) o1).compareTo((T) o2));
    }

}
