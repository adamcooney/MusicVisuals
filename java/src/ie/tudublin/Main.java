package ie.tudublin;

<<<<<<< HEAD
import example.*;

import c18372086.*;
=======
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
>>>>>>> cc0250fe11bfd31233735e224c9253c06ad1e5b1

public class Main
{	
	
	public void startUI()
	{
		String[] a = {"MAIN"};
<<<<<<< HEAD
        processing.core.PApplet.runSketch( a, new CubeVisual1());		
	}
	
	public void MyMusicVisual()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyMusicVisual());		
=======
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
>>>>>>> cc0250fe11bfd31233735e224c9253c06ad1e5b1
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.MyMusicVisual();	
	}
}