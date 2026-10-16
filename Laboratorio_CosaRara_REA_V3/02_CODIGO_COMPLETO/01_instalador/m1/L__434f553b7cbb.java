// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import A.C0005e;
import X0.C0055b;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char[] f3772l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f3773m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.p f3775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public X0.o f3777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V.a f3778e = new V.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0005e f3779f;
    public X0.s g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f3780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C.h f3781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final H.s f3782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public X0.B f3783k;

    public L(String str, X0.p pVar, String str2, X0.n nVar, X0.s sVar, boolean z2, boolean z3, boolean z4) {
        this.f3774a = str;
        this.f3775b = pVar;
        this.f3776c = str2;
        this.g = sVar;
        this.f3780h = z2;
        if (nVar != null) {
            this.f3779f = nVar.c();
        } else {
            this.f3779f = new C0005e(10);
        }
        if (z3) {
            this.f3782j = new H.s(3);
            return;
        }
        if (z4) {
            C.h hVar = new C.h();
            this.f3781i = hVar;
            X0.s sVar2 = X0.u.f1038f;
            F0.i.e(sVar2, "type");
            if (sVar2.f1033b.equals("multipart")) {
                hVar.f112b = sVar2;
            } else {
                throw new IllegalArgumentException(("multipart != " + sVar2).toString());
            }
        }
    }

    public final void a(String str, String str2, boolean z2) {
        H.s sVar = this.f3782j;
        if (z2) {
            sVar.getClass();
            F0.i.e(str, "name");
            ((ArrayList) sVar.f232b).add(C0055b.b(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, 83));
            ((ArrayList) sVar.f233c).add(C0055b.b(str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, 83));
            return;
        }
        sVar.getClass();
        F0.i.e(str, "name");
        ((ArrayList) sVar.f232b).add(C0055b.b(str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, 91));
        ((ArrayList) sVar.f233c).add(C0055b.b(str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, 91));
    }

    public final void b(String str, String str2, boolean z2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            C0005e c0005e = this.f3779f;
            if (z2) {
                c0005e.A(str, str2);
                return;
            } else {
                c0005e.y(str, str2);
                return;
            }
        }
        try {
            Pattern pattern = X0.s.f1030d;
            this.g = f1.d.q(str2);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e2);
        }
    }

    public final void c(X0.n nVar, X0.B b2) {
        C.h hVar = this.f3781i;
        hVar.getClass();
        F0.i.e(b2, "body");
        if (nVar.a("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (nVar.a("Content-Length") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        ((ArrayList) hVar.f113c).add(new X0.t(nVar, b2));
    }

    public final void d(String str, String str2, boolean z2) {
        String str3 = this.f3776c;
        if (str3 != null) {
            X0.p pVar = this.f3775b;
            X0.o oVarF = pVar.f(str3);
            this.f3777d = oVarF;
            if (oVarF == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + pVar + ", Relative: " + this.f3776c);
            }
            this.f3776c = null;
        }
        if (z2) {
            X0.o oVar = this.f3777d;
            oVar.getClass();
            F0.i.e(str, "encodedName");
            if (oVar.g == null) {
                oVar.g = new ArrayList();
            }
            ArrayList arrayList = oVar.g;
            F0.i.b(arrayList);
            arrayList.add(C0055b.b(str, 0, 0, " \"'<>#&=", true, false, true, false, 211));
            ArrayList arrayList2 = oVar.g;
            F0.i.b(arrayList2);
            arrayList2.add(str2 != null ? C0055b.b(str2, 0, 0, " \"'<>#&=", true, false, true, false, 211) : null);
            return;
        }
        X0.o oVar2 = this.f3777d;
        oVar2.getClass();
        F0.i.e(str, "name");
        if (oVar2.g == null) {
            oVar2.g = new ArrayList();
        }
        ArrayList arrayList3 = oVar2.g;
        F0.i.b(arrayList3);
        arrayList3.add(C0055b.b(str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 219));
        ArrayList arrayList4 = oVar2.g;
        F0.i.b(arrayList4);
        arrayList4.add(str2 != null ? C0055b.b(str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 219) : null);
    }
}
