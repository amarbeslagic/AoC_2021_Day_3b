import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("inputs//input_AoC_3b.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> listOfStringsOxigen = new ArrayList<>();
        List<String> listOfStringsCO2 = new ArrayList<>();

        String s;
        //put Strings in array
        while((s = br.readLine()) != null) {
            if (s.isBlank()) continue;

            listOfStringsOxigen.add(s);
            listOfStringsCO2.add(s);
        }

        // OXYGEN

        int countOX = 0;


        for(int positionInOneString = 0; positionInOneString <listOfStringsOxigen.get(0).length(); positionInOneString++){

            int listOfStringsOxigenSize = listOfStringsOxigen.size();

            for(int i=0; i<listOfStringsOxigen.size(); i++){
                char ch = listOfStringsOxigen.get(i).charAt(positionInOneString);
                if(listOfStringsOxigen.get(i).charAt(positionInOneString) == '1') countOX++;
            }

            //delete string with 0
            if(countOX >= listOfStringsOxigenSize/2.){
                //System.out.println("Brisem nule jer ima jedinica: " + countOX + " a ukupno je: " + listOfStringsOxigenSize );
                for(int i=0; i<listOfStringsOxigen.size(); i++){
                    if(listOfStringsOxigen.get(i).charAt(positionInOneString) == '0'){
                        listOfStringsOxigen.remove(i);
                        i--;
                    }
                }
            }
            else{
                //System.out.println("Brisem jedinice jer ima jedinica: " + countOX + " a ukupno je: " + listOfStringsOxigenSize );
                for(int i=0; i<listOfStringsOxigen.size(); i++){
                    if(listOfStringsOxigen.get(i).charAt(positionInOneString) == '1'){
                        listOfStringsOxigen.remove(i);
                        i--;
                    }
                }
            }
            if (listOfStringsOxigen.size() == 1) break;
            countOX = 0;
        }


        // CO2

        int countCO = 0;

        for(int positionInOneString = 0; positionInOneString <listOfStringsCO2.get(0).length(); positionInOneString++){

            int listOfStringsCo2Size = listOfStringsCO2.size();

            for(int i=0; i<listOfStringsCO2.size(); i++){
                char ch = listOfStringsCO2.get(i).charAt(positionInOneString);
                if(listOfStringsCO2.get(i).charAt(positionInOneString) == '1') countCO++;
            }

            if(countCO < listOfStringsCo2Size/2.){
                //System.out.println("Brisem nule jer ima jedinica: " + countCO + " a ukupno je: " + listOfStringsCo2Size );
                for(int i=0; i<listOfStringsCO2.size(); i++){
                    if(listOfStringsCO2.get(i).charAt(positionInOneString) == '0'){
                        listOfStringsCO2.remove(i);
                        i--;
                    }
                }
            }
            else{
                //System.out.println("Brisem jedinice jer ima jedinica: " + countCO + " a ukupno je: " + listOfStringsCo2Size );
                for(int i=0; i<listOfStringsCO2.size(); i++){
                    if(listOfStringsCO2.get(i).charAt(positionInOneString) == '1'){
                        listOfStringsCO2.remove(i);
                        i--;
                    }
                }
            }

            if (listOfStringsCO2.size() == 1) break;
            countCO = 0;
        }

        int oxygen = Integer.parseInt(listOfStringsOxigen.get(0), 2);
        int CO2 =  Integer.parseInt(listOfStringsCO2.get(0), 2);

        int sum = oxygen * CO2;


        System.out.println(oxygen);
        System.out.println(CO2);

        System.out.println(sum);

        //System.out.println(listOfStringsOxigen.size());
        //System.out.println(listOfStringsCO2.size());
    }
}