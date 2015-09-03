package Collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class CollectionsAddAll {
 
    public static void main(String a[]){
         
        List<String> myList = new ArrayList<String>();
        myList.add("java");
        myList.add("c");
        myList.add("c++");
        System.out.println("Initial list:"+myList);
        Collections.addAll(myList, "perl","php");
        System.out.println("After adding elements:"+myList);
        String[] strArr = {".Net", "unix"};
        Collections.addAll(myList, strArr);
        System.out.println("After adding array:"+myList);
    }
}
