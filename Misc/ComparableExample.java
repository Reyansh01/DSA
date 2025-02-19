package Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FriendComparable implements Comparable<FriendComparable> {

    private String name;
    private String grade;

    public FriendComparable(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    private static Map<String, Integer> gradeValueMap = new HashMap<>();

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
    public int compareTo(FriendComparable otherFriend) {
        return Integer.compare(gradeValueMap.get(this.getGrade()), gradeValueMap.get(otherFriend.getGrade()));
    }

    @Override
    public String toString() {
        return "Friend{name='" + name + "', grade='" + grade + "'}";
    }

}

public class ComparableExample {

    public static void main(String[] args) {
        List<FriendComparable> friends = new ArrayList<>();
        friends.add(new FriendComparable("Alice", "B"));
        friends.add(new FriendComparable("Bob", "A"));
        friends.add(new FriendComparable("Charlie", "A+"));

        System.out.println("Before sorting:");
        for (FriendComparable friend : friends) {
            System.out.println(friend);
        }

        Collections.sort(friends);

        System.out.println("\nAfter sorting:");
        for (FriendComparable friend : friends) {
            System.out.println(friend);
        }
    }

}
