// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import k1.InterfaceC0195k;

/* JADX INFO: loaded from: classes.dex */
public final class E extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0195k f917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStreamReader f920d;

    public E(InterfaceC0195k interfaceC0195k, Charset charset) {
        F0.i.e(interfaceC0195k, "source");
        F0.i.e(charset, "charset");
        this.f917a = interfaceC0195k;
        this.f918b = charset;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        p034t0.h hVar;
        this.f919c = true;
        InputStreamReader inputStreamReader = this.f920d;
        if (inputStreamReader != null) {
            inputStreamReader.close();
            hVar = p034t0.h.f4132b;
        } else {
            hVar = null;
        }
        if (hVar == null) {
            this.f917a.close();
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i2, int i3) throws IOException {
        Charset charsetForName;
        F0.i.e(cArr, "cbuf");
        if (this.f919c) {
            throw new IOException("Stream closed");
        }
        InputStreamReader inputStreamReader = this.f920d;
        if (inputStreamReader == null) {
            InputStream inputStreamS = this.f917a.s();
            InterfaceC0195k interfaceC0195k = this.f917a;
            Charset charset = this.f918b;
            byte[] bArr = Y0.b.f1119a;
            F0.i.e(interfaceC0195k, "<this>");
            F0.i.e(charset, "default");
            int iH = interfaceC0195k.h(Y0.b.f1122d);
            if (iH != -1) {
                if (iH == 0) {
                    charset = StandardCharsets.UTF_8;
                    F0.i.d(charset, "UTF_8");
                } else if (iH == 1) {
                    charset = StandardCharsets.UTF_16BE;
                    F0.i.d(charset, "UTF_16BE");
                } else if (iH != 2) {
                    if (iH == 3) {
                        Charset charset2 = M0.a.f360a;
                        charsetForName = M0.a.f362c;
                        if (charsetForName == null) {
                            charsetForName = Charset.forName("UTF-32BE");
                            F0.i.d(charsetForName, "forName(...)");
                            M0.a.f362c = charsetForName;
                        }
                    } else {
                        if (iH != 4) {
                            throw new AssertionError();
                        }
                        Charset charset3 = M0.a.f360a;
                        charsetForName = M0.a.f361b;
                        if (charsetForName == null) {
                            charsetForName = Charset.forName("UTF-32LE");
                            F0.i.d(charsetForName, "forName(...)");
                            M0.a.f361b = charsetForName;
                        }
                    }
                    charset = charsetForName;
                } else {
                    charset = StandardCharsets.UTF_16LE;
                    F0.i.d(charset, "UTF_16LE");
                }
            }
            inputStreamReader = new InputStreamReader(inputStreamS, charset);
            this.f920d = inputStreamReader;
        }
        return inputStreamReader.read(cArr, i2, i3);
    }
}
