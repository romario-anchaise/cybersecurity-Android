// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Charset f361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Charset f362c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        F0.i.d(charsetForName, "forName(...)");
        f360a = charsetForName;
        F0.i.d(Charset.forName("UTF-16"), "forName(...)");
        F0.i.d(Charset.forName("UTF-16BE"), "forName(...)");
        F0.i.d(Charset.forName("UTF-16LE"), "forName(...)");
        F0.i.d(Charset.forName("US-ASCII"), "forName(...)");
        F0.i.d(Charset.forName("ISO-8859-1"), "forName(...)");
    }
}
