package com.droidsam.app;

import com.droidsam.app.doubles.EmptySource;
import com.droidsam.app.mock.SpyOutputSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CopierTest {

    @Test
    void shouldNotCopyAnyCharWhenInputIsEmpty() {
        var input = new EmptySource();
        var output = new SpyOutputSource();

        new Copier(input, output).Copy();

        assertEquals(0, output.getTotalReceivedChars());
    }
}