// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class T extends CancellationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient a0 f402a;

    public T(String str, Throwable th, a0 a0Var) {
        super(str);
        this.f402a = a0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof T) {
                T t2 = (T) obj;
                if (!F0.i.a(t2.getMessage(), getMessage()) || !F0.i.a(t2.f402a, this.f402a) || !F0.i.a(t2.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        F0.i.b(message);
        int iHashCode = (this.f402a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f402a;
    }
}
