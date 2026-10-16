// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a0;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f35c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ k[] f36d;

    static {
        k kVar = new k("INSTANCE", 0);
        f35c = kVar;
        f36d = new k[]{kVar};
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f36d.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "DirectExecutor";
    }
}
