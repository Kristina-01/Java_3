import com.sun.jdi.event.StepEvent;

import java.util.Random;

public class GameLogic {

    static public void choiceofweapons(Weapon w, Player p){//выбор оружия для игрока
        int r = random.nextInt(3);
        p.weapon=w.nameW.get(r);
    }

    static public  int APSforENE(Enemy e){ //APS и DPS  врага
        int APS;
        APS = (e.baseAP+e.equipment)*5;
        int dpsE;
        dpsE = e.equipments.get(1).damage*APS;
        return dpsE;
    }

    static public  int APSforPl(Player p){ //APS и DPS игрока
        int APS;
        APS = (p.baseAP+p.equipment)*5;
        int dpsp;
        dpsp =  p.equipments.get(1).damage*APSforPl(p);
        return dpsp;
    }
    static public int damageforEn(Enemy e, Player p){ // нанесение урона на противника
        if(e.health<(p.baseAP +p.equipments.get(1).damage)) {
            e.health = 0;
        }else{
        e.health = e.health - (p.baseAP +p.equipments.get(1).damage);
        }
        return e.health;
    }
    static public int damageforPl(Enemy e, Player p){  // нанесение урона на игрока
        if(p.health<(e.baseAP +e.equipments.get(1).damage)) {
            p.health = 0;
        }else{
            p.health = p.health - (e.baseAP +e.equipments.get(1).damage);
        }
        return e.health;
    }

    static void Pole(char [][] arr, int x, int y){
        if(arr == null) return;
        if(arr.length -1 <= x) return;
        if(arr.length > 0 && arr[0].length -1 <= y) return;
        int _x = x; int _y = y;
        char ch = arr[x][y];
        arr[x][y] = ' ';
        x += 1;
        if(arr.length -1 <= x) { arr[_x][_y] = ch; return;}
        String res = direction();


    }

    static public Posion moving(String s, int x, int y, char [][] arr){ // выбор направления хода

        if(!GameLogic.WH(arr, x,y)) return  null;

         char ch = arr[x][y];
        int _x = x; int _y = y;
        if(s== "Левая_нижняя_диагональ"){
            x--;
            y++;
        }else if(s=="Левая_верхняя_диаганаль"){
            x--;
            y--;
        }
        else if(s=="Правая_верхняя_диаганаль"){
            x++;
            y--;
        }else if(s=="Правая_нижняя_диагональ"){
            x++;
            y++;
        }else if(s=="вправо"){
            x++;
        }else if(s=="влево"){
            x--;
        }else if(s=="вверх"){
            y--;
        }else if(s=="вниз"){
            y++;
        }

        if( GameLogic.WH(arr, x,y)) {
            arr[_x][_y] = ' ';
            arr[x][y] = ch;
            Posion p = new Posion();
            p.x = x;
            p.y = y;
            return p;
        }
        Posion p = new Posion();
        p.x = _x; p.y = _y;
        return  p;
    }

    static Random random = new Random();
    static public String direction(){

        String [] strs = new String[]{"Левая_нижняя_диагональ" , "Левая_верхняя_диаганаль","Правая_верхняя_диаганаль", "Правая_нижняя_диагональ", "вправо", "влево", "вверх", "вниз"};

        String str ="0";
        int r = random.nextInt(8000000);
        if(r<=1000000){
            str = strs[1];
        } else if(r<=2000000){
            str = strs[2];
        } else if(r<=3000000){
            str = strs[3];
        }else if(r<=4000000){
            str = strs[4];
        }else if(r<=5000000){
            str = strs[5];
        }else if(r<=6000000){
            str = strs[6];
        }else if(r<=7000000){
            str = strs[7];
        }else if(r<=8000000){
            str = strs[0];
        }
        return str;
    }


   public static Posion searchfortheenemy (char [][] arr, int x, int y){
        Posion p = new Posion();

        int h = arr.length - 1;
        int w = arr[0].length - 1;

       int _y = y-1;//  проверяем вверх
       if (_y>-1) {
           if(arr[_y][y]!= ' '){
               p.x = x; p.y = _y;
               return p;
           }
       }

       int _x=x-1; //проверяем левый низ
       _y =y+1;
       if(_x>-1 && _y< h)
       {
           if(arr[_x][_y]!=' '){
               p.x =_x;p.y =_y;
               return p;
           }
       }

       _x=x+1;//проверяем правый верх
       _y=y-1;
       if(_x<w && _y>-1){
           if(arr[_x][_y]!=' '){
               p.x =_x;p.y =_y;
               return p;
           }
       }

       _x =x+1;
       _y=y;//проверяем право
       if(_x<w){
           if(arr[_x][_y]!=' '){
               p.x=_x;p.y=y;
               return  p;
           }
       }
       _x=x+1; //проверяем вправо вниз
       _y=y+1;
       if(_x<w && _y<h){
           if(arr[_x][_y]!=' '){
               p.x=_x;p.y=_y;
               return  p;
           }
       }
       _y=y+1; //прверяет вниз
       if(_y<h){
           if(arr[_x][_y]!=' '){
               p.x=x;p.y=_y;
               return  p;
           }
       }

       _x=x-1; //прверяет влево
       if(_x>-1){
           if(arr[_x][_y]!=' '){
               p.x=_x;p.y=y;
               return  p;
           }
       }
       _x=x-1;
       _y=y-1;
       if(_x<-1 && _y<-1){
           if(arr[_x][_y]!=' '){
               p.x=_x;p.y=_y;
               return  p;
           }
       }
       return null;
  }

  static public boolean WH(char [][] arr, int x, int y){

      if(arr == null) return false;
      if(x < 0 || y < 0) return false;
      if(arr.length -1 <= x) return false;
      if(arr.length > 0 && arr[0].length -1 <= y) return false;

        if(arr.length > x && arr[0].length >y){
            return true;
        }
        return false;
  }
}


