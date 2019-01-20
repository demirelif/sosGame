import cs101.sosgame.SOS;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * GUI Panel class 
 * @author Elif Demir
 * @version 02/02/2018
*/
public class SOSGUIPanel extends JPanel
{
  // properties 
  SOSCanvas canvas;
  SOS sosPlay;
  JPanel score = new JPanel();
  String name1;
  String name2;
  ButtonGroup group;
  JRadioButton s;
  JRadioButton o;
  char print = ' ';
  JLabel l1;
  JLabel l2;
  int playX = -1;
  int playY = -1;
  int size;
  JOptionPane end;
  
  // constructor
  public SOSGUIPanel( int size)
  {
    super();
    MouseListener listener = new SOSListener();
    this.size = size;
    sosPlay = new SOS( size);
    canvas = new SOSCanvas( sosPlay );
    canvas.setBorder( BorderFactory.createRaisedBevelBorder() );
    group = new ButtonGroup();
    canvas.addMouseListener( listener);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBorder( new EtchedBorder() );
    s = new JRadioButton( "s" );
    o = new JRadioButton( "o" );
    
    name1 = "Ulku: ";
    name2 = "Tamer: ";
    l1 = new JLabel( name1 );
    l2 = new JLabel( name2 );
    
    group.add( s );
    group.add( o ); 
    s.addMouseListener( listener);
    o.addMouseListener( listener);
    
    buttonPanel.add( l1 );
    buttonPanel.add( s );
    buttonPanel.add( o );
    buttonPanel.add( l2 );
    
    setLayout( new BoxLayout ( this, BoxLayout.Y_AXIS) );
    add( canvas);
    add( buttonPanel);
    setVisible( true );
  }
  
  // inner class
  class SOSListener extends MouseAdapter
  {
    public void mouseClicked( MouseEvent e)
    {
      if ( sosPlay.isGameOver() )
      {
        if ( sosPlay.getPlayerScore1() > sosPlay.getPlayerScore2() )
        {
          end.showMessageDialog( null, name1 + "won!");
        }
        else if ( sosPlay.getPlayerScore2() >  sosPlay.getPlayerScore2() )
        {
          end.showMessageDialog( null, name2 + "won!");
        }
      }
      
      System.out.println( playX );
      System.out.println( playY );
      if ( sosPlay.getTurn() % 2 == 0 )
      {
        l1.setBackground( Color.WHITE);
        l2.setBackground( Color.GREEN);
        l2.setText( name2 + ": " + sosPlay.getPlayerScore2() );
        repaint();
      }
      
      else if ( sosPlay.getTurn() % 2 != 0)
      {
        l1.setBackground( Color.GREEN);
        l2.setBackground( Color.WHITE);
        l1.setText( name1 + ": " + sosPlay.getPlayerScore1() );
        repaint();
      }
      
      if ( s.isSelected() )
      {
        print = 's';
        playY = ( ( e.getY() / ( ( canvas.getWidth() ) / size ) ) + 1);
        playX = ( ( e.getX() / ( ( canvas.getWidth() ) / size ) ) + 1);
        sosPlay.play( print, playX, playY);
        repaint();
      }
      
      if ( o.isSelected() )
      {
        print = 'o';
        playY = ( ( e.getY() / ( ( canvas.getCanvasSize() ) / size ) ) + 1);
        playX = ( ( e.getX() / ( ( canvas.getCanvasSize() ) / size ) ) + 1);
        sosPlay.play( print, playX, playY);
        repaint();
      }
      sosPlay.printBoard();
    }
  }
}