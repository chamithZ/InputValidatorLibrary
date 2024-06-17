package org.inputValidator;

public class Main {
    public static void main(String[] args) {
        // Test email validation
        System.out.println(InputValidator.isValidEmail("test@example.com")); // true
        System.out.println(InputValidator.isValidEmail("invalid-email")); // false
        System.out.println(InputValidator.isValidEmail("test@@example.com")); // false

        // Test password validation
        System.out.println(InputValidator.isValidPassword("aaBdf3*h")); // true
        System.out.println(InputValidator.isValidPassword("aaaBdf3*h")); // false
        System.out.println(InputValidator.isValidPassword("aaBdf3h")); // false (missing special character)
        System.out.println(InputValidator.isValidPassword("a Bdf3*h")); // false (contains space)

        // Test date of birth validation
        System.out.println(InputValidator.isValidDateOfBirth("2000-01-01")); // true
        System.out.println(InputValidator.isValidDateOfBirth("2024-01-01")); // false (future date)
        System.out.println(InputValidator.isValidDateOfBirth("invalid-date")); // false

        // Test date & time validation
        System.out.println(InputValidator.isValidDateTime("2023-01-01T10:00:00")); // true
        System.out.println(InputValidator.isValidDateTime("2023-01-01 10:00:00")); // false (invalid format)
        System.out.println(InputValidator.isValidDateTime("invalid-date-time")); // false

        // Test country validation
        System.out.println(InputValidator.isValidCountry("United States")); // true
        System.out.println(InputValidator.isValidCountry("Narnia")); // false
        System.out.println(InputValidator.isValidCountry("")); // false

        // Test website URL validation
        System.out.println(InputValidator.isValidWebsiteURL("https://www.example.com")); // true
        System.out.println(InputValidator.isValidWebsiteURL("invalid-url")); // false
        System.out.println(InputValidator.isValidWebsiteURL("ftp://example.com")); // false (non-http/https scheme)

        // Test string validation
        System.out.println(InputValidator.isValidString("Hello World")); // true
        System.out.println(InputValidator.isValidString("")); // false
        System.out.println(InputValidator.isValidString("   ")); // false

        // Test number validation
        System.out.println(InputValidator.isValidNumber("12345")); // true
        System.out.println(InputValidator.isValidNumber("abc123")); // false
        System.out.println(InputValidator.isValidNumber(" 12345 ")); // true (trimmable whitespace)
    }
}