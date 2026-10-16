// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ b[] f177h;

    static {
        b bVar = new b("DESTROYED", 0);
        f172c = bVar;
        b bVar2 = new b("INITIALIZED", 1);
        f173d = bVar2;
        b bVar3 = new b("CREATED", 2);
        f174e = bVar3;
        b bVar4 = new b("STARTED", 3);
        f175f = bVar4;
        b bVar5 = new b("RESUMED", 4);
        f176g = bVar5;
        f177h = new b[]{bVar, bVar2, bVar3, bVar4, bVar5};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f177h.clone();
    }
}
