// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

/* JADX INFO: loaded from: classes.dex */
public final class S implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S f3822a = new S();

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return Q.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        return obj instanceof Q;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@" + Q.class.getName() + "()";
    }
}
