public class Program {

    public static void main(String[] args){
        //GameLogic.Pole();

        int num = 5;
        var arr = new char [num][];
        int x1=1; int y1 =0;
        int x2=4; int y2=4;
        for(int i =0;i<arr.length;++i){
            arr [i] = new char[num];
            for(int j=0; j<arr.length;j++){
                if(i == x1 && j == y1){
                arr[i][j] = '@';
                } else if (i == x2 && j == y2)
                {
                    arr[i][j] = 'P';
                }
                else
                    arr[i][j] = ' ';

            }
        }
        Print(arr);
       int i = 15;
/*
        String s = "вниз";//GameLogic.direction();
        Posion p = GameLogic.moving(s, x1, y1, arr);
        System.out.println(s);
        Print(arr);

        String s1 = "вниз";//GameLogic.direction();
        Posion p1 = GameLogic.moving(s1, p.x, p.y, arr);
        System.out.println(s);
        Print(arr);

 */

        Posion p = null;
       while (i > 0) {
           String s = GameLogic.direction();

           int _x = p == null ? x1 : p.x;
           int _y = p == null ? y1 : p.y;

           System.out.println(s + " " + _x + " " + _y);

           p = GameLogic.moving(s, _x, _y, arr);
           /*
           if(p != null) // если сделали шаг то ищем врага
           {
              p = GameLogic.searchfortheenemy(arr, p.x, p.y);
               if(p != null) // нашли врага
              {
//
              } // не нашли
          }

            */
           System.out.println();
           System.out.println();

           Print(arr);

           --i;
       }





    }



    static  void Print(char[][] arr)
    {
        for (int i = 0; i < arr.length; ++i)
        {

            System.out.println();

            for (int j = 0; j < arr[i].length; ++j)
            {
                System.out.print(" | ");
                System.out.print(arr[j][i]);
            }
            System.out.print(" | ");

        }
    }

}
