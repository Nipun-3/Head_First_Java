package c14.sharpenYourPencil;// Import necessary classes for MIDI handling, GUI creation, and random number generation
import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Import static members of ShortMessage for easier access to MIDI command constants
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicPlayer3 {
    // Member variable for the custom drawing panel
    private MyDrawPanel panel;
    // Random object for generating random numbers
    private Random random = new Random();

    // Main method to start the application
    public static void main(String[] args) {
        // Create an instance of MiniMusicPlayer3 and start it
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    // Method to set up the GUI
    public void setUpGui() {
        // Create a new JFrame with the title "My First Music Video"
        JFrame frame = new JFrame("My First Music Video");
        // Initialize the drawing panel and set it as the content pane of the frame
        panel = new MyDrawPanel();
        frame.setContentPane(panel);
        // Set the position and size of the frame
        frame.setBounds(30, 30, 300, 300);
        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to set up and start the MIDI sequence
    public void go() {
        // Set up the GUI
        setUpGui();

        try {
            // Get and open a MIDI sequencer
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            // Add the drawing panel as a controller event listener for MIDI control change messages
            sequencer.addControllerEventListener(panel, new int[]{127});
            // Create a new MIDI sequence with a resolution of 4 ticks per quarter note
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            // Create a new track in the sequence
            Track track = seq.createTrack();

            // Loop to add random MIDI events to the track
            int note;
            for (int i = 0; i < 60; i += 4) {
                // Generate a random note value
                note = random.nextInt(50) + 1;
                // Add a NOTE_ON event to the track
                track.add(makeEvent(NOTE_ON, 1, note, 100, i));
                // Add a CONTROL_CHANGE event to the track
                track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, i));
                // Add a NOTE_OFF event to the track
                track.add(makeEvent(NOTE_OFF, 1, note, 100, i + 2));
            }
            // Set the sequence to the sequencer
            sequencer.setSequence(seq);
            // Start playback of the sequence
            sequencer.start();
            // Set the tempo of the sequence in beats per minute
            sequencer.setTempoInBPM(120);
        } catch (Exception ex) {
            // Print any exceptions that occur
            ex.printStackTrace();
        }
    }

    // Method to create a MIDI event with specified parameters
    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            // Create a new ShortMessage with the specified command and parameters
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chnl, one, two);
            // Create a new MidiEvent with the ShortMessage and tick
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        }
        return event;
    }

    // Inner class for the custom drawing panel
    class MyDrawPanel extends JPanel implements ControllerEventListener {
        // Flag to indicate if a control change event has occurred
        private boolean msg = false;

        // Method called when a control change event occurs
        public void controlChange(ShortMessage event) {
            msg = true;
            // Request a repaint of the panel
            repaint();
        }

        // Method to paint the component
        public void paintComponent(Graphics g) {
            // If a control change event has occurred
            if (msg) {
                // Generate random color values
                int r = random.nextInt(250);
                int gr = random.nextInt(250);
                int b = random.nextInt(250);

                // Set the color and draw a filled rectangle with random dimensions and position
                g.setColor(new Color(r, gr, b));
                int height = random.nextInt(120) + 10;
                int width = random.nextInt(120) + 10;
                int xPos = random.nextInt(40) + 10;
                int yPos = random.nextInt(40) + 10;
                g.fillRect(xPos, yPos, width, height);

                // Reset the flag after painting
                msg = false;
            }
        }
    }
}
