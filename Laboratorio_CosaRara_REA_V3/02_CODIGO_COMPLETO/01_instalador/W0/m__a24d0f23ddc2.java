// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f824c;

    public final synchronized boolean a() {
        if (this.f822a) {
            return false;
        }
        this.f822a = true;
        this.f823b = false;
        this.f824c = -1;
        return true;
    }

    public final synchronized boolean b(int i2) {
        if (!d(i2)) {
            return false;
        }
        this.f822a = false;
        this.f823b = false;
        this.f824c = -1;
        return true;
    }

    public final synchronized l c(int i2) {
        if (!d(i2)) {
            return new l(-1, false);
        }
        this.f822a = false;
        this.f823b = false;
        this.f824c = -1;
        return new l(i2, true);
    }

    public final boolean d(int i2) {
        return this.f822a && i2 >= 0 && i2 == this.f824c;
    }
}
