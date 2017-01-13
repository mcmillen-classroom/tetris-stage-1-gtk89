import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.KeyboardFocusManager;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
  private static class GameKeyDispatcher implements KeyEventDispatcher {
    Grid grid;
    
    public GameKeyDispatcher(Grid grid) {
      this.grid = grid;
    }
    
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
      if (event.getID() == KeyEvent.KEY_PRESSED) {
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
          grid.moveDown();
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
          grid.moveLeft();
        } else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
          grid.moveRight();
        } else if (event.getKeyCode() ==  KeyEvent.VK_UP) {
          grid.rotate();
        }
      }
      
      return false;
    }
  }
    
  public static void main(String[] args) {
    JFrame frame = new JFrame("CSA Tetris");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 450);
  
    Grid grid = new Grid();
  
    Container mainPanel = frame.getContentPane();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    
    mainPanel.add(grid);
    
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    
    JButton sButton = new JButton("S");
    sButton.setName("S");
    buttonPanel.add(sButton);
    JButton zButton = new JButton("Z");
    zButton.setName("Z");
    buttonPanel.add(zButton);
    JButton iButton = new JButton("I");
    iButton.setName("I");
    buttonPanel.add(iButton);
    buttonPanel.setFocusable(false);
    
    mainPanel.add(buttonPanel);
  
    int colMidpoint = grid.COL_COUNT / 2;
    int rowMidpoint = grid.ROW_COUNT / 2;
    
    SShape s = new SShape();
    s.initPointsFromOrigin(colMidpoint, rowMidpoint);

    grid.setShape(s);
  
    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    manager.addKeyEventDispatcher(new GameKeyDispatcher(grid));
    
    frame.setVisible(true);
    
    ActionListener buttonListener = new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent event) {
        int colMidpoint = grid.COL_COUNT / 2;
        int rowMidpoint = grid.ROW_COUNT / 2;
        String name = ((JButton) event.getSource()).getName();
        
        switch (name) {
          case "I":
            IShape i = new IShape();
            i.initPointsFromOrigin(colMidpoint, rowMidpoint);
            grid.setShape(i);
            break;
          case "S":
            SShape s = new SShape();
            s.initPointsFromOrigin(colMidpoint, rowMidpoint);
            grid.setShape(s);
            break;
          case "Z":
            ZShape z = new ZShape();
            z.initPointsFromOrigin(colMidpoint, rowMidpoint);
            grid.setShape(z);
            break;
        }
      }
    };
    
    iButton.addActionListener(buttonListener);
    sButton.addActionListener(buttonListener);
    zButton.addActionListener(buttonListener);
  }
}