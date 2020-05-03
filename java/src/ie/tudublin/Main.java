package ie.tudublin;

import example.*;

import c18372086.*;

public class Main
{	
	
	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual1());		
	}
	
	public void MyMusicVisual()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyMusicVisual());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.MyMusicVisual();	
	}
}