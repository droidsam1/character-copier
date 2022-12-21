package com.droidsam.app.doubles;

import com.droidsam.app.ISource;

public class EmptySource implements ISource {
    @Override
    public char GetChar() {
        return '\n';
    }
}
