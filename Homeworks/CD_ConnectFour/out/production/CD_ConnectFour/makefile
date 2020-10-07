default: cpsc2150/connectX/Connect4Game.java
	javac cpsc2150/connectX/Connect4Game.java

run: cpsc2150/connectX/Connect4Game.class
	java cpsc2150.connectX.Connect4Game

test: default
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/connectX/Connect4Game.java cpsc2150/connectX/IGameBoard.java cpsc2150/connectX/TestIGameBoard.java

runtest: cpsc2150/connectX/Connect4Game.class cpsc2150/connectX/IGameBoard.class cpsc2150/connectX/TestIGameBoard.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.connectX.TestIGameBoard

clean:
	rm -f cpsc2150/connectX/*.class

