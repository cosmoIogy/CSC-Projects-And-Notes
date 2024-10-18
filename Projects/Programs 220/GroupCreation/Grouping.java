import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Student {
    String name;
    Map<String, Integer> preferences;

    public Student(String name) {
        this.name = name;
        this.preferences = new HashMap<>();
    }

    public void addPreference(String studentName, int score) {
        preferences.put(studentName, score);
    }

    public int getPreferenceScore(String studentName) {
        return preferences.getOrDefault(studentName, 0);
    }
}

public class Grouping {

    List<Student> students;

    public Grouping(List<Student> students) {
        this.students = students;
    }

    public List<List<Student>> formOptimizedGroups(int groupSize) {
        List<List<Student>> groups = new ArrayList<>();
        Set<Student> ungrouped = new HashSet<>(students);

        while (!ungrouped.isEmpty()) {
            List<Student> group = new ArrayList<>();
            
            // Step 1: Find the pair with the highest mutual score
            Student bestStudent1 = null;
            Student bestStudent2 = null;
            int bestScore = Integer.MIN_VALUE;

            for (Student s1 : ungrouped) {
                for (Student s2 : ungrouped) {
                    if (!s1.equals(s2)) {
                        int mutualScore = s1.getPreferenceScore(s2.name) + s2.getPreferenceScore(s1.name);
                        if (mutualScore > bestScore) {
                            bestStudent1 = s1;
                            bestStudent2 = s2;
                            bestScore = mutualScore;
                        }
                    }
                }
            }

            if (bestStudent1 != null && bestStudent2 != null) {
                group.add(bestStudent1);
                group.add(bestStudent2);
                ungrouped.remove(bestStudent1);
                ungrouped.remove(bestStudent2);
            }

            // Step 2: Fill the group with the best possible candidates
            while (group.size() < groupSize && !ungrouped.isEmpty()) {
                Student bestCandidate = null;
                int bestCandidateScore = Integer.MIN_VALUE;

                for (Student candidate : ungrouped) {
                    int candidateScore = 0;
                    for (Student member : group) {
                        candidateScore += member.getPreferenceScore(candidate.name) + candidate.getPreferenceScore(member.name);
                    }

                    if (candidateScore > bestCandidateScore) {
                        bestCandidate = candidate;
                        bestCandidateScore = candidateScore;
                    }
                }

                if (bestCandidate != null) {
                    group.add(bestCandidate);
                    ungrouped.remove(bestCandidate);
                }
            }

            groups.add(group);
        }

        return groups;
    }

    public int calculateGroupScore(List<Student> group) {
        int score = 0;
        for (Student s1 : group) {
            for (Student s2 : group) {
                if (!s1.equals(s2)) {
                    score += s1.getPreferenceScore(s2.name);
                }
            }
        }
        return score;
    }

    public void printBestGroups(List<List<Student>> groups) {
        for (int i = 0; i < groups.size(); i++) {
            List<Student> group = groups.get(i);
            int score = calculateGroupScore(group);
            System.out.println("Group " + (i + 1) + " (Score: " + score + "):");
            for (Student s : group) {
                System.out.println(" - " + s.name);
            }
            System.out.println();  // Blank line between groups
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Step 1: Load students and preferences from CSV file
        try (BufferedReader br = new BufferedReader(new FileReader("compatability_withnames.csv"))) {
            String line;
            String[] headers = br.readLine().split(",");  // First row is the headers (student names)

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Student student = new Student(values[0]);

                // Populate preferences based on CSV data
                for (int i = 1; i < values.length; i++) {
                    int score = Integer.parseInt(values[i]);
                    if (score != 0) {  // Ignore zero scores (no preference)
                        student.addPreference(headers[i], score);
                    }
                }
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Set group size and form optimized groups
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired group size: ");
        int groupSize = scanner.nextInt();

        Grouping grouping = new Grouping(students);
        List<List<Student>> optimizedGroups = grouping.formOptimizedGroups(groupSize);

        // Step 3: Print all groups with scores
        grouping.printBestGroups(optimizedGroups);
    }
}
