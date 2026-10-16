// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import A.i0;
import E0.p;
import F0.q;
import H.C0028c;
import N0.AbstractC0049v;
import N0.C0039k;
import N0.L;
import N0.M;
import R0.s;
import X0.C0056c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Process;
import android.os.Trace;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EdgeEffect;
import android.widget.TextView;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.Y;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.ProtocolException;
import java.net.Socket;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k1.B;
import k1.C;
import k1.C0187c;
import k1.C0188d;
import k1.C0193i;
import k1.G;
import k1.H;
import k1.I;
import k1.K;
import k1.o;
import k1.x;
import k1.z;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import p015j.Q0;

/* JADX INFO: loaded from: classes.dex */
public abstract class l implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f2732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f2733b;

    public static Drawable A(Context context, int i2) {
        return Q0.b().c(context, i2);
    }

    public static final Class C(K0.b bVar) {
        F0.i.e(bVar, "<this>");
        Class clsA = ((F0.d) bVar).a();
        if (!clsA.isPrimitive()) {
            return clsA;
        }
        String name = clsA.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return !name.equals("double") ? clsA : Double.class;
            case 104431:
                return !name.equals("int") ? clsA : Integer.class;
            case 3039496:
                return !name.equals("byte") ? clsA : Byte.class;
            case 3052374:
                return !name.equals("char") ? clsA : Character.class;
            case 3327612:
                return !name.equals("long") ? clsA : Long.class;
            case 3625364:
                return !name.equals("void") ? clsA : Void.class;
            case 64711720:
                return !name.equals("boolean") ? clsA : Boolean.class;
            case 97526364:
                return !name.equals("float") ? clsA : Float.class;
            case 109413500:
                return !name.equals("short") ? clsA : Short.class;
            default:
                return clsA;
        }
    }

    public static final boolean D(AssertionError assertionError) {
        Logger logger = x.f3514a;
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? M0.e.T(message, "getsockname failed") : false;
    }

    public static boolean E() {
        try {
            if (f2733b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f2733b == null) {
                f2732a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f2733b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f2733b.invoke(null, Long.valueOf(f2732a))).booleanValue();
        } catch (Exception e2) {
            if (!(e2 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e2);
                return false;
            }
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static final boolean F(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    public static X0.n G(String... strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        int length = strArr2.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr2[i3];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i3] = M0.e.j0(str).toString();
        }
        int iK = p029q.j.k(0, strArr2.length - 1, 2);
        if (iK >= 0) {
            while (true) {
                String str2 = strArr2[i2];
                String str3 = strArr2[i2 + 1];
                j(str2);
                l(str3, str2);
                if (i2 == iK) {
                    break;
                }
                i2 += 2;
            }
        }
        return new X0.n(strArr2);
    }

    public static void H(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static float K(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 31) {
            return D.f.c(edgeEffect, f2, f3);
        }
        D.e.a(edgeEffect, f2, f3);
        return f2;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x011f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x0164 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x0186 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x01b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x01c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x01da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0157 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x01a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x0146 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x018f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x017e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x016d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x006a A[EDGE_INSN: B:133:0x006a->B:22:0x006a BREAK  A[LOOP:2: B:16:0x004c->B:20:0x005d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0047  */
    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    /* JADX WARN: Code duplicated, block: B:20:0x005d A[LOOP:2: B:16:0x004c->B:20:0x005d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0091  */
    /* JADX WARN: Code duplicated, block: B:64:0x014e  */
    /* JADX WARN: Code duplicated, block: B:67:0x015c  */
    /* JADX WARN: Code duplicated, block: B:79:0x019f  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ad  */
    public static C0056c L(X0.n nVar) {
        int i2;
        int i3;
        int length;
        int length2;
        String string;
        String string2;
        int i4;
        X0.n nVar2 = nVar;
        F0.i.e(nVar2, "headers");
        int size = nVar.size();
        int i5 = 0;
        boolean z2 = true;
        String str = null;
        boolean z3 = false;
        boolean z4 = false;
        int iX = -1;
        int iX2 = -1;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int iX3 = -1;
        int iX4 = -1;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (i5 < size) {
            String strB = nVar2.b(i5);
            String strD = nVar2.d(i5);
            if (M0.m.M(strB, "Cache-Control")) {
                if (str == null) {
                    str = strD;
                }
                i3 = 0;
                while (i3 < strD.length()) {
                    length = strD.length();
                    length2 = i3;
                    while (true) {
                        if (length2 < length) {
                            size = size;
                            length2 = strD.length();
                            break;
                        }
                        size = size;
                        if (M0.e.S("=,;", strD.charAt(length2))) {
                            break;
                        }
                        length2++;
                        size = size;
                    }
                    String strSubstring = strD.substring(i3, length2);
                    F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    string = M0.e.j0(strSubstring).toString();
                    if (length2 != strD.length() || strD.charAt(length2) == ',' || strD.charAt(length2) == ';') {
                        z2 = z2;
                        i3 = length2 + 1;
                        string2 = null;
                    } else {
                        int length3 = length2 + 1;
                        byte[] bArr = Y0.b.f1119a;
                        int length4 = strD.length();
                        while (true) {
                            if (length3 >= length4) {
                                i4 = 1;
                                length3 = strD.length();
                                break;
                            }
                            char cCharAt = strD.charAt(length3);
                            int i6 = length4;
                            if (cCharAt != ' ' && cCharAt != '\t') {
                                i4 = 1;
                                break;
                            }
                            length3++;
                            length4 = i6;
                        }
                        if (length3 < strD.length()) {
                            z2 = z2;
                            if (strD.charAt(length3) == '\"') {
                                int i7 = length3 + i4;
                                int iX5 = M0.e.X(strD, '\"', i7, false, 4);
                                string2 = strD.substring(i7, iX5);
                                F0.i.d(string2, "this as java.lang.String…ing(startIndex, endIndex)");
                                i3 = iX5 + 1;
                            }
                        } else {
                            z2 = z2;
                        }
                        int length5 = strD.length();
                        int length6 = length3;
                        while (true) {
                            if (length6 >= length5) {
                                length6 = strD.length();
                                break;
                            }
                            int i8 = length5;
                            if (M0.e.S(",;", strD.charAt(length6))) {
                                break;
                            }
                            length6++;
                            length5 = i8;
                        }
                        String strSubstring2 = strD.substring(length3, length6);
                        F0.i.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        string2 = M0.e.j0(strSubstring2).toString();
                        i3 = length6;
                    }
                    if ("no-cache".equalsIgnoreCase(string)) {
                        z3 = true;
                    } else if ("no-store".equalsIgnoreCase(string)) {
                        z4 = true;
                    } else if ("max-age".equalsIgnoreCase(string)) {
                        iX = Y0.b.x(-1, string2);
                    } else if ("s-maxage".equalsIgnoreCase(string)) {
                        iX2 = Y0.b.x(-1, string2);
                    } else if ("private".equalsIgnoreCase(string)) {
                        z5 = true;
                    } else if ("public".equalsIgnoreCase(string)) {
                        z6 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(string)) {
                        z7 = true;
                    } else if ("max-stale".equalsIgnoreCase(string)) {
                        iX3 = Y0.b.x(Integer.MAX_VALUE, string2);
                    } else if ("min-fresh".equalsIgnoreCase(string)) {
                        iX4 = Y0.b.x(-1, string2);
                    } else if ("only-if-cached".equalsIgnoreCase(string)) {
                        z8 = true;
                    } else if ("no-transform".equalsIgnoreCase(string)) {
                        z9 = true;
                    } else if ("immutable".equalsIgnoreCase(string)) {
                        z10 = true;
                    }
                }
                i2 = size;
                i5++;
                nVar2 = nVar;
                size = i2;
            } else {
                if (!M0.m.M(strB, "Pragma")) {
                    i2 = size;
                }
                i5++;
                nVar2 = nVar;
                size = i2;
            }
            z2 = false;
            i3 = 0;
            while (i3 < strD.length()) {
                length = strD.length();
                length2 = i3;
                while (true) {
                    if (length2 < length) {
                        size = size;
                        length2 = strD.length();
                        break;
                    }
                    size = size;
                    if (M0.e.S("=,;", strD.charAt(length2))) {
                        break;
                        break;
                    }
                    length2++;
                    size = size;
                }
                String strSubstring3 = strD.substring(i3, length2);
                F0.i.d(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                string = M0.e.j0(strSubstring3).toString();
                if (length2 != strD.length()) {
                    z2 = z2;
                    i3 = length2 + 1;
                    string2 = null;
                } else {
                    z2 = z2;
                    i3 = length2 + 1;
                    string2 = null;
                }
                if ("no-cache".equalsIgnoreCase(string)) {
                    z3 = true;
                } else if ("no-store".equalsIgnoreCase(string)) {
                    z4 = true;
                } else if ("max-age".equalsIgnoreCase(string)) {
                    iX = Y0.b.x(-1, string2);
                } else if ("s-maxage".equalsIgnoreCase(string)) {
                    iX2 = Y0.b.x(-1, string2);
                } else if ("private".equalsIgnoreCase(string)) {
                    z5 = true;
                } else if ("public".equalsIgnoreCase(string)) {
                    z6 = true;
                } else if ("must-revalidate".equalsIgnoreCase(string)) {
                    z7 = true;
                } else if ("max-stale".equalsIgnoreCase(string)) {
                    iX3 = Y0.b.x(Integer.MAX_VALUE, string2);
                } else if ("min-fresh".equalsIgnoreCase(string)) {
                    iX4 = Y0.b.x(-1, string2);
                } else if ("only-if-cached".equalsIgnoreCase(string)) {
                    z8 = true;
                } else if ("no-transform".equalsIgnoreCase(string)) {
                    z9 = true;
                } else if ("immutable".equalsIgnoreCase(string)) {
                    z10 = true;
                }
            }
            i2 = size;
            i5++;
            nVar2 = nVar;
            size = i2;
        }
        return new C0056c(z3, z4, iX, iX2, z5, z6, z7, iX3, iX4, z8, z9, z10, !z2 ? null : str);
    }

    public static c1.g M(String str) throws ProtocolException {
        int i2;
        String strSubstring;
        F0.i.e(str, "statusLine");
        boolean zR = M0.m.R(str, "HTTP/1.", false);
        X0.x xVar = X0.x.f1090b;
        if (zR) {
            i2 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                xVar = X0.x.f1091c;
            }
        } else {
            if (!M0.m.R(str, "ICY ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i2 = 4;
        }
        int i3 = i2 + 3;
        if (str.length() < i3) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            String strSubstring2 = str.substring(i2, i3);
            F0.i.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            int i4 = Integer.parseInt(strSubstring2);
            if (str.length() <= i3) {
                strSubstring = "";
            } else {
                if (str.charAt(i3) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i2 + 4);
                F0.i.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            }
            return new c1.g(xVar, i4, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00a6  */
    public static long N(int i2, String str) {
        int iS = s(str, 0, i2, false);
        Matcher matcher = X0.k.f996m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int iY = -1;
        int i6 = -1;
        int i7 = -1;
        while (iS < i2) {
            int iS2 = s(str, iS + 1, i2, true);
            matcher.region(iS, iS2);
            if (i4 == -1 && matcher.usePattern(X0.k.f996m).matches()) {
                String strGroup = matcher.group(1);
                F0.i.d(strGroup, "matcher.group(1)");
                i4 = Integer.parseInt(strGroup);
                String strGroup2 = matcher.group(2);
                F0.i.d(strGroup2, "matcher.group(2)");
                i6 = Integer.parseInt(strGroup2);
                String strGroup3 = matcher.group(3);
                F0.i.d(strGroup3, "matcher.group(3)");
                i7 = Integer.parseInt(strGroup3);
            } else if (i5 == -1 && matcher.usePattern(X0.k.f995l).matches()) {
                String strGroup4 = matcher.group(1);
                F0.i.d(strGroup4, "matcher.group(1)");
                i5 = Integer.parseInt(strGroup4);
            } else if (iY == -1) {
                Pattern pattern = X0.k.f994k;
                if (matcher.usePattern(pattern).matches()) {
                    String strGroup5 = matcher.group(1);
                    F0.i.d(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    F0.i.d(locale, "US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    F0.i.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = pattern.pattern();
                    F0.i.d(strPattern, "MONTH_PATTERN.pattern()");
                    iY = M0.e.Y(strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i3 != -1 && matcher.usePattern(X0.k.f993j).matches()) {
                    String strGroup6 = matcher.group(1);
                    F0.i.d(strGroup6, "matcher.group(1)");
                    i3 = Integer.parseInt(strGroup6);
                }
            } else if (i3 != -1) {
            }
            iS = s(str, iS2 + 1, i2, false);
        }
        if (70 <= i3 && i3 < 100) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 < 70) {
            i3 += 2000;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (iY == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (1 > i5 || i5 >= 32) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i4 < 0 || i4 >= 24) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i6 < 0 || i6 >= 60) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i7 < 0 || i7 >= 60) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Y0.b.f1123e);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, iY - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i6);
        gregorianCalendar.set(13, i7);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void O(Context context, String str) {
        if (str.equals("")) {
            context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return;
        }
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file", 0);
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            try {
                try {
                    xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                    xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                    xmlSerializerNewSerializer.startTag(null, "locales");
                    xmlSerializerNewSerializer.attribute(null, "application_locales", str);
                    xmlSerializerNewSerializer.endTag(null, "locales");
                    xmlSerializerNewSerializer.endDocument();
                    Log.d("AppLocalesStorageHelper", "Storing App Locales : app-locales: " + str + " persisted successfully.");
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                Log.w("AppLocalesStorageHelper", "Storing App Locales : Failed to persist app-locales: ".concat(str), e2);
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.close();
                }
            }
        } catch (FileNotFoundException unused3) {
            Log.w("AppLocalesStorageHelper", "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing ");
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0045 A[EXC_TOP_SPLITTER, PHI: r2
  0x0045: PHI (r2v2 java.lang.String) = (r2v0 java.lang.String), (r2v4 java.lang.String) binds: [B:25:0x004e, B:21:0x0043] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static String R(Context context) {
        String attributeValue = "";
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            try {
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                    int depth = xmlPullParserNewPullParser.getDepth();
                    while (true) {
                        int next = xmlPullParserNewPullParser.next();
                        if (next != 1 && (next != 3 || xmlPullParserNewPullParser.getDepth() > depth)) {
                            if (next != 3 && next != 4 && xmlPullParserNewPullParser.getName().equals("locales")) {
                                attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "application_locales");
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (IOException | XmlPullParserException unused2) {
                    Log.w("AppLocalesStorageHelper", "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                }
                if (attributeValue.isEmpty()) {
                    context.deleteFile("androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                } else {
                    Log.d("AppLocalesStorageHelper", "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: ".concat(attributeValue));
                }
                return attributeValue;
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused4) {
            Log.w("AppLocalesStorageHelper", "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
            return "";
        }
    }

    public static int S(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d2 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d2 < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d2);
    }

    public static final C0187c V(Socket socket) throws IOException {
        Logger logger = x.f3514a;
        H h2 = new H(socket);
        OutputStream outputStream = socket.getOutputStream();
        F0.i.d(outputStream, "getOutputStream(...)");
        return new C0187c(h2, 0, new C0187c(outputStream, 1, h2));
    }

    public static final C0188d W(InputStream inputStream) {
        Logger logger = x.f3514a;
        F0.i.e(inputStream, "<this>");
        return new C0188d(inputStream, new K());
    }

    public static final C0188d X(Socket socket) throws IOException {
        Logger logger = x.f3514a;
        H h2 = new H(socket);
        InputStream inputStream = socket.getInputStream();
        F0.i.d(inputStream, "getInputStream(...)");
        return new C0188d(h2, new C0188d(inputStream, h2));
    }

    public static final Object Y(s sVar, s sVar2, p pVar) throws Throwable {
        Object c0039k;
        Object objE;
        L l2;
        try {
            q.a(pVar);
            c0039k = pVar.c(sVar2, sVar);
        } catch (Throwable th) {
            c0039k = new C0039k(th, false);
        }
        p042x0.a aVar = p042x0.a.f4189a;
        if (c0039k == aVar || (objE = sVar.E(c0039k)) == AbstractC0049v.f457d) {
            return aVar;
        }
        if (objE instanceof C0039k) {
            throw ((C0039k) objE).f440a;
        }
        M m2 = objE instanceof M ? (M) objE : null;
        return (m2 == null || (l2 = m2.f395a) == null) ? objE : l2;
    }

    public static final String Z(String str) {
        F0.i.e(str, "<this>");
        int i2 = 0;
        int i3 = -1;
        if (!M0.e.T(str, ":")) {
            try {
                String ascii = IDN.toASCII(str);
                F0.i.d(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                F0.i.d(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                F0.i.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i4 = 0; i4 < length; i4++) {
                    char cCharAt = lowerCase.charAt(i4);
                    if (F0.i.f(cCharAt, 31) <= 0 || F0.i.f(cCharAt, 127) >= 0 || M0.e.X(" #%/:?@[\\]", cCharAt, 0, false, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressT = (M0.m.R(str, "[", false) && M0.m.L(str, "]", false)) ? t(str, 1, str.length() - 1) : t(str, 0, str.length());
        if (inetAddressT == null) {
            return null;
        }
        byte[] address = inetAddressT.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressT.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        int i5 = 0;
        int i6 = 0;
        while (i5 < address.length) {
            int i7 = i5;
            while (i7 < 16 && address[i7] == 0 && address[i7 + 1] == 0) {
                i7 += 2;
            }
            int i8 = i7 - i5;
            if (i8 > i6 && i8 >= 4) {
                i3 = i5;
                i6 = i8;
            }
            i5 = i7 + 2;
        }
        C0193i c0193i = new C0193i();
        while (i2 < address.length) {
            if (i2 == i3) {
                c0193i.Q(58);
                i2 += i6;
                if (i2 == 16) {
                    c0193i.Q(58);
                }
            } else {
                if (i2 > 0) {
                    c0193i.Q(58);
                }
                byte b2 = address[i2];
                byte[] bArr = Y0.b.f1119a;
                c0193i.S(((b2 & 255) << 8) | (address[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return c0193i.J();
    }

    public static final p008e0.e d(Context context, p016j0.m mVar) {
        int iCheckPermission;
        ConnectivityManager connectivityManager = (ConnectivityManager) p031r.d.b(context, ConnectivityManager.class);
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", "android.permission.ACCESS_NETWORK_STATE")) {
                iCheckPermission = context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid());
            } else {
                iCheckPermission = p029q.k.a(new p029q.l(context).f4014a) ? 0 : -1;
            }
            if (iCheckPermission == 0) {
                try {
                    return new C.h(connectivityManager, mVar);
                } catch (Exception unused) {
                    return new C0028c(13);
                }
            }
        }
        return new C0028c(13);
    }

    public static final B e(G g) {
        F0.i.e(g, "<this>");
        return new B(g);
    }

    public static final C f(I i2) {
        F0.i.e(i2, "<this>");
        return new C(i2);
    }

    public static void j(String str) {
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(Y0.b.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), str).toString());
            }
        }
    }

    public static void k(int i2) {
        J0.c cVar = new J0.c(2, 36, 1);
        if (2 > i2 || i2 > cVar.f279b) {
            throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new J0.c(2, 36, 1));
        }
    }

    public static void l(String str, String str2) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Y0.b.i("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i2), str2));
                sb.append(Y0.b.q(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static final void m(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                p029q.j.a(th, th2);
            }
        }
    }

    public static int n(Y y2, H.h hVar, View view, View view2, N n2, boolean z2) {
        if (n2.u() == 0 || y2.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(N.C(view) - N.C(view2)) + 1;
        }
        return Math.min(hVar.l(), hVar.b(view2) - hVar.e(view));
    }

    public static int o(Y y2, H.h hVar, View view, View view2, N n2, boolean z2, boolean z3) {
        if (n2.u() == 0 || y2.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z3 ? Math.max(0, (y2.b() - Math.max(N.C(view), N.C(view2))) - 1) : Math.max(0, Math.min(N.C(view), N.C(view2)));
        if (z2) {
            return Math.round((iMax * (Math.abs(hVar.b(view2) - hVar.e(view)) / (Math.abs(N.C(view) - N.C(view2)) + 1))) + (hVar.k() - hVar.e(view)));
        }
        return iMax;
    }

    public static int p(Y y2, H.h hVar, View view, View view2, N n2, boolean z2) {
        if (n2.u() == 0 || y2.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return y2.b();
        }
        return (int) (((hVar.b(view2) - hVar.e(view)) / (Math.abs(N.C(view) - N.C(view2)) + 1)) * y2.b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (f1.d.j(r9, r1, F0.i.a(r7, r2) ? r0.getWidth() : p016j0.f.e(r7.f2749a, r8), F0.i.a(r7, r2) ? r0.getHeight() : p016j0.f.e(r7.f2750b, r8), r8) == 1.0d) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap q(android.graphics.drawable.Drawable r5, android.graphics.Bitmap.Config r6, g0.h r7, g0.g r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.l.q(android.graphics.drawable.Drawable, android.graphics.Bitmap$Config, g0.h, g0.g, boolean):android.graphics.Bitmap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] r(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            jArr[i2] = iArr[i2];
        }
        return jArr;
    }

    public static int s(String str, int i2, int i3, boolean z2) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z2)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e A[LOOP:2: B:25:0x004c->B:50:0x008e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1 A[LOOP:1: B:56:0x00a5->B:59:0x00b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:82:0x00b7 A[EDGE_INSN: B:82:0x00b7->B:60:0x00b7 BREAK  A[LOOP:1: B:56:0x00a5->B:59:0x00b1], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    public static final InetAddress t(String str, int i2, int i3) {
        int i4;
        ?? r14;
        int i5;
        char cCharAt;
        int i6;
        int i7;
        int i8;
        int iR;
        int i9 = 16;
        byte[] bArr = new byte[16];
        boolean z2 = false;
        int i10 = i2;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        while (true) {
            if (i10 >= i3) {
                i4 = i9;
                break;
            }
            if (i11 == i9) {
                return null;
            }
            int i14 = i10 + 2;
            if (i14 <= i3 && M0.m.Q(str, "::", i10, z2)) {
                if (i12 != -1) {
                    return null;
                }
                i11 += 2;
                if (i14 == i3) {
                    i4 = i9;
                    i12 = i11;
                    break;
                }
                i12 = i11;
                i13 = i14;
                i10 = i13;
                i7 = 0;
                while (i10 < i3) {
                    iR = Y0.b.r(str.charAt(i10));
                    if (iR != -1) {
                        break;
                        break;
                    }
                    i7 = (i7 << 4) + iR;
                    i10++;
                }
                i8 = i10 - i13;
                if (i8 != 0) {
                }
                return null;
            }
            if (i11 != 0) {
                if (!M0.m.Q(str, ":", i10, z2)) {
                    if (M0.m.Q(str, ".", i10, z2)) {
                        int i15 = i11 - 2;
                        int i16 = i15;
                        while (i13 < i3) {
                            if (i16 != i9) {
                                if (i16 == i15) {
                                    r14 = z2;
                                    i5 = i13;
                                    while (i5 < i3) {
                                        cCharAt = str.charAt(i5);
                                        if (F0.i.f(cCharAt, 48) < 0 || F0.i.f(cCharAt, 57) > 0) {
                                            break;
                                        }
                                        if ((r14 != 0 || i13 == i5) && (i6 = ((r14 * 10) + cCharAt) - 48) <= 255) {
                                            i5++;
                                            r14 = i6;
                                        }
                                    }
                                    if (i5 - i13 == 0) {
                                        bArr[i16] = (byte) r14;
                                        i16++;
                                        i13 = i5;
                                        i9 = 16;
                                        z2 = false;
                                    }
                                } else if (str.charAt(i13) == '.') {
                                    i13++;
                                    r14 = z2;
                                    i5 = i13;
                                    while (i5 < i3) {
                                        cCharAt = str.charAt(i5);
                                        if (F0.i.f(cCharAt, 48) < 0) {
                                            break;
                                        }
                                        break;
                                        break;
                                    }
                                    if (i5 - i13 == 0) {
                                        bArr[i16] = (byte) r14;
                                        i16++;
                                        i13 = i5;
                                        i9 = 16;
                                        z2 = false;
                                    }
                                }
                            }
                        }
                        if (i16 == i11 + 2) {
                            i11 += 2;
                            i4 = 16;
                            break;
                        }
                    }
                    return null;
                }
                i10++;
            }
            i13 = i10;
            i10 = i13;
            i7 = 0;
            while (i10 < i3) {
                iR = Y0.b.r(str.charAt(i10));
                if (iR != -1) {
                    break;
                }
                i7 = (i7 << 4) + iR;
                i10++;
            }
            i8 = i10 - i13;
            if (i8 != 0 || i8 > 4) {
                return null;
            }
            int i17 = i11 + 1;
            bArr[i11] = (byte) ((i7 >>> 8) & 255);
            i11 += 2;
            bArr[i17] = (byte) (i7 & 255);
            i9 = 16;
            z2 = false;
        }
        if (i11 != i4) {
            if (i12 == -1) {
                return null;
            }
            int i18 = i11 - i12;
            System.arraycopy(bArr, i12, bArr, 16 - i18, i18);
            Arrays.fill(bArr, i12, (16 - i11) + i12, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static final void u(o oVar, z zVar) throws IOException {
        try {
            IOException iOException = null;
            for (z zVar2 : oVar.d(zVar)) {
                try {
                    if (oVar.e(zVar2).f3491b) {
                        u(oVar, zVar2);
                    }
                    oVar.a(zVar2);
                } catch (IOException e2) {
                    if (iOException == null) {
                        iOException = e2;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final boolean v(char c2, char c3, boolean z2) {
        if (c2 == c3) {
            return true;
        }
        if (!z2) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static X0.x w(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return X0.x.f1090b;
        }
        if (str.equals("http/1.1")) {
            return X0.x.f1091c;
        }
        if (str.equals("h2_prior_knowledge")) {
            return X0.x.f1094f;
        }
        if (str.equals("h2")) {
            return X0.x.f1093e;
        }
        if (str.equals("spdy/3.1")) {
            return X0.x.f1092d;
        }
        if (str.equals("quic")) {
            return X0.x.g;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    public static final int x(Bitmap bitmap) {
        int i2;
        if (bitmap.isRecycled()) {
            throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap + " [" + bitmap.getWidth() + " x " + bitmap.getHeight() + "] + " + bitmap.getConfig()).toString());
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (Exception unused) {
            int height = bitmap.getHeight() * bitmap.getWidth();
            Bitmap.Config config = bitmap.getConfig();
            if (config == Bitmap.Config.ALPHA_8) {
                i2 = 1;
            } else if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
                i2 = 2;
            } else {
                i2 = (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.RGBA_F16) ? 4 : 8;
            }
            return i2 * height;
        }
    }

    public static ColorStateList y(Context context, int i2) {
        ColorStateList colorStateListA;
        ColorStateList colorStateList;
        s.k kVar;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        s.l lVar = new s.l(resources, theme);
        synchronized (s.n.f4063c) {
            try {
                SparseArray sparseArray = (SparseArray) s.n.f4062b.get(lVar);
                colorStateListA = null;
                if (sparseArray == null || sparseArray.size() <= 0 || (kVar = (s.k) sparseArray.get(i2)) == null) {
                    colorStateList = null;
                } else {
                    if (kVar.f4057b.equals(resources.getConfiguration())) {
                        if (theme != null || kVar.f4058c != 0) {
                            if (theme == null || kVar.f4058c != theme.hashCode()) {
                            }
                        }
                        colorStateList = kVar.f4056a;
                    }
                    sparseArray.remove(i2);
                    colorStateList = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal threadLocal = s.n.f4061a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.type;
        if (i3 < 28 || i3 > 31) {
            try {
                colorStateListA = s.c.a(resources, resources.getXml(i2), theme);
            } catch (Exception e2) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            }
        }
        if (colorStateListA == null) {
            return s.j.b(resources, i2, theme);
        }
        synchronized (s.n.f4063c) {
            try {
                WeakHashMap weakHashMap = s.n.f4062b;
                SparseArray sparseArray2 = (SparseArray) weakHashMap.get(lVar);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    weakHashMap.put(lVar, sparseArray2);
                }
                sparseArray2.append(i2, new s.k(colorStateListA, lVar.f4059a.getConfiguration(), theme));
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return colorStateListA;
    }

    public static float z(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return D.f.b(edgeEffect);
        }
        return 0.0f;
    }

    public abstract InputFilter[] B(InputFilter[] inputFilterArr);

    public abstract void I(Throwable th);

    public abstract void J(H.x xVar);

    public abstract void P(p025o.f fVar, p025o.f fVar2);

    public abstract void Q(p025o.f fVar, Thread thread);

    public abstract void T(boolean z2);

    public abstract void U(boolean z2);

    public abstract boolean g(p025o.g gVar, p025o.c cVar);

    public abstract boolean h(p025o.g gVar, Object obj, Object obj2);

    public abstract boolean i(p025o.g gVar, p025o.f fVar, p025o.f fVar2);

    @Override // A.i0
    public void c() {
    }

    @Override // A.i0
    public void b(View view) {
    }
}
