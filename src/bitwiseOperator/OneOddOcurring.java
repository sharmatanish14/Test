package bitwiseOperator;

import java.util.HashMap;
import java.util.Map;

public class OneOddOcurring {
    public static void main(String[] args) {
        int arr[] = {4, 3, 4, 4, 4, 5, 5};

        System.out.println(getOddOcurringNumber3(arr));

    }

    private static int getOddOcurringNumber(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count % 2 != 0) {
                return arr[i];
            }
        }

        return -1;
    }

    private static int getOddOcurringNumber2(int arr[]) {

        Map<Integer, Integer> map =new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()%2!=0){
                return entry.getKey();
            }
        }
        return -1;

    }

    private static int getOddOcurringNumber3(int arr[]){

        int res=0;

        for(int i=0;i<arr.length;i++){
            res = res ^ arr[i];
        }

        return res;
    }
}
