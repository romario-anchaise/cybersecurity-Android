// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ec implements AccessibilityService.TakeScreenshotCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p5 f3914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f3915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e2.r f3916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f3917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e2.d f3918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ fc f3919g;

    public ec(fc fcVar, AtomicReference atomicReference, p5 p5Var, AtomicBoolean atomicBoolean, e2.r rVar, boolean z2, e2.d dVar) {
        this.f3919g = fcVar;
        this.f3913a = atomicReference;
        this.f3914b = p5Var;
        this.f3915c = atomicBoolean;
        this.f3916d = rVar;
        this.f3917e = z2;
        this.f3918f = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0056  */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    /* JADX WARN: Code duplicated, block: B:26:0x005d A[Catch: all -> 0x0051, TRY_ENTER, TryCatch #0 {all -> 0x0051, blocks: (B:15:0x003f, B:17:0x0047, B:26:0x005d, B:27:0x0074, B:29:0x007c, B:30:0x008d), top: B:37:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:29:0x007c A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:15:0x003f, B:17:0x0047, B:26:0x005d, B:27:0x0074, B:29:0x007c, B:30:0x008d), top: B:37:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0096  */
    /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x005d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x007c, please report this as an issue */
    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    public final void onFailure(int i3) {
        int i4;
        boolean z2;
        boolean zCompareAndSet;
        e2.r rVar;
        fc fcVar;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f3913a.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        p5 p5Var = this.f3914b;
        try {
            if (p5Var.a()) {
                i4 = i3;
                if (x7.a((x7) p5Var.f4805d, p5Var.f4802a, p5Var.f4803b, false, i4)) {
                    z2 = true;
                }
                zCompareAndSet = this.f3915c.compareAndSet(true, false);
                rVar = this.f3916d;
                fcVar = this.f3919g;
                if (!z2) {
                    if (zCompareAndSet && !fcVar.f4034a.get()) {
                        rVar.a(fc.a(fcVar, this.f3917e));
                    }
                    if (zCompareAndSet) {
                        fcVar.c();
                        return;
                    }
                    return;
                }
                if (i4 == 3) {
                    Log.w("MirrorScreenshotPerf", "stage=oem source=rtc errorCode=3 sharedIntervalMs=" + ScreenMirrorService.o6.b());
                }
                if (fcVar.f4035b.compareAndSet(false, true)) {
                    Log.w("ScreenMirror", "RTC accessibility screenshot callback failed code=" + i4);
                }
                e2.s.a(rVar.f934a, rVar.f935b, i4);
                if (zCompareAndSet) {
                    fcVar.c();
                    return;
                }
                return;
            }
            i4 = i3;
            if (!z2) {
                if (zCompareAndSet) {
                    rVar.a(fc.a(fcVar, this.f3917e));
                }
                if (zCompareAndSet) {
                    fcVar.c();
                    return;
                }
                return;
            }
            if (i4 == 3) {
                Log.w("MirrorScreenshotPerf", "stage=oem source=rtc errorCode=3 sharedIntervalMs=" + ScreenMirrorService.o6.b());
            }
            if (fcVar.f4035b.compareAndSet(false, true)) {
                Log.w("ScreenMirror", "RTC accessibility screenshot callback failed code=" + i4);
            }
            e2.s.a(rVar.f934a, rVar.f935b, i4);
            if (zCompareAndSet) {
                fcVar.c();
                return;
            }
            return;
        } catch (Throwable th) {
            if (!zCompareAndSet) {
                throw th;
            }
            fcVar.c();
            throw th;
        }
        z2 = false;
        zCompareAndSet = this.f3915c.compareAndSet(true, false);
        rVar = this.f3916d;
        fcVar = this.f3919g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b3, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f5, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0118, code lost:
    
        if (r13 != false) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0, types: [e2.r] */
    /* JADX WARN: Type inference failed for: r1v1, types: [e2.r] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSuccess(android.accessibilityservice.AccessibilityService.ScreenshotResult r19) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.ec.onSuccess(android.accessibilityservice.AccessibilityService$ScreenshotResult):void");
    }
}
