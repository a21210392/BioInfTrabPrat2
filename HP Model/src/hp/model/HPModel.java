package hp.model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HPModel {

//    static String generateRandomMotif(List sequences, int motifSize) {
//        String motif = "";
//        String sequence;
//        int startAt;
//        Random ran = new Random();
//
//        sequence = sequences.get((ThreadLocalRandom.current().nextInt(0, sequences.size()))).toString();
//        startAt = (ThreadLocalRandom.current().nextInt(0, sequence.length() - motifSize));
//
//        for (int i = startAt;
//                i < startAt + motifSize;
//                i++) {
//            motif += (String.valueOf(sequence.charAt(i)));
//        }
//
//        return motif;
//    }
//
//    static int patternCounter(String pattern, String sequence, int maxMutations, int motifSize) {
//        int occurrences = 0;
//        int errors;
//        int i, j;
//
//        for (i = 0; i < sequence.length(); i++) {
//
//            //If exceeds sequence size, exit loop
//            if (i + motifSize >= sequence.length()) {
//                break;
//            }
//
//            errors = 0;
//            j = 0;
//
//            //Compares one character at a time
//            while (j < pattern.length() && errors <= maxMutations) {
//                if (pattern.charAt(j) != sequence.charAt(i + j)) {
//                    errors += 1;
//                }
//                j++;
//            }
//
//            if (errors <= maxMutations) {
//                occurrences += 1;
//            }
//        }
//        return occurrences;
//    }
    enum directions {

        left, forward, right;
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        final int MAX = 25;
        char[][] matrix = new char[MAX][MAX];
        int score = 0;
        String chain = "";
        String answer;
        int scoringMethod;
        int direction;
        int x;
        int y;
        boolean error = false;

        Scanner input = new Scanner(System.in);
        String filename;
        String line;

        File file = new File("s4.txt");
        Path filePath = Paths.get(file.toURI());

        try {

            Scanner filereader = new Scanner(filePath);

            while (filereader.hasNext()) {
                line = filereader.nextLine();
                if (line != null && line.length() != 0) {
                    chain = line;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                matrix[i][j] = ' ';
            }
        }

        matrix[MAX / 2][MAX / 2] = chain.charAt(0);
        x = y = MAX / 2;
        direction = directions.forward.ordinal();

        for (int i = 1; i < chain.length() && error != true; i++) {
            if (chain.charAt(i) == 'H' && ) {

            }

            //Counts number of times parts of "sequence" match "pattern", with "maxMutations" differences for each string in "sequences"
            for (String sequence : sequences) {
                occurrences += patternCounter(pattern, sequence, maxMutations, motifSize);
            }

            if (occurrences > score) {
                motif = pattern;
                score = occurrences;
            }
        }

        System.out.println(chain);
        System.out.println();
        System.out.println("Score: " + score);
    }
}
