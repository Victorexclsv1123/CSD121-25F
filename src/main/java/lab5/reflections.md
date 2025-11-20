1.Why can you change the type of the returned value in promptForPlayer without changing the return type in the function signature?
you can return the humanplayer or computerplayer because they are all came from the playerclass, in short they are all extended player. it can accept any 
subclass so it doesnt matter to change the return type.

2.Explain why the error occurred initially and why adding the abstract method signature fixes the error.
The error started because whoseTurn was typed as Player, and the Player class no longer had that method once pickNextMove was moved to HumanPlayer.
The mistake is fixed by adding an abstract pickNextMove back into Player since all Player subclasses now need to implement it,
allowing pickNextMove to be called on whoseTurn once more.



