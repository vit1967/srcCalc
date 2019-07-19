import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Input");
        Pattern patOp=Pattern.compile("[\\s]{0,3}[*/+-][\\s]{0,3}");
//        Pattern patOp=Pattern.compile("([\\s]){1,3}");
        Scanner sc=new Scanner(System.in).useDelimiter(patOp);

        try {
//            String inputs=sc.delimiter().toString();
//            String inputs=sc.next();
//            System.out.println(inputs);
            while (sc.hasNext()) {
                String inputs=sc.next();
                switch (inputs) {
                    case "=":
                        return;
                    case "+":

                    break;
                    case "-":

                    break;
                }
//                if(sc.next().equals(word)){
                System.out.println(inputs);
                
//                    break;
            }
        } catch (Exception e) {
        System.out.println("Произошло ещё какое-то исключение");
        }
        sc.close();




//        Stream<String> tokens = new Scanner(path).useDelimiter("\\s*,\\s*").tokens();
//
//
//        Matcher.stream и Scanner.findAll выдают поток найденных результатов:
//
//        Pattern pattern = Pattern.compile("[^,]");
//        Stream<String> matches = pattern.match(str).stream().map(MatchResult::group);
//        matches = new Scanner(path).findAll(pattern).map(MatchResult::group);



    }
}
