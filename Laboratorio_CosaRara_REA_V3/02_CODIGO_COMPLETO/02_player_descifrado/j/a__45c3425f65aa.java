// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package j;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2301c;

    public /* synthetic */ a(String str) {
        this.f2301c = str;
    }

    public boolean a(String str) {
        if (str.isEmpty() || str.equals(this.f2301c)) {
            return false;
        }
        this.f2301c = str;
        return true;
    }

    @Override // j.f
    public String d() {
        return this.f2301c;
    }

    @Override // j.f
    public void w(e eVar) {
    }
}
