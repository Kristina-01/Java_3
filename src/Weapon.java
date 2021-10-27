import java.util.ArrayList;
import java.util.Random;

public class Weapon {
    Random random = new Random();
    int r= random.nextInt(3);
    ArrayList<String> nameW = new ArrayList<String>(){{add("Лук");add("Нож");add("Бензопила");add("Винтовка");}};
    String name= nameW.get(r);
    int hit=10;
}
