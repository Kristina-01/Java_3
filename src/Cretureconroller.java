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
    ArrayList<Creature> list;


    public Cretureconroller(World w, Player pl, int x, int y, Enemy en, ArrayList<Creature> list) {
        t = new Thread(this, "Дополнительный поток");
        t.start();
        this.w = w;
        this.pl = pl;
        this.x = x;
        this.y = y;
        this.en = en;
        this.list = list;
    }

    @Override
    public void run() {
        int i = 0;
        boolean isStep = true;
        while (isStep) {

            int _x =  pos == null ? x : pos.x;
            int _y = pos == null ? y : pos.y;
            var em = w.searchfortheenemy(_x, _y);
            if (em == null && pl.alive) {
                System.out.println("Соперник не найден");
                pos = w.Step(_x, _y);
                w.Print();
            } else {

                Creature pm = null;
                Creature cl = null;
                for(int k = 0 ; k < list.size(); ++k)
                {
                    if(list.get(k).name.equals(em.name))
                    {
                        pm = list.get(k);
                        break;
                    }
                }

                if(pm != null) {
                    cl =  GameLogic.battle2(pm, pl);
                }

                if(pm.health <= 0)
                w.delcr(em.x, em.y);
                else if(pl.health <= 0)
                    w.delcr(pos.x, pos.y);
                w.Print();
                System.out.println("END " + cl.name);
                isStep = false;
            }

         ++i;

        }
    }
}



