package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.match.MatchBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.zipcoder.utils.FileReader.*;


public class GroceryReporter {
    private final String originalFileText;
    private String outPut;


    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = readFile(jerksonFileName);
        String tallText = originalFileText.toUpperCase();
        Integer iBox = 0;
        String iName, iType, iExp;
        Double iPrice;

        String patternString = ":(.*?)(;|#)";
//        String patternString = "##";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(tallText);

        int count = 0;
        while (matcher.find()) {
            count++;
//            System.out.println("found: " + count + " : "
//                    + matcher.start() + " - " + matcher.end());
            System.out.println(matcher.group(1));




//            Match(tallText, count, matcher.start(), matcher.end());
//
//            a = MatchBuilder.setValue(tallText);
//            a = MatchBuilder.setMatchNumber(count);
//            a = MatchBuilder.setStartingIndex(matcher.start());
//            a = MatchBuilder.setEndingIndex(matcher.end());
//
//            Match match = new Match.toString();

        }


    }











    @Override
    public String toString() {
        return outPut;
    }


}
