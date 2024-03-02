package testing.p3;

public class CodeCoverageQuiz {
    public void workMethod(int a, int b) {
        if (a > b) {
            if (a > 1) {
                System.out.println(a);
                a = b + 1;
            }
            System.out.println(b);
        }
        for (int i = 0; i < 2; i++) {
            if (a > b) {
                b++;
            }
            System.out.println(a);
        }
    }
}
