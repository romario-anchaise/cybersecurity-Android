// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f3125a = new Object[0];

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int b(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 == i4 ? 0 : 1;
    }

    public static void c(String str) {
        h1.a aVar = new h1.a(a0.a.h("lateinit property ", str, " has not been initialized"));
        String name = e.class.getName();
        StackTraceElement[] stackTrace = aVar.getStackTrace();
        int length = stackTrace.length;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            if (name.equals(stackTrace[i4].getClassName())) {
                i3 = i4;
            }
        }
        aVar.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i3 + 1, length));
        throw aVar;
    }

    public static final Object[] d(Collection collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    objArrCopyOf[i3] = it.next();
                    if (i4 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i5 = ((i4 * 3) + 1) >>> 1;
                        if (i5 <= i4) {
                            i5 = 2147483645;
                            if (i4 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i5);
                    } else if (!it.hasNext()) {
                        return Arrays.copyOf(objArrCopyOf, i4);
                    }
                    i3 = i4;
                }
            }
        }
        return f3125a;
    }

    public static final Object[] e(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        int size = collection.size();
        int i3 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    objNewInstance.getClass();
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i4 = i3 + 1;
                    objArrCopyOf[i3] = it.next();
                    if (i4 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i5 = ((i4 * 3) + 1) >>> 1;
                        if (i5 <= i4) {
                            i5 = 2147483645;
                            if (i4 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i5);
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf != objArr) {
                            return Arrays.copyOf(objArrCopyOf, i4);
                        }
                        objArr[i4] = null;
                        return objArr;
                    }
                    i3 = i4;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }
}
