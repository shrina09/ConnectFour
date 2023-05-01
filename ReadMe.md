# Connect Four
Text-base Connect Four game

## Description

A text-based Connect four game which uses 1 and 2 as a the player. It allows for loading the board onto a file of choice at any point in game and continue to play. It detects a winner and a tie as well. It takes user input from the terminal.

## Getting Started
### Dependencies

* It requires no prerequisites, libraries, OS version, etc., needed before installing and running your program. Docker and the e-text that was required for this course is sufficent. The java built-in libaries are used and do not need any other external libraries. They are imported in the program to accomadate. 

### Executing program

* How to build and run the program
* Step-by-step bullets
```
gradle build 
gradle run 
java -cp build/classes/java/main connectfour.ConnectFour
```
* Expected output<br />
0|0|0|0|0|0|0<br />
-+-+-+-+-+-+-<br />
0|0|0|0|0|0|0<br />
-+-+-+-+-+-+-<br />
0|0|0|0|0|0|0<br />
-+-+-+-+-+-+-<br />
0|0|0|0|0|0|0<br />
-+-+-+-+-+-+-<br />
0|0|0|0|0|0|0<br />
-+-+-+-+-+-+-<br />
0|0|0|0|0|0|0<br />

Enter a value between 0-5 for rows & 0-6 for column to play (Ex: 0,0) enter F to load the board on a file:<br />
5,1 (for postion)<br />
F(if a file name should be given to write to)<br />
Enter the name of the file(if out of this directory enter the path with it):<br />
fileName.csv<br />

## Author Information

Your name: Shrina<br />
Email: shrina@uoguelph.ca





