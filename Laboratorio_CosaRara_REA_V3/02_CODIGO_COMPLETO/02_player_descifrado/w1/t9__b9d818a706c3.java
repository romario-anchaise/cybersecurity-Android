// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.net.URI;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f5170a = Pattern.compile("^[a-z][a-z0-9_]*(?:\\.[a-z][a-z0-9_]*)+$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f5171b = Pattern.compile("^(?:[A-Za-z_$][A-Za-z0-9_$]*\\.)+[A-Za-z_$][A-Za-z0-9_$]*$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f5172c = Pattern.compile("^[a-f0-9]{64}$");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f5175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f5178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f5180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f5181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f5182m;
    public static final String n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f5183o;

    static {
        Pattern patternCompile = Pattern.compile("^[a-f0-9]{8}-(?:[a-f0-9]{4}-){3}[a-f0-9]{12}$");
        Pattern patternCompile2 = Pattern.compile("^[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?$");
        try {
            e2.n1 n1Var = new e2.n1(Class.forName("apk.builder.target.Profile", true, t9.class.getClassLoader()));
            if (n1Var.m("SCHEMA_VERSION") != 1) {
                throw new IllegalStateException("unsupported target profile schema");
            }
            String strU = n1Var.u("TARGET_ID", 64);
            String strP = n1Var.p("CORE_PACKAGE");
            f5173d = strP;
            String strP2 = n1Var.p("WRAPPER_PACKAGE");
            f5174e = strP2;
            f5175f = n1Var.j("HOST_MAIN_ACTIVITY");
            n1Var.j("HOST_BOOTSTRAP_ACTIVITY");
            String strU2 = n1Var.u("GATEWAY_URL", 2048);
            try {
                URI uriCreate = URI.create(strU2);
                if (!"wss".equals(uriCreate.getScheme()) || uriCreate.getHost() == null || uriCreate.getUserInfo() != null || uriCreate.getFragment() != null) {
                    throw new IllegalStateException("target profile URL invalid: GATEWAY_URL");
                }
                f5176g = strU2;
                f5177h = n1Var.u("BRAND_NAME", 100);
                n1Var.p("WRAPPER_JAVA_NAMESPACE");
                f5178i = n1Var.p("CORE_JAVA_NAMESPACE");
                n1Var.s("STABLE_MODULE_SHA256");
                n1Var.s("BRAND_MODULE_SHA256");
                n1Var.s("TARGET_BINDING_SHA256");
                n1Var.s("BUILD_NONCE");
                int iM = n1Var.m("VERSION_CODE");
                if (iM < 1 || iM > Integer.MAX_VALUE) {
                    o2.k("target profile integer out of range: VERSION_CODE");
                    return;
                }
                f5179j = iM;
                f5180k = n1Var.u("VERSION_NAME", 64);
                String strU3 = n1Var.u("STABLE_CORE_BEHAVIOR_ID", 36);
                if (!patternCompile.matcher(strU3).matches()) {
                    o2.k("target profile UUID invalid: STABLE_CORE_BEHAVIOR_ID");
                    return;
                }
                f5181l = strU3;
                f5182m = n1Var.s("CORE_SOURCE_SHA256");
                String strU4 = n1Var.u("BUILD_PROVENANCE", 16);
                if (!"development".equals(strU4) && !"promoted".equals(strU4)) {
                    o2.k("target profile provenance invalid: BUILD_PROVENANCE");
                    return;
                }
                n = strU4;
                f5183o = n1Var.s("PROCESS_EXIT_BUILD_ID");
                if (!patternCompile2.matcher(strU).matches()) {
                    throw new ExceptionInInitializerError("invalid target profile id");
                }
                if (strP.equals(strP2)) {
                    throw new ExceptionInInitializerError("core and wrapper packages must differ");
                }
                if (!"core".equals(n1Var.u("ROLE", 16))) {
                    throw new ExceptionInInitializerError("target profile role is not core");
                }
            } catch (IllegalArgumentException e3) {
                throw new IllegalStateException("target profile URL invalid: GATEWAY_URL", e3);
            }
        } catch (ReflectiveOperationException | RuntimeException e4) {
            ExceptionInInitializerError exceptionInInitializerError = new ExceptionInInitializerError("signed target profile unavailable");
            exceptionInInitializerError.initCause(e4);
            throw exceptionInInitializerError;
        }
    }
}
