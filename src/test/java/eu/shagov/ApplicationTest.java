package eu.shagov;

import java.util.HashMap;
import java.util.stream.Stream;
import eu.shagov.enums.SomeEnumType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class ApplicationTest {

    @DisplayName("Value source test")
    @ParameterizedTest(name = "Display name: {displayName} - Index: {index} - Arguments: {arguments} ")
    @ValueSource(strings = {"Param 1", "Param 2"})
    void testValueSource(String param) {
        System.out.println(param);
    }

    @DisplayName("Repeated test")
    @RepeatedTest(value = 1, name = "Display name: {displayName} - {currentRepetition} of {totalRepetitions} ")
    void testDependencyInjection(TestInfo testInfo,
                                 RepetitionInfo repetitionInfo,
                                 TestReporter testReporter) {
        System.out.println("Test info: " + testInfo.getDisplayName());
        System.out.println("- Class : " + testInfo.getTestClass().get().getName());
        System.out.println("- Method : " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition info: " + repetitionInfo);

        HashMap<String, String> values = new HashMap<>();
        values.put("name", "john");
        values.put("surname", "doe");

        testReporter.publishEntry(values);
    }

    @DisplayName("Params as enum test")
    @ParameterizedTest(name = "Display name: {displayName} - Index: {index} - Arguments: {arguments} ")
    @EnumSource(SomeEnumType.class)
    void paramsEnumTest(SomeEnumType someEnumType) {
        System.out.println(someEnumType.name());
    }

    @DisplayName("Params as csv test")
    @ParameterizedTest(name = "Display name: {displayName} - Index: {index} - Arguments: {arguments} ")
    @CsvSource(value = {
            "Russia; RUS; Moscow; 7",
            "Eesti; EST; Tallinn; 372",
            "Latvias; LAT; Riga; 371",
    }, delimiter = ';')
    void paramsCsvTest(String country, String countryCode, String capital, Integer prefix) {
        System.out.printf("%s %s %s %d", country, countryCode, capital, prefix);
    }

    @DisplayName("Params as csv file test")
    @ParameterizedTest(name = "Display name: {displayName} - Index: {index} - Arguments: {arguments} ")
    @CsvFileSource(resources = "/csvs/test.csv", numLinesToSkip = 1, delimiter = ';')
    void paramsCsvFileTest(String country, String countryCode, String capital, Integer prefix) {
        System.out.printf("%s %s %s %d", country, countryCode, capital, prefix);
    }

    @DisplayName("Params as Method provider test")
    @ParameterizedTest(name = "Display name: {displayName} - Index: {index} - Arguments: {arguments} ")
    @MethodSource("getArgs")
    void paramsMethodProviderTest(String country, String countryCode, String capital, Integer prefix) {
        System.out.printf("%s %s %s %d", country, countryCode, capital, prefix);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("Russia", "RUS", "Moscow", 7),
                Arguments.of("Eesti", "EST", "Tallinn", 372),
                Arguments.of("Latvias", "LAT", "Riga", 371)
        );
    }

    @DisplayName("Params as Custom arguments provider test")
    @ParameterizedTest(name = "Display name: {displayName} - Index: {index} - Arguments: {arguments} ")
    @ArgumentsSource(CustomArgsProvider.class)
    void paramsCustomArgsProviderTest(String country, String countryCode, String capital, Integer prefix) {
        System.out.printf("%s %s %s %d", country, countryCode, capital, prefix);
    }
}