// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s0;

import F0.h;
import X0.E;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import p022m0.e;

/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f4074a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int[] f4083k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String[] f4085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f4086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4087o = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f4075b = new char[1024];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4076c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4077d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4078e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4079f = 0;
    public int g = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4084l = 1;

    static {
        e.f3700a = new e();
    }

    public a(E e2) {
        int[] iArr = new int[32];
        this.f4083k = iArr;
        iArr[0] = 6;
        this.f4085m = new String[32];
        this.f4086n = new int[32];
        this.f4074a = e2;
    }

    public final double A() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            this.g = 0;
            int[] iArr = this.f4086n;
            int i2 = this.f4084l - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f4080h;
        }
        if (iN == 16) {
            this.f4082j = new String(this.f4075b, this.f4076c, this.f4081i);
            this.f4076c += this.f4081i;
        } else if (iN == 8 || iN == 9) {
            this.f4082j = G(iN == 8 ? '\'' : '\"');
        } else if (iN == 10) {
            this.f4082j = I();
        } else if (iN != 11) {
            throw R("a double");
        }
        this.g = 11;
        double d2 = Double.parseDouble(this.f4082j);
        if (this.f4087o != 1 && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            Q("JSON forbids NaN and infinities: " + d2);
            throw null;
        }
        this.f4082j = null;
        this.g = 0;
        int[] iArr2 = this.f4086n;
        int i3 = this.f4084l - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }

    public final int B() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            long j2 = this.f4080h;
            int i2 = (int) j2;
            if (j2 != i2) {
                throw new NumberFormatException("Expected an int but was " + this.f4080h + y());
            }
            this.g = 0;
            int[] iArr = this.f4086n;
            int i3 = this.f4084l - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (iN == 16) {
            this.f4082j = new String(this.f4075b, this.f4076c, this.f4081i);
            this.f4076c += this.f4081i;
        } else {
            if (iN != 8 && iN != 9 && iN != 10) {
                throw R("an int");
            }
            if (iN == 10) {
                this.f4082j = I();
            } else {
                this.f4082j = G(iN == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.f4082j);
                this.g = 0;
                int[] iArr2 = this.f4086n;
                int i5 = this.f4084l - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.g = 11;
        double d2 = Double.parseDouble(this.f4082j);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.f4082j + y());
        }
        this.f4082j = null;
        this.g = 0;
        int[] iArr3 = this.f4086n;
        int i7 = this.f4084l - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public final long C() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 15) {
            this.g = 0;
            int[] iArr = this.f4086n;
            int i2 = this.f4084l - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f4080h;
        }
        if (iN == 16) {
            this.f4082j = new String(this.f4075b, this.f4076c, this.f4081i);
            this.f4076c += this.f4081i;
        } else {
            if (iN != 8 && iN != 9 && iN != 10) {
                throw R("a long");
            }
            if (iN == 10) {
                this.f4082j = I();
            } else {
                this.f4082j = G(iN == 8 ? '\'' : '\"');
            }
            try {
                long j2 = Long.parseLong(this.f4082j);
                this.g = 0;
                int[] iArr2 = this.f4086n;
                int i3 = this.f4084l - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.g = 11;
        double d2 = Double.parseDouble(this.f4082j);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.f4082j + y());
        }
        this.f4082j = null;
        this.g = 0;
        int[] iArr3 = this.f4086n;
        int i4 = this.f4084l - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j3;
    }

    public final String D() throws IOException {
        String strG;
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 14) {
            strG = I();
        } else if (iN == 12) {
            strG = G('\'');
        } else {
            if (iN != 13) {
                throw R("a name");
            }
            strG = G('\"');
        }
        this.g = 0;
        this.f4085m[this.f4084l - 1] = strG;
        return strG;
    }

    public final int E(boolean z2) throws IOException {
        int i2 = this.f4076c;
        int i3 = this.f4077d;
        while (true) {
            if (i2 == i3) {
                this.f4076c = i2;
                if (!u(1)) {
                    if (!z2) {
                        return -1;
                    }
                    throw new EOFException("End of input" + y());
                }
                i2 = this.f4076c;
                i3 = this.f4077d;
            }
            int i4 = i2 + 1;
            char[] cArr = this.f4075b;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f4078e++;
                this.f4079f = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f4076c = i4;
                    if (i4 == i3) {
                        this.f4076c = i2;
                        boolean zU = u(2);
                        this.f4076c++;
                        if (!zU) {
                            return c2;
                        }
                    }
                    j();
                    int i5 = this.f4076c;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f4076c = i5 + 1;
                        while (true) {
                            if (this.f4076c + 2 > this.f4077d && !u(2)) {
                                Q("Unterminated comment");
                                throw null;
                            }
                            int i6 = this.f4076c;
                            if (cArr[i6] != '\n') {
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= 2) {
                                        i2 = this.f4076c + 2;
                                        i3 = this.f4077d;
                                        break;
                                    }
                                    if (cArr[this.f4076c + i7] != "*/".charAt(i7)) {
                                        break;
                                    }
                                    i7++;
                                }
                            } else {
                                this.f4078e++;
                                this.f4079f = i6 + 1;
                            }
                            this.f4076c++;
                        }
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f4076c = i5 + 1;
                        N();
                        i2 = this.f4076c;
                        i3 = this.f4077d;
                    }
                } else {
                    if (c2 != '#') {
                        this.f4076c = i4;
                        return c2;
                    }
                    this.f4076c = i4;
                    j();
                    N();
                    i2 = this.f4076c;
                    i3 = this.f4077d;
                }
            }
            i2 = i4;
        }
    }

    public final void F() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 7) {
            throw R("null");
        }
        this.g = 0;
        int[] iArr = this.f4086n;
        int i2 = this.f4084l - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    public final String G(char c2) throws c {
        int i2;
        char[] cArr;
        StringBuilder sb = null;
        do {
            int i3 = this.f4076c;
            int i4 = this.f4077d;
            while (true) {
                int i5 = i4;
                i2 = i3;
                while (true) {
                    cArr = this.f4075b;
                    if (i3 < i5) {
                        int i6 = i3 + 1;
                        char c3 = cArr[i3];
                        if (this.f4087o == 3 && c3 < ' ') {
                            Q("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
                            throw null;
                        }
                        if (c3 == c2) {
                            this.f4076c = i6;
                            int i7 = (i6 - i2) - 1;
                            if (sb == null) {
                                return new String(cArr, i2, i7);
                            }
                            sb.append(cArr, i2, i7);
                            return sb.toString();
                        }
                        if (c3 == '\\') {
                            this.f4076c = i6;
                            int i8 = i6 - i2;
                            int i9 = i8 - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max(i8 * 2, 16));
                            }
                            sb.append(cArr, i2, i9);
                            sb.append(L());
                            i3 = this.f4076c;
                            i4 = this.f4077d;
                        } else {
                            if (c3 == '\n') {
                                this.f4078e++;
                                this.f4079f = i6;
                            }
                            i3 = i6;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i3 - i2) * 2, 16));
            }
            sb.append(cArr, i2, i3 - i2);
            this.f4076c = i3;
        } while (u(1));
        Q("Unterminated string");
        throw null;
    }

    public final String H() throws IOException {
        String str;
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 10) {
            str = I();
        } else if (iN == 8) {
            str = G('\'');
        } else if (iN == 9) {
            str = G('\"');
        } else if (iN == 11) {
            str = this.f4082j;
            this.f4082j = null;
        } else if (iN == 15) {
            str = Long.toString(this.f4080h);
        } else {
            if (iN != 16) {
                throw R("a string");
            }
            str = new String(this.f4075b, this.f4076c, this.f4081i);
            this.f4076c += this.f4081i;
        }
        this.g = 0;
        int[] iArr = this.f4086n;
        int i2 = this.f4084l - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    public final String I() throws c {
        String string;
        StringBuilder sb = null;
        int i2 = 0;
        while (true) {
            int i3 = 0;
            while (true) {
                int i4 = this.f4076c;
                int i5 = i4 + i3;
                int i6 = this.f4077d;
                char[] cArr = this.f4075b;
                if (i5 < i6) {
                    char c2 = cArr[i4 + i3];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i3++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        j();
                    }
                    i2 = i3;
                } else if (i3 >= cArr.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i3, 16));
                    }
                    sb.append(cArr, this.f4076c, i3);
                    this.f4076c += i3;
                    if (!u(1)) {
                    }
                } else if (!u(i3 + 1)) {
                    i2 = i3;
                }
                if (sb == null) {
                    string = new String(cArr, this.f4076c, i2);
                } else {
                    sb.append(cArr, this.f4076c, i2);
                    string = sb.toString();
                }
                this.f4076c += i2;
                return string;
            }
        }
    }

    public final int J() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        switch (iN) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void K(int i2) {
        int i3 = this.f4084l;
        int[] iArr = this.f4083k;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f4083k = Arrays.copyOf(iArr, i4);
            this.f4086n = Arrays.copyOf(this.f4086n, i4);
            this.f4085m = (String[]) Arrays.copyOf(this.f4085m, i4);
        }
        int[] iArr2 = this.f4083k;
        int i5 = this.f4084l;
        this.f4084l = i5 + 1;
        iArr2[i5] = i2;
    }

    public final char L() throws c {
        int i2;
        if (this.f4076c == this.f4077d && !u(1)) {
            Q("Unterminated escape sequence");
            throw null;
        }
        int i3 = this.f4076c;
        int i4 = i3 + 1;
        this.f4076c = i4;
        char[] cArr = this.f4075b;
        char c2 = cArr[i3];
        if (c2 != '\n') {
            if (c2 != '\"') {
                if (c2 != '\'') {
                    if (c2 != '/' && c2 != '\\') {
                        if (c2 == 'b') {
                            return '\b';
                        }
                        if (c2 == 'f') {
                            return '\f';
                        }
                        if (c2 == 'n') {
                            return '\n';
                        }
                        if (c2 == 'r') {
                            return '\r';
                        }
                        if (c2 == 't') {
                            return '\t';
                        }
                        if (c2 != 'u') {
                            Q("Invalid escape sequence");
                            throw null;
                        }
                        if (i3 + 5 > this.f4077d && !u(4)) {
                            Q("Unterminated escape sequence");
                            throw null;
                        }
                        int i5 = this.f4076c;
                        int i6 = i5 + 4;
                        int i7 = 0;
                        while (i5 < i6) {
                            char c3 = cArr[i5];
                            int i8 = i7 << 4;
                            if (c3 >= '0' && c3 <= '9') {
                                i2 = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i2 = c3 - 'W';
                            } else {
                                if (c3 < 'A' || c3 > 'F') {
                                    Q("Malformed Unicode escape \\u".concat(new String(cArr, this.f4076c, 4)));
                                    throw null;
                                }
                                i2 = c3 - '7';
                            }
                            i7 = i2 + i8;
                            i5++;
                        }
                        this.f4076c += 4;
                        return (char) i7;
                    }
                }
            }
            return c2;
        }
        if (this.f4087o == 3) {
            Q("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.f4078e++;
        this.f4079f = i4;
        if (this.f4087o == 3) {
            Q("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c2;
    }

    public final void M(char c2) throws c {
        do {
            int i2 = this.f4076c;
            int i3 = this.f4077d;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = this.f4075b[i2];
                if (c3 == c2) {
                    this.f4076c = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f4076c = i4;
                    L();
                    i2 = this.f4076c;
                    i3 = this.f4077d;
                } else {
                    if (c3 == '\n') {
                        this.f4078e++;
                        this.f4079f = i4;
                    }
                    i2 = i4;
                }
            }
            this.f4076c = i2;
        } while (u(1));
        Q("Unterminated string");
        throw null;
    }

    public final void N() {
        char c2;
        do {
            if (this.f4076c >= this.f4077d && !u(1)) {
                return;
            }
            int i2 = this.f4076c;
            int i3 = i2 + 1;
            this.f4076c = i3;
            c2 = this.f4075b[i2];
            if (c2 == '\n') {
                this.f4078e++;
                this.f4079f = i3;
                return;
            }
        } while (c2 != '\r');
    }

    public final void O() throws c {
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f4076c;
                if (i3 + i2 < this.f4077d) {
                    char c2 = this.f4075b[i3 + i2];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        j();
                    }
                    this.f4076c += i2;
                    return;
                }
                this.f4076c = i3 + i2;
            }
        } while (u(1));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void P() throws IOException {
        int i2 = 0;
        do {
            int iN = this.g;
            if (iN == 0) {
                iN = n();
            }
            switch (iN) {
                case 1:
                    K(3);
                    i2++;
                    this.g = 0;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.f4085m[this.f4084l - 1] = null;
                    }
                    this.f4084l--;
                    i2--;
                    this.g = 0;
                    break;
                case 3:
                    K(1);
                    i2++;
                    this.g = 0;
                    break;
                case 4:
                    this.f4084l--;
                    i2--;
                    this.g = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.g = 0;
                    break;
                case 8:
                    M('\'');
                    this.g = 0;
                    break;
                case 9:
                    M('\"');
                    this.g = 0;
                    break;
                case 10:
                    O();
                    this.g = 0;
                    break;
                case 12:
                    M('\'');
                    if (i2 == 0) {
                        this.f4085m[this.f4084l - 1] = "<skipped>";
                    }
                    this.g = 0;
                    break;
                case 13:
                    M('\"');
                    if (i2 == 0) {
                        this.f4085m[this.f4084l - 1] = "<skipped>";
                    }
                    this.g = 0;
                    break;
                case 14:
                    O();
                    if (i2 == 0) {
                        this.f4085m[this.f4084l - 1] = "<skipped>";
                    }
                    this.g = 0;
                    break;
                case 16:
                    this.f4076c += this.f4081i;
                    this.g = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i2 > 0);
        int[] iArr = this.f4086n;
        int i3 = this.f4084l - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public final void Q(String str) throws c {
        throw new c(str + y() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
    }

    public final IllegalStateException R(String str) {
        return new IllegalStateException("Expected " + str + " but was " + h.i(J()) + y() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(J() == 9 ? "adapter-not-null-safe" : "unexpected-json-structure"));
    }

    public final void a() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 3) {
            throw R("BEGIN_ARRAY");
        }
        K(1);
        this.f4086n[this.f4084l - 1] = 0;
        this.g = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.g = 0;
        this.f4083k[0] = 8;
        this.f4084l = 1;
        this.f4074a.close();
    }

    public final void f() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 1) {
            throw R("BEGIN_OBJECT");
        }
        K(3);
        this.g = 0;
    }

    public final void j() throws c {
        if (this.f4087o == 1) {
            return;
        }
        Q("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x0184 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:120:0x0185  */
    /* JADX WARN: Code duplicated, block: B:123:0x0194  */
    /* JADX WARN: Code duplicated, block: B:126:0x019a  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ab A[PHI: r2 r4
  0x01ab: PHI (r2v51 int) = (r2v50 int), (r2v53 int) binds: [B:122:0x0192, B:129:0x01a5] A[DONT_GENERATE, DONT_INLINE]
  0x01ab: PHI (r4v10 int) = (r4v9 int), (r4v12 int) binds: [B:122:0x0192, B:129:0x01a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:132:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:174:0x021e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0220  */
    /* JADX WARN: Code duplicated, block: B:187:0x0241 A[DONT_INVERT, PHI: r1
  0x0241: PHI (r1v68 int) = (r1v67 int), (r1v71 int) binds: [B:173:0x021c, B:179:0x0229] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:188:0x0243  */
    /* JADX WARN: Code duplicated, block: B:202:0x0264  */
    /* JADX WARN: Code duplicated, block: B:204:0x026a  */
    /* JADX WARN: Code duplicated, block: B:207:0x026f  */
    /* JADX WARN: Code duplicated, block: B:212:0x027f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:213:0x0280  */
    /* JADX WARN: Code duplicated, block: B:215:0x028a  */
    /* JADX WARN: Code duplicated, block: B:217:0x0292  */
    /* JADX WARN: Code duplicated, block: B:227:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:236:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:238:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:281:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:283:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e8  */
    public final int n() throws IOException {
        int i2;
        int iE;
        int i3;
        int iE2;
        int i4;
        String str;
        String str2;
        int i5;
        char c2;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        char c3;
        int i10;
        int i11;
        int i12;
        int[] iArr = this.f4083k;
        int i13 = 1;
        int i14 = this.f4084l - 1;
        int i15 = iArr[i14];
        char[] cArr = this.f4075b;
        if (i15 == 1) {
            iArr[i14] = 2;
        } else {
            if (i15 != 2) {
                if (i15 == 3) {
                    i2 = 4;
                } else if (i15 == 5) {
                    i2 = 4;
                } else {
                    if (i15 != 4) {
                        if (i15 == 6) {
                            if (this.f4087o == 1) {
                                E(true);
                                int i16 = this.f4076c;
                                this.f4076c = i16 - 1;
                                if (i16 + 4 <= this.f4077d || u(5)) {
                                    int i17 = this.f4076c;
                                    if (cArr[i17] == ')' && cArr[i17 + 1] == ']' && cArr[i17 + 2] == '}' && cArr[i17 + 3] == '\'' && cArr[i17 + 4] == '\n') {
                                        this.f4076c = i17 + 5;
                                    }
                                }
                            }
                            this.f4083k[this.f4084l - 1] = 7;
                        } else if (i15 == 7) {
                            i3 = 0;
                            if (E(false) == -1) {
                                this.g = 17;
                                return 17;
                            }
                            j();
                            this.f4076c--;
                        } else {
                            i3 = 0;
                            if (i15 == 8) {
                                throw new IllegalStateException("JsonReader is closed");
                            }
                        }
                        iE2 = E(true);
                        if (iE2 != 34) {
                            this.g = 9;
                            return 9;
                        }
                        if (iE2 != 39) {
                            j();
                            this.g = 8;
                            return 8;
                        }
                        if (iE2 != 44 || iE2 == 59) {
                            i4 = 1;
                        } else {
                            if (iE2 == 91) {
                                this.g = 3;
                                return 3;
                            }
                            if (iE2 != 93) {
                                if (iE2 == 123) {
                                    this.g = 1;
                                    return 1;
                                }
                                int i18 = this.f4076c - 1;
                                this.f4076c = i18;
                                char c4 = cArr[i18];
                                if (c4 == 't' || c4 == 'T') {
                                    str = "true";
                                    str2 = "TRUE";
                                    i5 = 5;
                                } else {
                                    if (c4 != 'f' && c4 != 'F') {
                                        if (c4 != 'n' && c4 != 'N') {
                                            i5 = i3;
                                            break;
                                        }
                                        str = "null";
                                        str2 = "NULL";
                                        i5 = 7;
                                        if (i5 != 0) {
                                            return i5;
                                        }
                                        i6 = this.f4076c;
                                        i7 = this.f4077d;
                                        i8 = i3;
                                        i9 = i8;
                                        int i19 = i9;
                                        z2 = true;
                                        long j2 = 0;
                                        while (true) {
                                            if (i6 + i9 != i7) {
                                                c3 = cArr[i6 + i9];
                                                if (c3 != '+') {
                                                    if (c3 != 'E' || c3 == 'e') {
                                                        i10 = i7;
                                                        if (i8 != 2 || i8 == 4) {
                                                            i8 = 5;
                                                            i9++;
                                                            i7 = i10;
                                                            i13 = 1;
                                                        }
                                                    } else if (c3 == '-') {
                                                        i10 = i7;
                                                        if (i8 == 0) {
                                                            i8 = 1;
                                                            i19 = 1;
                                                        } else {
                                                            if (i8 != 5) {
                                                            }
                                                            i8 = 6;
                                                        }
                                                        i9++;
                                                        i7 = i10;
                                                        i13 = 1;
                                                    } else if (c3 == '.') {
                                                        i10 = i7;
                                                        if (i8 == 2) {
                                                            i8 = 3;
                                                            i9++;
                                                            i7 = i10;
                                                            i13 = 1;
                                                        }
                                                    } else if (c3 >= '0' && c3 <= '9') {
                                                        if (i8 == i13 || i8 == 0) {
                                                            i10 = i7;
                                                            j2 = -(c3 - '0');
                                                            i8 = 2;
                                                        } else if (i8 != 2) {
                                                            i10 = i7;
                                                            if (i8 == 3) {
                                                                i8 = 4;
                                                            } else if (i8 == 5 || i8 == 6) {
                                                                i8 = 7;
                                                            }
                                                        } else if (j2 != 0) {
                                                            i10 = i7;
                                                            long j3 = (10 * j2) - ((long) (c3 - '0'));
                                                            z2 &= j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                                                            j2 = j3;
                                                        }
                                                        i9++;
                                                        i7 = i10;
                                                        i13 = 1;
                                                    } else if (!x(c3)) {
                                                        i12 = 2;
                                                        if (i8 != 2) {
                                                            if (i8 != i12 || i8 == 4 || i8 == 7) {
                                                                this.f4081i = i9;
                                                                i11 = 16;
                                                                this.g = 16;
                                                            }
                                                        } else if (z2 || ((j2 == Long.MIN_VALUE && i19 == 0) || (j2 == 0 && i19 != 0))) {
                                                            i12 = 2;
                                                            if (i8 != i12) {
                                                            }
                                                            this.f4081i = i9;
                                                            i11 = 16;
                                                            this.g = 16;
                                                        } else {
                                                            if (i19 == 0) {
                                                                j2 = -j2;
                                                            }
                                                            this.f4080h = j2;
                                                            this.f4076c += i9;
                                                            i11 = 15;
                                                            this.g = 15;
                                                        }
                                                    }
                                                    if (i11 != 0) {
                                                        return i11;
                                                    }
                                                    if (x(cArr[this.f4076c])) {
                                                        Q("Expected value");
                                                        throw null;
                                                    }
                                                    j();
                                                    this.g = 10;
                                                    return 10;
                                                }
                                                i10 = i7;
                                                if (i8 != 5) {
                                                }
                                                i8 = 6;
                                                i9++;
                                                i7 = i10;
                                                i13 = 1;
                                            } else if (i9 != cArr.length) {
                                                if (!u(i9 + 1)) {
                                                    int i20 = this.f4076c;
                                                    i7 = this.f4077d;
                                                    i6 = i20;
                                                    c3 = cArr[i6 + i9];
                                                    if (c3 != '+') {
                                                        if (c3 != 'E') {
                                                            i10 = i7;
                                                            if (i8 != 2) {
                                                            }
                                                            i8 = 5;
                                                            i9++;
                                                            i7 = i10;
                                                            i13 = 1;
                                                        } else {
                                                            i10 = i7;
                                                            if (i8 != 2) {
                                                            }
                                                            i8 = 5;
                                                            i9++;
                                                            i7 = i10;
                                                            i13 = 1;
                                                        }
                                                        if (i11 != 0) {
                                                            return i11;
                                                        }
                                                        if (x(cArr[this.f4076c])) {
                                                            Q("Expected value");
                                                            throw null;
                                                        }
                                                        j();
                                                        this.g = 10;
                                                        return 10;
                                                    }
                                                    i10 = i7;
                                                    if (i8 != 5) {
                                                    }
                                                    i8 = 6;
                                                    i9++;
                                                    i7 = i10;
                                                    i13 = 1;
                                                }
                                                i12 = 2;
                                                if (i8 != 2) {
                                                    if (i8 != i12) {
                                                    }
                                                    this.f4081i = i9;
                                                    i11 = 16;
                                                    this.g = 16;
                                                } else {
                                                    if (z2) {
                                                    }
                                                    i12 = 2;
                                                    if (i8 != i12) {
                                                    }
                                                    this.f4081i = i9;
                                                    i11 = 16;
                                                    this.g = 16;
                                                }
                                                if (i11 != 0) {
                                                    return i11;
                                                }
                                                if (x(cArr[this.f4076c])) {
                                                    Q("Expected value");
                                                    throw null;
                                                }
                                                j();
                                                this.g = 10;
                                                return 10;
                                            }
                                            i11 = 0;
                                            if (i11 != 0) {
                                                return i11;
                                            }
                                            if (x(cArr[this.f4076c])) {
                                                Q("Expected value");
                                                throw null;
                                            }
                                            j();
                                            this.g = 10;
                                            return 10;
                                        }
                                    }
                                    str = "false";
                                    str2 = "FALSE";
                                    i5 = 6;
                                }
                                int i21 = this.f4087o != 3 ? 1 : i3;
                                int length = str.length();
                                int i22 = i3;
                                while (true) {
                                    if (i22 >= length) {
                                        if ((this.f4076c + length >= this.f4077d && !u(length + 1)) || !x(cArr[this.f4076c + length])) {
                                            this.f4076c += length;
                                            this.g = i5;
                                            break;
                                        }
                                        break;
                                    }
                                    if ((this.f4076c + i22 < this.f4077d || u(i22 + 1)) && ((c2 = cArr[this.f4076c + i22]) == str.charAt(i22) || (i21 != 0 && c2 == str2.charAt(i22)))) {
                                        i22++;
                                    }
                                    i5 = i3;
                                    break;
                                }
                                if (i5 != 0) {
                                    return i5;
                                }
                                i6 = this.f4076c;
                                i7 = this.f4077d;
                                i8 = i3;
                                i9 = i8;
                                int i110 = i9;
                                z2 = true;
                                long j4 = 0;
                                while (true) {
                                    if (i6 + i9 != i7) {
                                        c3 = cArr[i6 + i9];
                                        if (c3 != '+') {
                                            if (c3 != 'E') {
                                                i10 = i7;
                                                if (i8 != 2) {
                                                }
                                                i8 = 5;
                                                i9++;
                                                i7 = i10;
                                                i13 = 1;
                                            } else {
                                                i10 = i7;
                                                if (i8 != 2) {
                                                }
                                                i8 = 5;
                                                i9++;
                                                i7 = i10;
                                                i13 = 1;
                                            }
                                            if (i11 != 0) {
                                                return i11;
                                            }
                                            if (x(cArr[this.f4076c])) {
                                                Q("Expected value");
                                                throw null;
                                            }
                                            j();
                                            this.g = 10;
                                            return 10;
                                        }
                                        i10 = i7;
                                        if (i8 != 5) {
                                        }
                                        i8 = 6;
                                        i9++;
                                        i7 = i10;
                                        i13 = 1;
                                    } else if (i9 != cArr.length) {
                                        if (!u(i9 + 1)) {
                                            int i23 = this.f4076c;
                                            i7 = this.f4077d;
                                            i6 = i23;
                                            c3 = cArr[i6 + i9];
                                            if (c3 != '+') {
                                                if (c3 != 'E') {
                                                    i10 = i7;
                                                    if (i8 != 2) {
                                                    }
                                                    i8 = 5;
                                                    i9++;
                                                    i7 = i10;
                                                    i13 = 1;
                                                } else {
                                                    i10 = i7;
                                                    if (i8 != 2) {
                                                    }
                                                    i8 = 5;
                                                    i9++;
                                                    i7 = i10;
                                                    i13 = 1;
                                                }
                                                if (i11 != 0) {
                                                    return i11;
                                                }
                                                if (x(cArr[this.f4076c])) {
                                                    Q("Expected value");
                                                    throw null;
                                                }
                                                j();
                                                this.g = 10;
                                                return 10;
                                            }
                                            i10 = i7;
                                            if (i8 != 5) {
                                            }
                                            i8 = 6;
                                            i9++;
                                            i7 = i10;
                                            i13 = 1;
                                        }
                                        i12 = 2;
                                        if (i8 != 2) {
                                            if (i8 != i12) {
                                            }
                                            this.f4081i = i9;
                                            i11 = 16;
                                            this.g = 16;
                                        } else {
                                            if (z2) {
                                            }
                                            i12 = 2;
                                            if (i8 != i12) {
                                            }
                                            this.f4081i = i9;
                                            i11 = 16;
                                            this.g = 16;
                                        }
                                        if (i11 != 0) {
                                            return i11;
                                        }
                                        if (x(cArr[this.f4076c])) {
                                            Q("Expected value");
                                            throw null;
                                        }
                                        j();
                                        this.g = 10;
                                        return 10;
                                    }
                                    i11 = 0;
                                    if (i11 != 0) {
                                        return i11;
                                    }
                                    if (x(cArr[this.f4076c])) {
                                        Q("Expected value");
                                        throw null;
                                    }
                                    j();
                                    this.g = 10;
                                    return 10;
                                }
                            }
                            i4 = 1;
                            if (i15 == 1) {
                                this.g = 4;
                                return 4;
                            }
                        }
                        if (i15 == i4 && i15 != 2) {
                            Q("Unexpected value");
                            throw null;
                        }
                        j();
                        this.f4076c -= i4;
                        this.g = 7;
                        return 7;
                    }
                    iArr[i14] = 5;
                    int iE3 = E(true);
                    if (iE3 != 58) {
                        if (iE3 != 61) {
                            Q("Expected ':'");
                            throw null;
                        }
                        j();
                        if (this.f4076c < this.f4077d || u(1)) {
                            int i24 = this.f4076c;
                            if (cArr[i24] == '>') {
                                this.f4076c = i24 + 1;
                            }
                        }
                    }
                }
                iArr[i14] = i2;
                if (i15 == 5 && (iE = E(true)) != 44) {
                    if (iE != 59) {
                        if (iE == 125) {
                            this.g = 2;
                            return 2;
                        }
                        Q("Unterminated object");
                        throw null;
                    }
                    j();
                }
                int iE4 = E(true);
                if (iE4 == 34) {
                    this.g = 13;
                    return 13;
                }
                if (iE4 == 39) {
                    j();
                    this.g = 12;
                    return 12;
                }
                if (iE4 == 125) {
                    if (i15 != 5) {
                        this.g = 2;
                        return 2;
                    }
                    Q("Expected name");
                    throw null;
                }
                j();
                this.f4076c--;
                if (x((char) iE4)) {
                    this.g = 14;
                    return 14;
                }
                Q("Expected name");
                throw null;
            }
            int iE5 = E(true);
            if (iE5 != 44) {
                if (iE5 != 59) {
                    if (iE5 == 93) {
                        this.g = 4;
                        return 4;
                    }
                    Q("Unterminated array");
                    throw null;
                }
                j();
            }
        }
        i3 = 0;
        iE2 = E(true);
        if (iE2 != 34) {
            this.g = 9;
            return 9;
        }
        if (iE2 != 39) {
            j();
            this.g = 8;
            return 8;
        }
        if (iE2 != 44) {
            i4 = 1;
        } else {
            i4 = 1;
        }
        if (i15 == i4) {
        }
        j();
        this.f4076c -= i4;
        this.g = 7;
        return 7;
    }

    public final void r() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 4) {
            throw R("END_ARRAY");
        }
        int i2 = this.f4084l;
        this.f4084l = i2 - 1;
        int[] iArr = this.f4086n;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.g = 0;
    }

    public final void t() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN != 2) {
            throw R("END_OBJECT");
        }
        int i2 = this.f4084l;
        int i3 = i2 - 1;
        this.f4084l = i3;
        this.f4085m[i3] = null;
        int[] iArr = this.f4086n;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.g = 0;
    }

    public final String toString() {
        return a.class.getSimpleName() + y();
    }

    public final boolean u(int i2) throws IOException {
        int i3;
        int i4;
        int i5 = this.f4079f;
        int i6 = this.f4076c;
        this.f4079f = i5 - i6;
        int i7 = this.f4077d;
        char[] cArr = this.f4075b;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f4077d = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f4077d = 0;
        }
        this.f4076c = 0;
        do {
            int i9 = this.f4077d;
            int i10 = this.f4074a.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.f4077d + i10;
            this.f4077d = i3;
            if (this.f4078e == 0 && (i4 = this.f4079f) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f4076c++;
                this.f4079f = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public final String v(boolean z2) {
        StringBuilder sb = new StringBuilder("$");
        int i2 = 0;
        while (true) {
            int i3 = this.f4084l;
            if (i2 >= i3) {
                return sb.toString();
            }
            int i4 = this.f4083k[i2];
            switch (i4) {
                case 1:
                case 2:
                    int i5 = this.f4086n[i2];
                    if (z2 && i5 > 0 && i2 == i3 - 1) {
                        i5--;
                    }
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.f4085m[i2];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(h.b(i4, "Unknown scope value: "));
            }
            i2++;
        }
    }

    public final boolean w() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        return (iN == 2 || iN == 4 || iN == 17) ? false : true;
    }

    public final boolean x(char c2) throws c {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        j();
        return false;
    }

    public final String y() {
        return " at line " + (this.f4078e + 1) + " column " + ((this.f4076c - this.f4079f) + 1) + " path " + v(false);
    }

    public final boolean z() throws IOException {
        int iN = this.g;
        if (iN == 0) {
            iN = n();
        }
        if (iN == 5) {
            this.g = 0;
            int[] iArr = this.f4086n;
            int i2 = this.f4084l - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iN != 6) {
            throw R("a boolean");
        }
        this.g = 0;
        int[] iArr2 = this.f4086n;
        int i3 = this.f4084l - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }
}
