# battleship

This java program implements a command line-based variation of the 
[Battleship](https://en.wikipedia.org/wiki/Battleship_(game)) game.

## Usage

Compilation:

```bash
javac .\Battleship.java
```
Run:

```bash
java Battleship
```

## Example

```bash
java Battleship

***** Welcome to the Battleship game! *****

Available commands:
 1) show ships - displays the dashboard along with the positions of ships
 2) XY - fire at the coordinates XY. Where X is in [A-H] and Y is in [1-8]
 3) quit - exit from the game
 4) help - shows a list with the available commands
 Note: O indicates a miss and X indicates a hit

  1 2 3 4 5 6 7 8
A - - - - - - - -
B - - - - - - - -
C - - - - - - - -
D - - - - - - - -
E - - - - - - - -
F - - - - - - - -
G - - - - - - - -
H - - - - - - - -

> a1

Miss!

  1 2 3 4 5 6 7 8
A O - - - - - - -
B - - - - - - - -
C - - - - - - - -
D - - - - - - - -
E - - - - - - - -
F - - - - - - - -
G - - - - - - - -
H - - - - - - - -

> b2

Miss!

  1 2 3 4 5 6 7 8
A O - - - - - - -
B - O - - - - - -
C - - - - - - - -
D - - - - - - - -
E - - - - - - - -
F - - - - - - - -
G - - - - - - - -
H - - - - - - - -

> c5

Hit!

  1 2 3 4 5 6 7 8
A O - - - - - - -
B - O - - - - - -
C - - - - X - - -
D - - - - - - - -
E - - - - - - - -
F - - - - - - - -
G - - - - - - - -
H - - - - - - - -

> help

Available commands:
 1) show ships - displays the dashboard along with the positions of ships
 2) XY - fire at the coordinates XY. Where X is in [A-H] and Y is in [1-8]
 3) quit - exit from the game
 4) help - shows a list with the available commands
 Note: O indicates a miss and X indicates a hit

  1 2 3 4 5 6 7 8
A O - - - - - - -
B - O - - - - - -
C - - - - X - - -
D - - - - - - - -
E - - - - - - - -
F - - - - - - - -
G - - - - - - - -
H - - - - - - - -

> show ships

 The ships are revealed in the grid below.

  1 2 3 4 5 6 7 8
A - - - F B - - -
B C - - F B - - -
C C - - F B - - -
D C - - F - D - -
E - - - F - D - -
F - A A - - D - -
G - - - - - D - -
H - - - - - - - -


  1 2 3 4 5 6 7 8
A O - - - - - - -
B - O - - - - - -
C - - - - X - - -
D - - - - - - - -
E - - - - - - - -
F - - - - - - - -
G - - - - - - - -
H - - - - - - - -

> quit

 The ships are revealed in the grid below.

  1 2 3 4 5 6 7 8
A - - - F B - - -
B C - - F B - - -
C C - - F B - - -
D C - - F - D - -
E - - - F - D - -
F - A A - - D - -
G - - - - - D - -
H - - - - - - - -


Thank you for playing. Goodbye!
```

## Author

Giorgos Argyrides (g.aryrides@outlook.com)
