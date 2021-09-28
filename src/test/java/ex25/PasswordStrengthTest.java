package ex25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthTest {

    @Test
    void validateVeryWeak() {
        assertTrue(PasswordStrength.validateVeryWeak("1234567"));
        assertTrue(PasswordStrength.validateVeryWeak("1111111"));
        assertTrue(PasswordStrength.validateVeryWeak("1"));
        assertFalse(PasswordStrength.validateVeryWeak("12345678"));
        assertFalse(PasswordStrength.validateVeryWeak("123Q"));
        assertFalse(PasswordStrength.validateVeryWeak("a"));
    }

    @Test
    void validateWeak() {
        assertTrue(PasswordStrength.validateWeak("abcdefg"));
        assertTrue(PasswordStrength.validateWeak("AAAAAAA"));
        assertTrue(PasswordStrength.validateWeak("A"));
        assertFalse(PasswordStrength.validateWeak("abcdefgh"));
        assertFalse(PasswordStrength.validateWeak("abc32$"));
        assertFalse(PasswordStrength.validateWeak("1"));
    }

    @Test
    void validateStrong() {
        assertTrue(PasswordStrength.validateStrong("rjfdrfo9"));
        assertTrue(PasswordStrength.validateStrong("S9hSnX324dfgX"));
        assertTrue(PasswordStrength.validateStrong("1qqqqqqq"));
        assertFalse(PasswordStrength.validateStrong("xf7rder"));
        assertFalse(PasswordStrength.validateStrong("thfdeutf"));
        assertFalse(PasswordStrength.validateStrong("68547623"));
    }

    @Test
    void validateVeryStrong() {
        assertTrue(PasswordStrength.validateVeryStrong("hfdX3ie#"));
        assertTrue(PasswordStrength.validateVeryStrong("@rjgfdsE3"));
        assertTrue(PasswordStrength.validateVeryStrong("|ghgews4"));
        assertFalse(PasswordStrength.validateVeryStrong("37"));
        assertFalse(PasswordStrength.validateVeryStrong("password"));
        assertFalse(PasswordStrength.validateVeryStrong("4gjf5423"));
    }

    @Test
    void passwordValidator() {
        assertEquals(1, PasswordStrength.passwordValidator("1234567"));
        assertEquals(1, PasswordStrength.passwordValidator("2"));
        assertEquals(1, PasswordStrength.passwordValidator("000"));
        assertEquals(2, PasswordStrength.passwordValidator("aaa"));
        assertEquals(2, PasswordStrength.passwordValidator("z"));
        assertEquals(2, PasswordStrength.passwordValidator("admin"));
        assertEquals(3, PasswordStrength.passwordValidator("gjS87Sw3"));
        assertEquals(3, PasswordStrength.passwordValidator("aaaaaaa1"));
        assertEquals(3, PasswordStrength.passwordValidator("gjS87Sw3"));
        assertEquals(4, PasswordStrength.passwordValidator("57fhg74#"));
        assertEquals(4, PasswordStrength.passwordValidator("tjg8S49)))))))))"));
        assertEquals(4, PasswordStrength.passwordValidator("&gh67d1A"));
    }
}