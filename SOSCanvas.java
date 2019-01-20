import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * Canvas class draws the game
 * @author Elif Demir
 * @version 02/02/2018
*/

public class SOSCanvas extends JPanel
{
  // properties
  final int FRAME_SIZE = 400;
  final int WIDTH = 370;
  final int HEIGHT = 370;
  SOS sosGame;
  int start = 30;
    
  // constructor
  public SOSCanvas( SOS sos)
  {
    super();
    sosGame = sos;
    setBackground( Color.WHITE);
    setPreferredSize( new Dimension( WIDTH, HEIGHT ) );
    setVisible( true);
  }
  
  // methods
  public int getCanvasSize()
  {
    return FRAME_SIZE;
  }
  public void paintComponent( Graphics graph)
  {
    super.paintComponent( graph);
    draw( graph);
  }
  
  public void draw( Graphics graph)
  {
    for ( int i = 1; i < sosGame.getDimension() + 1; i++ )
    {
      for ( int j = 1; j < sosGame.getDimension() + 1; j++)
      {
        int squareX = getWidth()* i/ sosGame.getDimension();
        int squareY = getWidth()* j / sosGame.getDimension();
        graph.drawRect( i, j, ( squareX ), ( squareY ) );
      }
    }
    
    int y = 0;
    int x = 0;
    int set = getWidth() / sosGame.getDimension() / 2;
    for ( int m = 0; m < sosGame.getDimension(); m++)
    {
      for ( int k = 0; k < sosGame.getDimension(); k++)
      {
        graph.drawString( String.valueOf( sosGame.getCellContents(m, k) ), ( 2*m*set + set), ( 2*k*set + set) );
      }
    }
  }
}