import java.util.ArrayList;
import java.util.List;

public class ArithmeticSeries extends AbstractSeries {

    private double currentSum = 0.0;
    private double currentIndex = 1.0;

    public double next() {
        currentSum += currentIndex++;
        return currentSum;
    }
}


