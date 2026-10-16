// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s0;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import p018k0.i;

/* JADX INFO: loaded from: classes.dex */
public class b implements Closeable, Flushable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f4088l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f4089m = new String[128];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f4090n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Writer f4091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f4092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f4094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4096f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4097h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4098i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4099j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4100k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f4089m[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f4089m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f4090n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        int[] iArr = new int[32];
        this.f4092b = iArr;
        this.f4093c = 0;
        if (iArr.length == 0) {
            this.f4092b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f4092b;
        int i2 = this.f4093c;
        this.f4093c = i2 + 1;
        iArr2[i2] = 6;
        this.f4097h = 2;
        this.f4100k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f4091a = writer;
        y(i.f3407d);
    }

    public void A(double d2) throws IOException {
        F();
        if (this.f4097h == 1 || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
            a();
            this.f4091a.append((CharSequence) Double.toString(d2));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
    }

    public void B(long j2) throws IOException {
        F();
        a();
        this.f4091a.write(Long.toString(j2));
    }

    public void C(Number number) throws IOException {
        if (number == null) {
            w();
            return;
        }
        F();
        String string = number.toString();
        if (!string.equals("-Infinity") && !string.equals("Infinity") && !string.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (cls != Integer.class && cls != Long.class && cls != Double.class && cls != Float.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class && !f4088l.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        } else if (this.f4097h != 1) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
        }
        a();
        this.f4091a.append((CharSequence) string);
    }

    public void D(String str) throws IOException {
        if (str == null) {
            w();
            return;
        }
        F();
        a();
        z(str);
    }

    public void E(boolean z2) throws IOException {
        F();
        a();
        this.f4091a.write(z2 ? "true" : "false");
    }

    public final void F() throws IOException {
        if (this.f4099j != null) {
            int iX = x();
            if (iX == 5) {
                this.f4091a.write(this.f4096f);
            } else if (iX != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            v();
            this.f4092b[this.f4093c - 1] = 4;
            z(this.f4099j);
            this.f4099j = null;
        }
    }

    public final void a() throws IOException {
        int iX = x();
        if (iX == 1) {
            this.f4092b[this.f4093c - 1] = 2;
            v();
            return;
        }
        Writer writer = this.f4091a;
        if (iX == 2) {
            writer.append((CharSequence) this.f4096f);
            v();
        } else {
            if (iX == 4) {
                writer.append((CharSequence) this.f4095e);
                this.f4092b[this.f4093c - 1] = 5;
                return;
            }
            if (iX != 6) {
                if (iX != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f4097h != 1) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f4092b[this.f4093c - 1] = 7;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4091a.close();
        int i2 = this.f4093c;
        if (i2 > 1 || (i2 == 1 && this.f4092b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f4093c = 0;
    }

    public void f() throws IOException {
        F();
        a();
        int i2 = this.f4093c;
        int[] iArr = this.f4092b;
        if (i2 == iArr.length) {
            this.f4092b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f4092b;
        int i3 = this.f4093c;
        this.f4093c = i3 + 1;
        iArr2[i3] = 1;
        this.f4091a.write(91);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f4093c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f4091a.flush();
    }

    public void j() throws IOException {
        F();
        a();
        int i2 = this.f4093c;
        int[] iArr = this.f4092b;
        if (i2 == iArr.length) {
            this.f4092b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f4092b;
        int i3 = this.f4093c;
        this.f4093c = i3 + 1;
        iArr2[i3] = 3;
        this.f4091a.write(123);
    }

    public final void n(int i2, int i3, char c2) throws IOException {
        int iX = x();
        if (iX != i3 && iX != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f4099j != null) {
            throw new IllegalStateException("Dangling name: " + this.f4099j);
        }
        this.f4093c--;
        if (iX == i3) {
            v();
        }
        this.f4091a.write(c2);
    }

    public void r() throws IOException {
        n(1, 2, ']');
    }

    public void t() throws IOException {
        n(3, 5, '}');
    }

    public void u(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f4099j != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iX = x();
        if (iX != 3 && iX != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f4099j = str;
    }

    public final void v() throws IOException {
        if (this.g) {
            return;
        }
        String str = this.f4094d.f3408a;
        Writer writer = this.f4091a;
        writer.write(str);
        int i2 = this.f4093c;
        for (int i3 = 1; i3 < i2; i3++) {
            writer.write(this.f4094d.f3409b);
        }
    }

    public b w() throws IOException {
        if (this.f4099j != null) {
            if (!this.f4100k) {
                this.f4099j = null;
                return this;
            }
            F();
        }
        a();
        this.f4091a.write("null");
        return this;
    }

    public final int x() {
        int i2 = this.f4093c;
        if (i2 != 0) {
            return this.f4092b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void y(i iVar) {
        Objects.requireNonNull(iVar);
        this.f4094d = iVar;
        this.f4096f = ",";
        if (iVar.f3410c) {
            this.f4095e = ": ";
            if (iVar.f3408a.isEmpty()) {
                this.f4096f = ", ";
            }
        } else {
            this.f4095e = ":";
        }
        this.g = this.f4094d.f3408a.isEmpty() && this.f4094d.f3409b.isEmpty();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    public final void z(String str) throws IOException {
        String str2;
        String[] strArr = this.f4098i ? f4090n : f4089m;
        Writer writer = this.f4091a;
        writer.write(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i2 < i3) {
                        writer.write(str, i2, i3 - i2);
                    }
                    writer.write(str2);
                    i2 = i3 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i3) {
                    writer.write(str, i2, i3 - i2);
                }
                writer.write(str2);
                i2 = i3 + 1;
            }
        }
        if (i2 < length) {
            writer.write(str, i2, length - i2);
        }
        writer.write(34);
    }
}
