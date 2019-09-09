# infomedia

To build Application Java 8 should be used and Apache maven > 3.x.\

$mvn clean install

Also surfire reports will be generated (the simpliest few tests).
To run application use the nex command from the root of the project:

$java -jar target/com-infomedia-tennismatch-1.0-SNAPSHOT.jar

Basicaly was used Approach to randomize result of the Tennis Match. So every launch the output will be different.
The result printed to console could be similar to:\
############################\
Ricardo : Rodriguez
0 - 0, 15 - 0\
0 - 0, 30 - 0\
0 - 0, 30 - 15\
0 - 0, 30 - 30\
0 - 0, 30 - 40\
0 - 1, Player 2 - Rodriguez game!\
0 - 1, 0 - 15\
0 - 1, 15 - 15\
0 - 1, 15 - 30\
0 - 1, 15 - 40\
0 - 1, 30 - 40\
0 - 1, Deuce : 0 - 0\
0 - 1, Deuce : 0 - 1\
0 - 1, Deuce : 1 - 1\
0 - 1, Deuce : 2 - 1\
0 - 1, Deuce : 2 - 2\
0 - 1, Deuce : 2 - 3\
0 - 1, Deuce : 3 - 3\
0 - 1, Deuce : 3 - 4\
1 - 1, Deuce : 3 - 5 : Player 1 - Ricardo game!\
1 - 1, 15 - 0\
1 - 1, 30 - 0\
1 - 1, 40 - 0\
1 - 1, 40 - 15\
2 - 1, Player 1 - Ricardo game!\
2 - 1, 15 - 0\
2 - 1, 15 - 15\
2 - 1, 15 - 30\
2 - 1, 30 - 30\
2 - 1, 30 - 40\
2 - 1, Deuce : 0 - 0\
2 - 1, Deuce : 0 - 1\
2 - 2, Deuce : 0 - 2 : Player 2 - Rodriguez game!\
2 - 2, 15 - 0\
2 - 2, 15 - 15\
2 - 2, 30 - 15\
2 - 2, 40 - 15\
2 - 2, 40 - 30\
3 - 2, Player 1 - Ricardo game!\
3 - 2, 0 - 15\
3 - 2, 15 - 15\
3 - 2, 30 - 15\
3 - 2, 40 - 15\
3 - 2, 40 - 30\
4 - 2, Player 1 - Ricardo game!\
4 - 2, 0 - 15\
4 - 2, 15 - 15\
4 - 2, 30 - 15\
4 - 2, 40 - 15\
4 - 2, 40 - 30\
4 - 2, Deuce : 0 - 0\
4 - 2, Deuce : 1 - 0\
5 - 2, Deuce : 2 - 0 : Player 1 - Ricardo game!\
5 - 2, 15 - 0\
5 - 2, 30 - 0\
5 - 2, 40 - 0\
5 - 2, 40 - 15\
5 - 2, 40 - 30\
6 - 2, Player 1 - Ricardo game set!\
##################################
