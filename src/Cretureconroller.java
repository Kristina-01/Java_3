import java.util.ArrayList;



public class Cretureconroller implements  Runnable {
    char[][] field;
    Enemy en;
    Thread t;
    World w;
    Creature cr;
    Posion pos;
    Player pl;
    int x;
    int y;


    public Cretureconroller(World w, Player pl, int x, int y, Enemy en) {
        t = new Thread(this, "Дополнительный поток");
        t.start();
        this.w = w;
        this.pl = pl;
        this.x = x;
        this.y = y;
        this.en = en;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 4) {

            int _x =  pos == null ? x : pos.x;
            int _y = pos == null ? y : pos.y;
            if (w.searchfortheenemy(_x, _y) == null && pl.alive) {
                System.out.println("Соперник не найден");
                pos = w.Step(_x, _y);
                w.Print();
            } else {
                while (en.health!=0 && pl.health!=0){
                    GameLogic.damageforEn(en, pl);
                }
                int delx = w.searchfortheenemy(_x,_y).x;
                int dely = w.searchfortheenemy(_x,_y).y;
                System.out.println(delx);
                System.out.println(dely);

                w.delcr(delx, dely);


            }

         ++i;

        }
    }
}



