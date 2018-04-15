import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        CustomArrayList<Integer> arrayList = new CustomArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        System.out.println(arrayList.get(0) + ":" + arrayList.get(1) + ":" + arrayList.get(2));
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("first", 1);
        customHashMap.put("second", 2);
        System.out.println(customHashMap.get("first"));
        System.out.println(customHashMap.get("unfirst"));
    }
}
