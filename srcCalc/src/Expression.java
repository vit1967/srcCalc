public class Expression  {
    private static Integer iRez;
    private static Main.Action action;



    public static int calc(int ival, Main.Action operation){
        if (iRez==null){
            iRez=ival;
        } else {    //если уже было , делаем ранее запомненное действие, а потом запоминаем новое действие
            switch (action) {
                case Plus:
                    iRez+=ival;
                    break;
                case Minus:
                    iRez-=ival;
                    break;
                case Mult:
                    iRez =iRez*ival;
                    break;
                case Div:
                    iRez=(Integer) iRez/ival;
            }

        }
        action=operation;
        return iRez;
    }

    public static Integer getiRez() {
        return iRez;
    }
}
