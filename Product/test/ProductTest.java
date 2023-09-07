import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp() {
        p1 = new Product("Chips", "Barbeque Chips", "00000A", 2.34);
        p2 = new Product("Cookies", "Snickerdoodle", "00000B", 3.42);
        Product.setIDSeed(0);
        p3 = new Product("Soda", "Sprite", 2.72);
        p4 = new Product("Chips", "Plain", 2.34);
        p5 = new Product("Cookies", "M&M's", 3.42);
        p6 = new Product("Soda", "Coke", 2.72);
    }

    @Test
    void setIDSeed() {
        p1.setIDSeed(5);
        assertEquals(5, p1.getIDSeed());
    }

    @Test
    void setName() {
        p1.setName("chips");
        assertEquals("chips", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("BBQ Chips");
        assertEquals("BBQ Chips", p1.getDescription());
    }

    @Test
    void setID() {
        p1.setID("00000K");
        assertEquals("00000K", p1.getID());
    }

    @Test
    void setCost() {
        p1.setCost(5.49);
        assertEquals(5.49, p1.getCost());
    }

    @Test
    void toCSVDataRecord() {

    }
}