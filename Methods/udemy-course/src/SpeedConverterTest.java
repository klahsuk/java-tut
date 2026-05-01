import static org.junit.jupiter.api.Assertions.*;

class SpeedConverterTest {

    SpeedConverter converter = new SpeedConverter();

    @org.junit.jupiter.api.Test
    void toMilesPerHour() {
        assertEquals(1, converter.toMilesPerHour(1.5));
        assertEquals(6, converter.toMilesPerHour(10.25));
        assertEquals(-1, converter.toMilesPerHour(-5.6));
        assertEquals(16, converter.toMilesPerHour(25.42));
        assertEquals(47, converter.toMilesPerHour(75.114));

        converter.printConversion(1.5);
    }
}