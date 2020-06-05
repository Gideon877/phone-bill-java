package phonebill.bill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataBundleTest {

    @Test
    void totalCost_Higher() {
        assertEquals(358.4, new DataBundle(1024).totalCost());
    }

    @Test
    void totalCost_Medium() {
        assertEquals(275, new DataBundle(500).totalCost());
    }

    @Test
    void totalCost_Basic() {
        assertEquals(96, new DataBundle(128).totalCost());
    }

    @Test
    void totalCost_One() {
        assertEquals(0.75, new DataBundle(1).totalCost());
    }

    @Test
    void totalCost_Zero() {
        assertEquals(0, new DataBundle(0).totalCost());
    }

    @Test
    void totalCost_Below_Zero() {
        assertEquals(151.5, new DataBundle(-202).totalCost());
    }
}