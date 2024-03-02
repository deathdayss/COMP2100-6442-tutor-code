package testing.sample;

import org.junit.*;

public class ResourceReuse {
    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("test before class");
    }

    @AfterClass
    public static void testAfterClass() {
        System.out.println("test after class");
    }

    @Before
    public void testBefore() {
        System.out.println("test before");
    }

    @After
    public void testAfter() {
        System.out.println("test after");
    }

    @Test
    public void testA() {
        System.out.println("test A");
    }

    @Test
    public void testB() {
        System.out.println("test B");
    }
}
