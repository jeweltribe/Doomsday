Author: Varun Rai

Tic tac toe that uses the red and yellow discs from connect 4. 
Three images are used, one for the board and the other two for player representation.
The board is added as a drawable source for a GridLayout that is 3x3. There are 9 ImageViews
in each section of the board. At the start these ImageView are blank and don't associate with 
either of the two drawables for red and yellow. 

When the user selects a spot on the board, the ImageView is first moved off the screen on the y axis,
by 1000 pixels. Then, depending on the player turn, the ImageView's image is set. Then the animate() 
method is called to have the discs dropin from the top of the screen. 