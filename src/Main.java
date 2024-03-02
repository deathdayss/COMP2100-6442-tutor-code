public class Main {
    public static void main(String[] args) {
        double f = 111231.5585;
        double fConvert = Double.parseDouble(String.format("%.5f", f));

        System.out.println(fConvert + 1);;
    }
}