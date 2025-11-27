package desafio.backend.itau.springboot.dto;

import java.util.DoubleSummaryStatistics;

public class ResponseTransactionDTO {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public ResponseTransactionDTO(DoubleSummaryStatistics stats) {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        if (stats.getCount() == 0) {
            this.min = 0.0;
            this.max = 0.0;
        } else {
            this.min = stats.getMin();
            this.max = stats.getMax();
        }
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

}
