package plagiator.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kenneth on 7/4/19.
 */
public class JaccardSimilarity implements SimilarityAlgorithm {
    /**
     * Calculates Jaccard Similarity of two set character sequence passed as
     * input.
     */
    public float apply(String left, String right) {
        return Math.round(calculateJaccardSimilarity(left, right));
    }

    /**
     * Calculates Jaccard Similarity of two character sequences passed as
     * input. Does the calculation by identifying the union (characters in at
     * least one of the two sets) of the two sets and intersection (characters
     * which are present in set one which are present in set two)
     */
    private float calculateJaccardSimilarity(String left, String right) {
        Set<String> intersectionSet = new HashSet<String>();
        Set<String> unionSet = new HashSet<String>();
        boolean unionFilled = false;
        int leftLength = left.length();
        int rightLength = right.length();
        if (leftLength == 0 || rightLength == 0) {
            return 0f;
        }

        for (int leftIndex = 0; leftIndex < leftLength; leftIndex++) {
            unionSet.add(String.valueOf(left.charAt(leftIndex)));
            for (int rightIndex = 0; rightIndex < rightLength; rightIndex++) {
                if (!unionFilled) {
                    unionSet.add(String.valueOf(right.charAt(rightIndex)));
                }
                if (left.charAt(leftIndex) == right.charAt(rightIndex)) {
                    intersectionSet.add(String.valueOf(left.charAt(leftIndex)));
                }
            }
            unionFilled = true;
        }
        return (intersectionSet.size() / (float) unionSet.size()) * 100;
    }
}
