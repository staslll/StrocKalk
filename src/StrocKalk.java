import java.util.Scanner;

public class StrocKalk {
    static String [] expresion;
    static char oper = '0';
    static String itog = "" ;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение. ");
        String str = sc.nextLine();
        String calc = calc(str);


    }
    public static String calc(String str)throws Exception {
        if (str.contains("+")) {
            str = str.replace(" ", "");
            expresion = str.split("\\+");
            oper = '+';
        } else if (str.contains("-")) {
            expresion = str.split(" - ");
            oper = '-';
        }else if (str.contains("/")) {
            str = str.replace(" ", "");
            expresion = str.split("/");
            oper = '/';
        } else if (str.contains("*")) {
            str = str.replace(" ", "");
            expresion = str.split("\\*");
            oper = '*';
        } else {
            throw new Exception("Ошибка в знаке действмя.");
        }
        if (oper == '*' || oper == '/') {
            if (expresion[1].contains("\"")) throw new Exception("Умножать,делить только на число и без кавычек.");
        }
        if (oper == '+' || oper == '-'){
            if (expresion[0].contains("\"")){
            }else
                throw new Exception("Скложение и вычитание только между строками.");
        }
           for (int i = 0; i < expresion.length; i++) {
             expresion[i] = expresion[i].replace("\"", "");
        }
            if (expresion[0].length() > 10 || expresion[1].length()>10) {
             throw new Exception("Строки при вводе не должны быть больше 10 букв.");
        }
           if (oper == '+') {
               itog = expresion[0].concat(expresion[1]);
                   System.out.println("\"" + itog + "\"");

           }
            if (oper == '-') {
                    int index = expresion[0].indexOf(expresion[1]);
                if (index == -1) {
                    System.out.println("\"" + expresion[0] + "\"");
                }else {
                    String itog = expresion[0].substring(0, index);
                    itog += expresion[0].substring(index + expresion[1].length());
                    System.out.println("\"" + itog + "\"");
                }
            }
       if (oper == '*'){
          int number = Integer.parseInt(expresion[1]);
          if (number < 1 || number >10) throw new Exception("Число должно быть от 1 до 10.");
           for (int i = 0;i < number;i++){
               itog +=expresion[0];
           }
           if (itog.length()>40){
               System.out.println("\"" + itog.substring(0,40) + "..." + "\"");
           }else
           System.out.println("\"" + itog + "\"");
       }
       if (oper =='/') {
           str = str.replace(" ", "");
           int number1 = expresion[0].length() / Integer.parseInt(expresion[1]);
           if (number1 < 1 || number1 > 10) throw new Exception("Число должно быть от 1 до 10.");
              String itog = expresion[0].substring(0, number1);
           System.out.println("\"" + itog + "\"");
       }


        return itog;
    }
}

