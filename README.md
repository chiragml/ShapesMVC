***

------------------
# README.MD

------------------------------
Changes Made to the Model
------------------------------

---------------------------------------

While building the model for the program, I had made certain logical assumptions that didn't turn 
out to be optimal for the views. Those changes are listed below.

* While making the model in HW 7, I assumed that the *Scale* is going to be the scale that takes one
input argument and I have to multiply that integer with my actual data to get the new size. However,
To my surprise, the scale was actually a re-size function that gave in as an argument the new sizes 
of the dimensions. 
  * It further became an issue when my method overload for transform got messed up because of this
  new development.

In order to fix this, I made some changes to my transform method and the scale concrete class.
I gave my transform method an extra variable aka dummy variable to denote that this overload method
is reserved for scale and I changed my scale in such a way that it didn't multiply but replaced the
new dimensions from the previous dimensions. 

* The other change that I made was to add a remove shape method to my IAlbum. This just made 
removing shapes easier for me.
* **

------------------------
View
--------------------------
***

Given that both the views shared no features in common, I kept both view separate and had an 
associative connection between my view and my controller. Furthermore, I decided that my one view 
will not be able to communicate with my other view. 

* Swing View: The java swing view had only one entry point to it which was its constructor. This 
design is common for both of my views. The constructor took the input arguments and saved them in 
private instance variables that was further used by my methods inside the view class.
  * Swing View takes help from a helper class named graphical that was responsible for creating the 
  shapes for the snapshot. It took individual snap as input argument  and traversed through it and 
  called swing's paint method on it. 
  * There are separate methods and panels for each function in my swing view including a panel for 
  button etc. This helped me set my layout properly taking care of "Separation of Concerns".
* Web View: The web view made use of buffer Writer to write the output string to a html file that 
could then be used to create the actual HTML + SVG page. The view uses album given to it by the 
controller to get the individual snapshots and respective snapshots to get the shapes and add the 
shapes to the svg tag and put all of this to a string. The obtained string then gets added to file
using buffer writer. 

***

--------------
Controller
---------------
***
The Controller used the input from the Main java file and stored in local variables. The controller 
then parsed the input file and used a scanner to scan through the file. It used a while loop that 
looped through the individual lines of the file by checking if the scanner has any next value(line). 


If the scanner had a next line the controller took that line, trimmed it and divided the line into 
an array of strings with the split delimiter as a whiteSpace. Since the array still could have 
empty strings as its first input character, ran the output array through a loop that would check
if there is an empty string in the array and if there was, it ignored that index and stored rest of 
the array into an arraylist of strings. That arraylist then used the cleaned data to form the album
that is passed to the respective view. To pass the album to correct view and to call the correct 
view, the controller also takes as input the type of view from the main java file. 

***

-------------
Main java file
------------------
***

The main java file took the command line input and took input file, output file(If necessary), 
size of the screen(Optional) and took the type of view to pass them to controller as input arguments.
It also instantiates the album and the controller and sends the instance of album to the controller
as its input argument. It took into consideration the pairs that are compulsory to have in the 
command line to take the arguments to parse through the arguments and get the data from it. 

***
