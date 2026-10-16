// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

/* JADX INFO: loaded from: classes.dex */
public abstract class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorC0197a f3768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0198b f3769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0198b f3770c;

    static {
        int i2 = 6;
        String property = System.getProperty("java.vm.name");
        property.getClass();
        if (property.equals("RoboVM")) {
            f3768a = null;
            f3769b = new C0198b(7);
            f3770c = new C0198b(i2);
        } else if (property.equals("Dalvik")) {
            f3768a = new ExecutorC0197a();
            f3769b = new K(0);
            f3770c = new C0200d(i2);
        } else {
            f3768a = null;
            f3769b = new K(1);
            f3770c = new C0200d(i2);
        }
    }
}
