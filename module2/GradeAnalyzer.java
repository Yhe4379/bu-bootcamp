import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    static int invalidCount = 0;

    public static void main(String[] args) {
        ArrayList<Integer> scores = readScores("scores.txt");

        if (scores.isEmpty()) {
            System.out.println("No valid scores found.");
            return;
        }

        double avg = calculateAverage(scores);

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > high) high = score;
            if (score < low) low = score;
        }

        writeReport(scores, avg, high, low, "report.txt");
    }

    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Warning: skipping invalid line: " + line);
                    invalidCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return scores;
    }

    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (int score : scores) {
            total += score;
        }
        return total / scores.size();
    }

    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int score : scores) {
            if (score >= 90) countA++;
            else if (score >= 80) countB++;
            else if (score >= 70) countC++;
            else if (score >= 60) countD++;
            else countF++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== Grade Analysis Report ===\n");
        sb.append(String.format("Total scores processed: %d%n", scores.size()));
        sb.append(String.format("Invalid lines skipped:  %d%n", invalidCount));
        sb.append("\n");
        sb.append(String.format("Average score: %.2f%n", avg));
        sb.append(String.format("Highest score: %d%n", high));
        sb.append(String.format("Lowest score:  %d%n", low));
        sb.append("\n");
        sb.append("Grade distribution:\n");
        sb.append(String.format("  A (90-100):   %d%n", countA));
        sb.append(String.format("  B (80-89):    %d%n", countB));
        sb.append(String.format("  C (70-79):    %d%n", countC));
        sb.append(String.format("  D (60-69):    %d%n", countD));
        sb.append(String.format("  F (below 60): %d%n", countF));

        String report = sb.toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report);
        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }

        System.out.print(report);
    }
}