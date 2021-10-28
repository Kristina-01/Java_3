import java.util.ArrayList;

public class Program {

    public static void main(String[] args){
        //GameLogic.Pole();


        World w = new World(4);
        int x = 1; int y = 0;
        w.SetPlayer(x, y, '@');
        w.SetPlayer(3, 1, 'A');

        w.Print();
        Player pl = new Player();
        pl.name = "@";
        Posion p = null;
        Enemy en = new Enemy();
        en.name = "A";

        int i = 0;

        ArrayList<Creature> list = new ArrayList<Creature>();
        list.add(en);
        list.add(pl);

        // while (i < 4)
        {
             ++i;
             int _x = p != null ? p.x : x;
             int _y = p != null ? p.y : y;

            Cretureconroller cretureconroller1 = new Cretureconroller(w,pl,_x,_y, en, list);
            Cretureconroller2 cretureconroller2 = new Cretureconroller2(w,en,_x,_y, list);
            Thread th1 = new Thread(cretureconroller1);
            Thread th2 = new Thread(cretureconroller2);

             System.out.println();
             System.out.println();
             // w.Print();
        }



    }





}
