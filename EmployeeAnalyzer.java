import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeAnalyzer {

    public static void main(String[] args) {
        String filePath = "path/to/your/input/file.txt"; // Specify the path to your input file
        try (BufferedReader br = new BufferedReader(new FileReader("C:\Users\shaik noorullah\Assignment_Timecard.xlsx"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into parts using comma as the delimiter
                String[] parts = line.split(",");
                String name = parts[7].trim(); // Assuming the name is at index 7
                String position = parts[0].trim(); // Assuming the position is at index 0
                int workHours = Integer.parseInt(parts[4].trim()); // Assuming work hours are at index 4

                // Check conditions
                if (hasWorkedForSevenConsecutiveDays(br, name) ||
                    hasLessThan10HoursBetweenShifts(br, name) ||
                    hasWorkedMoreThan14HoursInSingleShift(workHours)) {
                    System.out.println("Name: " + name + ", Position: " + position);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasWorkedForSevenConsecutiveDays(BufferedReader br, String name) throws IOException {
        // Logic to check if the employee has worked for 7 consecutive days
        // Implement your logic here
        private static boolean hasWorkedForSevenConsecutiveDays(BufferedReader br, String name) throws IOException {
            int consecutiveDays = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String employeeName = parts[7].trim(); // Assuming the name is at index 7
        
                // If the current line belongs to the same employee and has worked, increment the consecutiveDays count
                if (employeeName.equals(name) && hasWorked(parts)) {
                    consecutiveDays++;
                } else {
                    // If the current line does not belong to the same employee or has not worked, reset the count
                    consecutiveDays = 0;
                }
        
                // If the employee has worked for 7 consecutive days, return true
                if (consecutiveDays == 7) {
                    return true;
                }
            }
            return false;
        }
        
        // Helper method to check if an employee has worked on a specific day (you need to implement this logic based on your input data)
        private static boolean hasWorked(String[] parts) {
            // Implement your logic to determine if the employee has worked on a specific day
            // For example, check if the work hours on this day are greater than 0
            int workHours = Integer.parseInt(parts[4].trim()); // Assuming work hours are at index 4
            return workHours > 0;
        }
        
        //return false; // Return true if the condition is met, else false
    }

    private static boolean hasLessThan10HoursBetweenShifts(BufferedReader br, String name) throws IOException {
        // Logic to check if the employee has less than 10 hours between shifts but greater than 1 hour
        // Implement your logic here
        private static boolean hasLessThan10HoursBetweenShifts(BufferedReader br, String name) throws IOException {
            String line;
            String[] parts;
            String lastEndTime = null;
            while ((line = br.readLine()) != null) {
                parts = line.split(",");
                String currentName = parts[7].trim(); // Assuming the name is at index 7
                String currentTimeIn = parts[2].trim(); // Assuming time in is at index 2
        
                // Check if the current line belongs to the same employee
                if (currentName.equals(name)) {
                    // Parse the current time in
                    // Assuming time format is in HH:mm (24-hour format)
                    int currentHour = Integer.parseInt(currentTimeIn.split(":")[0]);
        
                    // Compare with the last end time
                    if (lastEndTime != null) {
                        int lastEndHour = Integer.parseInt(lastEndTime.split(":")[0]);
                        int timeDifference = currentHour - lastEndHour;
        
                        // Check if the time difference is greater than 1 hour and less than 10 hours
                        if (timeDifference > 1 && timeDifference < 10) {
                            return true; // Employee has less than 10 hours between shifts but greater than 1 hour
                        }
                    }
        
                    // Update the last end time for the next iteration
                    lastEndTime = parts[3].trim(); // Assuming time out is at index 3
                }
            }
            return false; // No shifts found with less than 10 hours between them
        }
        
        return false; // Return true if the condition is met, else false
    }

    private static boolean hasWorkedMoreThan14HoursInSingleShift(int workHours) {
        // Logic to check if the employee has worked for more than 14 hours in a single shift
        
        return workHours > 14;
    }
}
