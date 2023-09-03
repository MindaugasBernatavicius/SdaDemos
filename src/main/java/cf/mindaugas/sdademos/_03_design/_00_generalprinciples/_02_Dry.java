package cf.mindaugas.sdademos._03_design._00_generalprinciples;

public class _02_Dry {
    // DRY with functions
    public static void bubbleSortAsc(Person arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].age > arr[j + 1].age) {
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDesc(Person arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].age < arr[j + 1].age) {
                    Person temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDry(Person arr[], boolean reverse) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (reverse) {
                    if (arr[j].age > arr[j + 1].age) {
                        Person temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j].age < arr[j + 1].age) {
                        Person temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    // ... w/ even DRY'er with comparator
}

class Person {
    int age;
}


// DRY with Classes
// 1. no inheritance
// class Tiger {
//     int age;
//     String name;
// }
//
// class Lion {
//     int age;
//     String name;
// }
//
// class Puma {
//     int age;
//     String name;
// }


// 2. w/ inheritance
class WildCat {
    int age;
    String name;
}

class Tiger extends WildCat {
}

class Lion extends WildCat {
}

class Puma extends WildCat {
}

