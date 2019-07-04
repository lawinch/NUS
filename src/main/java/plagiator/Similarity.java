package plagiator;

public class Similarity {

    private final float jaccard;
    private final float wagnerFischer;

    public Similarity(float jaccard, float wagnerFischer) {
        this.jaccard = jaccard;
        this.wagnerFischer = wagnerFischer;
    }

    public float getJaccard() {
        return jaccard;
    }

    public float getWagnerFischer() {
        return wagnerFischer;
    }

}
