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

    private ISource emptySource() {
        var input = mock(ISource.class);
        when(input.GetChar()).thenReturn('\n');
        return input;
    }
}