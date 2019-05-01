import java.util.ArrayList;
import java.util.List;

public class AddOne {

    public static void main(String[] ar) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(6);
        a.add(0);
        a.add(6);
        a.add(4);
        a.add(8);
        a.add(8);
        a.add(1);


        //System.out.println(a);
        //System.out.println(plusOne(a));

        final List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);

        //System.out.println(repeatedNumber(list));


        System.out.println(generate(5));

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        int i = 0;
        while (i < a.size() - 1 && a.get(i) == 0) {
            a.remove(i);
            // i++;
        }
        int carry = 1;

        for (int j = a.size() - 1; j >= 0; j--) {
            int sum = a.get(j) + carry;
            a.set(j, sum % 10);
            carry = sum / 10;


        }

        if (carry > 0) {
            a.add(0, carry);
        }
        return a;
    }


    public static ArrayList<Integer> repeatedNumber(final List<Integer> list) {

        int repeated = 0;
        int missing = 0;
        for (int i = 0; i < list.size(); i++) {
            int index = Math.abs(list.get(i));
            if (list.get(index - 1) < 0) {
                repeated = index;
            } else {
                list.set(index - 1, -list.get(index - 1));
            }

        }

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) > 0) {
                missing = j + 1;
                break;
            }
        }

        ArrayList<Integer> a = new ArrayList<>();

        a.add(repeated);
        a.add(missing);

        return a;


    }

    public static ArrayList<ArrayList<Integer>> generate(int n) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        arr.add(temp);
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(1);
            for (int j = 0; j<temp.size()-1;j++){
                temp1.add(temp.get(j)+ temp.get(j+1));
            }
            temp1.add(1);

            arr.add(temp1);
            temp = temp1;

        }

        return arr;
    }
}
