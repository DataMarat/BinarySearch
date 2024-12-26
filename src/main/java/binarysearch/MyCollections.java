package binarysearch;

import java.util.Comparator;
import java.util.List;

/**
 * Класс MyCollections предоставляет методы для выполнения бинарного поиска
 * в списках. Реализация поддерживает естественный порядок элементов (Comparable)
 * и пользовательский порядок с использованием Comparator.
 */
public class MyCollections {

    /**
     * Выполняет бинарный поиск в списке с использованием естественного порядка элементов (Comparable).
     *
     * @param list список для поиска
     * @param key  ключ для поиска
     * @param <T>  тип элементов списка (должен реализовывать Comparable)
     * @return индекс найденного ключа или отрицательное значение, если ключ не найден
     * @throws NullPointerException если список или ключ равен null
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T key) {
        if (list == null || key == null) {
            throw new NullPointerException("List or key is null");
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Ключ найден
            }
        }
        return -(low + 1); // Ключ не найден
    }

    /**
     * Выполняет бинарный поиск в списке с использованием пользовательского порядка (Comparator).
     *
     * @param list       список для поиска
     * @param key        ключ для поиска
     * @param comparator компаратор для сравнения элементов
     * @param <T>        тип элементов списка
     * @return индекс найденного ключа или отрицательное значение, если ключ не найден
     * @throws NullPointerException если список, ключ или компаратор равен null
     */
    public static <T> int binarySearch(List<T> list, T key, Comparator<? super T> comparator) {
        if (list == null || key == null || comparator == null) {
            throw new NullPointerException("List, comparator, or key is null");
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = comparator.compare(midVal, key);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid; // Ключ найден
            }
        }
        return -(low + 1); // Ключ не найден
    }
}
