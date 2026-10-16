// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f3406b;

    static {
        a aVar = new a();
        f3405a = aVar;
        f3406b = new h[]{aVar, new h() { // from class: k0.b
            @Override // p018k0.h
            public final String b(Field field) {
                return h.c(field.getName());
            }
        }, new h() { // from class: k0.c
            @Override // p018k0.h
            public final String b(Field field) {
                return h.c(h.a(field.getName(), ' '));
            }
        }, new h() { // from class: k0.d
            @Override // p018k0.h
            public final String b(Field field) {
                return h.a(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        }, new h() { // from class: k0.e
            @Override // p018k0.h
            public final String b(Field field) {
                return h.a(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        }, new h() { // from class: k0.f
            @Override // p018k0.h
            public final String b(Field field) {
                return h.a(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        }, new h() { // from class: k0.g
            @Override // p018k0.h
            public final String b(Field field) {
                return h.a(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public static String a(String str, char c2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String c(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i2 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
            }
        }
        return str;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f3406b.clone();
    }

    public abstract String b(Field field);
}
