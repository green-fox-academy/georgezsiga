import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Created by georgezsiga on 4/5/17.
 */
class ExtensionTest {

  Extension extension = new Extension();

  @Test
  void testAdd_2and3is5() {
    assertEquals(5, extension.add(2, 3));
  }

  @Test
  void testAdd_4and4is5() {
    assertEquals(8, extension.add(4, 4));
  }

  @Test
  void testMaxOfThree_first() {
    assertEquals(5, extension.maxOfThree(5, 4, 3));
  }

  @Test
  void testMaxOfThree_third() {
    assertEquals(5, extension.maxOfThree(3, 4, 5));
  }

  @Test
  void testMedian_four() {
    assertEquals(5, extension.median(Arrays.asList(7,5,3,5)));
  }
  @Test
  void testMedian_five() {
    assertEquals(3, extension.median(Arrays.asList(1,2,3,4,5)));
  }

  @Test
  void testMedian_d1() {
    assertEquals(4.5, extension.median(Arrays.asList(1,2,3,4,5,6,7,8)));
  }

  @Test
  void testMedian_double2() {
    assertEquals(4, extension.median(Arrays.asList(1,1,10,2,20,6)));
  }

  @Test
  void testIsVowel_a() {
    assertTrue(extension.isVowel('a'));
  }

  @Test
  void testIsVowel_u() {
    assertFalse(extension.isVowel('c'));
  }

  @Test
  void testTranslate_bemutatkozik() {
    assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
  }

  @Test
  void testTranslate_kolbice() {
    assertEquals("lavagovopuvus", extension.translate("lagopus"));
  }

//  @Test
//  void testTranslate_a() {
//    assertEquals("ava", extension.translate("a"));
//  }
  @Test
  void testTranslate_b() {
    assertEquals("b", extension.translate("b"));
  }
//  @Test
//  void testTranslate_aaa() {
//    assertEquals("avaavaava", extension.translate("aaa"));
//  }

  @Test
  void testTranslate_bbb() {
    assertEquals("bbb", extension.translate("bbb"));
  }
}
