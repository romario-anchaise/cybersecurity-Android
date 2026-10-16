// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5254f;

    public ud(int i3, int i4, long j3, long j4, int i5, String str) {
        this.f5249a = i3;
        this.f5250b = i4;
        this.f5251c = j3;
        this.f5252d = j4;
        this.f5253e = i5;
        this.f5254f = str;
    }

    public static IllegalArgumentException a(String str) {
        return new IllegalArgumentException("invalid TextEdit V1: ".concat(str));
    }

    public static ud b(byte[] bArr) {
        if (bArr.length < 20) {
            throw a("inner payload too short");
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        int i3 = byteBufferOrder.get() & 255;
        int i4 = byteBufferOrder.get() & 255;
        short s3 = byteBufferOrder.getShort();
        int i5 = s3 & 65535;
        long j3 = byteBufferOrder.getLong();
        long j4 = ((long) byteBufferOrder.getInt()) & 4294967295L;
        short s4 = byteBufferOrder.getShort();
        int i6 = 65535 & byteBufferOrder.getShort();
        if (i3 != 1) {
            throw a("unsupported schema");
        }
        if (i6 != bArr.length - 20) {
            throw a("text length mismatch");
        }
        if (j3 == 0 || j4 == 0) {
            throw a("session or sequence missing");
        }
        if ((65534 & s3) != 0) {
            throw a("unknown flags");
        }
        if (s4 < -1024 || s4 > 1024) {
            throw a("amount out of range");
        }
        byte[] bArr2 = new byte[i6];
        byteBufferOrder.get(bArr2);
        try {
            CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr2)).toString();
            boolean z2 = (s3 & 1) != 0;
            switch (i4) {
                case 1:
                case 13:
                    if (z2 || s4 != 0 || i6 == 0) {
                        throw a("insertion fields invalid");
                    }
                    break;
                case 2:
                case 3:
                    if (z2 || s4 < 1 || i6 != 0) {
                        throw a("deletion fields invalid");
                    }
                    break;
                case 4:
                    if (s4 == 0 || i6 != 0) {
                        throw a("relative movement fields invalid");
                    }
                    break;
                case 5:
                case 6:
                    if (s4 != 0 || i6 != 0) {
                        throw a("boundary movement fields invalid");
                    }
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                    if (z2 || s4 != 0 || i6 != 0) {
                        throw a("operation fields invalid");
                    }
                    break;
                case 11:
                case 12:
                    if (!z2 && s4 == 0 && string != null && string.length() == 32) {
                        for (int i7 = 0; i7 < string.length(); i7++) {
                            char cCharAt = string.charAt(i7);
                            if ((cCharAt >= '0' && cCharAt <= '9') || (cCharAt >= 'a' && cCharAt <= 'f')) {
                            }
                        }
                        break;
                    }
                    throw a("cut token invalid");
                default:
                    throw a("unsupported operation");
            }
            return new ud(i4, i5, j3, j4, s4, string);
        } catch (CharacterCodingException unused) {
            throw a("text is not valid UTF-8");
        }
    }
}
