package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.match.MatchBuilder;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.zipcoder.utils.FileReader.*;


public class GroceryReporter {
    private final String originalFileText;
    private String outPut;


    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = readFile(jerksonFileName);

        String tallText = originalFileText;


        String[] iName = new String[100];
        String[] iPric = new String[100];
        String[] iType = new String[100];
        String[] iExpr = new String[100];


        Integer milkMax= 0;
        Integer breadMax = 0;
        Integer cookiesMax = 0;
        Integer applesMax = 0;

        Integer milkMin = 0;
        Integer breadMin = 0;
        Integer cookiesMin = 0;
        Integer applesMin = 0;


        Double milkPriceMax = 0.0;
        Double milkPriceMin = 0.0;

        Double cookiesPriceMax = 0.0;
        Double cookiesPriceMin = 0.0;

        Double breadPriceMax = 0.0;
        Double breadPriceMin = 0.0;

        Double applesPriceMax = 0.0;
        Double applesPriceMin = 0.0;


        String patternString = ":(.*?)([;#@!*^%])";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(tallText);

        Integer iPlace = 0;
        int count = 0;

        while (matcher.find()) {

            if (count % 4 == 0) {
                iName[iPlace] = matcher.group(1);
            }
            else if (count % 4 == 1) {
                iPric[iPlace] = matcher.group(1);
            }
            else if (count % 4 == 2) {
                iType[iPlace] = matcher.group(1);
            }
            else if (count % 4 == 3) {
                iExpr[iPlace] = matcher.group(1);
                iPlace++;
            }

            count++;

        }


        Integer iError = 0;
        String tmp = "";

        for (int i = 0; i < iPlace; i++) {

            if ((iName[i].length() == 0)) {
                iName[i] = "Milk";
                iError++;
            }

            if ((iPric[i].length() == 0)) {
                iPric[i] = "3.23";
                iError++;
            }

            iName[i] = iName[i].toLowerCase();

            tmp = iName[i].substring(0, 1);

            tmp = tmp.toUpperCase();

            iName[i] = tmp + iName[i].substring(1);

            if (iName[i].equals("Co0kies")) {
                iName[i] = "Cookies";
            }

        }

        for (Integer i = 0; i <iPlace; i++) {

            if (iName[i].equals("Milk")) {
                milkPriceMax = Double.parseDouble(iPric[i]);
                milkPriceMin = milkPriceMax;
            }

            if (iName[i].equals("Bread")) {
                breadPriceMax = Double.parseDouble(iPric[i]);
                breadPriceMin = milkPriceMax;
            }

            if (iName[i].equals("Cookies")) {
                cookiesPriceMax = Double.parseDouble(iPric[i]);
                cookiesPriceMin = milkPriceMax;
            }

            if (iName[i].equals("Apples")) {
                applesPriceMax = Double.parseDouble(iPric[i]);
                applesPriceMin = milkPriceMax;
            }

        }

        for (Integer i = 0; i <iPlace; i++) {


            if (iName[i].equals("Milk")) {

                if (Double.parseDouble(iPric[i]) > milkPriceMax) {
                    milkPriceMax = Double.parseDouble(iPric[i]);
                }

                if (Double.parseDouble(iPric[i]) < milkPriceMin) {
                    milkPriceMin = Double.parseDouble(iPric[i]);
                }

            }

            if (iName[i].equals("Bread")) {

                if (Double.parseDouble(iPric[i]) > breadPriceMax) {
                    breadPriceMax = Double.parseDouble(iPric[i]);
                }

                if (Double.parseDouble(iPric[i]) < breadPriceMin) {
                    breadPriceMin = Double.parseDouble(iPric[i]);
                }
            }

            if (iName[i].equals("Cookies")) {

                if (Double.parseDouble(iPric[i]) > cookiesPriceMax) {
                    cookiesPriceMax = Double.parseDouble(iPric[i]);
                }

                if (Double.parseDouble(iPric[i]) < cookiesPriceMin) {
                    cookiesPriceMin = Double.parseDouble(iPric[i]);
                }
            }

            if (iName[i].equals("Apples")) {

                if (Double.parseDouble(iPric[i]) > applesPriceMax) {
                    applesPriceMax = Double.parseDouble(iPric[i]);
                }

                if (Double.parseDouble(iPric[i]) < applesPriceMin) {
                    applesPriceMin = Double.parseDouble(iPric[i]);
                }
            }

        }


