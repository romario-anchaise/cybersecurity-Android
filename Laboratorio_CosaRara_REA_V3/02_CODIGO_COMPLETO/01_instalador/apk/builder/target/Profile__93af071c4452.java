// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package apk.builder.target;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public final class Profile {

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public static final long f2077N0 = 8450496730865214858L;
    public static final long N1 = 359348178951441401L;
    public static final long N2 = 6589607830647544707L;
    public static final long N3 = 7956780659366243855L;

    private Profile() {
    }

    private static String decode(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (((i2 * 29) + 85) & 255));
        }
        return new String(bArr2, StandardCharsets.UTF_8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:93:0x015b  */
    public static Object value(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name");
        }
        switch (str) {
            case "SCHEMA_VERSION":
                return 1;
            case "ROLE":
                return decode(new byte[]{34, 0, -18, -36, -71, -125, 113});
            case "TARGET_ID":
                return decode(new byte[]{49, 7, -32, -58, -96, -120});
            case "WRAPPER_PACKAGE":
                return decode(new byte[]{54, 29, -30, -126, -90, -44, 112, 18, 80, 116, 16, -11, -44, -1, -115, 107, 22, 32, 109, 9, -6, -122, -90});
            case "CORE_PACKAGE":
                return decode(new byte[]{54, 29, -30, -126, -90, -107, 58, 83, 77, 116, 14, -14, -58, -91, -120, 121, 21, 38, 40, 26, -31, -41, -75});
            case "GATEWAY_URL":
                return decode(new byte[]{34, 1, -4, -106, -26, -55, 110, 79, 79, 63, 16, -5, -35, -86, -59, 107, 74, 109, 43, 9, -9, -40, -74, -100});
            case "BRAND_NAME":
                return decode(new byte[]{22, 29, -4, -51, -101, -121, 113, 65});
            case "WRAPPER_JAVA_NAMESPACE":
                return decode(new byte[]{57, 11, -3, -126, -70, -110, 98, 66, 81, 63, 89, -29, -61, -81, -101, 120, 64, 48});
            case "CORE_JAVA_NAMESPACE":
                return decode(new byte[]{57, 11, -3, -126, -70, -110, 98, 66, 81, 63, 89, -26, -60, -96, -97, 97, 72, 39});
            case "STABLE_MODULE_SHA256":
                return decode(new byte[]{108, 70, -71, -50, -83, -123, 96, 66, 88, 106, 18, -92, -43, -1, -39, 49, 28, 33, 107, 72, -87, -126, -78, -108, 53, 75, 36, 93, -79, -89, -117, -22, -51, 35, 75, 124, 90, -65, -63, -8, -71, -53, 35, 85, 100, 95, -66, -98, -90, -128, -55, 42, 12, 100, 16, -89, -98, -6, -33, 48, 20, 14, 61, 75});
            case "BRAND_MODULE_SHA256":
                return decode(new byte[]{99, 67, -23, -103, -7, -128, 101, 66, 9, 62, 64, -11, -45, -85, -37, 107, 70, 115, 60, 68, -96, -126, -75, -58, 56, 27, 35, 81, -73, -1, -39, -67, -61, 36, 25, 121, 11, -25, -110, -91, -69, -104, 35, 87, 55, 93, -24, -104, -10, -121, -102, 45, 8, 110, 69, -96, -101, -8, -46, 49, 21, 93, 56, 28});
            case "TARGET_BINDING_SHA256":
                return decode(new byte[]{97, 68, -68, -98, -15, -123, 48, 23, 13, 104, 20, -11, -123, -6, -39, 57, 70, 118, 57, 31, -96, -123, -21, -60, 57, 29, 35, 7, -78, -6, -113, -21, -58, 32, 26, 126, 93, -28, -110, -14, -22, -51, 116, 7, 99, 90, -78, -51, -90, -44, -53, 126, 1, 52, 65, -90, -50, -85, -124, 51, 71, 6, 106, 75});
            case "BUILD_NONCE":
                return decode(new byte[]{54, 16, -23, -54, -3, -123, 101, 68, 9, 56, 21, -11, -125, -88, -36, 108, 71, 32, 59, 69, -83, -46, -21, -60, 110, 30, 35, 6, -29, -86, -119, -69, -58, 113, 77, 127, 80, -74, -108, -92, -18, -52, 47, 81, 97, 92, -70, -51, -3, -43, -102, 127, 9, 55, 75, -87, -56, -6, -33, 50, 19, 90, 107, 72});
            case "VERSION_CODE":
                return 515;
            case "VERSION_NAME":
                return decode(new byte[]{100, 92, -67, -126, -4, -41, 49});
            case "STABLE_CORE_BEHAVIOR_ID":
                return decode(new byte[]{102, 65, -20, -99, -81, -43, 52, 22, 16, 105, 70, -10, -127, -29, -34, 108, 64, 36, 114, 29, -8, -126, -80, -35, 52, 28, 34, 6, -78, -5, -116, -67, -105, 35, 28, 122});
            case "CORE_SOURCE_SHA256":
                return decode(new byte[]{100, 20, -23, -97, -8, -47, 98, 70, 13, 62, 22, -83, -122, -1, -40, 57, 20, 33, 57, 77, -82, -124, -21, -58, 111, 73, 114, 87, -74, -85, -40, -69, -106, 116, 78, 124, 10, -80, -112, -91, -68, -53, 32, 2, 97, 13, -78, -102, -90, -43, -50, 37, 95, 52, 23, -88, -103, -8, -45, 49, 23, 14, 105, 29});
            case "BUILD_PROVENANCE":
                return decode(new byte[]{37, 0, -32, -63, -90, -110, 102, 68});
            case "PROCESS_EXIT_BUILD_ID":
                return decode(new byte[]{102, 68, -72, -54, -83, -47, 103, 17, 94, 105, 21, -10, -127, -7, -118, 59, 64, 116, 58, 30, -85, -114, -31, -110, 57, 75, 112, 6, -74, -85, -117, -67, -51, 112, 78, 121, 8, -25, -111, -9, -72, -97, 35, 85, 99, 11, -70, -97, -95, -37, -101, 41, 11, 100, 69, -94, -49, -4, -41, 61, 66, 15, 108, 28});
            case "TELEMETRY_URL":
                return decode(new byte[]{61, 6, -5, -36, -70, -36, 44, 15, 80, 53, 5, -15, -42, -95, -121, 108, 11, 33, 48, 83, -8, -58, -70, -33, 121, 79, 43, 1, -20, -5, -49, -86, -116, 61, 70, 34, 26, -14, -62, -84, -79});
            case "TELEMETRY_KEY":
                return decode(new byte[]{30, 40, -24, -39, -82, -73, 52, 108, 84, 10, 4, -40, -59, -97, -65, 105, 67, 16, 21, 59, -9, -3, -89, -124, 73, 75, 118, 29, -64, -50, -52, -70});
            case "HOME_URL":
                return decode(new byte[]{61, 6, -5, -36, -70, -36, 44, 15, 92, 42, 7, -70, -43, -89, -120, 99, 81, 45, 52, 82, -17, -33, -93, -33});
            case "PAYLOAD_KEY_HEX":
                return decode(new byte[]{102, 16, -72, -108, -3, -46, 55, 66, 91, 106, 78, -96, -125, -3, -115, 106, 16, 117, 57, 30, -83, -48, -30, -106, 57, 76, 33, 6, -32, -86, -33, -21});
            case "PAYLOAD_HEADER_LEN":
                return 21;
            case "PAYLOAD_CHUNK_ORDER":
                return 1;
            case "PAYLOAD_SIGBLOCK_TYPE":
                return 988570784;
            case "CORE_ASSET_A":
                return decode(new byte[]{59, 25, -71, -103, -7, -47, 107, 25, 76, 107});
            case "CORE_ASSET_B":
                return decode(new byte[]{59, 16, -2, -36, -90, -34, 112, 66, 87});
            case "CORE_PAYLOAD_SHA256":
                return decode(new byte[]{54, 75, -73, -55, -85, -121, 102, 20, 91, 60, 64, -96, -43, -4, -40, 62, 71, 118, 102, 72, -6, -113, -29, -57, 53, 24, 36, 93, -80, -4, -39, -23, -106, 33, 75, 120, 93, -30, -105, -10, -17, -101, 39, 2, 100, 15, -77, -101, -92, -128, -52, 47, 91, 97, 70, -15, -107, -14, -127, 49, 24, 9, 98, 77});
            default:
                throw new IllegalArgumentException("unknown profile field");
        }
    }
}
