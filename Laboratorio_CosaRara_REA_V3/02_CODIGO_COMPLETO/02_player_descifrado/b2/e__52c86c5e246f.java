// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f273c;

    public /* synthetic */ e(String str, boolean z2, int i3) {
        this.f271a = i3;
        this.f273c = str;
        this.f272b = z2;
    }

    public static e a(String str) {
        return new e(false, str, 1);
    }

    public String toString() {
        switch (this.f271a) {
            case 2:
                String str = this.f273c;
                int length = String.valueOf(str).length();
                boolean z2 = this.f272b;
                StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(z2).length());
                sb.append("{");
                sb.append(str);
                sb.append("}");
                sb.append(z2);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ e(boolean z2, String str, int i3) {
        this.f271a = i3;
        this.f272b = z2;
        this.f273c = str;
    }
}
