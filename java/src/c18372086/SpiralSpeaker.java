package c18372086;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class SpiralSpeaker extends Visual 
{
    /*
    MyMusicVisual mv;

    public SpiralSpeaker(MyMusicVisual mv)
    {
        this.mv = mv; 
    }*/

	Minim minim;
    AudioSample as;
    
    int frameSize=1024;
    int sampleRate = 44100;

    FFT fft;

	public void settings()
	{
		fullScreen(P3D, SPAN);
    }

    public void setup() 
	{
		minim = new Minim(this);
        as = minim.loadSample("technomyecho.mp3", frameSize);
		
        fft = new FFT(frameSize, 44100);
        
        background(0);
	}

    public void keyPressed() 
    {
        if (key == ' ')
		{
			as.stop();
			as.trigger();
		}
    }

    float angle = 0;
    float cx = 0;
    float px = 0;
    float cy = 0;
    float py = 0;
    float cz = 0;
    float pz = 0;
	
	int numLines = 100;
	float[] freqSpikes = new float[numLines];

    public void draw()
    {	
        camera(width/2, height/2, (height/2) / tan(PI*30 / 180), width/2, height/2, 0, 0, -1, 0);
        background(0);		
        colorMode(HSB);	

        fft.window(FFT.HAMMING);
        fft.forward(as.left);
    
        float radius = 200;

        float theta = 0;
        int count = 0;

        while(count<=4) 
        {
            for(int i = 0 ; i < numLines ; i ++)
            {
                theta = map(i, 0, numLines, 0, TWO_PI);
                strokeWeight(5); 
                stroke(map(i,0,numLines,0,255), 255, 255);
                freqSpikes[i] = lerp(freqSpikes[i], fft.getBand(i), 0.2f);
                cz = (cos(theta) * radius) - width;
                pz = (cos(theta) * radius) - width;
                cx = (sin(theta) * radius) + width/2;
                px = (sin(theta) * radius) + width/2;
                cy = 0;
                py = freqSpikes[i] * 20;
                line(cx, cy, cz, px, py, pz);
            }
            
            count++;
            radius = radius + 250;
            angle += 0.001f;
            //rotateX(angle);
            //rotateY(angle);
            //rotateZ(angle);
        }
    }      
}