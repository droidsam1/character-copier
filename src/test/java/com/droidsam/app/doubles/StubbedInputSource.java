package com.droidsam.app.doubles;

import com.droidsam.app.ISource;

public class StubbedInputSource implements ISource {
    private final int numberCallsBeforeEmpty;
    private int numberOfCalls = 0;

    private StubbedInputSource(int numberCallsBeforeEmpty) {
        this.numberCallsBeforeEmpty = numberCallsBeforeEmpty;
    }

    public static StubbedInputSource onlyOneCharBeforeEmpty() {
        return new StubbedInputSource(1);
    }

    @Override
    public char GetChar() {
        if (numberOfCalls++ < numberCallsBeforeEmpty) {
            return 'A';
        }
        return '\n';
    }
}
