// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package C;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputContentInfo f109a;

    public g(Object obj) {
        this.f109a = (InputContentInfo) obj;
    }

    @Override // C.i
    public final ClipDescription a() {
        return this.f109a.getDescription();
    }

    @Override // C.i
    public final void b() {
        this.f109a.requestPermission();
    }

    @Override // C.i
    public final Uri c() {
        return this.f109a.getLinkUri();
    }

    @Override // C.i
    public final Object e() {
        return this.f109a;
    }

    @Override // C.i
    public final Uri g() {
        return this.f109a.getContentUri();
    }

    public g(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f109a = new InputContentInfo(uri, clipDescription, uri2);
    }
}
