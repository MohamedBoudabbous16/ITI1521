
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

/**
 * la classe TestDevoir1 est une classe qui execute les units test qui se trouve dans le devoir
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 01/24/2024
 */
public class TestDevoir1 {

    public static void main(String[] args) {
        StudentInfo.display();
        TestUtils.runClass(UnitTestPerson.class);        
    }

}

// TestDevoir1 est le fichier java qui execute tous les units tests definis
//
// pour compiler le tout, il faut executer donc les compilations ci-dessous
//
// javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." TestUtils.java
// javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." UnitTestPerson.java
// javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." TestDevoir1.java
//
// pour executer
// java -cp "junit-4.13.jar;hamcrest-core-1.3.jar; ." TestDevoir1
//
// Expected output:
//  assert result is true.