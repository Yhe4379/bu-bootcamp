import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    // 每个测试运行前都会先执行这个方法,重新造一个新的 Contact
    @BeforeEach
    public void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    public void testGetName() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    public void testGetPhone() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    public void testToStringFormat() {
        assertEquals("Ada Lovelace | +1 617 555 0101", contact.toString());
    }

    @Test
    public void testNameIsNotNull() {
        assertNotNull(contact.getName());
    }

    @Test
    public void testTwoContactsAreIndependent() {
        Contact a = new Contact("Ada Lovelace", "+1 617 555 0101");
        Contact b = new Contact("Ada Lovelace", "+1 999 999 9999");
        // 名字相同但电话不同,两个对象互相独立
        assertEquals(a.getName(), b.getName());
        assertNotEquals(a.getPhone(), b.getPhone());
    }
}