import org.example.Anagram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramTest {
    Anagram anagram = new Anagram();

    @Test
    public void isAnagramWithBoolAndNullMethods(){
        Boolean hasWord = anagram.compareWord("Mani","Mani");
        assertNotNull(hasWord);

        Boolean equalWords = anagram.compareWord("Mani","Mani");
        assertFalse(equalWords);

        Boolean differentWordsAnagram = anagram.compareWord("Poder","Pedro");
        assertTrue(differentWordsAnagram);
    }

    @Test
    public void isAnagramWithAssertMethods(){
        assertNotEquals(true, anagram.compareWord("Ruido","Oscar"));
        assertEquals(true, anagram.compareWord("Llenaba","Ballena"));
    }

}
