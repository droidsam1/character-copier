package com.droidsam.app;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CopierWithMockitoTest {

    @Test
    void shouldNotCopyAnyCharWhenInputIsEmpty() {
        var input = mock(ISource.class);
        var output = spy(IDestination.class);

        when(input.GetChar()).thenReturn('\n');

        new Copier(input, output).Copy();

        verify(output, never()).SetChar(any(char.class));
    }
}