package main;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main  {
    static boolean onlyFrom0to10=true;  //нстройка ограничения вводимого числа только от 0 до 10(по усл. задачи)
    static boolean only2digit=false;  //нстройка ограничения кол-ва вводимых чисел только 2-мя (по усл. задачи)

    enum RomArab { Arab(1),Rom(2),NoElse(0),Err(-1); //флаг сост. и типа вычислений: арабскими/ римскими /ни то ни се(ошибка)
    private int val;
        RomArab(int v) { this.val=v;       }
    }
    public static RomArab tipRA;

    enum Action{
        none,Plus,Minus,Div,Mult,Eqv,Err;
    }
    public static Action action=Action.none;

    public static void main(String[] args) throws IOException,NoValidateTipExeption {

        System.out.println("Введи выр. вида 1+9 или 121 +43- 64 +765*5 / 2 или римск. вида VII+IIL - XVI .");

        Scanner sc=new Scanner(System.in);
        try {
            Pattern pattern=Pattern.compile("(?:([0-9]+)|([IVXLDMC]+))(\\s*[*/+-]\\s*)?+");
            while (sc.hasNext()) {
                int cntDig=0;
                action=Action.none;
                String inputs=sc.nextLine();
                Matcher matcher=pattern.matcher(inputs);
//                System.out.println(matcher.groupCount()+"inputs="+inputs); //dbg
                Expression exp=new Expression();
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
                        cntDig++;
                        ival=StringParser.inputToInt(si);
                        if (onlyFrom0to10 && (ival< 0 || ival>10)) throw new NoValidateTipExeption("Только от 0 до 10ти или присвойте onlyFrom0to10=false , а ввели:"+si);

                    }
                    if (matcher.start(2)>=0) { //обнаружена гр. римских цифр
                        String si=matcher.group(2);
//                        System.out.print(",,"+matcher.start(2)+"g2="+matcher.group(2)); //dbg
                        if (tipRA ==RomArab.Arab) {
                            throw new NoValidateTipExeption("НЕ АРАБСКАЯ ЦИФРА:"+si);
                        }
                        tipRA=RomArab.Rom;
                        cntDig++;
                        ival=StringParser.inputToInt(si);
                        if (onlyFrom0to10 && (ival< 0 || ival>10)) throw new NoValidateTipExeption("Только от 0 до 10ти, или присвойте onlyFrom0to10=false, а ввели:"+si);

                    }
                    if (matcher.start(3)>=0) { //обнаружен знак операции
                        String sz = matcher.group(3).trim();  //знак
//                        System.out.println("," + matcher.start(3) + "g3=" + sz + "."); //dbg
                        action = StringParser.toAction(sz);
                    }

                    if(cntDig>1) { //больше 1й цифры (еще нет знаков оперраций)
                        if (only2digit && cntDig>2 ) throw new NoValidateTipExeption("Только 2 числа или присвойте only2digit=false , а ввели:"+cntDig);
                        if(action==Action.none) throw new NoValidateTipExeption("НЕ БЫЛО ЗНАКА ОПЕРАЦИИ:");
                        else if(only2digit) {action = Action.Eqv;} //если любой знак уже был
                    }
                    System.out.print(tipRA.name()+"="); System.out.print(ival);System.out.println(","+action.name()+",cnt="+cntDig); //dbg

                    exp.calc(ival,action);

                }
                System.out.println("Результат="+exp.getiRez());

            }
        } catch (Exception | NoValidateTipExeption e) {
            System.out.println("Что-то пошло не так:"+e.getMessage());
        }
        sc.close();

    }
}
