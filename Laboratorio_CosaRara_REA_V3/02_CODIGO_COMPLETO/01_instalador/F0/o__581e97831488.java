// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f181a;

    static {
        p pVar = null;
        try {
            pVar = (p) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (pVar == null) {
            pVar = new p();
        }
        f181a = pVar;
    }
}
