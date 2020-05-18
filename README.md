# Music Visualiser Project

Name: Adam Cooney

Student Number: C18372086

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
I got my inspiration for this assignment when I was listening to some RnB from the early 2000's. It got me thinking of the old boom boxes that people
used to listen to their music on. So for my first visual I thought it would be really cool if I created an audio visual of one of these boom boxes.
For my SpiralSpeaker.java visual, I wanted to carry on with the theme of the boom box I created in the first visual, and I wanted to make another speaker-like visual. This time
I took the image of a water speaker, as the lines on them shoot up when the amplitude is increased, and I created something similar to it.
For my Cubes.java visual I wanted to create a visual that the user could interact with. So, I decided to take a similar approach to the starter code where the cubes could 
be separated and I wanted to add more colours and features to it like making multiple cubes expand when the amplitude is increased.
The song I used for this assignment is called 'Techno My EchoOo' which I found on https://freemusicarchive.org/ which is a royalty-free music website.

# Instructions
As far as instructions go, there are not many. In my Cubes.java file you can duplicate the number of cubes that appear on the screen 
by pressing the number '2' on your keypad and then return from two cubes back to one cube on the screen by pressing '2' again. Similarly, you
can increase the number of cubes that are on screen to 4 by pressing the number '4' on your keypad and return from 4 cubes back to 1 cube
by pressing the number '4' again.

# How it works
Boombox.java:
The code for this visual was not too complex. It involved creating many different shapes of different sizes and positioning them correctly to form
the image of a boom box. To form the big speakers on the boom box, I used spheres so I could calculate the average amplitude. I then set the the 
size of the spheres to 85 and I used the getAmplitude function so I could make the speakers increases and decrease in size, depending on the 
amplitude of the song.

Cubes.java:
For my Cubes.java visual, I created two boolean variables, twocubes and fourcubes, which are used so that you can increase the number of cubes on
the screen to 2 or 4 depending on what key you press(instructions below). I then created the variable numLines which controls the number of cube visuals that 
the original cube visual expands by when the amplitude of the song is increased. I then created a new array, freqSpikes, which I used to loop the variable 'i'
through the for loop. To get the size of the cube, I used the lerp() function, the value of 'i' in the freqSpikes array being the starting value and then I used the fft.getBands() function so
the amplitude of the requested frequency band is the end value. I then created the variable boxSize to set the initial size of the cube, and adding the size of the increased amplitude to it. 
Similar to before, I created the variable smoothedBoxSize which I initialize the size of using the lerp() function. SmoothedBoxSize is the first variable and boxSize is the second variable. 
Finally, I used the box(smoothedBoxSize) function to create the cube and set its size to the smoothedBoxSize variable I created. This will allow the cube to expand greatly in accordance 
with the amplitude of the song. I positioned the cube in the centre of the screen using the translate function and made the cube rotate using rotateX(angle) and rotateY(angle), angle being a 
variable I created that increases by 0.05f each time. For twocubes and fourcubes, the code is exactly the same. The only thing that changes is the positioning of the cubes 
which I change by modifying the translate function to set new x and y coordinates for each cube.

SpiralSpeaker.java:
Firstly, I created the variable numLines which will be the number of lines that will appear on each loop of the speaker. I then created the array freqSpikes and 
initialized its size to numLines. I then created the variables radius, theta and count and initialized them to 200, 0 and 0 respectively. The count variable is used in the while loop so that there are 
many rings of lines created. Count is incremented after each iteration of the for loop. I also increase the radius variable by 250 after each iteration of the foor loop so that the rings get bigger each time.   
Similar to the Cubes visual, I used the lerp() function to get the amplitude of the requested frequency band. I created the points cx, px, cy, py, cz and pz which are used to position 
each line on the circle. The variables cy and py determine the size of the lines. The starting point for each line 0 and their end points vary depending on the amplitude of the song. 

MyMusicVisual.java:
Unfortunately, I could not get this part of the assignment to work properly. This file was supposed to call the functions from all of the classes above but sadly I was not successful 
in doing so, although, I did spend a large amount of time trying to figure it out. In the end, I had to result in calling each file separately in order to make my video.  

# What I am most proud of in the assignment
Although my assignment is probably not as complex as complex as other students', I am proud of myself for investing so much time and effort into this assignment as it was by no means easy. 
This is my first time carrying out a project like this in Java by myself and I am very happy with the outcome of each of my visuals. I think some of my visuals are
quite unique, and from the research I have carried out throughout this assignment I have learned so much about new functions that I will find very useful to me in the future.

Link to YouTube video: https://www.youtube.com/watch?v=vrogzyut05E

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

