package com.droidsam.app;


public class Copier {

    private final ISource source;
    private final IDestination destination;

    public Copier(ISource source, IDestination destination) {

        this.source = source;
        this.destination = destination;
    }

    public void Copy() {
        char inputChar = source.GetChar();
        if (inputChar != '\n') {
            destination.SetChar(inputChar);
        }

    }
}
