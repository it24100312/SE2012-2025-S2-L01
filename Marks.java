
import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = input.nextInt(); // n = number of students

        int[][] studentMarks = new int[n][3];
        int choice;

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Add student marks");
            System.out.println("2. Update student marks");
            System.out.println("3. Get the average of a subject");
            System.out.println("4. Get the average of a student");
            System.out.println("5. Get the total marks of a student");
            System.out.println("6. Display student marks table");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: "); 

            choice = input.nextInt();

            int stdID, subID, totSub, totStu;

            switch (choice) {
                case 1:
                    System.out.println("\nAdd student marks:");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("\nEnter the marks of student %d\n", i+1);

                        int mathMarks;
                        do {
                            System.out.print("Mathematics (0-100): ");
                            mathMarks = input.nextInt();
                        }
                        while (mathMarks < 0 || mathMarks > 100);
                        studentMarks[i][0] = mathMarks;

                        int chemMarks;
                        do {
                            System.out.print("Chemistry (0-100): ");
                            chemMarks = input.nextInt();
                        }
                        while (chemMarks < 0 || chemMarks > 100);
                        studentMarks[i][1] = chemMarks;

                        int physMarks;
                        do {
                            System.out.print("Physics (0-100): ");
                            physMarks = input.nextInt();
                        }
                        while (physMarks < 0 || physMarks > 100);
                        studentMarks[i][2] = physMarks;
                    }
                    break;

                case 2: 
                    System.out.println("\nUpdate student marks:");

                    do {
                        System.out.print("Enter student ID (1-" + n + "): ");
                        stdID = input.nextInt();
                        if (stdID <= 0 || stdID > n) {
                            System.out.println("Invalid Student ID!. Please enter again.");
                        }
                    }
                    while (stdID <= 0 || stdID > n);

                    do {
                        System.out.print("Enter subject ID (0-Maths, 1-Chem, 2-Phys): ");
                        subID = input.nextInt();
                        if (subID < 0 || subID > 2) {
                            System.out.println("Invalid Subject ID!. Please enter again.");
                        }
                    }
                    while (subID < 0 || subID > 2);

                    System.out.print("Enter marks: ");
                    studentMarks[stdID-1][subID] = input.nextInt();
                    break;

                case 3:
                    System.out.println("\nAverage mark of a subject:");
                    totSub = 0;
                    float avgSub;

                    do {
                        System.out.print("Enter subject ID (0-Maths, 1-Chem, 2-Phys): ");
                        subID = input.nextInt();
                        if (subID < 0 || subID > 2) {
                            System.out.println("Invalid Subject ID!. Please enter again.");
                        }
                    }
                    while (subID < 0 || subID > 2);

                    for (int i = 0; i < n; i++) {
                        totSub = totSub + studentMarks[i][subID];
                    }
                    avgSub = (float) totSub / n;

                    if (subID == 0) {
                        System.out.printf("\nAverage marks of Mathematics: %.2f\n", avgSub);
                    }
                    else if (subID == 1) {
                        System.out.printf("\nAverage marks of Chemistry: %.2f\n", avgSub);
                    }
                    else {
                        System.out.printf("\nAverage marks of Physics: %.2f\n", avgSub);
                    }
                    break;

                case 4:
                    System.out.println("\nAverage mark of a student:");
                    totStu = 0;
                    float avgStu;

                    do {
                        System.out.print("Enter student ID (1-" + n + "): ");
                        stdID = input.nextInt();
                        if (stdID <= 0 || stdID > n) {
                            System.out.println("Invalid Student ID!. Please enter again.");
                        }
                    }
                    while (stdID <= 0 || stdID > n);

                    for (int j = 0; j < 3; j++) {
                        totStu = totStu + studentMarks[stdID-1][j];
                    }
                    avgStu = (float) totStu / 3;

                    System.out.printf("\nAverage mark of Student %d: %.2f\n", stdID, avgStu);
                    break;

                case 5:
                    System.out.println("\nTotal marks of a student:");
                    totStu = 0;

                    do {
                        System.out.print("Enter student ID (1-" + n + "): ");
                        stdID = input.nextInt();
                        if (stdID <= 0 || stdID > n) {
                            System.out.println("Invalid Student ID!. Please enter again.");
                        }
                    }
                    while (stdID <= 0 || stdID > n);

                    for (int j = 0; j < 3; j++) {
                        totStu = totStu + studentMarks[stdID-1][j];
                    }

                    System.out.println("\nTotal marks of Student " + stdID + ": " + totStu);
                    break;

                case 6:
                    System.out.println("\nDisplay student marks table:");
                    System.out.println("\n               Student Marks Table");
                    System.out.printf("%-10s | %-11s | %-9s | %-7s\n", "Student ID", "Mathematics", "Chemistry", "Physics");
                    System.out.println("-----------------------------------------------");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("    %-6d |     %-7d |    %-6d |   %-4d\n", i + 1, studentMarks[i][0], studentMarks[i][1], studentMarks[i][2]);
                    }
                    break;

                case 7:
                    System.out.println("\nEnd of Program.");

                    return;

                default:
                    System.out.println("Invalid choice!");
            }

        }

    }
}