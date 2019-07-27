import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    enum RomArab { Arab(1),Rom(2),NoElse(0),Err(-1); //флаг сост. и типа вычислений: арабскими/ римскими /ни то ни се(ошибка)
    private int val;
        RomArab(int v) { this.val=v;       }
    }
    public static RomArab tipRA;

    enum Action{
        Plus,Minus,Div,Mult,Eqv,Err;
    }
    public static Action action=null;

    public static void main(String[] args) throws IOException {
        Integer leftVal;
        System.out.println("Введи выр. вида 121 +43- 64 +765*5 / 2 или римск. вида VII+IIL - XVI с любым кол-вом оп.");
//        Pattern patOp=Pattern.compile("[\\s]{0,3}[*/+-][\\s]{0,3}");
//        Pattern patOp=Pattern.compile("\\s*[*/+-]\\s*");
//        Pattern patOp=Pattern.compile("([\\s]){1,3}");
//        Scanner sc=new Scanner(System.in).useDelimiter(patOp);
//        String input = "878979+287372 -787 + 7564 / IVXL * 576 + LXII =";

        Scanner sc=new Scanner(System.in);
        try {
            Pattern pattern=Pattern.compile("(?:([0-9]+)|([IVXLDMC]+))(\\s*[*/+-]\\s*)?+");
            while (sc.hasNext()) {
                String inputs=sc.nextLine();
                Matcher matcher=pattern.matcher(inputs);
//                System.out.println(matcher.groupCount()+"inputs="+inputs); //dbg
                Expression exp=new Expression();
                leftVal=null;
                tipRA=RomArab.NoElse;
                while (matcher.find()) {
//                System.out.print(matcher.start()+"="+matcher.group()+"знак:");
                    int ival=-1;
                    if (matcher.start(1)>=0) {  //обнаружена гр. арабских
                        String si=matcher.group(1);
//                        System.out.print(matcher.start(1) + "g1=" + si + ": "); //dbg
                        if (tipRA ==RomArab.Rom) {
                            throw new NoValidateTipExeption("НЕ РИМСКАЯ ЦИФРА:"+si);
                        }
                        tipRA=RomArab.Arab;
                        ival=StringParser.toInt(si);

                    }
                    if (matcher.start(2)>=0) { //обнаружена гр. римских цифр
                        String si=matcher.group(2);
//                        System.out.print(",,"+matcher.start(2)+"g2="+matcher.group(2)); //dbg
                        if (tipRA ==RomArab.Arab) {
                            throw new NoValidateTipExeption("НЕ АРАБСКАЯ ЦИФРА:"+si);
                        }
                        tipRA=RomArab.Rom;
                        ival=StringParser.toInt(si);
                    }
                    if (matcher.start(3)>=0) {
                        String sz = matcher.group(3).trim();  //знак
//                        System.out.println("," + matcher.start(3) + "g3=" + sz + "."); //dbg
                        action = StringParser.toAction(sz);
                    } else action=Action.Eqv;
                    System.out.print(tipRA.name()+"="); System.out.print(ival);System.out.println(","+action.name()); //dbg
                    Expression.calc(ival,action);

                }
                System.out.println("Результат="+Expression.getiRez());

            }
        } catch (Exception | NoValidateTipExeption e) {
            System.out.println("Что-то пошло не так:"+e.getMessage());
        }
        sc.close();

        //--


    }
}
