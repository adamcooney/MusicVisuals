package c18372086;

import ie.tudublin.*;
import ddf.minim.*;

public class Visual2 extends Visual
{    
    Minim minim;
    AudioSample as;

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
    
    boolean twocubes = false;

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        if (keyCode == RIGHT)
        {
            
        }

        if (keyCode == LEFT)
        {
            //twocubes = ! twocubes;
        }
    }

    float angle = 0;
    float smoothedBoxSize = 0;
    float smoothedBoxSize2 = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(255);
        fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);

        //noStroke();
        strokeWeight(2);
        pushMatrix();
        translate(-140, 40, -65);
        sphere(smoothedBoxSize);
        popMatrix();
        pushMatrix();
        translate(140, 40, -65);
        sphere(smoothedBoxSize);
        popMatrix();

        float boxSize = 85 + (getAmplitude() * 25);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.3f);

        //noStroke();
        strokeWeight(2);
        fill(0);
        pushMatrix();
        translate(-140, 40, -65);
        sphere(smoothedBoxSize2);
        popMatrix();
        pushMatrix();
        translate(140, 40, -65);
        sphere(smoothedBoxSize2);
        popMatrix();

        float boxSize2 = 55 + (getAmplitude() * 25);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize2 = lerp(smoothedBoxSize2, boxSize2, 0.3f);

        fill(150);
        stroke(0);
        rect(-225, -100, 450, 225); //tlx, tly, w, h
        rect(-45, -135, 85, 10);
        rect(-45, -135, 10, 40);
        rect(40, -135, 10, 40);
        rect(-45, -70, 15, 15);
        rect(-25, -70, 15, 15);
        rect(-5, -70, 15, 15);
        rect(15, -70, 15, 15);
        triangle(35, -70, 50, -63, 35, -55); // vertices
        //colorMode(HSB);
        //fill(0);
        //ellipse(0, 0, 50, 50); // cx, cy, w, h
        //float boxSize2 = 20 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        //smoothedBoxSize2 = lerp(smoothedBoxSize2, boxSize2, 0.2f);
        
        /*
        if (twocubes)
        {
            pushMatrix();
            translate(-125, 0, 0);
            //rotateY(angle);
            //rotateX(angle);
            //box(smoothedBoxSize);
            //strokeWeight(1);
            //fill(HSB);
            sphere(smoothedBoxSize);
            //sphere(smoothedBoxSize2);
            popMatrix();
            pushMatrix();
            translate(125, 0, 0);
            //rotateY(angle);
            //rotateX(angle);
            strokeWeight(5); 
            //box(smoothedBoxSize); 
            //fill(HSB);
            sphere(smoothedBoxSize); 
            //sphere(smoothedBoxSize2);            
            popMatrix();
        }
        */
        /*
        else
        {
            
            //rotateY(angle);
            //rotateX(angle);
            //strokeWeight(1);
            //fill(HSB);
            sphere(smoothedBoxSize); 
            //sphere(smoothedBoxSize2);           
            strokeWeight(5);
                
            //box(smoothedBoxSize);
        }
        */
        angle += 0.01f;
    }
    
}
