// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class U implements OnReceiveContentListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0025z f9a;

    public U(InterfaceC0025z interfaceC0025z) {
        this.f9a = interfaceC0025z;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        C0009i c0009i = new C0009i(new C0005e(contentInfo));
        C0009i c0009iA = ((D.w) this.f9a).a(view, c0009i);
        if (c0009iA == null) {
            return null;
        }
        if (c0009iA == c0009i) {
            return contentInfo;
        }
        ContentInfo contentInfoT = c0009iA.f45a.t();
        Objects.requireNonNull(contentInfoT);
        return AbstractC0004d.e(contentInfoT);
    }
}
