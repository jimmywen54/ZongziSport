import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
@ContextConfiguration(locations = { "/spring-context.xml"})
public abstract class SpringTestCase  extends AbstractJUnit4SpringContextTests{
}
