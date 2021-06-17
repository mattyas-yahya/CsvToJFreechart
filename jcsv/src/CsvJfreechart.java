

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.*;
import org.jfree.data.statistics.HistogramDataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
        import java.io.IOException;
public class CsvJfreechart
{
    public static void main(String[] args) throws IOException
    {
        String line = "";
        String splitBy = ",";
        try
        {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xxxxxxx\\Documents\\machine1.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] machine = line.split(splitBy);    // use comma as separator
                System.out.println(machine[0] +","+ machine[1]  +","+ machine[2]+","+ machine[3]);


                HistogramDataset dataset = new HistogramDataset();
                dataset.addSeries("key1", new double[]{Double.parseDouble(machine[0])}, 50);
                dataset.addSeries("key2", new double[]{Double.parseDouble(machine[1])}, 50);
                dataset.addSeries("key3", new double[]{Double.parseDouble(machine[2])}, 50);
                dataset.addSeries("key4", new double[]{Double.parseDouble(machine[3])}, 50);


                JFreeChart histogram = ChartFactory.createHistogram("Normal machine",
                        "y values", "x values", dataset);

                ChartUtils.saveChartAsPNG(new File("histogram.png"), histogram, 450, 400);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
