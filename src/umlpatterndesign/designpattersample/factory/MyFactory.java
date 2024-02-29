package umlpatterndesign.designpattersample.factory;

public class MyFactory implements Factory {

    @Override
    public Product createProduct(String productType) {
        if (productType.equals("1")) {
            return new MyProduct01();
        }
        else if (productType.equals("2")) {
            return new MyProduct02();
        }
        System.out.println("invalid product type");
        return null;
    }
}
