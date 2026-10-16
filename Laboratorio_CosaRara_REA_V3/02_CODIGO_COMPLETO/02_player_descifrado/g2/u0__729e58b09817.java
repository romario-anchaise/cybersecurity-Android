// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'g' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u0 f1748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u0 f1749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u0 f1750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u0 f1751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u0 f1752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u0 f1753l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final u0 f1754m;
    public static final u0 n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final u0 f1755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final u0 f1756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final u0 f1757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ u0[] f1758r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0 f1759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1762f;

    static {
        v0 v0Var = v0.f1766d;
        u0 u0Var = new u0("H264_HEADER", 0, v0Var, 5, "h264:header", true);
        f1748g = u0Var;
        u0 u0Var2 = new u0("H264_CONFIG", 1, v0Var, 5, "h264:config", true);
        f1749h = u0Var2;
        u0 u0Var3 = new u0("H264_KEYFRAME", 2, v0Var, 4, "h264:keyframe", true);
        f1750i = u0Var3;
        u0 u0Var4 = new u0("H264_DISPOSABLE", 3, v0Var, 0, null, false);
        f1751j = u0Var4;
        v0 v0Var2 = v0.f1769g;
        u0 u0Var5 = new u0("CAMERA_HEADER", 4, v0Var2, 5, "camera:header", true);
        f1752k = u0Var5;
        u0 u0Var6 = new u0("CAMERA_FRAME", 5, v0Var2, 1, "camera:frame", false);
        f1753l = u0Var6;
        v0 v0Var3 = v0.f1767e;
        u0 u0Var7 = new u0("WEBP_FRAME", 6, v0Var3, 2, "webp", false);
        f1754m = u0Var7;
        u0 u0Var8 = new u0("WEBP_PACKET", 7, v0Var3, 2, "webp", false);
        v0 v0Var4 = v0.f1768f;
        u0 u0Var9 = new u0("NODE_V1", 8, v0Var4, 3, "nodes", false);
        n = u0Var9;
        u0 u0Var10 = new u0("NODE_V2", 9, v0Var4, 3, "nodes", false);
        f1755o = u0Var10;
        u0 u0Var11 = new u0("NODE_V3_FULL", 10, v0Var4, 3, "nodes", false);
        f1756p = u0Var11;
        u0 u0Var12 = new u0("NODE_V3_OBSERVATION", 11, v0Var4, 2, "nodes", false);
        f1757q = u0Var12;
        f1758r = new u0[]{u0Var, u0Var2, u0Var3, u0Var4, u0Var5, u0Var6, u0Var7, u0Var8, u0Var9, u0Var10, u0Var11, u0Var12};
    }

    public u0(String str, int i3, v0 v0Var, int i4, String str2, boolean z2) {
        super(str, i3);
        this.f1759c = v0Var;
        this.f1760d = i4;
        this.f1761e = str2;
        this.f1762f = z2;
    }

    public static u0 valueOf(String str) {
        return (u0) Enum.valueOf(u0.class, str);
    }

    public static u0[] values() {
        return (u0[]) f1758r.clone();
    }
}
