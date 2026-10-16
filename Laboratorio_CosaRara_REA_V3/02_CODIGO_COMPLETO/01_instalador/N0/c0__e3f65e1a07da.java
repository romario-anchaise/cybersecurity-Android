// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import p018k0.k;
import p018k0.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final S f3892A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final P f3893B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final S f3894a = new S(Class.class, new k(new F(), 2), 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final S f3895b = new S(BitSet.class, new k(new Q(), 2), 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final V f3896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final T f3897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final T f3898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final T f3899f;
    public static final T g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final S f3900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final S f3901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final S f3902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0240w f3903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final T f3904l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final B f3905m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final C f3906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final D f3907o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final S f3908p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final S f3909q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final S f3910r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final S f3911s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final S f3912t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final S f3913u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final S f3914v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final S f3915w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final C0229k f3916x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final S f3917y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final O f3918z;

    static {
        U u2 = new U();
        f3896c = new V();
        f3897d = new T(Boolean.TYPE, Boolean.class, u2);
        f3898e = new T(Byte.TYPE, Byte.class, new W());
        f3899f = new T(Short.TYPE, Short.class, new X());
        g = new T(Integer.TYPE, Integer.class, new Y());
        f3900h = new S(AtomicInteger.class, new k(new Z(), 2), 0);
        f3901i = new S(AtomicBoolean.class, new k(new a0(), 2), 0);
        f3902j = new S(AtomicIntegerArray.class, new k(new C0239v(), 2), 0);
        f3903k = new C0240w();
        new C0241x();
        new C0242y();
        f3904l = new T(Character.TYPE, Character.class, new C0243z());
        A a2 = new A();
        f3905m = new B();
        f3906n = new C();
        f3907o = new D();
        f3908p = new S(String.class, a2, 0);
        f3909q = new S(StringBuilder.class, new E(), 0);
        f3910r = new S(StringBuffer.class, new G(), 0);
        f3911s = new S(URL.class, new H(), 0);
        f3912t = new S(URI.class, new I(), 0);
        f3913u = new S(InetAddress.class, new J(), 1);
        f3914v = new S(UUID.class, new K(), 0);
        f3915w = new S(Currency.class, new k(new L(), 2), 0);
        f3916x = new C0229k(2, new M());
        f3917y = new S(Locale.class, new N(), 0);
        O o2 = new O();
        f3918z = o2;
        f3892A = new S(o.class, o2, 1);
        f3893B = new P();
    }
}
