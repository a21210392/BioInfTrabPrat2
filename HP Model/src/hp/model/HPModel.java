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
    static final int MAX = 25;

    enum directions {

        F, L, R;
    }

    void printMatrix(char[][] matrix) {
        int x;
        int y;

        for (y = MAX - 1; y >= 0; y--) {
            for (x = 0; x < MAX; x++) {
                System.out.print(matrix[x][y]);
            }
            System.out.println();
        }
    }

    static int fillMatrix(String chain, int scoringMethod) {
        char[][] matrix = new char[MAX][MAX];
        String answer = "";
        int score;
        int x;
        int y;
        int i = 0;
        int direction;
        boolean legal = true;

        for (x = 0; x < MAX; x++) {
            for (y = 0; y < MAX; y++) {
                matrix[x][y] = ' ';
            }
        }

        direction = directions.F.ordinal();
        x = MAX / 2;
        y = MAX / 2;
        matrix[x][y] = chain.charAt(0);

        while (i < chain.length() - 1 && legal == true) {
            if (answer[i] == E) {
                direction--;
                if (direction < 0) {
                    direction = 3;
                }
            } else if (answer[i] == D) {
                direction = (direction + 1) % 4;
            }

            // Actualiza coordenadas de escrita
            switch (direction) {
                case 0:
                    y++;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y--;
                    break;
                case 3:
                    x--;
                    break;
            }

            if (x < 0 || x > MAX - 1 || y < 0 || y > MAX - 1 || matrix[x][y] != ' ') {
                legal = false;
            } else {
                matrix[x][y] = chain.charAt(i + 1);
                i++;
            }
        }

        printMatrix(matrix);

        if (i < chain.length() - 1) {
            if (scoringMethod == 0) {
                return 0;
            } else {
                return chain.length() - i;
            }
        } else {
            score = 0;
            for (x = 0; x < MAX; x++) {
                for (y = 0; y < MAX; y++) {
                    if (x < MAX - 1 && matrix[x][y] == 'H' && matrix[x + 1][y] == 'H') {
                        score++;
                    }
                    if (y < MAX - 1 && matrix[x][y] == 'H' && matrix[x][y + 1] == 'H') {
                        score++;
                    }
                }
            }
            return -score;
        }
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        String chain = "";
        int scoringMethod = 0;
        int score;

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

        score = fillMatrix(chain, scoringMethod);

        //Counts number of times parts of "sequence" match "pattern", with "maxMutations" differences for each string in "sequences"
        for (String sequence : sequences) {
            occurrences += patternCounter(pattern, sequence, maxMutations, motifSize);
        }

        if (occurrences > score) {
            motif = pattern;
            score = occurrences;
        }
    }

    System.out.println (chain);

    System.out.println ();

    System.out.println (
            

"Score: " + score);
    }
}
