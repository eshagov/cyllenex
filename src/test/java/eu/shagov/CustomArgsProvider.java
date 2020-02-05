package eu.shagov;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CustomArgsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of("Russia", "RU", "Moscow", 7),
                Arguments.of("Eesti", "EE", "Tallinn", 372),
                Arguments.of("Latvias", "LV", "Riga", 371)
        );
    }
}
