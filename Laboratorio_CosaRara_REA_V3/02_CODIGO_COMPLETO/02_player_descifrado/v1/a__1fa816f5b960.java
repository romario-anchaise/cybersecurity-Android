// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v1;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f3277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Charset f3278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Charset f3279c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        charsetForName.getClass();
        f3277a = charsetForName;
        Charset.forName("UTF-16").getClass();
        Charset.forName("UTF-16BE").getClass();
        Charset.forName("UTF-16LE").getClass();
        Charset.forName("US-ASCII").getClass();
        Charset.forName("ISO-8859-1").getClass();
    }
}
