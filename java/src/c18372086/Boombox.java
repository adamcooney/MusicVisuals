package c18372086;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.analysis.FFT;

public class Boombox extends Visual
{    
    /*
    MyMusicVisual mv;

    public Boombox(MyMusicVisual mv)
    {
        this.mv = mv; 
    }*/

    Minim minim;
    AudioSample as;
    
    int frameSize = 1024;

	int sampleRate = 44100;

	FFT fft;

	float frameToSecond = sampleRate / (float) frameSize;

    public void settings()
    {
        //size(1320, 680, P3D);
        fullScreen(P3D, SPAN);
         
    }

    public void setup()
    {
        startMinim();
        // Call loadAudio to load an audio file to process 
        loadAudio("technomyecho.mp3");  

        colorMode(HSB);
    }
    
    float lerpedw = 0;
    float average = 0;
    float offs = 0;
    
    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    float angle = 0;
    float smoothedBoxSize = 0;
    
    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);
        
        //creating mini speakers
        strokeWeight(5);
        fill(0);
        ellipse(140, -70, 30, 30);
        ellipse(-140, -70, 30, 30);
        ellipse(-140, 40, 130, 130);
        ellipse(140, 40, 130, 130);

        //creating big speakers
        fill(0);
        stroke(50);
        strokeWeight(2);
        pushMatrix();
        translate(-140, 40, -65);
        sphere(smoothedBoxSize);
        popMatrix();
        pushMatrix();
        translate(140, 40, -65);
        sphere(smoothedBoxSize);
        popMatrix();

        //changes size depending on amplitude
        float boxSize = 85 + (getAmplitude() * 25);
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.3f);

        //creating boombox
        fill(100);
        stroke(0);
        rect(-225, -100, 450, 225); 
        fill(125);
        rect(-60, -100, 120, 225);
        //top of boombox for 3D look
        fill(100);
        noStroke();
        rect(-195, -120, 390, 20);
        triangle(-225, -100, -195, -120, -195, -100);
        fill(200);
        triangle(225, -100, 195, -120, 195, -100);
        //making the handle
        fill(75);
        stroke(0);
        rect(-35, -145, 75, 10);
        fill(100);
        rect(-45, -145, 10, 35);
        rect(40, -145, 10, 35);
        //buttons
        rect(-45, -70, 15, 15);
        rect(-25, -70, 15, 15);
        rect(-5, -70, 15, 15);
        rect(15, -70, 15, 15);
        triangle(35, -70, 50, -63, 35, -55); 
        //music tape player
        rect(-45, 90, 90, 10);
        rect(-37, 50, 75, 40);
        //music tape
        fill(0);
        rect(-32, 60, 65, 28);
        fill(50);
        ellipse(-15, 75, 10, 10);
        ellipse(15, 75, 10, 10);
        fill(0);
        line(-15, 75, -15, 65);
        //rotateY(angle);
        //rotateX(angle);
        line(15, 75, 15, 65);
        //rotateY(angle);
        //rotateX(angle);
        //background for mini and big speakers
        noStroke();
        fill(0);
        ellipse(140, -70, 30, 30);
        ellipse(-140, -70, 30, 30);
        ellipse(-140, 40, 130, 130);
        ellipse(140, 40, 130, 130);
        
        angle += 0.01f;
    }
    
}