import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Grid extends JPanel {
    
  int ROW_COUNT = 20;
  int COL_COUNT = 10;
  int CELL_SIZE = 20;

  IShape i;
  SShape s;
  ZShape z;

  public void setShape(SShape sShape) {
    s = sShape;
    s.grid = this;
    i = null;
    z = null;
    repaint();
  } 
  
  public void setShape(IShape iShape) {
    i = iShape;
    // i.grid = this;
    s = null;
    z = null;
    repaint();
  }
  
  public void setShape(ZShape zShape) {
    z = zShape;
    // z.grid = this;
    i = null;
    s = null;
    repaint();
  }

  public boolean moveDown() {
    boolean moved = false;
    
    if (s != null) {
      moved = s.moveDown();
    }
    
    if (moved) {
      repaint();
    }
    
    return moved;
  }
  
  public boolean moveLeft() {
    boolean moved = false;
    
    if (s != null) {
      moved = s.moveLeft();
    }
    
    if (moved) {
      repaint();
    }
    
    return moved;
  }
  
  public boolean moveRight() {
    boolean moved = false;
    
    if (s != null) {
      moved = s.moveRight();
    }
    
    if (moved) {
      repaint();
    }
    
    return moved;
  }

  public boolean rotate() {
        boolean moved = false;
    
    if (s != null) {
      moved = s.rotate();
    }
    
    if (moved) {
      repaint();
    }
    
    return moved;
  }

  /**
   * Checks whether a cell is empty.
   * Unimplemented: returns true if in bounds of grid;
   */
  public boolean isEmpty(int col, int row) {
    return isInBounds(col, row);
  }
  
  /**
   * Check whether the col and row are within the bounds of the grid.
   */
  public boolean isInBounds(int col, int row) {
    return (col >= 0 && col < COL_COUNT) && (row >= 0 && row < ROW_COUNT);
  }

  /**
   * Draws the grid.
   */
  public void paintComponent(Graphics g) {
    g.clearRect(0, 0, COL_COUNT * CELL_SIZE, ROW_COUNT * CELL_SIZE);
    
    for (int col = 0; col < COL_COUNT; col++) {
      for (int row = 0; row < ROW_COUNT; row++) {
        g.setColor(Color.gray);
        g.drawRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);
      }
    }
    
    if (s != null) {
      g.setColor(Color.RED);
      g.fillRect(
        s.colOrigin * CELL_SIZE + 1, 
        s.rowOrigin * CELL_SIZE + 1, 
        CELL_SIZE - 1, 
        CELL_SIZE - 1
      );
      g.fillRect(
        s.col0 * CELL_SIZE + 1, 
        s.row0 * CELL_SIZE + 1, 
        CELL_SIZE - 1, 
        CELL_SIZE - 1
      );
      g.fillRect(
        s.col1 * CELL_SIZE + 1, 
        s.row1 * CELL_SIZE + 1, 
        CELL_SIZE - 1, 
        CELL_SIZE - 1
      );
      g.fillRect(
        s.col2 * CELL_SIZE + 1, 
        s.row2 * CELL_SIZE + 1, 
        CELL_SIZE - 1, 
        CELL_SIZE - 1
      );
    }
  }
}