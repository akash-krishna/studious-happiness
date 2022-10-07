import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
    @Test(groups = "api")
    public void shouldTest(){
        Assert.assertEquals(1,1);
        System.out.println("Test1");

    }
}
