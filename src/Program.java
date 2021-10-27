public class Program {

    public static void main(String[] args){
        //GameLogic.Pole();


        World w = new World(4);
        int x = 1; int y = 0;
        w.SetPlayer(x, y, '@');
        w.SetPlayer(3, 1, 'A');

        w.Print();
        Player pl = new Player();
        Posion p = null;
        Enemy en = new Enemy();

        int i = 0;



        // while (i < 4)
        {
             ++i;
             int _x = p != null ? p.x : x;
             int _y = p != null ? p.y : y;

            Cretureconroller cretureconroller1 = new Cretureconroller(w,pl,_x,_y, en);
           // Cretureconroller2 cretureconroller2 = new Cretureconroller2(w,en,_x,_y);
            Thread th1 = new Thread(cretureconroller1);
            //Thread th2 = new Thread(cretureconroller2);

             System.out.println();
             System.out.println();
             // w.Print();
        }



    }





}
