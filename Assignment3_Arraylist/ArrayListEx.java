import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args){
        ArrayList<Integer> intArrList = new ArrayList<Integer>();
        intArrList.add(3);
        intArrList.add(6);
        //int[] arr = new int[]{18, 21, 24, 27, 30};
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(21);
        list2.add(24);
        list2.add(27);
        intArrList.addAll(list2);

        intArrList.forEach(i -> System.out.println(i));

        /*for (Integer i : intArrList){
            System.out.println(i);*/
        
        ArrayList<String> words = new ArrayList<String>();
        words.add("One");
        words.add("fish");
        words.add("Two");
        words.add("fish");
        boolean c = words.contains("Two");
            for (String s : words){
                System.out.println(s);

        

        }
    }
}
