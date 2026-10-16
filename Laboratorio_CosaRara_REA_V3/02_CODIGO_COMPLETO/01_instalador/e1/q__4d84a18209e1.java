// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static int a(int i2, int i3, int i4) {
        if ((i3 & 8) != 0) {
            i2--;
        }
        if (i4 <= i2) {
            return i2 - i4;
        }
        throw new IOException("PROTOCOL_ERROR padding " + i4 + " > remaining length " + i2);
    }
}
