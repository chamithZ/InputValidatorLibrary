import org.inputValidator.InputValidator;
import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
    public void testValidEmail() {
        assertTrue(InputValidator.isValidEmail("test@example.com"));
        assertTrue(InputValidator.isValidEmail("user.name+tag+sorting@example.com"));
        assertTrue(InputValidator.isValidEmail("user_name@example.co.uk"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(InputValidator.isValidEmail("invalid-email"));
        assertFalse(InputValidator.isValidEmail("test@@example.com"));
        assertFalse(InputValidator.isValidEmail("test@.com"));
        assertFalse(InputValidator.isValidEmail("test@com"));
        assertFalse(InputValidator.isValidEmail(null));
        assertFalse(InputValidator.isValidEmail(""));
    }

    @Test
    public void testValidPassword() {
        assertTrue(InputValidator.isValidPassword("aBdguif3*h"));
        assertTrue(InputValidator.isValidPassword("A1b2C3d4!"));
        assertTrue(InputValidator.isValidPassword("P@ssw0rd123!"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(InputValidator.isValidPassword("aaaBdf3*h")); // repeating characters
        assertFalse(InputValidator.isValidPassword("a Bdf3*h")); // contains space
        assertFalse(InputValidator.isValidPassword("aB3*h")); // too short
        assertFalse(InputValidator.isValidPassword("aaaaaaaBdf3*h")); // repeating characters
        assertFalse(InputValidator.isValidPassword("abcdefgh")); // no uppercase, digits, or special chars
        assertFalse(InputValidator.isValidPassword(null));
    }

    @Test
    public void testValidDateOfBirth() {
        assertTrue(InputValidator.isValidDateOfBirth("2000-01-01"));
        assertTrue(InputValidator.isValidDateOfBirth("1990-12-31"));
    }

    @Test
    public void testInvalidDateOfBirth() {
        assertFalse(InputValidator.isValidDateOfBirth("2025-01-01")); // future date
        assertFalse(InputValidator.isValidDateOfBirth("invalid-date"));
        assertFalse(InputValidator.isValidDateOfBirth("01-01-2000")); // wrong format
        assertFalse(InputValidator.isValidDateOfBirth(null));
        assertFalse(InputValidator.isValidDateOfBirth(""));
    }

    @Test
    public void testValidDateTime() {
        assertTrue(InputValidator.isValidDateTime("2023-01-01T10:00:00"));
        assertTrue(InputValidator.isValidDateTime("2022-12-31T23:59:59"));
    }

    @Test
    public void testInvalidDateTime() {
        assertFalse(InputValidator.isValidDateTime("2023-01-01 10:00:00")); // wrong format
        assertFalse(InputValidator.isValidDateTime("invalid-date-time"));
        assertFalse(InputValidator.isValidDateTime("2023-01-32T10:00:00")); // invalid date
        assertFalse(InputValidator.isValidDateTime(null));
        assertFalse(InputValidator.isValidDateTime(""));
    }

    @Test
    public void testValidCountry() {
        assertTrue(InputValidator.isValidCountry("United States"));
        assertTrue(InputValidator.isValidCountry("Canada"));
        assertTrue(InputValidator.isValidCountry("United Kingdom"));
    }

    @Test
    public void testInvalidCountry() {
        assertFalse(InputValidator.isValidCountry("Narnia"));
        assertFalse(InputValidator.isValidCountry("Atlantis"));
        assertFalse(InputValidator.isValidCountry(""));
        assertFalse(InputValidator.isValidCountry(null));
    }

    @Test
    public void testValidWebsiteURL() {
        assertTrue(InputValidator.isValidWebsiteURL("https://www.example.com"));
        assertTrue(InputValidator.isValidWebsiteURL("http://example.com"));
    }

    @Test
    public void testInvalidWebsiteURL() {
        assertFalse(InputValidator.isValidWebsiteURL("invalid-url"));
        assertFalse(InputValidator.isValidWebsiteURL("ftp://example.com")); // non-http/https scheme
        assertFalse(InputValidator.isValidWebsiteURL(null));
        assertFalse(InputValidator.isValidWebsiteURL(""));
    }

    @Test
    public void testValidString() {
        assertTrue(InputValidator.isValidString("Hello World"));
        assertTrue(InputValidator.isValidString("Non-empty string"));
    }

    @Test
    public void testInvalidString() {
        assertFalse(InputValidator.isValidString(""));
        assertFalse(InputValidator.isValidString("   ")); // whitespace only
        assertFalse(InputValidator.isValidString(null));
    }

    @Test
    public void testValidNumber() {
        assertTrue(InputValidator.isValidNumber("12345"));
        assertTrue(InputValidator.isValidNumber("123.45"));
        assertTrue(InputValidator.isValidNumber(" 12345 ")); // trimmable whitespace
    }

    @Test
    public void testInvalidNumber() {
        assertFalse(InputValidator.isValidNumber("abc123"));
        assertFalse(InputValidator.isValidNumber("12.34.56"));
        assertFalse(InputValidator.isValidNumber("123-45"));
        assertFalse(InputValidator.isValidNumber(""));
        assertFalse(InputValidator.isValidNumber(null));
    }
}