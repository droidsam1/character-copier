package com.droidsam.app.doubles;

import com.droidsam.app.ISource;

import java.util.Arrays;

public class StubInputSource implements ISource {
    private final int numberCallsBeforeEmpty;
    private final char[] fullSourceChars;
    private int numberOfCalls = 0;

    private StubInputSource(int numberCallsBeforeEmpty) {
        this.numberCallsBeforeEmpty = numberCallsBeforeEmpty;
        this.fullSourceChars = new char[numberCallsBeforeEmpty];
        Arrays.fill(this.fullSourceChars, 'A');
    }

    public static StubInputSource oneCharOnly() {
        return new StubInputSource(1);
    }

    public static StubInputSource tenChars() {
        return new StubInputSource(10);
    }

    public static StubInputSource empty() {
        return new StubInputSource(0);
    }

    @Override
    public char GetChar() {
        if (numberOfCalls++ < numberCallsBeforeEmpty) {
            return fullSourceChars[numberOfCalls - 1];
        }
        return '\n';
    }
}
