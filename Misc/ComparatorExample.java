package Misc;
    
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Friend {
    private String name;
    private String grade;

    public Friend(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Friend{name='" + name + "', grade='" + grade + "'}";
    }
}

class ComparatorExample implements Comparator<Friend> {
    private static final Map<String, Integer> gradeValueMap = new HashMap<>();
    static {
        gradeValueMap.put("A+", 1);
        gradeValueMap.put("A", 2);
        gradeValueMap.put("A-", 3);
        gradeValueMap.put("B+", 4);
        gradeValueMap.put("B", 5);
        gradeValueMap.put("B-", 6);
        gradeValueMap.put("C+", 7);
        gradeValueMap.put("C", 8);
        gradeValueMap.put("C-", 9);
        gradeValueMap.put("D+", 10);
        gradeValueMap.put("D", 11);
        gradeValueMap.put("D-", 12);
        gradeValueMap.put("F", 13);
    }

    @Override
    public int compare(Friend f1, Friend f2) {
        return Integer.compare(gradeValueMap.get(f1.getGrade()), gradeValueMap.get(f2.getGrade()));
    }


    public static void main(String[] args) {
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Alice", "B"));
        friends.add(new Friend("Bob", "A"));
        friends.add(new Friend("Charlie", "A+"));

        System.out.println("Before sorting:");
        for (Friend friend : friends) {
            System.out.println(friend);
        }

        // Collections.sort(friends, new Comparator<>() {
        //     @Override
        //     public int compare(Friend f1, Friend f2) {
        //         return Integer.compare(gradeValueMap.get(f1.getGrade()), gradeValueMap.get(f2.getGrade()));
        //     }
        // });

        Collections.sort(friends, new ComparatorExample());

        System.out.println("\nAfter sorting:");
        for (Friend friend : friends) {
            System.out.println(friend);
        }
    }

}
