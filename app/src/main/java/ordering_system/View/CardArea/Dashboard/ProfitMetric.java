package ordering_system.View.CardArea.Dashboard;

public class ProfitMetric extends MetricCard {
    public ProfitMetric(String imageLocation, String text) {
        super(imageLocation, text);
    }

    @Override
    public void setValue(int value) {
        valueLabel.setText("$" + Integer.toString(value));
    }
}
