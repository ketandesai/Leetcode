import java.util.ArrayList;

public class FindDuplicates {

    static int[] arr = new int[]{1, 2, 2, 3, 1};
    static ArrayList duplicates = new ArrayList<>();
    public static void main(String args[]){
        for (int i =0; i < arr.length; i++){
            if (arr[Math.abs(arr[i]) ] == 0 ){
                arr[i] = arr.length * -1;
            }
            else if (arr[Math.abs(arr[i]) ] < 0 ) {
                duplicates.add(Math.abs(arr[i]));
            }else if (arr[Math.abs(arr[i]) ] > 0 ) {
                arr[Math.abs(arr[i])] = -1 * arr[Math.abs(arr[i]) ];
            }
            System.out.println(arr[i]);

        }
        System.out.println("Duplicates = " + duplicates);

    }


}
