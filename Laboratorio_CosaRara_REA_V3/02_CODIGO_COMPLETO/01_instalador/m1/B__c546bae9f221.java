// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class B extends W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0198b f3750f;
    public final boolean g;

    public B(int i2, String str, boolean z2) {
        this.f3748d = i2;
        switch (i2) {
            case 1:
                C0198b c0198b = C0198b.f3833b;
                Objects.requireNonNull(str, "name == null");
                this.f3749e = str;
                this.f3750f = c0198b;
                this.g = z2;
                break;
            case 2:
                C0198b c0198b2 = C0198b.f3833b;
                Objects.requireNonNull(str, "name == null");
                this.f3749e = str;
                this.f3750f = c0198b2;
                this.g = z2;
                break;
            default:
                C0198b c0198b3 = C0198b.f3833b;
                Objects.requireNonNull(str, "name == null");
                this.f3749e = str;
                this.f3750f = c0198b3;
                this.g = z2;
                break;
        }
    }

    @Override // m1.W
    public final void a(L l2, Object obj) {
        switch (this.f3748d) {
            case 0:
                if (obj != null) {
                    this.f3750f.getClass();
                    String string = obj.toString();
                    if (string != null) {
                        l2.a(this.f3749e, string, this.g);
                        break;
                    }
                }
                break;
            case 1:
                if (obj != null) {
                    this.f3750f.getClass();
                    String string2 = obj.toString();
                    if (string2 != null) {
                        l2.b(this.f3749e, string2, this.g);
                        break;
                    }
                }
                break;
            default:
                if (obj != null) {
                    this.f3750f.getClass();
                    String string3 = obj.toString();
                    if (string3 != null) {
                        l2.d(this.f3749e, string3, this.g);
                        break;
                    }
                }
                break;
        }
    }
}
