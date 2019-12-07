package cf.mindaugas.sdademos.design.generalprinciples;

public class _02_Dry {

    public static void bubbleSortAsc(Person arr[]){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j].age > arr[j+1].age){
                    Person temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortDesc(Person arr[]){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j].age > arr[j+1].age){
                    Person temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // ... vs.

    public static void bubbleSortDry(Person arr[], boolean reverse){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if(reverse){
                    if (arr[j].age > arr[j+1].age){
                        Person temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                } else {
                    if (arr[j].age < arr[j+1].age){
                        Person temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }

            }
        }
    }
}

class Person {
    int age;
}
