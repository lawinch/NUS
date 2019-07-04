package plagiator;

public class Similarity {

    private float percentage;
    private float distance;
    private String template1;

    public Similarity(float distance, String template1) {
        this.distance = distance;
        this.template1 = template1;

        this.computePercentage();
    }

    private void computePercentage() {
        percentage = (template1.length() - distance/ template1.length()) * 100;
    }

    public float getPercentage() {
        return percentage;
    }
}
