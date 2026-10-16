// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m;

import android.content.Context;
import android.os.Trace;
import androidx.work.WorkManagerInitializer;
import h0.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import p.b;
import p.m;
import q.q;
import q2.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f2673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f2674e = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f2677c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f2676b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2675a = new HashMap();

    public a(Context context) {
        this.f2677c = context.getApplicationContext();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c A[Catch: all -> 0x0013, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x000b, B:9:0x0016, B:11:0x001c, B:13:0x0024, B:27:0x0082, B:28:0x0087, B:29:0x0088, B:35:0x0094, B:36:0x00ae, B:15:0x0028, B:17:0x003d, B:18:0x0041, B:20:0x0047, B:22:0x0055, B:25:0x005b), top: B:42:0x000b, outer: #0, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x0024 A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x000b, B:9:0x0016, B:11:0x001c, B:13:0x0024, B:27:0x0082, B:28:0x0087, B:29:0x0088, B:35:0x0094, B:36:0x00ae, B:15:0x0028, B:17:0x003d, B:18:0x0041, B:20:0x0047, B:22:0x0055, B:25:0x005b), top: B:42:0x000b, outer: #0, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x003d A[Catch: all -> 0x0059, TryCatch #2 {all -> 0x0059, blocks: (B:15:0x0028, B:17:0x003d, B:18:0x0041, B:20:0x0047, B:22:0x0055, B:25:0x005b), top: B:43:0x0028, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0047 A[Catch: all -> 0x0059, TryCatch #2 {all -> 0x0059, blocks: (B:15:0x0028, B:17:0x003d, B:18:0x0041, B:20:0x0047, B:22:0x0055, B:25:0x005b), top: B:43:0x0028, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0088 A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x000b, B:9:0x0016, B:11:0x001c, B:13:0x0024, B:27:0x0082, B:28:0x0087, B:29:0x0088, B:35:0x0094, B:36:0x00ae, B:15:0x0028, B:17:0x003d, B:18:0x0041, B:20:0x0047, B:22:0x0055, B:25:0x005b), top: B:42:0x000b, outer: #0, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0094 A[Catch: all -> 0x0013, TRY_ENTER, TryCatch #1 {all -> 0x0013, blocks: (B:6:0x000b, B:9:0x0016, B:11:0x001c, B:13:0x0024, B:27:0x0082, B:28:0x0087, B:29:0x0088, B:35:0x0094, B:36:0x00ae, B:15:0x0028, B:17:0x003d, B:18:0x0041, B:20:0x0047, B:22:0x0055, B:25:0x005b), top: B:42:0x000b, outer: #0, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0094, please report this as an issue */
    public final void a(Class cls, HashSet hashSet) {
        List<Class> list;
        synchronized (f2674e) {
            if (k.h()) {
                try {
                    Trace.beginSection(cls.getSimpleName());
                    if (!hashSet.contains(cls)) {
                        throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
                    }
                    if (this.f2675a.containsKey(cls)) {
                        this.f2675a.get(cls);
                    } else {
                        hashSet.add(cls);
                        try {
                            ((WorkManagerInitializer) cls.getDeclaredConstructor(null).newInstance(null)).getClass();
                            list = Collections.EMPTY_LIST;
                            if (!list.isEmpty()) {
                                for (Class cls2 : list) {
                                    if (!this.f2675a.containsKey(cls2)) {
                                        a(cls2, hashSet);
                                    }
                                }
                            }
                            Context context = this.f2677c;
                            m.d().a(WorkManagerInitializer.f204a, "Initializing WorkManager with default configuration.");
                            q.b(context, new b(new g()));
                            q qVarA = q.a(context);
                            hashSet.remove(cls);
                            this.f2675a.put(cls, qVarA);
                        } catch (Throwable th) {
                            throw new h1.a(th);
                        }
                    }
                    Trace.endSection();
                } catch (Throwable th2) {
                    Trace.endSection();
                    throw th2;
                }
            } else {
                if (!hashSet.contains(cls)) {
                    throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
                }
                if (this.f2675a.containsKey(cls)) {
                    hashSet.add(cls);
                    ((WorkManagerInitializer) cls.getDeclaredConstructor(null).newInstance(null)).getClass();
                    list = Collections.EMPTY_LIST;
                    if (!list.isEmpty()) {
                        while (r0.hasNext()) {
                            if (!this.f2675a.containsKey(cls2)) {
                                a(cls2, hashSet);
                            }
                        }
                    }
                    Context context2 = this.f2677c;
                    m.d().a(WorkManagerInitializer.f204a, "Initializing WorkManager with default configuration.");
                    q.b(context2, new b(new g()));
                    q qVarA2 = q.a(context2);
                    hashSet.remove(cls);
                    this.f2675a.put(cls, qVarA2);
                } else {
                    this.f2675a.get(cls);
                }
                Trace.endSection();
            }
            throw th;
        }
    }
}
