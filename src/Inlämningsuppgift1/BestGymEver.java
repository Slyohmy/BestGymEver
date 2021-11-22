package Inlämningsuppgift1;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BestGymEver{

    List<String> currentCustomer = new ArrayList<>();
    String line1;
    String filePath = "src/Inlämningsuppgift1/Personuppgifter.txt";
    Path inFilePath = Paths.get(filePath);
    LocalDate dateNow = LocalDate.now();
    LocalTime timeNow = LocalTime.now();
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalDate dateMinusTwelveMonths = dateNow.minusMonths(12);

    boolean exists = false;

    public List<String> getCurrentCustomer(){
        return currentCustomer;
    }

    public String checkIfCustomerExist() {

        String inputDialog = JOptionPane.showInputDialog("Vänligen ange ett personnummer och namn:");

        try(BufferedReader fileScanner = new BufferedReader(new FileReader(String.valueOf(inFilePath)))){
            String temp;

            while((temp = fileScanner.readLine()) != null){
                line1 = temp;
                LocalDate line2 = LocalDate.parse(String.valueOf(fileScanner.readLine()));

                    if (line2.isAfter(dateMinusTwelveMonths)) {
                        System.out.println("Medlemmar: " + line1 + "\nSenast betalat: " + line2);
                        currentCustomer.add(line1);

                        if (line1.equals(inputDialog)) {
                            exists = true;
                        }
                    }
            }
            if (exists == true){
                JOptionPane.showMessageDialog(null, inputDialog
                        + " är medlem på BestGymEver.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Inte medlem");
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
        return inputDialog;
    }

    public void checkIn(String name){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Inlämningsuppgift1/Medlemmar.txt", true))) {
            for (String finns: currentCustomer) {
                if (finns.equals(name)){
                    writer.write(finns + " var senast på gymmet den " + dateNow + " klockan " + timeNow.format(timeFormatter));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}