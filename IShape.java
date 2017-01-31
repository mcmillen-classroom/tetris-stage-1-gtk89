public class IShape {
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
    // TODO: start here
    colOrigin = initCol;
    rowOrigin = initRow;
    col0 = initCol;
    row0 = initRow + 1;
    col1 = initCol;
    row1 = initRow -1;
    col2 = initCol;
    row2 = initRow -2;
    direction = 0;
  }
  public boolean moveDown(){
    boolean down =
      grid.isEmpty(col0, row0 + 1) &&
      grid.isInBounds(col0, row0 + 1);
    if (down) {
      ++rowOrigin;
      ++row0;
      ++row1;
      ++row2;
    
    return true;
    }
    return false;
  }

  public boolean moveLeft() {
 
    if(direction == 0){
      boolean left0 =
        grid.isEmpty(col0 - 1, row0) &&
        grid.isInBounds(col0 - 1, row0);
      boolean left1  = 
        grid.isEmpty(col1 - 1, row1)&&
        grid.isInBounds(col1 - 1, row1);
      boolean leftO  = 
        grid.isEmpty(colOrigin - 1, rowOrigin)&&
        grid.isInBounds(colOrigin - 1, rowOrigin);
        boolean left2  = 
        grid.isEmpty(col2 - 1, row2)&&
        grid.isInBounds(col2 - 1, row2);
      if (left0 && left1 && leftO && left2) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        return true;
      }
        
    
    }else if (direction == 1){
      boolean left0 =
        grid.isEmpty(col0 - 1, row0) &&
        grid.isInBounds(col0 - 1, row0);
      if (left0) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        return true;
      }

    }else if (direction == 2){
      boolean low0 =   
        grid.isEmpty(col0 - 1, row0 )&&
        grid.isInBounds(col0 - 1, row0 );
      boolean lowO = 
        grid.isEmpty(colOrigin - 1, rowOrigin ) &&
        grid.isInBounds(colOrigin - 1, rowOrigin );
      boolean low1 = 
        grid.isEmpty(col1 - 1, row1 ) &&
        grid.isInBounds(col1 - 1, row1 );
      boolean low2 =
        grid.isEmpty(col2 - 1, row2 )&&
        grid.isInBounds(col2 -1, row2 );
      if(low0 && lowO && low1 && low2){
        --col0;
        --colOrigin;
        --col1;
        --col2;
        return true;
      }

    }else if (direction == 3){
      boolean left2 = 
        grid.isEmpty(col2 - 1, row2)&&
        grid.isInBounds(col2 - 1, row2);
      if (left2) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        return true;
      }  
    }
    return false;
  }
  public boolean moveRight() {
    if(direction == 0){
      boolean right2 =
        grid.isEmpty(col2 + 1, row2) &&
        grid.isInBounds(col2 + 1, row2);
      boolean rightO  = 
        grid.isEmpty(colOrigin + 1, rowOrigin)&&
        grid.isInBounds(colOrigin + 1, rowOrigin);
      boolean right0 = 
        grid.isEmpty(col0 + 1, row0)&&
        grid.isInBounds(col0 + 1, row0);
      boolean right1 = 
        grid.isEmpty(col1 + 1, row1)&&
        grid.isInBounds(col1 + 1, row1);
        
      if (right2 && rightO && right1 && right0) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        return true;
      }
  
    }else if (direction == 1){
      boolean right2 =
        grid.isEmpty(col2 + 1, row2) &&
        grid.isInBounds(col2 + 1, row2);
      if (right2) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        return true;
      }
   
    }else if (direction == 2){
      boolean right2 =
        grid.isEmpty(col2 + 1, row2) &&
        grid.isInBounds(col2 + 1, row2);
      boolean rightO  = 
        grid.isEmpty(colOrigin + 1, rowOrigin)&&
        grid.isInBounds(colOrigin + 1, rowOrigin);
      boolean right0 = 
        grid.isEmpty(col0 + 1, row0)&&
        grid.isInBounds(col0 + 1, row0);
      boolean right1 = 
        grid.isEmpty(col1 + 1, row1)&&
        grid.isInBounds(col1 + 1, row1);
      if (right0 && right1 && rightO && right2) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        return true;
      }
    
    }else if (direction == 3){
      boolean right0 =
        grid.isEmpty(col0 + 1, row0) &&
        grid.isInBounds(col0 + 1, row0);
      if (right0) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        return true;
      }  
      
    }
    return false;
  } 
  
  public boolean rotate() {
      
      if (direction == 0) {
        boolean rotate0 = 
          grid.isEmpty(col0 - 1, row0 - 1)&&
          grid.isInBounds(col0 -1, row0 - 1);
        boolean rotate1 =  
          grid.isEmpty(col1 + 1, row1 + 1)&&
          grid.isInBounds(col1 + 1, row1 + 1);
        boolean rotate2 = 
          grid.isEmpty(col2 +2, row2 + 2)&&
          grid.isInBounds(col2 + 2, row2 + 2);
        if(rotate0 && rotate1 && rotate2){ 
          --row0;
          --col0;
          ++row1;
          ++col1;
          row2 = row2 + 2;
          col2 = col2 + 2;
          direction = 1;
          return true;
        }
    
      } else if (direction == 1) {
        boolean rotate0 = 
          grid.isEmpty(col0 + 1, row0 - 1)&&
          grid.isInBounds(col0 + 1, row0 - 1);
        boolean rotate1 =  
          grid.isEmpty(col1 - 1, row1 + 1)&&
          grid.isInBounds(col1 - 1, row1 + 1);
        boolean rotate2 = 
          grid.isEmpty(col2 - 2, row2 + 2)&&
          grid.isInBounds(col2 - 2, row2 + 2);
        if(rotate1 && rotate2){ 
          --row0;
          ++col0;
          ++row1;
          --col1;
          row2 = row2 + 2;
          col2 = col2 - 2;
          direction = 2;
          return true;
        }
       
      } else if (direction == 2) {
        boolean rotate0 = 
          grid.isEmpty(col0 + 1, row0 + 1)&&
          grid.isInBounds(col0 + 1, row0 + 1);
        boolean rotate1 =  
          grid.isEmpty(col1 - 1, row1 - 1)&&
          grid.isInBounds(col1 - 1, row1 - 1);
        boolean rotate2 = 
          grid.isEmpty(col2 - 2, row2 - 2)&&
          grid.isInBounds(col2 - 2, row2 - 2);
        if(rotate0 && rotate1 && rotate2){ 
          ++row0;
          ++col0;
          --row1;
          --col1;
          row2 = row2 - 2;
          col2 = col2 - 2;
          direction = 3;
          return true;
        }
        
      } else if (direction == 3) {
        boolean rotate0 = 
          grid.isEmpty(col0 - 1, row0 + 1)&&
          grid.isInBounds(col0 -1, row0 + 1);
        boolean rotate1 =  
          grid.isEmpty(col1 + 1, row1 - 1)&&
          grid.isInBounds(col1 + 1, row1 - 1);
        boolean rotate2 = 
          grid.isEmpty(col2 + 2, row2 - 2)&&
          grid.isInBounds(col2 + 2, row2 - 2);
        if(rotate0 && rotate1 && rotate2){ 
          ++row0;
          --col0;
          --row1;
          ++col1;
          row2 = row2 - 2;
          col2 = col2 + 2;
          direction = 0;
          return true;
        }
      }
    return false;
  }
  
}

