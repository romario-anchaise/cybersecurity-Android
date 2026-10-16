// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.emoji2.text;

import A.C0005e;
import H.l;
import H.m;
import H.v;
import R.a;
import R.b;
import android.content.Context;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.InterfaceC0082u;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements b {
    @Override // R.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // R.b
    public final Object b(Context context) {
        Object objB;
        v vVar = new v(new C0005e(context));
        vVar.f199a = 1;
        if (l.f205j == null) {
            synchronized (l.f204i) {
                try {
                    if (l.f205j == null) {
                        l.f205j = new l(vVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        a aVarC = a.c(context);
        aVarC.getClass();
        synchronized (a.f531e) {
            try {
                objB = aVarC.f532a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        AbstractC0078p lifecycle = ((InterfaceC0082u) objB).getLifecycle();
        lifecycle.a(new m(this, lifecycle));
        return Boolean.TRUE;
    }
}
