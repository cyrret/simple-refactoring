package org.chartsmart.tests;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DelayedClipboardReporter;
import org.approvaltests.reporters.UseReporter;
import org.chartsmart.IndvDisplay;
import org.chartsmart.MainWindow;
import org.junit.Test;

@UseReporter(DelayedClipboardReporter.class)
public class ChartSmartTest {
    @Test
    public void testRun() {
        MainWindow chartSmart = new MainWindow();
        Approvals.verify(chartSmart);
    }

    @Test
    public void testBarChart() {
        IndvDisplay cw = new IndvDisplay();
        cw.toggleChart(true, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testBarChartCompare() {
        IndvDisplay cw = new IndvDisplay();
        cw.toggleChart(true, "shareddisplay", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChart() {
        IndvDisplay cw = new IndvDisplay();
        cw.toggleChart(false, "rpfll", true);
        Approvals.verify(cw);
    }

    @Test
    public void testPieChartCompare() {
        IndvDisplay cw = new IndvDisplay();
        cw.toggleChart(false, "shareddisplay", true);
        Approvals.verify(cw);
    }
}
