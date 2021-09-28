package ex24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AnagramTest {
    @Test
    public void TestAnagram(){
        assertTrue(Anagram.isAnagram("tar", " rat"));
        assertTrue(Anagram.isAnagram("arc ", "car"));
        assertTrue(Anagram.isAnagram(" elbow ", " below"));
        assertTrue(Anagram.isAnagram("state", "taste "));
        assertTrue(Anagram.isAnagram("stressed", "desserts"));
        assertFalse(Anagram.isAnagram("testing", "anagrams"));
        assertFalse(Anagram.isAnagram("following", "follow"));
        assertFalse(Anagram.isAnagram("anagrams", "anagram"));
        assertFalse(Anagram.isAnagram("tattarrattat", "tattarratrat"));
    }
}