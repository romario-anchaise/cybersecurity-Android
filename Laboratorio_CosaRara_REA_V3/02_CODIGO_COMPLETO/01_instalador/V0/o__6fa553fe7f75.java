// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f721f;
    public static final String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f727m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f732r;

    static {
        String strA = p.a(new int[]{146, 54, 89, 125, 69, 0, 139, 252, 88, 38, 62, 246, 22, 247, 109, 219, 150, 50, 28, 3, 85, 26, 132, 249, 80, 38});
        f716a = Pattern.compile("^[a-z][a-z0-9_]*(?:\\.[a-z][a-z0-9_]*)+$");
        f717b = Pattern.compile("^[a-f0-9]{64}$");
        Pattern patternCompile = Pattern.compile("^[a-f0-9]{32}$");
        f718c = Pattern.compile("^[A-Za-z][A-Za-z0-9._-]{5,63}$");
        Pattern patternCompile2 = Pattern.compile("^[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?$");
        try {
            n nVar = new n(Class.forName(strA, true, o.class.getClassLoader()));
            if (nVar.b("SCHEMA_VERSION") != 1) {
                throw new IllegalStateException("unsupported target profile schema");
            }
            f719d = nVar;
            String strF = nVar.f(64, "TARGET_ID");
            String strD = nVar.d("WRAPPER_PACKAGE");
            String strD2 = nVar.d("CORE_PACKAGE");
            f720e = strD2;
            f721f = nVar.g("GATEWAY_URL", "wss");
            g = nVar.g("TELEMETRY_URL", "https");
            f722h = nVar.f(512, "TELEMETRY_KEY");
            f723i = nVar.g("HOME_URL", "https");
            f724j = nVar.f(100, "BRAND_NAME");
            nVar.d("WRAPPER_JAVA_NAMESPACE");
            nVar.d("CORE_JAVA_NAMESPACE");
            String strF2 = nVar.f(32, "PAYLOAD_KEY_HEX");
            if (!patternCompile.matcher(strF2).matches()) {
                throw new IllegalStateException("target profile AES key invalid: PAYLOAD_KEY_HEX");
            }
            f725k = strF2;
            f726l = nVar.c("PAYLOAD_HEADER_LEN", 8, 64);
            f727m = nVar.c("PAYLOAD_CHUNK_ORDER", 0, 1);
            nVar.c("PAYLOAD_SIGBLOCK_TYPE", 1, Integer.MAX_VALUE);
            String strA2 = nVar.a("CORE_ASSET_A");
            f728n = strA2;
            String strA3 = nVar.a("CORE_ASSET_B");
            f729o = strA3;
            f730p = nVar.c("VERSION_CODE", 1, Integer.MAX_VALUE);
            f731q = nVar.f(64, "VERSION_NAME");
            f732r = nVar.e("CORE_PAYLOAD_SHA256");
            nVar.e("STABLE_MODULE_SHA256");
            nVar.e("BRAND_MODULE_SHA256");
            nVar.e("TARGET_BINDING_SHA256");
            nVar.e("BUILD_NONCE");
            if (!patternCompile2.matcher(strF).matches()) {
                throw new ExceptionInInitializerError("invalid target profile id");
            }
            if (strD.equals(strD2)) {
                throw new ExceptionInInitializerError("wrapper and core packages must differ");
            }
            if (strA2.equals(strA3)) {
                throw new ExceptionInInitializerError("payload asset names must differ");
            }
            if (!"wrapper".equals(nVar.f(16, "ROLE"))) {
                throw new ExceptionInInitializerError("target profile role is not wrapper");
            }
        } catch (ReflectiveOperationException | RuntimeException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
