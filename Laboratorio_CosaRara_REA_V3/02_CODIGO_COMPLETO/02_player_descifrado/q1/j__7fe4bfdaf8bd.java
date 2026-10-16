// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f3130a;

    static {
        k kVar = null;
        try {
            kVar = (k) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (kVar == null) {
            kVar = new k();
        }
        f3130a = kVar;
    }
}
