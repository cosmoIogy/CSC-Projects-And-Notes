import java.util.*;

class Student {
    String name;
    List<String> preferredGroupMates;
    List<Integer> preferenceScores;
    List<String> haters;
    List<Integer> haterScores;

    public Student(String name) {
        this.name = name;
        this.preferredGroupMates = new ArrayList<>();
        this.preferenceScores = new ArrayList<>();
        this.haters = new ArrayList<>();
        this.haterScores = new ArrayList<>();
    }

    public void addPreference(String studentName, int score) {
        preferredGroupMates.add(studentName);
        preferenceScores.add(score);
    }

    public void addHater(String studentName, int score) {
        haters.add(studentName);
        haterScores.add(score);
    }

    // Method to get preference score for a specific student
    public int getPreferenceScore(String studentName) {
        int index = preferredGroupMates.indexOf(studentName);
        return index != -1 ? preferenceScores.get(index) : 0;
    }

    // Method to get hater score for a specific student
    public int getHaterScore(String studentName) {
        int index = haters.indexOf(studentName);
        return index != -1 ? haterScores.get(index) : 0;
    }
}

public class Grouping {
    List<Student> students;

    public Grouping(List<Student> students) {
        this.students = students;
    }

    // Method to generate groupings and calculate scores
    public List<List<Student>> generateGroups(int groupSize) {
        List<List<Student>> groups = new ArrayList<>();
        // Algorithm to generate groups goes here (e.g., greedy algorithm or heuristic)
        return groups;
    }

    // Method to calculate the score for a group
    public int calculateGroupScore(List<Student> group) {
        int score = 0;
        for (Student s1 : group) {
            for (Student s2 : group) {
                if (!s1.equals(s2)) {
                    score += s1.getPreferenceScore(s2.name);
                    score += s2.getPreferenceScore(s1.name);
                    score += s1.getHaterScore(s2.name);
                    score += s2.getHaterScore(s1.name);
                }
            }
        }
        return score;
    }

    // Method to calculate the total score for all groups
    public int calculateTotalScore(List<List<Student>> groups) {
        int totalScore = 0;
        for (List<Student> group : groups) {
            totalScore += calculateGroupScore(group);
        }
        return totalScore;
    }

    public static void main(String[] args) {
        // Example setup, read the data, create students and add preferences/haters
        Student s1 = new Student("Belle Walters");
        s1.addPreference("Quin Simpson", 2);
        s1.addPreference("Enrique Atkins", 3);
        s1.addHater("Ira Woodard", -3);
        
        // Continue for all students...

        List<Student> students = Arrays.asList(s1 /*, other students */);
        Grouping grouping = new Grouping(students);
        
        // Set group size and generate groups
        int groupSize = 4;
        List<List<Student>> groups = grouping.generateGroups(groupSize);
        
        // Calculate the total score for this grouping
        int totalScore = grouping.calculateTotalScore(groups);
        System.out.println("Total Grouping Score: " + totalScore);
    }
}
