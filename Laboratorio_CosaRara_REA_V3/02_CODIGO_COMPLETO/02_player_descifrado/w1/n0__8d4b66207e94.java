// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f4588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4593f = "";

    public n0(m0 m0Var) {
        if (m0Var == null) {
            o2.i("limits and clock required");
            throw null;
        }
        this.f4588a = m0Var;
        long jNanoTime = System.nanoTime();
        this.f4589b = jNanoTime;
        this.f4590c = jNanoTime > 9223372036794775807L ? Long.MAX_VALUE : jNanoTime + 60000000;
    }

    public final boolean a() {
        return this.f4593f.isEmpty() && b();
    }

    public final boolean b() {
        if (this.f4593f.isEmpty()) {
            if (System.nanoTime() - this.f4590c < 0) {
                return true;
            }
            if (this.f4593f.isEmpty()) {
                this.f4593f = "deadline";
            }
        }
        return false;
    }

    public final boolean c(int i3) {
        if (b()) {
            this.f4588a.getClass();
            if (i3 <= 32) {
                int i4 = this.f4592e;
                if (i4 < 512) {
                    this.f4592e = i4 + 1;
                    return true;
                }
                if (this.f4593f.isEmpty()) {
                    this.f4593f = "visited_limit";
                }
            } else if (this.f4593f.isEmpty()) {
                this.f4593f = "depth_limit";
                return false;
            }
        }
        return false;
    }

    public final boolean d() {
        if (b()) {
            int i3 = this.f4591d;
            this.f4588a.getClass();
            if (i3 < 8) {
                this.f4591d++;
                return true;
            }
            if (this.f4593f.isEmpty()) {
                this.f4593f = "window_limit";
            }
        }
        return false;
    }
}
