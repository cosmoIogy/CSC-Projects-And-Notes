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
    Random rand = new Random();  // Random object for introducing randomness

    public Grouping(List<Student> students) {
        this.students = students;
    }

    // Method to form optimized groups dynamically based on group size
    public List<List<Student>> formOptimizedGroups(int groupSize) {
        List<List<Student>> bestGroups = new ArrayList<>();
        int bestTotalScore = Integer.MIN_VALUE;

        // Attempt multiple iterations to find the best possible grouping
        for (int iteration = 0; iteration < 1000; iteration++) {
            List<List<Student>> groups = new ArrayList<>();
            Set<Student> ungrouped = new HashSet<>(students);

            // Step 1: Form groups by randomly selecting pairs and adding best candidates
            while (!ungrouped.isEmpty()) {
                List<Student> group = new ArrayList<>();
                
                // Step 2: Randomly select the first student for the group
                Student firstStudent = getRandomStudent(ungrouped);
                group.add(firstStudent);
                ungrouped.remove(firstStudent);

                // Step 3: Fill the group with the best possible candidates, dynamically based on group size
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

            // Step 4: Calculate the total score of the current group configuration
            int totalScore = calculateTotalGroupScore(groups);

            // Step 5: Keep track of the best grouping based on the total score
            if (totalScore > bestTotalScore) {
                bestTotalScore = totalScore;
                bestGroups = groups;
            }
        }

        return bestGroups;
    }

    // Method to calculate the total score of all groups combined
    public int calculateTotalGroupScore(List<List<Student>> groups) {
        int totalScore = 0;
        for (List<Student> group : groups) {
            totalScore += calculateGroupScore(group);
        }
        return totalScore;
    }

    // Method to calculate the score of a group based on the preferences within the group
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

    // Helper method to get a random student from a set of ungrouped students
    private Student getRandomStudent(Set<Student> ungrouped) {
        int index = rand.nextInt(ungrouped.size());
        int i = 0;
        for (Student student : ungrouped) {
            if (i == index) {
                return student;
            }
            i++;
        }
        return null;  // Should never happen
    }

    // Print all groups with their calculated scores
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
