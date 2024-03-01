import java.util.HashMap;
import java.util.Scanner;

public class Marks {

    public HashMap getMarks(){
        HashMap<String, Integer> marks = new HashMap<>();
        marks.put("Physics", 90);
        marks.put("Maths", 70);
        marks.put("Chemistry", 40);
        marks.put("Computer Science", 95);

        return marks;
    }

    public int getMarksBySub(String subject){
        HashMap<String, Integer> marks = getMarks();
        int mark = 0;
        if (subject.isEmpty()){
            throw new NullPointerException("Input should not be empty!");
        }
        if (!marks.containsKey(subject)){
            throw new NullPointerException("No such subject!");
        } else {
            mark = marks.get(subject);
        }
        return mark;
    }
}
