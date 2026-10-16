// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f204i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile l f205j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p021m.f f207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f211f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f212h;

    public l(v vVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f206a = reentrantReadWriteLock;
        this.f208c = 3;
        k kVar = (k) vVar.f200b;
        this.f211f = kVar;
        int i2 = vVar.f199a;
        this.g = i2;
        this.f212h = (e) vVar.f201c;
        this.f209d = new Handler(Looper.getMainLooper());
        this.f207b = new p021m.f();
        g gVar = new g(this);
        this.f210e = gVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i2 == 0) {
            try {
                this.f208c = 0;
            } catch (Throwable th) {
                this.f206a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                kVar.v(new f(gVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static l a() {
        l lVar;
        synchronized (f204i) {
            try {
                lVar = f205j;
                if (!(lVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    public final int b() {
        this.f206a.readLock().lock();
        try {
            return this.f208c;
        } finally {
            this.f206a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.g == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f206a.writeLock().lock();
        try {
            if (this.f208c == 0) {
                this.f206a.writeLock().unlock();
                return;
            }
            this.f208c = 0;
            this.f206a.writeLock().unlock();
            g gVar = this.f210e;
            l lVar = gVar.f196a;
            try {
                lVar.f211f.v(new f(gVar));
            } catch (Throwable th) {
                lVar.d(th);
            }
        } catch (Throwable th2) {
            this.f206a.writeLock().unlock();
            throw th2;
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f206a.writeLock().lock();
        try {
            this.f208c = 2;
            arrayList.addAll(this.f207b);
            this.f207b.clear();
            this.f206a.writeLock().unlock();
            this.f209d.post(new j(arrayList, this.f208c, th));
        } catch (Throwable th2) {
            this.f206a.writeLock().unlock();
            throw th2;
        }
    }

    public final CharSequence e(CharSequence charSequence, int i2, int i3) {
        int iCharCount;
        A[] aArr;
        if (!(b() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        if (!(i2 <= i3)) {
            throw new IllegalArgumentException("start should be <= than end");
        }
        C c2 = null;
        if (charSequence == null) {
            return null;
        }
        if (!(i2 <= charSequence.length())) {
            throw new IllegalArgumentException("start should be < than charSequence length");
        }
        if (!(i3 <= charSequence.length())) {
            throw new IllegalArgumentException("end should be < than charSequence length");
        }
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        s sVar = this.f210e.f197b;
        sVar.getClass();
        boolean z2 = charSequence instanceof z;
        if (z2) {
            ((z) charSequence).a();
        }
        if (z2) {
            c2 = new C((Spannable) charSequence);
        } else {
            try {
                if (charSequence instanceof Spannable) {
                    c2 = new C((Spannable) charSequence);
                } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i2 - 1, i3 + 1, A.class) <= i3) {
                    c2 = new C(charSequence);
                }
            } finally {
                if (z2) {
                    ((z) charSequence).b();
                }
            }
        }
        if (c2 != null && (aArr = (A[]) c2.f189b.getSpans(i2, i3, A.class)) != null && aArr.length > 0) {
            for (A a2 : aArr) {
                int spanStart = c2.f189b.getSpanStart(a2);
                int spanEnd = c2.f189b.getSpanEnd(a2);
                if (spanStart != i3) {
                    c2.removeSpan(a2);
                }
                i2 = Math.min(spanStart, i2);
                i3 = Math.max(spanEnd, i3);
            }
        }
        if (i2 != i3 && i2 < charSequence.length()) {
            r rVar = new r((w) ((x) sVar.f232b).f248c);
            int iCodePointAt = Character.codePointAt(charSequence, i2);
            int i4 = 0;
            C c3 = c2;
            loop1: while (true) {
                iCharCount = i2;
                while (true) {
                    if (i2 >= i3 || i4 >= Integer.MAX_VALUE) {
                        break loop1;
                    }
                    int iA = rVar.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i3) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i2 = iCharCount;
                    } else if (iA == 2) {
                        i2 += Character.charCount(iCodePointAt);
                        if (i2 < i3) {
                            iCodePointAt = Character.codePointAt(charSequence, i2);
                        }
                    } else if (iA != 3) {
                    }
                }
                if (!sVar.y(charSequence, iCharCount, i2, rVar.f228d.f245b)) {
                    if (c3 == null) {
                        c3 = new C((Spannable) new SpannableString(charSequence));
                    }
                    c3.setSpan(new A(rVar.f228d.f245b), iCharCount, i2, 33);
                    i4++;
                }
            }
            if (rVar.f225a == 2 && rVar.f227c.f245b != null && ((rVar.f230f > 1 || rVar.c()) && i4 < Integer.MAX_VALUE && !sVar.y(charSequence, iCharCount, i2, rVar.f227c.f245b))) {
                if (c3 == null) {
                    c3 = new C(charSequence);
                }
                c3.setSpan(new A(rVar.f227c.f245b), iCharCount, i2, 33);
            }
            if (c3 != null) {
                return c3.f189b;
            }
            if (!z2) {
                return charSequence;
            }
        } else if (!z2) {
            return charSequence;
        }
        return charSequence;
    }

    public final void f(i iVar) {
        p028p0.a.a(iVar, "initCallback cannot be null");
        this.f206a.writeLock().lock();
        try {
            if (this.f208c == 1 || this.f208c == 2) {
                this.f209d.post(new j(Arrays.asList(iVar), this.f208c, null));
            } else {
                this.f207b.add(iVar);
            }
        } finally {
            this.f206a.writeLock().unlock();
        }
    }
}
