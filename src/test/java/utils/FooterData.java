package utils;

import java.util.ArrayList;
import java.util.List;

public class FooterData {

    public static final String LINKEDIN = "Visit us on LinkedIn";
    public static final String TWITTER = "Visit us on Twitter";
    public static final String YOUTUBE = "Visit us on YouTube";
    public static final String WROCLAW_NAME = "A4BEE HQ Wroclaw";
    public static final String WARSAW_NAME = "A4BEE Warsaw";

    public static List<String> getListOfCompanyNames() {
        List<String> listOfCompanyNames = new ArrayList<>();
        listOfCompanyNames.add(WROCLAW_NAME);
        listOfCompanyNames.add(WARSAW_NAME);
        return listOfCompanyNames;
    }

    public static List<String> getListOfSocialMedia() {
        List<String> listOfSocialMedia = new ArrayList<>();
        listOfSocialMedia.add(LINKEDIN);
        listOfSocialMedia.add(TWITTER);
        listOfSocialMedia.add(YOUTUBE);
        return listOfSocialMedia;
    }
}
