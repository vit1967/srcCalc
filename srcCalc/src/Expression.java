public class Expression  {
    private  Integer iRez;
    private  Main.Action action;



    public  int calc(int ival, Main.Action operation){
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

    public  Integer getiRez() {
        return iRez;
    }
}
