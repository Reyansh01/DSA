package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxAvgScore {

    public static void main(String[] args) {
        String scores[][] = {{"jerry", "65"}, {"bob","91"}, {"jerry","23"}, {"Eric","83"},{"Eric","99"}};
        Student student = maxAvgScore(scores);
        System.out.println("topStudent: " + student.getName() + " with highest score: " + student.getAvgScore());
    }

    private static Student maxAvgScore(String[][] scores) {
        Map<String, List<Integer>> studentScores = new HashMap<>();
        for(int i = 0; i < scores.length; i++) {
            studentScores.putIfAbsent(scores[i][0], new ArrayList<>());
            studentScores.get(scores[i][0]).add(Integer.parseInt(scores[i][1]));
        }

        double highestAvg = 0;
        String topStudent = null;

        for(Map.Entry<String, List<Integer>> entry: studentScores.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
            String student = entry.getKey();

            double average = entry.getValue().stream()
            .mapToInt(Integer::intValue).average().orElse(0);
            if((average > highestAvg) || (average == highestAvg && topStudent.compareTo(student) < 0)) {
                highestAvg = average;
                topStudent = student;
            }
        }

        return new Student(topStudent, highestAvg);
    }

    public static class Student {
        private double avgScore;
        private String name;

        public Student(String name, double avgScore) {
            this.name = name;
            this.avgScore = avgScore;
        }

        public double getAvgScore() {
            return avgScore;
        }

        public void setAvgScore(double avgScore) {
            this.avgScore = avgScore;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
