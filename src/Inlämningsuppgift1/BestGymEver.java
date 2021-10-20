package Inlämningsuppgift1;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class BestGymEver{

    public BestGymEver() {

        String line1;
        String line2;
        String filePath = "src/Inlämningsuppgift1/Personuppgifter.txt";
        String outFilePathString = "src/Inlämningsuppgift1/Medlemmar.txt";
        Path inFilePath = Paths.get(filePath);
        Path outFilePath = Paths.get(outFilePathString);
        String[] date;
        LocalDate dateNow = LocalDate.now();
        LocalDate dateMinusTwelveMonths = dateNow.minusMonths(12);
        String inputDialog = JOptionPane.showInputDialog("Vänligen ange ett personnummer och namn:");

        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(outFilePath));
            Scanner fileScanner = new Scanner(inFilePath)){

            while(fileScanner.hasNext()){
                line1 = fileScanner.nextLine();
                if (fileScanner.hasNext()){
                    line2 = fileScanner.nextLine();
                    date = line2.split("--");

                    if (dateNow.parse(date[0]).isAfter(dateMinusTwelveMonths)) {
                        writer.print(line1 + "\n" + line2 + "\n");

                        if (line1.equals(inputDialog)) {
                            JOptionPane.showMessageDialog(null, inputDialog
                                    + " är medlem på BestGymEver.");
                        }
                        //TODO lyckas få till en else statement som printar ut "Inte medlem" 1 gång och inte 4.
                        //else
                        //    JOptionPane.showMessageDialog(null, "Inte medlem");
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File does not exist.");
            e.printStackTrace();
            System.exit(0);
        }
        catch (IOException e){
            System.out.println("Failed to write to file.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e){
            System.out.println("Something went wrong.");
            e.printStackTrace();
            System.exit(0);
        }
    }
}