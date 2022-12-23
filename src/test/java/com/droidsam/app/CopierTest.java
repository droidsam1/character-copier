package com.droidsam.app;

import com.droidsam.app.doubles.StubInputSource;
import com.droidsam.app.mock.SpyOutputSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CopierTest {

    @Test
    void shouldNotCopyAnyCharWhenInputIsEmpty() {
        var input = StubInputSource.empty();
        var output = new SpyOutputSource();

        new Copier(input, output).Copy();

        assertEquals(0, output.getTotalReceivedChars());
    }

    @Test
    void shouldCopyTheOnlyCharWhenInputHasOnlyOneChar() {
        var input = StubInputSource.oneCharOnly();
        var output = new SpyOutputSource();

        new Copier(input, output).Copy();

        assertEquals(1, output.getTotalReceivedChars());
    }

    @Test
    void shouldCopyMultipleCharsWhenInputHasMultipleChars() {
        var input = StubInputSource.tenChars();
        var output = new SpyOutputSource();

        new Copier(input, output).Copy();

        assertEquals(10, output.getTotalReceivedChars());
    }
}