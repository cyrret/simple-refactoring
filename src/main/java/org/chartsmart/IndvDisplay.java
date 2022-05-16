package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IndvDisplay extends JPanel {
    private class Unit {
        private String unitName;
        private double value;

        public double convertTo(Unit unit) {
            return 0;
        }

        public void setName(String name) {
            this.unitName = name;
        }

        public String getName() {
            return unitName;
        }

        public void setValue(double v1) {
            this.value = v1;
        }

        public double getValue() {
            return value;
        }
    }

    private String jjD;
    private String chartTitle;
    private String[] horizontalLabelNames;
    private String[] verticalLabelNames;
    private boolean isBarChart;


    private void initializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        String titleChartType;
        String titleModeType;

        titleChartType = isBarChart ? "Bar Chart" :  "Pie Chart";
        titleModeType = jjD.equals("rpfll") ? "Single Mode" : "Compare Mode";

        chartTitle = titleChartType + " - " + titleModeType;
    }

    public IndvDisplay() {
    }

    public String getTitle() {
        return chartTitle;
    }

    /**
     * @return
     */
    private Unit horizontalNaming() {
        return new Unit();
    }

    /**
     * Shows the chart
     *
     * @param ct
     * @param jjReq1205
     * @param orientation
     * @param reversornotreverse
     * @param jackshiddenhack
     * @return
     */
    public void toggleChart(boolean ct, String stjjDReq1205, boolean shouldDisplayChart) {
        this.isBarChart = ct;
        this.jjD = stjjDReq1205;
        if (shouldDisplayChart) {
            initializeDrawArea();
        }
    }

    /**
     * @param g
     * @author Wilbur
     * @since
     */
    public void paint(Graphics g) {
        DrawChart(g);
    }

    /**
     * @param g
     */
    private void DrawChart(Graphics g) {
        // Render chart background
        if (isBarChart) {
            if (jjD.equals("rpfll")) {
                Color bgc = Color.RED;
                g.setColor(bgc);
                g.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(95, 95, 210, 210);
            }
        } else {
            if (jjD.equals("rpfll")) {
                Color bgcb;
                bgcb = Color.BLUE;
                g.setColor(bgcb);
                g.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                g.setColor(Color.BLUE);
                double isq = 405;
                float padding = 90;
                int sc = (int) (isq - padding * 2);
                g.fillOval(100, 100, sc, sc);
            }
        }
        String[] data = null;
        List<String> specialData = new ArrayList<String>();
        String[] data3point14 = new String[0];
        if (isBarChart) {
            if (jjD.equals("rpfll")) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i++] = "Small";
            }
        } else {
            // BUG445: Org rep team missing req chart
            if (jjD.equals("rpfll")) {
                specialData.add("Pie Chart");
            } else {
                data3point14 = new String[2];
                data3point14[1] = "Small";
                data3point14[0] = "Pie" + " Chart";
            }
        }
        Font font;
        if (isBarChart) {
            if (jjD.equals("shareddisplay")) {
                font = new Font("Arial Black", Font.BOLD, 25);
                g.setColor(Color.CYAN);
                int bottomY = 300;
                g.fillRect(100, bottomY - 100, 40, 100);
                g.fillRect(140, bottomY - 200, 40, 200);
                g.fillRect(180, bottomY - 150, 40, 150);
                g.fillRect(220, bottomY - 125, 40, 125);
                g.fillRect(260, bottomY - 170, 40, 170);
                g.setColor(Color.RED);
                g.setFont(font);
                g.drawString(data[0], 130, 250);
                g.drawString(data[1], 130, 270);
            } else {
                int bottomY = 500;
                g.setColor(Color.CYAN);
                g.fillRect(112, bottomY - 200, 75, 200);
                g.fillRect(187, bottomY - 400, 75, 400);
                g.fillRect(262, bottomY - 300, 75, 300);
                g.fillRect(337, bottomY - 250, 75, 250);
                g.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                g.setColor(Color.BLACK);
                g.setFont(font);
                g.drawString(data[0], 130, 400);
            }
        } else {
            if (jjD.equals("rpfll")) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                g.setColor(Color.WHITE);
                g.setFont(font);
                g.drawString(specialData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                g.setFont(font);
                g.setColor(Color.WHITE);
                g.drawString(data3point14[0], 145, 205);
                g.drawString(data3point14[1], 170, 235);
            }
        }
        if (specialData.contains("Monthly")
                || getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }
}
