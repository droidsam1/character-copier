package com.droidsam.app.mock;

import com.droidsam.app.IDestination;

import java.util.ArrayList;
import java.util.List;

public class SpyOutputSource implements IDestination {

    public List<Character> receivedChars;

    public SpyOutputSource() {
        receivedChars = new ArrayList<>();
    }

    @Override
    public void SetChar(char character) {
        receivedChars.add(character);
    }

    public int getTotalReceivedChars() {
        return receivedChars.size();
    }
}