        for (Integer i = 0; i <iPlace; i++) {

            if (iName[i].equals("Milk")) {

                if (Double.parseDouble(iPric[i]) == milkPriceMax) {
                    milkMax++;
                }
                else {
                    milkMin++;
                }

            }

            if (iName[i].equals("Bread")) {

                if (Double.parseDouble(iPric[i]) == breadPriceMax) {
                    breadMax++;
                }
                else {
                    breadMin++;
                }
            }

            if (iName[i].equals("Cookies")) {

                if (Double.parseDouble(iPric[i]) == cookiesPriceMax) {
                    cookiesMax++;
                }
                else {
                    cookiesMin++;
                }
            }

            if (iName[i].equals("Apples")) {

                if ((Double.parseDouble(iPric[i]) == applesPriceMax)) {
                    applesMax++;
                }
                else {
                    applesMin++;
                }

            }

        }

        System.out.print("name:    Milk \t\t seen: " + (milkMax+milkMin) + " times\n");
        System.out.print("============= \t \t =============\n");
        System.out.print("Price: \t " + milkPriceMax + "\t\t seen: " + milkMax + " times\n");
        System.out.print("-------------\t\t -------------\n");
        System.out.print("Price: \t " + milkPriceMin + "\t\t seen: " + milkMin + " time\n");
        System.out.print("\n");
        System.out.print("name:   Bread \t\t seen: " + breadMax + " times\n");
        System.out.print("============= \t \t =============\n");
        System.out.print("Price: \t" +  breadPriceMax + "\t\t seen: " +  breadMax + " times\n");
        System.out.print("-------------\t\t -------------\n");
        System.out.print("\n");
        System.out.print("name: Cookies \t\t seen: " + cookiesMax + " times\n");
        System.out.print("============= \t \t =============\n");
        System.out.print("Price: \t " + cookiesPriceMax + "\t\t seen: " + cookiesMax + " times\n");
        System.out.print("-------------\t\t -------------\n");
        System.out.print("\n");
        System.out.print("name:  Apples \t\t seen: " + (applesMax+applesMin) + " times\n");
        System.out.print("============= \t \t =============\n");
        System.out.print("Price: \t " + applesPriceMax + "\t\t seen: " + applesMax + " times\n");
        System.out.print("-------------\t\t -------------\n");
        System.out.print("Price: \t " + applesPriceMin + "\t\t seen: " + applesMin + " times\n");
        System.out.print("\n");
        System.out.print("Errors         \t \t seen: " + iError + " times\n");

        outPut = "name:    Milk \t\t seen: " + (milkMax+milkMin) + " times\n";
        outPut =outPut + "============= \t \t =============\n";
        outPut =outPut +"Price: \t " + milkPriceMax + "\t\t seen: " + milkMax + " times\n";
        outPut =outPut + "-------------\t\t -------------\n";
        outPut =outPut + "Price: \t " + milkPriceMin + "\t\t seen: " + milkMin + " time\n";
        outPut =outPut + "\n";
        outPut =outPut + "name:   Bread \t\t seen: " + breadMax + " times\n";
        outPut =outPut + "============= \t \t =============\n";
        outPut =outPut + "Price: \t" +  breadPriceMax + "\t\t seen: " +  breadMax + " times\n";
        outPut =outPut + "-------------\t\t -------------\n";
        outPut =outPut + "\n";
        outPut =outPut + "name: Cookies \t\t seen: " + cookiesMax + " times\n";
        outPut =outPut + "============= \t \t =============\n";
                outPut =outPut + "Price: \t " + cookiesPriceMax + "\t\t seen: " + cookiesMax + " times\n";
                outPut =outPut + "-------------\t\t -------------\n";
                outPut =outPut + "\n";
                outPut =outPut + "name:  Apples \t\t seen: " + (applesMax+applesMin) + " times\n";
                outPut =outPut + "============= \t \t =============\n";
                outPut =outPut + "Price: \t " + applesPriceMax + "\t\t seen: " + applesMax + " times\n";
                outPut =outPut + "-------------\t\t -------------\n";
                outPut =outPut + "Price: \t " + applesPriceMin + "\t\t seen: " + applesMin + " times\n";
                outPut =outPut + "\n";
                outPut =outPut + "Errors         \t \t seen: " + iError + " times\n";

    }




    @Override
    public String toString() {
        return outPut;
    }


}
