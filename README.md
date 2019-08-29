<h1 align="center">Guessing Game</h1>
<p align="left"><strong>Description</strong>
<br>  This guessing game is loosely inspired by https://en.akinator.com. To play the game you must first think of a random animal. Then the program asks a series of questions to the user, to which a yes or no answer is given. Once the necessary amount of questions are asked, the program will make a guess to what "animal" you have chosen. If the guess is wrong, the program will ask for the answer and a question which leads to this answer and add it to the game's database. The program will also automatically create a path to reach this answer from the series of questions. Everytime the game is played, more data is added to the database; therefore the next user will also have this answer avialable. Since there is a database, the game will not reset everytime the program is compiled and excecuted. </p>

<p align="left"><strong>Implementation Details</strong>
<br>  The project contains a text file which serves as an data base and a dynamic binary decision tree which stores the information. Each spot on the tree consists of a node class which contains data and two references to other nodes. The data is stored in level-order line by line. If a node is missing, the line is simply left blank. When the initial tree is first built the data is read in level order and the tree is built recursively and the data is read iteratively. After each game the private method update() is called to store the data, while the class constructor makes the tree. </p>

<h2>Key learnings</h2>

- OOP  
- Database storage and usage
- Binary Decision Trees
- Level Order and Preorder Traversal.
- Recusion
- Dynamic Programming

<h2>Installation</h2>


  
  
