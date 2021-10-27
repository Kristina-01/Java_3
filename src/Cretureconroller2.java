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


    public Cretureconroller2(World w, Enemy en, int x, int y) {
        t = new Thread(this, "Дополнительный поток");
        t.start();
        this.w = w;
        this.en = en;
        this.x = x;
    }

    public void run() {
        while(!en.expects){
            if (en.alive && pl.alive){
                System.out.println("Бой начался");
                GameLogic.damageforPl(en, pl);

            }
            }
        }


    }

