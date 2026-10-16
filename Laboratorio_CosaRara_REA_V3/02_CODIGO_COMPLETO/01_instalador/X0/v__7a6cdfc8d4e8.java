// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import A.C0005e;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H.x f1045a = new H.x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0005e f1046b = new C0005e(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1047c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f1048d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final W0.t f1049e = new W0.t();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1050f = true;
    public final C0055b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1052i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0055b f1053j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0055b f1054k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C0055b f1055l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SocketFactory f1056m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List f1057n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f1058o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j1.c f1059p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final C0059f f1060q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1061r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1062s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f1063t;

    public v() {
        C0055b c0055b = C0055b.f944a;
        this.g = c0055b;
        this.f1051h = true;
        this.f1052i = true;
        this.f1053j = C0055b.f945b;
        this.f1054k = C0055b.f946c;
        this.f1055l = c0055b;
        SocketFactory socketFactory = SocketFactory.getDefault();
        F0.i.d(socketFactory, "getDefault()");
        this.f1056m = socketFactory;
        this.f1057n = w.f1064A;
        this.f1058o = w.f1065z;
        this.f1059p = j1.c.f3401a;
        this.f1060q = C0059f.f961c;
        this.f1061r = 10000;
        this.f1062s = 10000;
        this.f1063t = 10000;
    }
}
