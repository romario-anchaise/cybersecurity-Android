// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.content.Context;
import android.util.AtomicFile;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f137a = {30000, 60000, 120000, 300000};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f138b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile p f139c = p.a(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadPoolExecutor f140d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(32), new l(0), new ThreadPoolExecutor.AbortPolicy());

    public static String a(String str) {
        if (str.trim().isEmpty()) {
            return "unknown";
        }
        StringBuilder sb = new StringBuilder(Math.min(48, str.length()));
        for (int i3 = 0; i3 < str.length() && sb.length() < 48; i3++) {
            char cCharAt = str.charAt(i3);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < '0' || cCharAt > '9') && cCharAt != '.' && cCharAt != '_' && cCharAt != '-'))) {
                cCharAt = '_';
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static n b(long j3, long j4, p pVar) {
        p pVarA = pVar == null ? p.a(0L) : pVar;
        if (pVarA.f132h) {
            return new n(pVarA, false, false, false, Math.max(0L, 0L));
        }
        long j5 = pVarA.f129e;
        if (j5 <= 0 || j4 <= 0 || pVarA.f131g != j4) {
            return new n(pVarA, false, false, false, Math.max(0L, j5 > 0 ? Math.max(1L, j5 - j3) : 0L));
        }
        if (j3 < j5) {
            return new n(pVarA, false, false, false, Math.max(1L, Math.max(1L, j5 - j3)));
        }
        boolean z2 = pVarA.f130f;
        boolean z3 = pVarA.f133i;
        long j6 = pVarA.f125a;
        long j7 = pVarA.f126b;
        return z3 ? new n(new p(j6, j7, pVarA.f127c, pVarA.f128d, v(j3, 60000L), z2, pVarA.f131g, false, true), false, true, z2, 0L) : new n(new p(j6, j7, pVarA.f127c, pVarA.f128d, v(j3, 15000L), z2, pVarA.f131g, false, true), true, false, z2, 0L);
    }

    public static o c(long j3, p pVar) {
        p pVarA = pVar == null ? p.a(0L) : pVar;
        long j4 = pVarA.f129e;
        if (pVarA.f132h) {
            return j4 > j3 ? new o(pVarA, false, Math.max(1L, Math.max(1L, j4 - j3))) : new o(new p(pVarA.f125a, pVarA.f126b, pVarA.f127c, 0L, v(j3, 60000L), false, pVarA.f131g, true, false), true, 0L);
        }
        long j5 = pVarA.f128d;
        if (j5 <= 0) {
            return new o(pVarA, false, 0L);
        }
        if (j3 < j5) {
            return new o(pVarA, false, Math.max(1L, Math.max(1L, j5 - j3)));
        }
        return j4 > 0 ? new o(pVarA, false, Math.max(1L, Math.max(1L, j4 - j3))) : new o(new p(pVarA.f125a, pVarA.f126b, pVarA.f127c, 0L, v(j3, 15000L), false, pVarA.f131g, true, false), true, 0L);
    }

    public static q d(long j3, long j4, boolean z2, p pVar) {
        p pVarA = pVar == null ? p.a(0L) : pVar;
        if (j4 > 0) {
            long j5 = pVarA.f131g;
            if (j5 == j4 && pVarA.f133i) {
                if (z2) {
                    return new q(new p(j3, pVarA.f126b, pVarA.f127c, pVarA.f128d, 0L, false, j5, pVarA.f132h, false), true, true);
                }
                p pVar2 = new p(pVarA.f125a, pVarA.f126b, pVarA.f127c, pVarA.f128d, v(j3, 60000L), pVarA.f130f, pVarA.f131g, pVarA.f132h, false);
                Math.max(1L, 60000L);
                return new q(pVar2, true, false);
            }
        }
        long j6 = pVarA.f129e;
        Math.max(0L, j6 > 0 ? Math.max(1L, j6 - j3) : 0L);
        return new q(pVarA, false, false);
    }

    /* JADX WARN: Failed to calculate best type for var: r15v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v0 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v1 ??, new type: long[]
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v2 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r2v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v4 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v11 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v7 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v0 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public static a1.d e(long r36, long r38, a2.p r40) {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.r.e(long, long, a2.p):a1.d");
    }

    /* JADX WARN: Code duplicated, block: B:69:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:? A[Catch: all -> 0x0054, SYNTHETIC, TRY_LEAVE, TryCatch #6 {all -> 0x0054, blocks: (B:20:0x0045, B:47:0x0078, B:46:0x0075, B:42:0x006f), top: B:73:0x0012, inners: #4 }] */
    public static q f(Context context, long j3, long j4, boolean z2) {
        long j5;
        long j6;
        boolean z3;
        Throwable th;
        Throwable th2;
        synchronized (f138b) {
            try {
                try {
                    try {
                        File fileI = i(context);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(j(context), "rw");
                        try {
                            try {
                                FileChannel channel = randomAccessFile.getChannel();
                                try {
                                    try {
                                        FileLock fileLockLock = channel.lock();
                                        try {
                                            p pVarN = n(fileI);
                                            f139c = pVarN;
                                            j5 = j3;
                                            j6 = j4;
                                            z3 = z2;
                                            try {
                                                q qVarD = d(j5, j6, z3, pVarN);
                                                if (qVarD.f134a) {
                                                    x(fileI, (p) qVarD.f136c);
                                                }
                                                f139c = (p) qVarD.f136c;
                                                if (fileLockLock != null) {
                                                    fileLockLock.close();
                                                }
                                                channel.close();
                                                randomAccessFile.close();
                                                return qVarD;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                Throwable th4 = th;
                                                if (fileLockLock == null) {
                                                    throw th4;
                                                }
                                                try {
                                                    fileLockLock.close();
                                                    throw th4;
                                                } catch (Throwable th5) {
                                                    th4.addSuppressed(th5);
                                                    throw th4;
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            j5 = j3;
                                            j6 = j4;
                                            z3 = z2;
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        th2 = th;
                                        if (channel != null) {
                                            throw th2;
                                        }
                                        try {
                                            channel.close();
                                            throw th2;
                                        } catch (Throwable th8) {
                                            th2.addSuppressed(th8);
                                            throw th2;
                                        }
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    j5 = j3;
                                    j6 = j4;
                                    z3 = z2;
                                    th2 = th;
                                    if (channel != null) {
                                        throw th2;
                                    }
                                    channel.close();
                                    throw th2;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                th = th;
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (Throwable th11) {
                                    th.addSuppressed(th11);
                                    throw th;
                                }
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            j5 = j3;
                            j6 = j4;
                            z3 = z2;
                            th = th;
                            randomAccessFile.close();
                            throw th;
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        Log.w("MeshRestartGate", "mesh repair confirmation unavailable; using fallback", th);
                        q qVarD2 = d(j5, j6, z3, f139c);
                        f139c = (p) qVarD2.f136c;
                        return qVarD2;
                    }
                } catch (Throwable th14) {
                    th = th14;
                    j5 = j3;
                    j6 = j4;
                    z3 = z2;
                    Log.w("MeshRestartGate", "mesh repair confirmation unavailable; using fallback", th);
                    q qVarD3 = d(j5, j6, z3, f139c);
                    f139c = (p) qVarD3.f136c;
                    return qVarD3;
                }
            } catch (Throwable th15) {
                throw th15;
            }
        }
    }

    public static String g(String str, long j3) {
        return "mesh-fuse-expiry:" + Math.max(1L, j3) + ":" + a(str);
    }

    public static p h(long j3, p pVar) {
        if (pVar == null || !pVar.f132h) {
            return pVar == null ? p.a(0L) : pVar;
        }
        return new p(pVar.f125a, pVar.f126b, pVar.f127c, 0L, v(j3, 60000L), false, pVar.f131g, true, false);
    }

    public static File i(Context context) {
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (contextCreateDeviceProtectedStorageContext != null) {
            context = contextCreateDeviceProtectedStorageContext;
        }
        File file = new File(context.getFilesDir(), "keepalive");
        if (file.exists() || file.mkdirs() || file.isDirectory()) {
            return new File(file, "mesh-restart-gate");
        }
        o2.k("cannot create gate directory");
        return null;
    }

    public static File j(Context context) {
        return new File(i(context).getParentFile(), "mesh-restart-gate.lock");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #1 {all -> 0x0041, blocks: (B:12:0x0010, B:14:0x001a, B:16:0x003a, B:36:0x007d, B:19:0x0044, B:25:0x0064, B:35:0x0079, B:54:0x009d, B:53:0x009a, B:50:0x0095, B:20:0x004f, B:24:0x0061, B:34:0x0076, B:49:0x0094, B:48:0x0091), top: B:65:0x0010, outer: #5, inners: #4, #6 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0061 A[Catch: all -> 0x006c, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x006c, blocks: (B:20:0x004f, B:24:0x0061, B:34:0x0076, B:49:0x0094, B:48:0x0091, B:45:0x008c, B:22:0x005b, B:33:0x0073, B:42:0x0086, B:43:0x0089, B:32:0x006f), top: B:71:0x004f, outer: #1, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:67:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean k(Context context) {
        p pVar;
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileLock fileLockTryLock;
        p pVarA;
        if (context == null) {
            return true;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        synchronized (f138b) {
            pVar = null;
            try {
                File fileI = i(context);
                if (fileI.exists()) {
                    randomAccessFile = new RandomAccessFile(j(context), "rw");
                    channel = randomAccessFile.getChannel();
                    fileLockTryLock = channel.tryLock(0L, Long.MAX_VALUE, true);
                    if (fileLockTryLock == null) {
                        channel.close();
                        randomAccessFile.close();
                    } else {
                        p pVarN = n(fileI);
                        fileLockTryLock.release();
                        channel.close();
                        randomAccessFile.close();
                        pVarA = pVarN;
                        f139c = pVarA;
                        pVar = pVarA;
                    }
                } else {
                    if (new File(fileI.getPath() + ".bak").exists()) {
                        randomAccessFile = new RandomAccessFile(j(context), "rw");
                        try {
                            channel = randomAccessFile.getChannel();
                            try {
                                fileLockTryLock = channel.tryLock(0L, Long.MAX_VALUE, true);
                                if (fileLockTryLock == null) {
                                    channel.close();
                                    randomAccessFile.close();
                                } else {
                                    try {
                                        p pVarN2 = n(fileI);
                                        fileLockTryLock.release();
                                        channel.close();
                                        randomAccessFile.close();
                                        pVarA = pVarN2;
                                    } catch (Throwable th) {
                                        fileLockTryLock.release();
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                if (channel == null) {
                                    throw th2;
                                }
                                try {
                                    channel.close();
                                    throw th2;
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                    throw th2;
                                }
                                Log.w("MeshRestartGate", "cross-process fuse state refresh unavailable", th);
                                if (pVar == null) {
                                    pVar = f139c;
                                }
                                return l(System.currentTimeMillis(), pVar);
                            }
                        } catch (Throwable th4) {
                            try {
                                randomAccessFile.close();
                                throw th4;
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                                throw th4;
                            }
                        }
                    } else {
                        pVarA = p.a(0L);
                    }
                    f139c = pVarA;
                    pVar = pVarA;
                }
            } catch (Throwable th6) {
                Log.w("MeshRestartGate", "cross-process fuse state refresh unavailable", th6);
            }
        }
        if (pVar == null) {
            pVar = f139c;
        }
        return l(System.currentTimeMillis(), pVar);
    }

    public static boolean l(long j3, p pVar) {
        if (pVar == null || pVar.f132h) {
            return false;
        }
        long j4 = pVar.f128d;
        return ((j4 > j3 ? 1 : (j4 == j3 ? 0 : -1)) > 0) || (pVar.f130f && (pVar.f129e > 0L ? 1 : (pVar.f129e == 0L ? 0 : -1)) > 0) || ((j4 > 0L ? 1 : (j4 == 0L ? 0 : -1)) > 0 && pVar.f127c >= 5);
    }

    public static boolean m(String str) {
        return str.startsWith("mesh-restart:") || str.startsWith("mesh-restart-trailing:") || str.startsWith("mesh-restart-essential:") || str.startsWith("mesh-restart-essential-trailing:") || str.startsWith("mesh-fuse-expiry:");
    }

    public static p n(File file) throws IOException {
        File file2 = new File(file.getPath() + ".bak");
        if (!file.exists() && !file2.exists()) {
            return p.a(0L);
        }
        FileInputStream fileInputStreamOpenRead = new AtomicFile(file).openRead();
        try {
            DataInputStream dataInputStream = new DataInputStream(fileInputStreamOpenRead);
            try {
                p pVarO = o(dataInputStream, fileInputStreamOpenRead.getChannel().size());
                dataInputStream.close();
                fileInputStreamOpenRead.close();
                return pVarO;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (fileInputStreamOpenRead != null) {
                try {
                    fileInputStreamOpenRead.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    public static p o(DataInputStream dataInputStream, long j3) throws IOException {
        if (j3 == 8) {
            long j4 = dataInputStream.readLong();
            return j4 > 0 ? new p(j4, j4, 1, 0L, 0L, false, 1L, false, false) : p.a(0L);
        }
        if (j3 < 40) {
            return p.a(0L);
        }
        long j5 = dataInputStream.readLong();
        int i3 = dataInputStream.readInt();
        if (j5 != 5567948084211700805L) {
            return p.a(0L);
        }
        long j6 = dataInputStream.readLong();
        long j7 = dataInputStream.readLong();
        int i4 = dataInputStream.readInt();
        long j8 = dataInputStream.readLong();
        if (i3 == 1) {
            return (j6 <= 0 || j7 <= 0 || i4 <= 0) ? p.a(0L) : new p(j6, j7, i4, Math.max(0L, j8), 0L, false, Math.max(1L, i4), false, false);
        }
        if ((i3 != 2 && i3 != 3 && i3 != 4) || j3 < 49) {
            return p.a(0L);
        }
        long j9 = dataInputStream.readLong();
        boolean z2 = dataInputStream.readBoolean();
        long jMax = (i3 < 3 || j3 < 58) ? Math.max(1L, i4) : dataInputStream.readLong();
        boolean z3 = i3 >= 3 && j3 >= 58 && dataInputStream.readBoolean();
        boolean z4 = i3 >= 4 && j3 >= 59 && dataInputStream.readBoolean();
        if (i4 == 0 && j9 == 0 && j8 == 0 && !z3) {
            return p.a(jMax);
        }
        return (j7 <= 0 || i4 <= 0 || j8 < 0 || j9 < 0 || jMax <= 0) ? p.a(0L) : new p(j6, j7, i4, j8, j9, z2, jMax, z3, z4);
    }

    public static void p(Context context, String str, q qVar) {
        p pVar = (p) qVar.f136c;
        long j3 = pVar.f129e;
        if (j3 <= 0) {
            return;
        }
        c2.p.B(-1, 20001, Math.max(1L, j3 - System.currentTimeMillis()), context, t(pVar.f131g, u(str), pVar.f130f));
    }

    public static void q(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String strA = a(str);
        try {
            f140d.execute(new k(0, context, strA));
        } catch (Throwable unused) {
            Log.w("MeshRestartGate", "mesh reconciliation queue full source=".concat(strA));
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x023f */
    /* JADX WARN: Code duplicated, block: B:186:0x0235 A[Catch: all -> 0x0233, TRY_LEAVE, TryCatch #7 {all -> 0x0233, blocks: (B:186:0x0235, B:183:0x022f, B:180:0x022a), top: B:215:0x022a, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x0255  */
    /* JADX WARN: Code duplicated, block: B:199:0x0258  */
    /* JADX WARN: Code duplicated, block: B:215:0x022a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void r(android.content.Context r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.r.r(android.content.Context, java.lang.String):void");
    }

    public static void s(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            f140d.execute(new m(context, 0));
        } catch (Throwable unused) {
            Log.w("MeshRestartGate", "mesh fuse restore queue full");
        }
    }

    public static String t(long j3, String str, boolean z2) {
        String str2 = Math.max(1L, j3) + ":" + a(str);
        return z2 ? "mesh-restart-essential:".concat(str2) : "mesh-restart:".concat(str2);
    }

    public static String u(String str) {
        String[] strArr = {"mesh-restart-essential-trailing:", "mesh-restart-trailing:", "mesh-restart-essential:", "mesh-restart:"};
        for (int i3 = 0; i3 < 4; i3++) {
            String str2 = strArr[i3];
            if (str.startsWith(str2)) {
                String strSubstring = str.substring(str2.length());
                int iIndexOf = strSubstring.indexOf(58);
                if (iIndexOf >= 0) {
                    strSubstring = strSubstring.substring(iIndexOf + 1);
                }
                return a(strSubstring);
            }
        }
        return "unknown";
    }

    public static long v(long j3, long j4) {
        if (j3 > Long.MAX_VALUE - j4) {
            return Long.MAX_VALUE;
        }
        return j3 + j4;
    }

    public static void w(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        String strA = a(str);
        try {
            f140d.execute(new k(1, context, strA));
        } catch (Throwable unused) {
            Log.w("MeshRestartGate", "mesh repair schedule queue full source=".concat(strA));
        }
    }

    public static void x(File file, p pVar) throws IOException {
        FileOutputStream fileOutputStreamStartWrite;
        AtomicFile atomicFile = new AtomicFile(file);
        try {
            fileOutputStreamStartWrite = atomicFile.startWrite();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStreamStartWrite);
                y(dataOutputStream, pVar);
                dataOutputStream.flush();
                atomicFile.finishWrite(fileOutputStreamStartWrite);
            } catch (IOException e3) {
                e = e3;
                if (fileOutputStreamStartWrite != null) {
                    atomicFile.failWrite(fileOutputStreamStartWrite);
                }
                throw e;
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStreamStartWrite = null;
        }
    }

    public static void y(DataOutputStream dataOutputStream, p pVar) throws IOException {
        dataOutputStream.writeLong(5567948084211700805L);
        dataOutputStream.writeInt(4);
        dataOutputStream.writeLong(pVar.f125a);
        dataOutputStream.writeLong(pVar.f126b);
        dataOutputStream.writeInt(pVar.f127c);
        dataOutputStream.writeLong(pVar.f128d);
        dataOutputStream.writeLong(pVar.f129e);
        dataOutputStream.writeBoolean(pVar.f130f);
        dataOutputStream.writeLong(pVar.f131g);
        dataOutputStream.writeBoolean(pVar.f132h);
        dataOutputStream.writeBoolean(pVar.f133i);
    }
}
