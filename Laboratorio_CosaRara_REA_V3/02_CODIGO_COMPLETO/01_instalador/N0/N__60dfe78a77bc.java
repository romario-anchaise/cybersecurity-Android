// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;
import p018k0.y;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class N extends y {
    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(aVar.H(), "_");
        String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        if (strNextToken2 == null && strNextToken3 == null) {
            return new Locale(strNextToken);
        }
        return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        Locale locale = (Locale) obj;
        bVar.D(locale == null ? null : locale.toString());
    }
}
