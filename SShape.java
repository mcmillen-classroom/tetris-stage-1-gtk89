public class SShape {
  int colOrigin;  
  int rowOrigin;
  int col0;
  int row0;
  int col1;
  int row1;
  int col2;
  int row2;
  int direction; // 0: EAST 1: SOUTH 2: WEST 3: NORTH
  Grid grid;
  
  public void initPointsFromOrigin(int initCol, int initRow) {
    colOrigin = initCol;
    rowOrigin = initRow;
    col0 = initCol - 1;
    row0 = initRow;
    col1 = initCol;
    row1 = initRow - 1;
    col2 = initCol + 1;
    row2 = initRow - 1;
    direction = 0;
  }
  
  public boolean moveDown() {
    boolean left =
      grid.isEmpty(col0, row0 + 1) &&
      grid.isInBounds(col0, row0 + 1);
    boolean down =
      grid.isEmpty(colOrigin, rowOrigin + 1) &&
      grid.isInBounds(colOrigin, rowOrigin + 1);
    boolean right =
      grid.isEmpty(col2, row2 + 1) &&
      grid.isInBounds(col2, row2 + 1);
      
    if (left && down && right) {
      ++rowOrigin;
      ++row0;
      ++row1;
      ++row2;

      return true;
    }
      
    return false;
  }
  
  public boolean moveLeft() {
    boolean left =
      grid.isEmpty(col0 - 1, row0) &&
      grid.isInBounds(col0 - 1, row0);
    
    if (left) {
      --colOrigin;
      --col0;
      --col1;
      --col2;
      
      return true;
    }
    
    return false;
  }
  
  public boolean moveRight() {
    boolean rightTop =
      grid.isEmpty(col2 + 1, row0) &&
      grid.isInBounds(col2 + 1, row0);
    boolean rightBottom =
      grid.isEmpty(colOrigin + 1, row0) &&
      grid.isInBounds(colOrigin + 1, row0);
    
    if (rightTop && rightBottom) {
      ++colOrigin;
      ++col0;
      ++col1;
      ++col2;
      
      return true;
    }
    
    return false;
  } 
  
  public boolean rotate() {
    // TODO: do not allow the shape to rotate if the cells are not empty.
    // Use grid.isEmpty() and grid.isInBounds()
    
    if (direction == 0) {
      --row0;
      ++col0;
      ++row1;
      ++col1;
      row2 = row2 + 2;
      
      direction = 1;
    } else if (direction == 1) {
      ++row0;
      ++col0;
      --col1;
      ++row1;
      col2 = col2 - 2;
      
      direction = 2;
    } else if (direction == 2) {
      ++row0;
      --col0;
      --row1;
      --col1;
      row2 = row2 - 2;
      
      direction = 3;
    } else if (direction == 3) {
      --row0;
      --col0;
      --row1;
      ++col1;
      col2 = col2 + 2;
      
      direction = 0;
    }
    
    return true;
  }
}