// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e0;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f685c;

    public n(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f685c = bArr;
    }

    @Override // e0.m
    public final byte[] e() {
        return this.f685c;
    }
}
