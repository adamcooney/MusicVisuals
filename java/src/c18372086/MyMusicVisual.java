package c18372086;

import ie.tudublin.*;

public class MyMusicVisual extends Visual
{    
    // WaveForm wf;
    // AudioBandsVisual abv;
    //Boombox bb;
    //SpiralSpeaker ss;
    //Cubes cu;

    public void settings()
    {
        fullScreen(P3D, SPAN);
        
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

        
        
        // Call this instead to read audio from the microphone
        // startListening(); 
        
        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);
        //bb = new Boombox(this);
        //ss = new SpiralSpeaker(this);
        //cu = new Cubes(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);
        colorMode(HSB);
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
        // wf.render();
        // abv.render();
        //bb.draw();
        //ss.draw();
        //cu.draw();
    }
}