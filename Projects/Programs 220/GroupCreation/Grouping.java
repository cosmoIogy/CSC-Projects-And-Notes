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

    public int getPreferenceScore(String studentName) {
        int index = preferredGroupMates.indexOf(studentName);
        return index != -1 ? preferenceScores.get(index) : 0;
    }

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
                    score += s1.getHaterScore(s2.name);
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
        }
    }

    public static void main(String[] args) {
        // Example setup: create students and add preferences/haters
        Student s1 = new Student("Belle Walters");
        s1.addPreference("Quin Simpson", 2);
        s1.addPreference("Enrique Atkins", 3);
        s1.addHater("Ira Woodard", -3);

        Student s2 = new Student("Quin Simpson");
        s2.addPreference("Belle Walters", 5);

        List<Student> students = Arrays.asList(s1, s2 /*, other students */);
        Grouping grouping = new Grouping(students);

        // Set group size and form optimized groups
        int groupSize = 4;
        List<List<Student>> optimizedGroups = grouping.formOptimizedGroups(groupSize);

        // Print the best groups
        grouping.printBestGroups(optimizedGroups);
    }
}