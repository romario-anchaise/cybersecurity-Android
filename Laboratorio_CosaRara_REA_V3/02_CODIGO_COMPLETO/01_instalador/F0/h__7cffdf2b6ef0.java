// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class h {
    public static /* synthetic */ String a(int i2) {
        if (i2 == 1) {
            return "settings_bypass";
        }
        if (i2 == 2) {
            return "full_blackhole";
        }
        throw null;
    }

    public static String b(int i2, String str) {
        return str + i2;
    }

    public static String c(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.y());
        return sb.toString();
    }

    public static String d(String str, long j2) {
        return str + j2;
    }

    public static String e(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static /* synthetic */ void f(int i2) {
        if (i2 != 0) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        i.g(nullPointerException, i.class.getName());
        throw nullPointerException;
    }

    public static /* synthetic */ void g(int i2, String str) {
        if (i2 == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = i.class.getName();
            int i3 = 0;
            while (!stackTrace[i3].getClassName().equals(name)) {
                i3++;
            }
            while (stackTrace[i3].getClassName().equals(name)) {
                i3++;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
            i.g(nullPointerException, i.class.getName());
            throw nullPointerException;
        }
    }

    public static /* synthetic */ String h(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? "null" : "FULL_BLACKHOLE";
        }
        return "SETTINGS_BYPASS";
    }

    public static /* synthetic */ String i(int i2) {
        switch (i2) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }
}
