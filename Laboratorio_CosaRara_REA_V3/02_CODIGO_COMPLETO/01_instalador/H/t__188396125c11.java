// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.content.Context;
import android.graphics.Typeface;
import androidx.lifecycle.EnumC0076n;
import java.nio.MappedByteBuffer;
import lyr.stable.wrapper.MainActivity;
import p009f.DialogC0119i;
import p015j.V;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f235b;

    public /* synthetic */ t(int i2, Object obj) {
        this.f234a = i2;
        this.f235b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f234a) {
            case 0:
                u uVar = (u) this.f235b;
                synchronized (uVar.f239d) {
                    try {
                        if (uVar.f242h == null) {
                            return;
                        }
                        try {
                            p041x.h hVarB = uVar.b();
                            int i2 = hVarB.f4184e;
                            if (i2 == 2) {
                                synchronized (uVar.f239d) {
                                }
                            }
                            if (i2 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i2 + ")");
                            }
                            try {
                                int i3 = p039w.j.f4157a;
                                p039w.i.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                C0028c c0028c = uVar.f238c;
                                Context context = uVar.f236a;
                                c0028c.getClass();
                                Typeface typefaceD = p033t.f.f4108a.d(context, new p041x.h[]{hVarB}, 0);
                                MappedByteBuffer mappedByteBufferO = p028p0.a.o(uVar.f236a, hVarB.f4180a);
                                if (mappedByteBufferO == null || typefaceD == null) {
                                    throw new RuntimeException("Unable to open file.");
                                }
                                try {
                                    p039w.i.a("EmojiCompat.MetadataRepo.create");
                                    x xVar = new x(typefaceD, f1.d.w(mappedByteBufferO));
                                    p039w.i.b();
                                    p039w.i.b();
                                    synchronized (uVar.f239d) {
                                        try {
                                            f1.l lVar = uVar.f242h;
                                            if (lVar != null) {
                                                lVar.J(xVar);
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                        break;
                                    }
                                    uVar.a();
                                    return;
                                } catch (Throwable th2) {
                                    int i4 = p039w.j.f4157a;
                                    p039w.i.b();
                                    throw th2;
                                }
                            } catch (Throwable th3) {
                                int i5 = p039w.j.f4157a;
                                p039w.i.b();
                                throw th3;
                            }
                            break;
                        } catch (Throwable th4) {
                            synchronized (uVar.f239d) {
                                try {
                                    f1.l lVar2 = uVar.f242h;
                                    if (lVar2 != null) {
                                        lVar2.I(th4);
                                    }
                                    uVar.a();
                                    return;
                                } catch (Throwable th5) {
                                    throw th5;
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
            case 1:
                String message = ((Exception) this.f235b).getMessage();
                W0.h hVar = (W0.h) W0.i.f813r.get();
                if (hVar != null) {
                    ((MainActivity) hVar).o(message);
                    return;
                }
                return;
            case 2:
                String str = (String) this.f235b;
                W0.h hVar2 = (W0.h) W0.i.f813r.get();
                if (hVar2 != null) {
                    ((MainActivity) hVar2).o(str);
                    return;
                }
                return;
            case 3:
                ((androidx.fragment.app.h) this.f235b).invalidateMenu();
                return;
            case 4:
                DialogC0119i.a((DialogC0119i) this.f235b);
                return;
            case 5:
                ((androidx.activity.o) this.f235b).a();
                return;
            case 6:
                androidx.lifecycle.B b2 = (androidx.lifecycle.B) this.f235b;
                F0.i.e(b2, "this$0");
                int i6 = b2.f1628b;
                androidx.lifecycle.w wVar = b2.f1632f;
                if (i6 == 0) {
                    b2.f1629c = true;
                    wVar.f(EnumC0076n.ON_PAUSE);
                }
                if (b2.f1627a == 0 && b2.f1629c) {
                    wVar.f(EnumC0076n.ON_STOP);
                    b2.f1630d = true;
                    return;
                }
                return;
            default:
                ((V) this.f235b).getClass();
                return;
        }
    }
}
