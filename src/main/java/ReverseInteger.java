public class ReverseInteger {
    public static void main(String[] args) {
        int original = 12300;
        int reversed = 0;

        while(original != 0){
            reversed = reversed * 10 + original % 10;
            original = original / 10;
        }

        System.out.println(reversed);
    }
}
