package ie.tudublin;

//import example.*;

import c18372086.*;

public class Main
{	
	
	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyMusicVisual());		
	}
	
	public void Boombox()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Boombox());		
	}

	public void SpiralSpeaker()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new SpiralSpeaker());		
	}

	public void Cubes()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Cubes());		
	}
	
	public static void main(String[] args)
	{
		Main main = new Main();
		main.SpiralSpeaker();
	}
}