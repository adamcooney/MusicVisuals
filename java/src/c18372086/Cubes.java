package c18372086;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class Cubes extends Visual 
{
    /*
    MyMusicVisual mv;

    public Cubes(MyMusicVisual mv)
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
        colorMode(HSB);
    }
    
    boolean twocubes = false;
    boolean fourcubes = false;

    public void keyPressed()
    {
        if(key == ' ')
        {
            as.stop();
		    as.trigger();
        }
        if (key == '2')
        {
            twocubes = ! twocubes;

        }
        else if (key == '4')
        {
            fourcubes = ! fourcubes;
        }
    }

    float smoothedBoxSize = 0;
    float angle = 0;

    int numLines = 20;
    float[] freqSpikes = new float[numLines];

    public void draw()
    {
        background(0);
        fft.window(FFT.HAMMING);
        fft.forward(as.left);

        for(int i =0 ;i<numLines; i++)
        { 
            if (twocubes)
            {
                freqSpikes[i] = lerp(freqSpikes[i], fft.getBand(i), 0.5f);
                pushMatrix(); 
                float boxSize = 100 + (freqSpikes[i] * 2); 
                smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
                noFill();
                stroke(map(i, 0, numLines, 0, 255), 255, 255);
                translate(330, height/2, 0);
                rotateY(angle);
                rotateX(angle);
                strokeWeight(5);            
                box(smoothedBoxSize);
                popMatrix();

                freqSpikes[i] = lerp(freqSpikes[i], fft.getBand(i), 0.5f);
                pushMatrix();  
                smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
                noFill();
                stroke(map(i, 0, numLines, 0, 255), 255, 255);
                translate(990, height/2, 0);
                rotateY(angle);
                rotateX(angle);
                strokeWeight(5);            
                box(smoothedBoxSize);
                popMatrix();
                
            }
            else if(fourcubes)
            {
                freqSpikes[i] = lerp(freqSpikes[i], fft.getBand(i), 0.5f);
                pushMatrix(); 
                float boxSize = 100 + (freqSpikes[i] * 2); 
                smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
                noFill();
                stroke(map(i, 0, numLines, 0, 255), 255, 255);
                translate(330, 170, 0);
                rotateY(angle);
                rotateX(angle);
                strokeWeight(5);            
                box(smoothedBoxSize);
                popMatrix();

                freqSpikes[i] = lerp(freqSpikes[i], fft.getBand(i), 0.5f);
                pushMatrix();  
                smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
                noFill();
                stroke(map(i, 0, numLines, 0, 255), 255, 255);
                translate(990, 170, 0);
                rotateY(angle);
                rotateX(angle);
                strokeWeight(5);            
                box(smoothedBoxSize);
                popMatrix();

                freqSpikes[i] = lerp(freqSpikes[i], fft.getBand(i), 0.5f);
                pushMatrix(); 
                smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
                noFill();
                stroke(map(i, 0, numLines, 0, 255), 255, 255);
                translate(330, 510, 0);
                rotateY(angle);
                rotateX(angle);
                strokeWeight(5);            
                box(smoothedBoxSize);
                popMatrix();

                freqSpikes[i] = lerp(freqSpikes[i], fft.getBand(i), 0.5f);
                pushMatrix(); 
                smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
                noFill();
                stroke(map(i, 0, numLines, 0, 255), 255, 255);
                translate(990, 510, 0);
                rotateY(angle);
                rotateX(angle);
                strokeWeight(5);            
                box(smoothedBoxSize);
                popMatrix();
            }	
            else
            {
                freqSpikes[i] = lerp(freqSpikes[i], fft.getBand(i), 0.5f);
                pushMatrix(); 
                float boxSize = 100 + (freqSpikes[i] * 2); 
                smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);
                noFill();
                stroke(map(i, 0, numLines, 0, 255), 255, 255);
                translate(width/2, height/2, 0);
                rotateY(angle);
                rotateX(angle);
                strokeWeight(5);            
                box(smoothedBoxSize);
                popMatrix();
            }
        }
        angle += 0.05f;
       
    }

}