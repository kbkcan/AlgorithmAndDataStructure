package list.stack.practice;

public class BracketChekerTest {
	public static void main(String[] args) {
        BracketChecker op = new BracketChecker();
        String exp = "{(A+B)-3}*5+[{cos(x+y)+7}-1]*4";
        char postfix[];
        int value;
        System.out.println(exp);
        
        if(op.testPair(exp)){
            System.out.println("수식이 올바름(괄호의 쌍이 일치)");
        }else{
            System.out.println("수식이 올바르지 않음(괄호의 쌍이 불일치)");
        }
    }
}
