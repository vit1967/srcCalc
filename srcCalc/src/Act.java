public enum Act { PLUS('+'), MINUS('-'), MUL('*'), DIV('/');
    private char symbol;

    Act(char s) {     symbol=s;}
    char getSymbol(){ return symbol;}
}
