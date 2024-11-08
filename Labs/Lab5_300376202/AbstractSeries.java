public abstract class AbstractSeries implements Series {

    public double[] take(int k) {

        double[] result = new double[k];
        result[0] = next();
        for (int i = 1; i < k; i++) {
            result[i] = result[i - 1] + next();
        }
        return result;
        
    }

}
