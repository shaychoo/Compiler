package IC;

    //import IC.Parser.*;

    import IC.AST.ASTNode;
    import IC.AST.PrettyPrinter;
    import IC.AST.StatementsBlock;
    import IC.Parser.*;
    import IC.Parser.Token;
    import java_cup.anttask.CUPTask;
    import java_cup.runtime.Symbol;
    import jflex.anttask.JFlexTask;

    import java.io.File;
    import java.io.FileReader;


public class Main
{
//        CUPTask cupTask = new CUPTask();
//        JFlexTask jFlex = new JFlexTask();
//
//        try {
//            jFlex.setFile(new File("src/IC/Parser/IC.lex"));
//            jFlex.execute();
//            FileReader txtFile = new FileReader(args[0]);
//            Lexer scanner = new Lexer(txtFile);
//            Token stat ;
//            do {
//                stat = scanner.next_token();
//                System.out.println(stat.toString());
//            }while (stat.getVal() != -1);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        private static boolean printtokens = false;

        /** Reads an SLP and pretty-prints it.
         *
         * @param args Should be the name of the file containing an SLP.
         */
        public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Error: Missing input file argument!");
                printUsage();
                System.exit(-1);
            }
            if (args.length == 2) {
                if (args[1].equals("-printtokens")) {
                    printtokens = true;
                } else {
                    printUsage();
                    System.exit(-1);
                }
            }

            // Parse the input file
            FileReader txtFile = new FileReader(args[0]);
            Lexer scanner = new Lexer(txtFile);
            Parser parser = new Parser(scanner);
            parser.printTokens = printtokens;
            Symbol parseSymbol = parser.parse();



                System.out.println("Parsed " + args[0] + " successfully!");
                // StatementsBlock root = (StatementsBlock) parseSymbol.value;
                ASTNode root = (ASTNode) parseSymbol.value;

                // Pretty-print the program to System.out
                PrettyPrinter printer = new PrettyPrinter(root);
                printer.print();

                // Interpret the program
                //SLPEvaluator evaluator = new SLPEvaluator(root);
                //evaluator.evaluate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /** Prints usage information about this application to System.out
         */
        public static void printUsage() {
        System.out.println("Usage: slp file [-printtokens]");
    }



    }

