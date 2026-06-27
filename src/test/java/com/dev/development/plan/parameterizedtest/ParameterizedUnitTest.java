package com.dev.development.plan.parameterizedtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dev.development.plan.unittesting.Numbers;
import java.time.Month;
import java.util.List;
import java.util.Arrays;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.FieldSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedUnitTest {

  static List<String> cities = Arrays.asList("Madrid", "Rome", "Paris", "London");

  @ParameterizedTest
  @ValueSource(ints = {2, 4, 6, 8})
  void testIfTheNumberIsEven(int number) {
    assertEquals(0, number % 2);
  }

  @ParameterizedTest
  @CsvSource({
      "apple, 5",
      "banana, 6",
      "cherry, 6"
  })
  void testSomething(String input, int inputLength) {
    assertEquals(inputLength, input.length());
  }


  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, 7})
  void isNumberOdd(int number) {
    assertTrue(Numbers.isOdd(number));
  }


  @ParameterizedTest
  @EnumSource(Month.class)
  void checkIfMonthsNumberAreBetweenOneAndTwelve(Month month) {
    int monthValue = month.getValue();
    assertTrue(monthValue >= 1 && monthValue <= 12);
  }

  @ParameterizedTest
  @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
  void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
    String actualValue = input.toUpperCase();
    assertEquals(expected, actualValue);
  }


  @ParameterizedTest
  @MethodSource("com.dev.development.plan.unittesting.StringParams#blankStrings")
  void isBlankShouldReturnTrueForNullOrBlankStringsExternalSource(String input) {
    assertTrue(Strings.isBlank(input));
  }


  @ParameterizedTest
  @FieldSource
  void cities(String city) {
    assertFalse(city.isBlank());
  }

}
