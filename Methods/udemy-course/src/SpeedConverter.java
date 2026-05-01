public class SpeedConverter {

    public long toMilesPerHour(double kilometersPerHour) {
        if(kilometersPerHour < 0) {
            return -1L;
        } else {
            return Math.round(kilometersPerHour/1.6);
        }
    }

    public void printConversion(double kilometersPerHour) {
        long mph = toMilesPerHour(kilometersPerHour);
        String output = (kilometersPerHour < 0) ? "Invalid Value" : kilometersPerHour + " km/h = " + mph + " mi/h";
        System.out.println(output);
    }
}
