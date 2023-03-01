import com.maria.yandex30.BeautifulString;
import com.maria.yandex30.Histogram;

public class Main {

    public static void main(String[] args) {
//        int max = BeautifulString.countLongest();
//        System.out.println(max);
    }

    public static void print(Object s){
        System.out.println(s);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(',');
            }

        }
        System.out.println();
    }

}
