package finalreview.prefinal.pre20202.Q2;

import org.junit.Before;

public class PersonRepositoryTest {

    SequenceGenerator sequenceGenerator;
    PersonRepository personRepository;

    @Before
    public void before() {
        sequenceGenerator = new SequenceGenerator();
        personRepository = new PersonRepository();
        personRepository.setSequenceGenerator(sequenceGenerator);
    }

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########

    // ########## YOUR CODE ENDS HERE ##########


}
