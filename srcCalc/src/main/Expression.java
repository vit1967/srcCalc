package main;

public class Expression  {
    private  Integer iRez;
    private  Main.Action action;



    public  int calc(int ival, Main.Action operation) throws NoValidateTipExeption {
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
                case none:
                    throw new NoValidateTipExeption("НЕТ ОПЕРАЦИИ:");
                default:
                    throw new NoValidateTipExeption("НЕТ ОПЕРАЦИИ и воще хрень какая-то:");
            }


        }
        action=operation;

        return iRez;
    }

    public  String getiRez() throws NoValidateTipExeption {
        return StringParser.rezToString(iRez);
    }
}
