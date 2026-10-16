// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

import N0.AbstractC0049v;

/* JADX INFO: loaded from: classes.dex */
public final class j extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f610c;

    public j(Runnable runnable, long j2, i iVar) {
        super(j2, iVar);
        this.f610c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f610c.run();
        } finally {
            this.f608b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f610c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(AbstractC0049v.d(runnable));
        sb.append(", ");
        sb.append(this.f607a);
        sb.append(", ");
        sb.append(this.f608b);
        sb.append(']');
        return sb.toString();
    }
}
