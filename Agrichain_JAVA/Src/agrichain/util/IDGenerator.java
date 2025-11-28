package agrichain.util;

public class IDGenerator {

    private static int cropNo = 1;

    public static String generateCropId() {
        return "C" + String.format("%03d", cropNo++);
    }
}
