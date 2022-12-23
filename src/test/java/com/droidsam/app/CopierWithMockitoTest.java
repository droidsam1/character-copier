package com.droidsam.app;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CopierWithMockitoTest {

    public static final char DUMMY_CHAR = 'A';
    public static final char NEW_LINE_CHAR = '\n';

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

    @Test
    void shouldCopySameCharsFromInputToSource() {
        var input = tenChars();
        var output = mock(IDestination.class);

        new Copier(input, output).Copy();

        var captor = ArgumentCaptor.forClass(char.class);
        verify(output, times(10)).SetChar(captor.capture());
        var expectedOutput = String.valueOf(DUMMY_CHAR).repeat(10);
        var actualOutput = captor.getAllValues().stream().map(Object::toString).collect(Collectors.joining());
        assertEquals(expectedOutput, actualOutput);
    }


    private ISource tenChars() {
        var input = mock(ISource.class);
        when(input.GetChar()).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(DUMMY_CHAR).thenReturn(NEW_LINE_CHAR);
        return input;
    }

    private ISource oneCharOnly() {
        var input = mock(ISource.class);
        when(input.GetChar()).thenReturn(DUMMY_CHAR).thenReturn(NEW_LINE_CHAR);
        return input;
    }

    private ISource emptySource() {
        var input = mock(ISource.class);
        when(input.GetChar()).thenReturn(NEW_LINE_CHAR);
        return input;
    }
}