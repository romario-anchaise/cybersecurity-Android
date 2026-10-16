// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.activity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ androidx.fragment.app.h f1246a;

    public d(androidx.fragment.app.h hVar) {
        this.f1246a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            super/*android.app.Activity*/.onBackPressed();
        } catch (IllegalStateException e2) {
            if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e2;
            }
        }
    }
}
