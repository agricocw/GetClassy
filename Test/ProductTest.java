import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    public void testToCSVDataRecord() {
        Product product = new Product("SampleProduct", "SampleDescription", "P001", 19.99);
        String expected = "P001, SampleProduct, SampleDescription, 19.99";
        assertEquals(expected, product.toCSVDataRecord());
    }

    @Test
    public void testSetName() {
        Product product = new Product("SampleProduct", "SampleDescription", "P001", 19.99);
        product.setName("NewName");
        assertEquals("NewName", product.getName());
    }

    @Test
    public void testSetDescription() {
        Product product = new Product("SampleProduct", "SampleDescription", "P001", 19.99);
        product.setDescription("NewDescription");
        assertEquals("NewDescription", product.getDescription());
    }

    @Test
    public void testSetID() {
        Product product = new Product("SampleProduct", "SampleDescription", "P001", 19.99);
        product.setID("NewID");
        assertEquals("NewID", product.getID());
    }

    @Test
    public void testSetCost() {
        Product product = new Product("SampleProduct", "SampleDescription", "P001", 19.99);
        product.setCost(29.99);
        assertEquals(29.99, product.getCost(), 0.001);
    }

}
