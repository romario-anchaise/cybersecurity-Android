// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p013i.D;

/* JADX INFO: loaded from: classes.dex */
public final class x implements p011h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f249d;

    public x() {
        this.f247b = new ArrayDeque();
        this.f248c = new ArrayDeque();
        this.f249d = new ArrayDeque();
    }

    @Override // p011h.a
    public boolean a(p011h.b bVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f246a).onActionItemClicked(g(bVar), new p013i.u((Context) this.f247b, (p037v.a) menuItem));
    }

    public void b(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        h();
    }

    @Override // p011h.a
    public boolean c(p011h.b bVar, p013i.n nVar) {
        p011h.g gVarG = g(bVar);
        p021m.i iVar = (p021m.i) this.f249d;
        Menu d2 = (Menu) iVar.get(nVar);
        if (d2 == null) {
            d2 = new D((Context) this.f247b, nVar);
            iVar.put(nVar, d2);
        }
        return ((ActionMode.Callback) this.f246a).onPrepareActionMode(gVarG, d2);
    }

    public void d(b1.g gVar) {
        F0.i.e(gVar, "call");
        gVar.f2127b.decrementAndGet();
        b((ArrayDeque) this.f248c, gVar);
    }

    @Override // p011h.a
    public void e(p011h.b bVar) {
        ((ActionMode.Callback) this.f246a).onDestroyActionMode(g(bVar));
    }

    @Override // p011h.a
    public boolean f(p011h.b bVar, p013i.n nVar) {
        p011h.g gVarG = g(bVar);
        p021m.i iVar = (p021m.i) this.f249d;
        Menu d2 = (Menu) iVar.get(nVar);
        if (d2 == null) {
            d2 = new D((Context) this.f247b, nVar);
            iVar.put(nVar, d2);
        }
        return ((ActionMode.Callback) this.f246a).onCreateActionMode(gVarG, d2);
    }

    public p011h.g g(p011h.b bVar) {
        ArrayList arrayList = (ArrayList) this.f248c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            p011h.g gVar = (p011h.g) arrayList.get(i2);
            if (gVar != null && gVar.f2790b == bVar) {
                return gVar;
            }
        }
        p011h.g gVar2 = new p011h.g((Context) this.f247b, bVar);
        arrayList.add(gVar2);
        return gVar2;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:24:0x0072 A[Catch: all -> 0x00a5, TryCatch #1 {all -> 0x00a5, blocks: (B:22:0x006c, B:24:0x0072, B:27:0x00a7), top: B:49:0x006c }] */
    /* JADX WARN: Code duplicated, block: B:49:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x0072, please report this as an issue */
    public void h() {
        int size;
        boolean z2;
        int i2;
        b1.g gVar;
        byte[] bArr = Y0.b.f1119a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.f247b).iterator();
                F0.i.d(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    b1.g gVar2 = (b1.g) it.next();
                    if (((ArrayDeque) this.f248c).size() >= 64) {
                        break;
                    }
                    if (gVar2.f2127b.get() < 5) {
                        it.remove();
                        gVar2.f2127b.incrementAndGet();
                        arrayList.add(gVar2);
                        ((ArrayDeque) this.f248c).add(gVar2);
                    }
                }
                synchronized (this) {
                    ((ArrayDeque) this.f248c).size();
                    ((ArrayDeque) this.f249d).size();
                }
                size = arrayList.size();
                z2 = false;
                for (i2 = 0; i2 < size; i2++) {
                    gVar = (b1.g) arrayList.get(i2);
                    synchronized (this) {
                        try {
                            if (((ThreadPoolExecutor) this.f246a) == null) {
                                TimeUnit timeUnit = TimeUnit.SECONDS;
                                SynchronousQueue synchronousQueue = new SynchronousQueue();
                                String str = Y0.b.g + " Dispatcher";
                                F0.i.e(str, "name");
                                this.f246a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new Y0.a(str, z2));
                            }
                            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.f246a;
                            F0.i.b(threadPoolExecutor);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    gVar.getClass();
                    b1.j jVar = gVar.f2128c;
                    x xVar = jVar.f2131a.f1066a;
                    byte[] bArr2 = Y0.b.f1119a;
                    try {
                        try {
                            threadPoolExecutor.execute(gVar);
                        } catch (RejectedExecutionException e2) {
                            InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                            interruptedIOException.initCause(e2);
                            jVar.l(interruptedIOException);
                            gVar.f2126a.g(jVar, interruptedIOException);
                            jVar.f2131a.f1066a.d(gVar);
                        }
                    } catch (Throwable th2) {
                        jVar.f2131a.f1066a.d(gVar);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        size = arrayList.size();
        z2 = false;
        while (i2 < size) {
            gVar = (b1.g) arrayList.get(i2);
            synchronized (this) {
                if (((ThreadPoolExecutor) this.f246a) == null) {
                    TimeUnit timeUnit2 = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue2 = new SynchronousQueue();
                    String str2 = Y0.b.g + " Dispatcher";
                    F0.i.e(str2, "name");
                    this.f246a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit2, synchronousQueue2, new Y0.a(str2, z2));
                }
                ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) this.f246a;
                F0.i.b(threadPoolExecutor2);
                gVar.getClass();
                b1.j jVar2 = gVar.f2128c;
                x xVar2 = jVar2.f2131a.f1066a;
                byte[] bArr3 = Y0.b.f1119a;
                threadPoolExecutor2.execute(gVar);
            }
        }
    }

    public x(Typeface typeface, I.b bVar) {
        int i2;
        int i3;
        this.f249d = typeface;
        this.f246a = bVar;
        this.f248c = new w(1024);
        int iA = bVar.a(6);
        if (iA != 0) {
            int i4 = iA + bVar.f2a;
            i2 = ((ByteBuffer) bVar.f5d).getInt(((ByteBuffer) bVar.f5d).getInt(i4) + i4);
        } else {
            i2 = 0;
        }
        this.f247b = new char[i2 * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i5 = iA2 + bVar.f2a;
            i3 = ((ByteBuffer) bVar.f5d).getInt(((ByteBuffer) bVar.f5d).getInt(i5) + i5);
        } else {
            i3 = 0;
        }
        for (int i6 = 0; i6 < i3; i6++) {
            q qVar = new q(this, i6);
            I.a aVarC = qVar.c();
            int iA3 = aVarC.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) aVarC.f5d).getInt(iA3 + aVarC.f2a) : 0, (char[]) this.f247b, i6 * 2);
            if (qVar.b() > 0) {
                ((w) this.f248c).a(qVar, 0, qVar.b() - 1);
            } else {
                throw new IllegalArgumentException("invalid metadata codepoint length");
            }
        }
    }

    public x(Context context) {
        this.f246a = context.getApplicationContext();
        this.f247b = p016j0.d.f3373a;
        this.f248c = null;
        this.f249d = new p016j0.j();
    }

    public x(Context context, ActionMode.Callback callback) {
        this.f247b = context;
        this.f246a = callback;
        this.f248c = new ArrayList();
        this.f249d = new p021m.i(0);
    }
}
