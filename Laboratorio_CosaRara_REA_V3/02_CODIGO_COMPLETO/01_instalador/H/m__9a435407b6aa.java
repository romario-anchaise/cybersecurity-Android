// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.InterfaceC0067e;
import androidx.lifecycle.InterfaceC0082u;

/* JADX INFO: loaded from: classes.dex */
public final class m implements InterfaceC0067e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0078p f213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer f214b;

    public m(EmojiCompatInitializer emojiCompatInitializer, AbstractC0078p abstractC0078p) {
        this.f214b = emojiCompatInitializer;
        this.f213a = abstractC0078p;
    }

    @Override // androidx.lifecycle.InterfaceC0067e
    public final void b(InterfaceC0082u interfaceC0082u) {
        this.f214b.getClass();
        (Build.VERSION.SDK_INT >= 28 ? AbstractC0027b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new p(), 500L);
        this.f213a.c(this);
    }
}
