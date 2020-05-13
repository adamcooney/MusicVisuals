package c18372086;

import ie.tudublin.*;
import ddf.minim.*;

public class MyMusicVisual extends Visual
{    
    //WaveForm wf;
    //AudioBandsVisual abv;
    Minim minim;
    AudioSample as;

    int frameSize = 1024;

	float frameToSecond = 44100 / (float) frameSize;

    public void settings()
    {
        size(1024, 500, P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("technomyecho.mp3");   
        //minim = new Minim(this);
        //as = minim.loadSample("technomyecho.mp3", frameSize);

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        //wf = new WaveForm(this);
        //abv = new AudioBandsVisual(this);
    }
    
    float lerpedw = 0;
    float average = 0;
    float offs = 0;
    
    boolean twocubes = false;

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            //as.stop();
			//as.trigger();
        }

        if (keyCode == RIGHT)
        {
            
        }

        if (keyCode == LEFT)
        {
            twocubes = ! twocubes;
        }
    }

    float angle = 0;
    float smoothedBoxSize = 0;
    float smoothedBoxSize2 = 0;

    public void draw()
    {
        /*
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        //wf.render();
        //abv.render();
        */

        calculateAverageAmplitude();
        background(0);
        fill(0, 25, 0);
        rect(-50, 10, 100, 200); //tlx, tly, w, h
        colorMode(HSB);
        fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);
        fill(0, 150, 0);
        rect(50, 10, 100, 200); //tlx, tly, w, h

        float boxSize = 20 + (getAmplitude() * 50);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);

        //float boxSize2 = 20 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        //smoothedBoxSize2 = lerp(smoothedBoxSize2, boxSize2, 0.2f);
                          
        if (twocubes)
        {
            pushMatrix();
            translate(-125, 0, 0);
            rotateY(angle);
            rotateX(angle);
            //box(smoothedBoxSize);
            //strokeWeight(1);
            sphere(smoothedBoxSize);
            sphere(smoothedBoxSize2);
            popMatrix();
            pushMatrix();
            translate(125, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5); 
            //box(smoothedBoxSize); 
            sphere(smoothedBoxSize); 
            sphere(smoothedBoxSize2);            
            popMatrix();
        }

        else
        {
            
            rotateY(angle);
            rotateX(angle);
            //strokeWeight(1);
            sphere(smoothedBoxSize); 
            sphere(smoothedBoxSize2);           
            strokeWeight(5);
                
            //box(smoothedBoxSize);
        }
        angle += 0.01f;
    }
    
}
