# Mocking Kata (Copier)

* This is part of my practice of exercises provided by the book _Agile Technical Practices Distilled_

The character copier is a simple class that reads characters from a source and copies them to a destination one character at a time.

The character copier gets the source and destination injected in the constructor.

![clas diagram](https://www.planetgeek.ch/wp-content/uploads/2010/03/Copier.png)

When the method **Copy** is called on the copier, then it should read characters from the source and copy them to the destination until the source returns a newline (**\n**).

The exercise is to implement the character copier using mocks for the source and the destination (try using manually written mocks and mocks written with a mocking framework.

## POINTS OF INTEREST
The following points make this exercise interesting:

* Good exercise to compare manually written mocks to generated ones.  
* Ordering of calls on destination is important
* Small steps: first copy a single character, then multiples ending with **\n** 
* Very concise

Happy mocking!<br>