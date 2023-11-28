import processing.core.*;

import java.io.*;
import java.util.*;

public class FileIO extends PApplet {

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        copyFileContents();
        background(180);
        noLoop();
    }


    void copyFileContents() {

        double x, y, z;
        Point p;
        List<Point> points = new ArrayList<>();

        String[] lines = loadStrings("positions.txt");
        PrintWriter output = createWriter("/Users/gaberiedel/Downloads/lab9helperCode/drawMe.txt");

        for (String line : lines) {
            String[] words= line.split(",");
            x = Double.parseDouble(words[0]);
            y = Double.parseDouble(words[1]);
            z = Double.parseDouble(words[2]);
            p = new Point(x, y, z);
            points.add(p);
        }

        List<Point> newList = points.stream().filter(p1-> p1.z <= 2.0)
                .map(p1-> p1.scale(0.5))
                .map(p1 -> p1.translate(-150, -37))
                .toList();

        for(Point point : newList){
            x = point.x;
            y = point.y;
            z = point.z;
            String lineToWrite = x + ", " + y + ", " + z;
            println(lineToWrite);
            output.println(lineToWrite);
        }

        // Close the writer
        output.flush(); // Make sure all data is written
        output.close(); // Close the file
    }

    public static void main(String args[]) {
        PApplet.main("FileIO");
    }
}
