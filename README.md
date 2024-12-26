# Проект Binary Search

## Описание
Проект представляет собой реализацию пользовательских классов `MyArrays` и `MyCollections`, предоставляющих методы бинарного поиска, аналогичные стандартным классам `Arrays` и `Collections` из Java. Реализация охватывает массивы примитивных типов, массивы объектов с использованием `Comparable` и `Comparator`, а также списки (`List<T>`).

## Возможности
- **Бинарный поиск в массивах примитивных типов**: поддерживаются типы `int`, `byte`, `char`, `double`, `float`, `long`, `short`.
- **Бинарный поиск в массивах объектов**: поддержка естественного порядка через `Comparable` и пользовательского порядка через `Comparator`.
- **Бинарный поиск в списках**: поддержка как естественного порядка (`Comparable`), так и пользовательского (`Comparator`).

## Структура проекта
```
src/
├── main/
│   ├── java/
│   │   ├── binarysearch/
│   │   │   ├── MyArrays.java
│   │   │   ├── MyCollections.java
│   │   ├── tests/
│   │   │   ├── MyArraysTest.java
│   │   │   ├── MyCollectionsTest.java
```

## Как использовать

### Компиляция
Для компиляции всех файлов выполните следующую команду:
```bash
javac src/main/java/binarysearch/*.java src/main/java/tests/*.java -d out
```

### Запуск тестов
Для запуска тестов выполните:
```bash
java -cp out tests.MyArraysTest
java -cp out tests.MyCollectionsTest
```

## Примеры использования

### Использование `MyArrays`
Пример бинарного поиска в массиве целых чисел:
```java
int[] intArray = {1, 3, 5, 7, 9};
int index = MyArrays.binarySearch(intArray, 5);
System.out.println("Индекс: " + index); // Вывод: Индекс: 2
```

Пример с использованием массива объектов и компаратора:
```java
String[] stringArray = {"apple", "banana", "cherry", "date"};
Comparator<String> reverseComparator = Comparator.reverseOrder();
Arrays.sort(stringArray, reverseComparator);
int index = MyArrays.binarySearch(stringArray, "banana", reverseComparator);
System.out.println("Индекс: " + index); // Вывод: Индекс: 1
```

### Использование `MyCollections`
Пример бинарного поиска в списке:
```java
List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9);
int index = MyCollections.binarySearch(intList, 5);
System.out.println("Индекс: " + index); // Вывод: Индекс: 2
```

Пример с пользовательским компаратором:
```java
List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date");
Comparator<String> reverseComparator = Comparator.reverseOrder();
List<String> reverseSortedList = new ArrayList<>(stringList);
reverseSortedList.sort(reverseComparator);
int index = MyCollections.binarySearch(reverseSortedList, "date", reverseComparator);
System.out.println("Индекс: " + index); // Вывод: Индекс: 0
```

## Лицензия
Этот проект распространяется под лицензией MIT. Вы можете использовать, изменять и распространять его с указанием автора.