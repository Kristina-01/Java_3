import java.util.ArrayList;

public class Cretureconroller2 implements Runnable {
    char[][] field;
    Enemy en;
    Thread t;
    World w;
    Creature cr;
    Posion pos;
    Player pl;
    int x;
    int y;


    public Cretureconroller2(World w, Enemy en, int x, int y, ArrayList<Creature> list) {
        t = new Thread(this, "Дополнительный поток");
        t.start();
        this.w = w;
        this.en = en;
        this.x = x;
        this.y=y;
    }

    public void run() {
        while(!en.expects){
            if (en.alive && pl.alive){
                System.out.println("Бой начался");
                while (en.health!=0 && pl.health!=0){
                    GameLogic.damageforPl(en, pl);
                }


                w.delcr(x, y );

            }
         }
        }


    }

