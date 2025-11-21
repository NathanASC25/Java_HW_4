import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
public class Question2 {
    public static void main(String[] args) throws Exception {
        // Test Case
        // Existing test file location
        File testFile = new File("./TextFiles", "Test1.txt");
        File output = new File("./TextFiles/output.txt");
        // Separate File to determine averages equal, below, or above overall average
        String[] repNames = new String[100];
        double[] avgTripLengths = new double[100];
        int totalTestRecords = numRecords(repNames, avgTripLengths);
        compareTripLengths(output, avgTripLengths, totalTestRecords);
        sortIndividuals(repNames, avgTripLengths, totalTestRecords);
	// PrintWriter in Append mode instead of overwriting
	PrintWriter writeOutput = new PrintWriter(new FileWriter(output, true));
        for (int i = 0; i < 100; i++) {
            writeOutput.printf("Rep Name: %s \nAverage Trip Length: %.2f\n\n", repNames[i], avgTripLengths[i]);
        }
	writeOutput.close();
    }
    // Part 1. 
    public static int numRecords(String[] names, double[] avgTripLengths) throws Exception {
        File testFile = new File("./TextFiles", "Test1.txt");
        Scanner readFile = new Scanner(testFile);
        int recordCount = 0;
        // Reads each token
        while (readFile.hasNext()) {
            String name = readFile.next();
            float firstTrip = readFile.nextFloat();
            float secondTrip = readFile.nextFloat();
            double avgMiles = (firstTrip + secondTrip) / 2;
            names[recordCount] = name;
            avgTripLengths[recordCount] = avgMiles;
            recordCount += 1;
        }
        readFile.close();
        return recordCount;
    }
    // Part 2.
    public static void compareTripLengths(File output, double[] avgTripLengths, int totalRecords) throws Exception {
        // Initial Output written to file
        PrintWriter writeOutput = new PrintWriter(output);
        double totalTripLength = 0.0;
        double overallAvgTripLength = 0.0;
        int belowAvgLength = 0;
        int equalAvgLength = 0;
        int aboveAvgLength = 0;
        for (int i = 0; i < avgTripLengths.length; i++) {
            totalTripLength += avgTripLengths[i];
        }
        overallAvgTripLength = totalTripLength / totalRecords;
        for (int i = 0; i < avgTripLengths.length; i++) {
            if (avgTripLengths[i] > overallAvgTripLength) {
                aboveAvgLength += 1;
            }
            else if (avgTripLengths[i] < overallAvgTripLength) {
                belowAvgLength += 1;
	    }
	    else if (avgTripLengths[i] == overallAvgTripLength) {
                equalAvgLength += 1;
	    }
        }
        writeOutput.printf("Number of average trip lengths above overall average: %d\n", aboveAvgLength);
        writeOutput.printf("Number of average trip lengths below overall average: %d\n", belowAvgLength);
        writeOutput.printf("Number of average trip lengths equal to overall average: %d\n\nRecords:\n\n", equalAvgLength);
	writeOutput.close();
    }
       // Part 3.
    public static void sortIndividuals(String[] names, double[] avgTripLengths, int totalRecords) {
        // If the first character of the second name belongs later in the alphabet compared to the first name, places are switched
        for (int i = 0; i < totalRecords - 1; i++) {
            char[] firstName = names[i].toCharArray();
            for (int j = i + 1; j < totalRecords; j++) {
                char[] secondName = names[j].toCharArray();
                if (secondName[0] > firstName[0]) {
                    String newFirstName = names[j];
                    names[j] = names[i];
                    names[i] = newFirstName;
                    double newFirstTripLength = avgTripLengths[j];
                    avgTripLengths[j] = avgTripLengths[i];
                    avgTripLengths[i] = newFirstTripLength;
                }
            }
        }
    }
}
