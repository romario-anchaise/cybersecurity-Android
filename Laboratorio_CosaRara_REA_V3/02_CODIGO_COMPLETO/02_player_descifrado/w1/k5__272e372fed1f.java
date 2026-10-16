// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4395d;

    public k5(String str, boolean z2, boolean z3, boolean z4) {
        this.f4395d = str;
        this.f4392a = z2;
        this.f4393b = z3;
        this.f4394c = z4;
    }

    public static k5 a(byte[] bArr) {
        if (bArr.length < 4) {
            o2.i("TEXT_INPUT payload too short");
            return null;
        }
        byte b3 = bArr[0];
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if ((b3 & 248) != 0 || bArr[1] != 0 || i3 != bArr.length - 4) {
            o2.i("TEXT_INPUT metadata invalid");
            return null;
        }
        try {
            CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, 4, i3)).toString();
            boolean z2 = (b3 & 4) != 0;
            if (!z2 || !string.isEmpty()) {
                return new k5(string, (b3 & 1) != 0, (b3 & 2) != 0, z2);
            }
            o2.i("paced TEXT_INPUT requires text");
            return null;
        } catch (Exception e3) {
            throw new IllegalArgumentException("TEXT_INPUT UTF-8 invalid", e3);
        }
    }

    public static k5 b() {
        return new k5(false, false, false, (n5) null);
    }

    public k5(boolean z2, boolean z3, boolean z4, n5 n5Var) {
        this.f4392a = z2;
        this.f4393b = z3;
        this.f4394c = z4;
        this.f4395d = n5Var;
    }
}
