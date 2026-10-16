// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.C0005e;

/* JADX INFO: renamed from: j.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0141d0 extends C0005e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0143e0 f3156c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0141d0(C0143e0 c0143e0) {
        super(21, c0143e0);
        this.f3156c = c0143e0;
    }

    @Override // A.C0005e, p015j.InterfaceC0139c0
    public final void c(int i2) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i2);
    }

    @Override // A.C0005e, p015j.InterfaceC0139c0
    public final void w(int i2) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i2);
    }
}
