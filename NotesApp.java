import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Write a new note");
            System.out.println("2. View all notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter your Note:");
                    String note = sc.nextLine();
                    writeNote(note);
                    break;

                case 2:
                    System.out.println("Your saved Notes:");
                    readNotes();
                    break;

                case 3:
                    System.out.println("Exiting Notes App...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again...");
            }

        } while (choice != 3);

        sc.close();
    }


    private static void writeNote(String note) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(note + System.lineSeparator());
            System.out.println(" || Note saved successfully. ||");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

  
    private static void readNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(" - " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Start writing!");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
}
