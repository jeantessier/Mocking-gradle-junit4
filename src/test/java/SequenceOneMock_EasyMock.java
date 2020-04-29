import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

public class SequenceOneMock_EasyMock extends TestCase {
    public void testSequence() {
        int somedValue = 42;

        SimpleInterface mockSimple = createStrictMock(SimpleInterface.class);
        expect(mockSimple.irrelevantMethod()).andReturn(somedValue);
        expect(mockSimple.simpleMethod()).andReturn(somedValue);
        replay(mockSimple);

        Client sut = new Client(mockSimple);
        sut.callSimpleAndIrrelevant();

        verify(mockSimple);
    }
}
