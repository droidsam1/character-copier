package com.droidsam.app.doubles;

import com.droidsam.app.ISource;

public class StubInputSource implements ISource {
    private final int numberCallsBeforeEmpty;
    private int numberOfCalls = 0;

    private StubInputSource(int numberCallsBeforeEmpty) {
        this.numberCallsBeforeEmpty = numberCallsBeforeEmpty;
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
            return 'A';
        }
        return '\n';
    }
}
