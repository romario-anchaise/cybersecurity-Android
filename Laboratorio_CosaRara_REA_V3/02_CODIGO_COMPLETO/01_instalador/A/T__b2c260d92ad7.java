// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class T {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static C0009i b(View view, C0009i c0009i) {
        ContentInfo contentInfoT = c0009i.f45a.t();
        Objects.requireNonNull(contentInfoT);
        ContentInfo contentInfoE = AbstractC0004d.e(contentInfoT);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoE);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoE ? c0009i : new C0009i(new C0005e(contentInfoPerformReceiveContent));
    }

    public static void c(View view, String[] strArr, InterfaceC0025z interfaceC0025z) {
        if (interfaceC0025z == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new U(interfaceC0025z));
        }
    }
}
