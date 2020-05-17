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
The code for this visual was not too complex. It involved creating many different shapes of different sizes and positioning them correctly to form
the image of a boom box. To form the big speakers on the boom box, I used spheres so I could calculate the average amplitude. I then set the the 
size of the spheres to 85 and I used the getAmplitude function so I could make the speakers increases and decrease in size, depending on the 
amplitude of the song.    

# Instructions
As far as instructions go, there are not many. In my Cubes.java file you can duplicate the number of cubes that appear on the screen 
by pressing the number '2' on your keypad and then return from two cubes back to one cube on the screen by pressing '2' again. Similarly, you
can increase the number of cubes that are on screen to 4 by pressing the number '4' on your keypad and return from 4 cubes back to 1 cube
by pressing the number '4' again.

# How it works

# What I am most proud of in the assignment

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

