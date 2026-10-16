// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package apk.builder.target;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public final class Profile {
    public static final long N0 = 2218654230607026274L;
    public static final long N1 = 361752404608778617L;
    public static final long N2 = 4774759970790607020L;
    public static final long N3 = 3459544353818860075L;

    private Profile() {
    }

    private static String decode(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i3] = (byte) (bArr[i3] ^ (((i3 * 29) + 217) & 255));
        }
        return new String(bArr2, StandardCharsets.UTF_8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:69:0x00f8  */
    public static Object value(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name");
        }
        switch (str) {
            case "SCHEMA_VERSION":
                return 1;
            case "ROLE":
                return decode(new byte[]{-70, -103, 97, 85});
            case "TARGET_ID":
                return decode(new byte[]{-67, -125, 124, 90, 36, 4});
            case "WRAPPER_PACKAGE":
                return decode(new byte[]{-70, -103, 126, 30, 34, 88, -12, -106, -84, -16, -100, 121, 80, 99, 9, -17, -102, -92, -47, 117, 126, 10, 34});
            case "CORE_PACKAGE":
                return decode(new byte[]{-70, -103, 126, 30, 34, 25, -66, -41, -79, -16, -126, 126, 66, 57, 12, -3, -103, -94, -108, 102, 101, 91, 49});
            case "GATEWAY_URL":
                return decode(new byte[]{-82, -123, 96, 10, 98, 69, -22, -53, -77, -69, -100, 119, 89, 54, 65, -17, -58, -23, -105, 117, 115, 84, 50, 24});
            case "BRAND_NAME":
                return decode(new byte[]{-102, -103, 96, 81, 31, 11, -11, -59});
            case "WRAPPER_JAVA_NAMESPACE":
                return decode(new byte[]{-75, -113, 97, 30, 62, 30, -26, -58, -83, -69, -43, 111, 71, 51, 31, -4, -52, -76});
            case "CORE_JAVA_NAMESPACE":
                return decode(new byte[]{-75, -113, 97, 30, 62, 30, -26, -58, -83, -69, -43, 106, 64, 60, 27, -27, -60, -93});
            case "STABLE_MODULE_SHA256":
                return decode(new byte[]{-32, -62, 37, 82, 41, 9, -28, -58, -92, -18, -98, 40, 81, 99, 93, -75, -112, -91, -41, 52, 45, 14, 54, 16, -87, -49, -88, -47, 53, 27, 15, 110, 65, -89, -41, -32, -34, 51, 69, 124, 5, 79, -81, -39, -32, -61, 58, 26, 42, 4, -75, -106, -120, -24, -108, 35, 2, 126, 83, -68, -112, -14, -71, -49});
            case "BRAND_MODULE_SHA256":
                return decode(new byte[]{-17, -57, 117, 5, 125, 12, -31, -58, -11, -70, -52, 121, 87, 55, 95, -17, -54, -9, -128, 56, 36, 14, 49, 66, -92, -97, -81, -35, 51, 67, 93, 57, 79, -96, -123, -27, -113, 107, 22, 33, 7, 28, -81, -37, -77, -63, 108, 28, 122, 3, -26, -111, -116, -30, -63, 36, 7, 124, 94, -67, -111, -95, -68, -104});
            case "TARGET_BINDING_SHA256":
                return decode(new byte[]{-21, -107, 43, 86, 44, 94, -29, -110, -12, -23, -102, 46, 84, 48, 9, -23, -111, -2, -47, 56, 41, 3, 96, 17, -12, -52, -82, -35, 103, 64, 7, 63, 31, -92, -122, -29, -37, 51, 65, 119, 86, 31, -81, -34, -77, -54, 108, 29, 122, 4, -73, -61, -36, -30, -110, 117, 7, 121, 95, -18, -60, -89, -67, -99});
            case "BUILD_NONCE":
                return decode(new byte[]{-18, -50, 112, 9, 122, 15, -73, -62, -13, -23, -97, 32, 12, 97, 90, -68, -56, -9, -121, 51, 120, 89, 111, 66, -93, -54, -83, -33, 61, 27, 7, 100, 27, -91, -42, -24, -36, 62, 18, 124, 4, 29, -1, -35, -25, -63, 60, 31, 120, 5, -25, -63, -36, -17, -61, 32, 3, 122, 9, -79, -107, -89, -23, -49});
            case "VERSION_CODE":
                return 515;
            case "VERSION_NAME":
                return decode(new byte[]{-24, -40, 33, 30, 120, 91, -75});
            case "STABLE_CORE_BEHAVIOR_ID":
                return decode(new byte[]{-22, -59, 112, 1, 43, 89, -80, -110, -20, -19, -54, 122, 5, 127, 90, -24, -52, -96, -50, 97, 124, 14, 52, 89, -88, -104, -82, -118, 54, 71, 8, 57, 27, -89, -128, -26});
            case "CORE_SOURCE_SHA256":
                return decode(new byte[]{-24, -112, 117, 3, 124, 93, -26, -62, -15, -70, -102, 33, 2, 99, 92, -67, -104, -91, -123, 49, 42, 8, 111, 66, -13, -51, -2, -37, 50, 23, 92, 63, 26, -16, -46, -32, -114, 60, 20, 33, 0, 79, -84, -114, -27, -111, 54, 30, 42, 81, -78, -103, -37, -72, -109, 44, 5, 124, 95, -67, -109, -14, -19, -103});
            case "BUILD_PROVENANCE":
                return decode(new byte[]{-87, -124, 124, 93, 34, 30, -30, -64});
            case "PROCESS_EXIT_BUILD_ID":
                return decode(new byte[]{-22, -64, 36, 86, 41, 93, -29, -107, -94, -19, -103, 122, 5, 101, 14, -65, -52, -16, -122, 98, 47, 2, 101, 22, -91, -49, -4, -118, 50, 23, 15, 57, 65, -12, -46, -27, -116, 107, 21, 115, 4, 27, -81, -39, -25, -105, 62, 27, 45, 95, -25, -107, -113, -24, -63, 38, 83, 120, 91, -79, -58, -13, -24, -104});
            case "HOST_MAIN_ACTIVITY":
                return decode(new byte[]{-75, -113, 97, 30, 62, 30, -26, -58, -83, -69, -43, 111, 71, 51, 31, -4, -52, -76, -51, 77, 124, 83, 57, 53, -14, -38, -94, -98, 108, 86, 70});
            case "HOST_BOOTSTRAP_ACTIVITY":
                return decode(new byte[]{-75, -113, 97, 30, 62, 30, -26, -58, -83, -69, -43, 111, 71, 51, 31, -4, -52, -76, -51, 83, 117, 95, 59, 24, -45, -63, -92, -100, 118, 86, 77, 61, 9, -41, -48, -92, -124, 124, 78, 48, 24});
            default:
                throw new IllegalArgumentException("unknown profile field");
        }
    }
}
