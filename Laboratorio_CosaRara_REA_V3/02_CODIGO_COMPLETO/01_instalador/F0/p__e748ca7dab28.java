// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    public static String a(f fVar) {
        String string = fVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
