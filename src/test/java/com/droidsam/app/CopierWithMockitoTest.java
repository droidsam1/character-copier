package com.droidsam.app;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CopierWithMockitoTest {

    @Test
    void shouldNotCopyAnyCharWhenInputIsEmpty() {
        var input = emptySource();
        var output = spy(IDestination.class);

        new Copier(input, output).Copy();

        verify(output, never()).SetChar(any(char.class));
    }

    @Test
    void shouldCopyTheOnlyCharWhenInputHasOnlyOneChar() {
        var input = oneCharOnly();
        var output = spy(IDestination.class);

        new Copier(input, output).Copy();

        verify(output, atMostOnce()).SetChar(any(char.class));
    }

    @Test
    void shouldCopyMultipleCharsWhenInputHasMultipleChars() {
        var input = tenChars();
        var output = spy(IDestination.class);

        new Copier(input, output).Copy();

        verify(output, times(10)).SetChar(any(char.class));
    }


    private ISource tenChars() {
        var input = mock(ISource.class);
        when(input.GetChar()).thenReturn('A').thenReturn('A').thenReturn('A').thenReturn('A').thenReturn('A').thenReturn('A').thenReturn('A').thenReturn('A').thenReturn('A').thenReturn('A').thenReturn('\n');
        return input;
    }

    private ISource oneCharOnly() {
        var input = mock(ISource.class);
        when(input.GetChar()).thenReturn('A').thenReturn('\n');
        return input;
    }

    private ISource emptySource() {
        var input = mock(ISource.class);
        when(input.GetChar()).thenReturn('\n');
        return input;
    }
}