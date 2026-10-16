// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

/* JADX INFO: loaded from: classes.dex */
public final class f extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient p040w0.i f546a;

    public f(p040w0.i iVar) {
        this.f546a = iVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f546a.toString();
    }
}
