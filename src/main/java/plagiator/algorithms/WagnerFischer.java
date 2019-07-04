package plagiator.algorithms;

import plagiator.Utils;

/**
 * Represents the Wagner–Fischer algorithm
 */
public class WagnerFischer {
    /**
     * Get the Levenshtein Distance for two given strings.
     */
    public static int getLevenshteinDistance(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        char[] s1chars = s1.toLowerCase().toCharArray();
        char[] s2chars = s2.toLowerCase().toCharArray();
        int[][] distanceMatrix = fillLevenshteinMatrix(s1chars, s2chars);

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1chars[i - 1] == s2chars[j - 1]) {
                    distanceMatrix[i][j] = distanceMatrix[i - 1][j - 1];
                } else {
                    int tmp = Math.min((distanceMatrix[i - 1][j] + 1), (distanceMatrix[i][j -  1] + 1));
                    distanceMatrix[i][j] = Math.min(tmp, (distanceMatrix[i - 1][j - 1] + 1));
                }
            }
        }

        return distanceMatrix[s1Length][s2Length];
    }

    /**
     * Gets the percentage of similarity between to strings.
     */
    public static float getPercentageSimilarity(int distance, int len1, int len2) {
        return Math.round(Math.abs((1.0f - (distance / ((float) Math.max(len1, len2)))) * 100.0f));
    }

    /**
     * Runs the algorithm for computing the similarity of two strings.
     */
    public static float runAlgorithm(String s1, String s2) {
        return (getPercentageSimilarity(getLevenshteinDistance(s1, s2), s1.length(), s2.length()));
    }


    /**
     * Fills the Levenshtein matrix.
     */
    private static int[][] fillLevenshteinMatrix(char[] s1, char[] s2) {
        int[][] matrix = new int[s1.length + 1][s2.length + 1];

        for (int i = 0; i < s1.length + 1; i++) {
            matrix[i][0] = i;
        }

        for (int j = 0; j < s2.length + 1; j++) {
            matrix[0][j] = j;
        }

        return matrix;
    }

    public static float getSimilarityScore(String template1, String template2) {
        String words1 = Utils.getWords(template1);
        String words2 = Utils.getWords(template2);
        int distance = getLevenshteinDistance(words1, words2);
        return getPercentageSimilarity(distance, words1.length(), words2.length());
    }
}
