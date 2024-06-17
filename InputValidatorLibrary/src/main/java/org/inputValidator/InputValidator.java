package org.inputValidator;

import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

/**
 * The InputValidator class provides static methods for validating different types of inputs such as emails, passwords,
 * dates, times, countries, URLs, strings, and numbers.
 */
public class InputValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    private static final Pattern PASSWORD_UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
    private static final Pattern PASSWORD_LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
    private static final Pattern PASSWORD_DIGIT_PATTERN = Pattern.compile(".*\\d.*");
    private static final Pattern PASSWORD_SPECIAL_CHAR_PATTERN = Pattern.compile(".*[!@#$%^&*()\\-_=+{};:,<.>].*");
    private static final Pattern PASSWORD_CONSECUTIVE_PATTERN = Pattern.compile(".*(.)\\1{2,}.*");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    /**
     * Validates if the given email is in a proper format.
     *
     * @param email the email address to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates if the given password meets the required criteria.
     *
     * @param password the password to validate
     * @return true if the password is valid, false otherwise
     */
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8 || password.contains(" ")) {
            return false;
        }
        return PASSWORD_UPPERCASE_PATTERN.matcher(password).matches() &&
                PASSWORD_LOWERCASE_PATTERN.matcher(password).matches() &&
                PASSWORD_DIGIT_PATTERN.matcher(password).matches() &&
                PASSWORD_SPECIAL_CHAR_PATTERN.matcher(password).matches() &&
                !PASSWORD_CONSECUTIVE_PATTERN.matcher(password).matches();
    }

    /**
     * Validates if the given date of birth is in the format yyyy-MM-dd and is a date in the past.
     *
     * @param dob the date of birth to validate
     * @return true if the date of birth is valid, false otherwise
     */
    public static boolean isValidDateOfBirth(String dob) {
        return isValidDate(dob, DATE_FORMATTER, LocalDate.now());
    }

    /**
     * Validates if the given date and time are in the format yyyy-MM-dd'T'HH:mm:ss.
     *
     * @param dateTime the date and time to validate
     * @return true if the date and time are valid, false otherwise
     */
    public static boolean isValidDateTime(String dateTime) {
        return isValidDate(dateTime, DATE_TIME_FORMATTER, null);
    }

    private static boolean isValidDate(String date, DateTimeFormatter formatter, LocalDate comparisonDate) {
        if (date == null || date.isEmpty()) {
            return false;
        }
        try {
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            return comparisonDate == null || parsedDate.isBefore(comparisonDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Validates if the given country name is a valid ISO country.
     *
     * @param country the country name to validate
     * @return true if the country name is valid, false otherwise
     */
    public static boolean isValidCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            return false;
        }
        for (String isoCountry : Locale.getISOCountries()) {
            Locale locale = new Locale("", isoCountry);
            if (locale.getDisplayCountry().equalsIgnoreCase(country.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates if the given URL is a valid website URL.
     *
     * @param url the URL to validate
     * @return true if the URL is valid, false otherwise
     */
    public static boolean isValidWebsiteURL(String url) {
        if (url == null || url.isEmpty()) {
            return false;
        }
        try {
            URL validUrl = new URL(url);
            return "http".equals(validUrl.getProtocol()) || "https".equals(validUrl.getProtocol());
        } catch (MalformedURLException e) {
            return false;
        }
    }

    /**
     * Validates if the given input string is not null and not empty after trimming.
     *
     * @param input the string to validate
     * @return true if the string is valid, false otherwise
     */
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    /**
     * Validates if the given input string is a valid number.
     *
     * @param input the string to validate
     * @return true if the string is a valid number, false otherwise
     */
    public static boolean isValidNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
