public class GeometricSeries extends AbstractSeries {

    private double total = 0.0;
    private double currentValue = 1.0;
    private double divisor = 2.0;

    public double next() {

        total += currentValue;
        currentValue /= divisor;
        return total;
    }
}

