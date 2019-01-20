import javax.swing.JFrame;
import java.io.PrintStream;
import java.awt.FlowLayout;
import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * main class 
 * @author Elif Demir
 * @version 02/02/2018
*/

public class Lab05 extends JFrame
{
  public static void main( String[] args)
  {
    JFrame mySOSGame = new JFrame();
    mySOSGame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    
    mySOSGame.setTitle( "MySOSGame: v1.0"); 
    mySOSGame.setBounds( 300, 100, 800, 470);
    mySOSGame.setBackground( Color.GRAY);
    
    JPanel firstSOS = new SOSGUIPanel( 5);
    JPanel secondSOS = new SOSGUIPanel( 3);
    JPanel content = new JPanel();
    
    content.add( firstSOS);
    content.add( secondSOS);
    mySOSGame.add( content);
    mySOSGame.setVisible( true );
  }
}