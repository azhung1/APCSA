     public class RotateArray
     {
      public static int [][] rotateArray (int [][] arr, int degree)
     {
        int i,j, length, length2;
        length = arr.length;
        length2 = arr[0].length;
        int [][] arr1 = new int [length][length2] ;
    
        if(degree == 90)
        {
       arr1 = new int [length2][length];
        for (i = 0;i<arr.length;i++)
        {
          for(j = 0; j<arr[i].length;j++)
          {
              arr1[j][arr.length-1-i] =arr[i][j];
          }
        }
        }
         if(degree == 180)
        {
             arr1 = new int [length][length2];
        for (i = 0;i<arr.length;i++)
        {
          for(j = 0; j<arr[i].length;j++)
          {
              arr1[arr.length-1-i][arr[0].length-1-j] =arr[i][j];
          }
        }
        }
         if(degree == 270)
        {
           arr1 = new int [length2][length];
        for (i = 0;i<arr.length;i++)
        {
          for(j = 0; j<arr[i].length;j++)
          {
              arr1[arr[0].length-1-j][i] =arr[i][j];
          }
        }
        }
         if(degree == 360)
        {
             for (i = 0;i<arr.length;i++)
        {
          for(j = 0; j<arr[i].length;j++)
          {
              arr1[i][j] =arr[i][j];
          }
        }
        
        }
        return arr1;
     }
     
     }