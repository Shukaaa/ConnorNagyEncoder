# Connor Nagy Encoder

## Description

Just for fun project to meme my friend Connor Nagy.
This is a simple encoder and decoder that takes in a string and turns it into a binary ascii representation.
The 0's and 1's are then replaced with the words "Connor" and "Nagy" respectively.

## Usage

1. Create JAR file with Gradle
```bash
./gradlew jar
```

2. Run JAR file

2.1 Encode a message
```bash
java -jar build/libs/ConnorNagyEncoder-1.0-SNAPSHOT.jar --message "Hello, World!" --mode ENCODE
```
Should return:
```
~ [CN-DECODER CLI] > Encoded message ~
ConnorNagyConnor.NagyConnor...Nagy.Connor.NagyConnorNagyConnorNagy.ConnorNagy.Connor..Nagy.ConnorNagy.Connor..Nagy.ConnorNagy...Connor.NagyConnorNagy.Connor...NagyConnor.....NagyConnorNagyConnorNagy..ConnorNagy.ConnorNagy...ConnorNagy..Connor.NagyConnor.Nagy.ConnorNagy.Connor..Nagy.Connor.NagyConnor...NagyConnor...Nagy
~~~~~~~~~~~~~~~~~~~
```

2.2 Encode a message (minified)
```bash
java -jar build/libs/ConnorNagyEncoder-1.0-SNAPSHOT.jar --message "Hello, World!" --mode ENCODE --encodeMinified
```

Should return:
```
~ [CN-DECODER CLI] > Encoded message (minified) ~
CNC1NC3N1C1NCNCN1CN1C2N1CN1C2N1CN3C1NCN1C3NC5NCNCN2CN1CN3CN2C1NC1N1CN1C2N1C1NC3NC3N
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```

2.3 Decode a message
```bash
java -jar build/libs/ConnorNagyEncoder-1.0-SNAPSHOT.jar --message "ConnorNagyConnor.NagyConnor...Nagy.Connor.NagyConnorNagyConnorNagy.ConnorNagy.Connor..Nagy.ConnorNagy...Connor.NagyConnorNagy.Connor...NagyConnor.....NagyConnorNagyConnorNagy..ConnorNagy.ConnorNagy...ConnorNagy..Connor.NagyConnor.Nagy.ConnorNagy.Connor..Nagy.Connor.NagyConnor...NagyConnor...Nagy" --mode DECODE
```

Should return:
```
~ [CN-DECODER CLI] > Decoded message ~
Hello, World!
~~~~~~~~~~~~~~~~~~~
```

2.4 Decode a message (minified)
```bash
java -jar build/libs/ConnorNagyEncoder-1.0-SNAPSHOT.jar --message "CNC1NC3N1C1NCNCN1CN1C2N1CN1C2N1CN3C1NCN1C3NC5NCNCN2CN1CN3CN2C1NC1N1CN1C2N1C1NC3NC3N" --mode DECODE
```

Should return:
```
~ [CN-DECODER CLI] > Decoded message (minified) ~
Hello, World!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
```