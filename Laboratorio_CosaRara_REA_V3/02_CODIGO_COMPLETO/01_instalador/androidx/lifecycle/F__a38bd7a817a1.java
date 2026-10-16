// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class F {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Class[] f1636f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f1638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f1640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Q.d f1641e;

    public F(HashMap map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f1637a = linkedHashMap;
        this.f1638b = new LinkedHashMap();
        this.f1639c = new LinkedHashMap();
        this.f1640d = new LinkedHashMap();
        this.f1641e = new androidx.activity.b(1, this);
        linkedHashMap.putAll(map);
    }

    public static Bundle a(F f2) {
        F0.i.e(f2, "this$0");
        Iterator it = p036u0.q.r(f2.f1638b).entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap = f2.f1637a;
            int i2 = 0;
            if (!zHasNext) {
                Set<String> setKeySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : setKeySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                p034t0.d[] dVarArr = {new p034t0.d("keys", arrayList), new p034t0.d("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                while (i2 < 2) {
                    p034t0.d dVar = dVarArr[i2];
                    String str2 = (String) dVar.f4126a;
                    Object obj = dVar.f4127b;
                    if (obj == null) {
                        bundle.putString(str2, null);
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Byte) {
                        bundle.putByte(str2, ((Number) obj).byteValue());
                    } else if (obj instanceof Character) {
                        bundle.putChar(str2, ((Character) obj).charValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Number) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(str2, ((Number) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Number) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Number) obj).longValue());
                    } else if (obj instanceof Short) {
                        bundle.putShort(str2, ((Number) obj).shortValue());
                    } else if (obj instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) obj);
                    } else if (obj instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) obj);
                    } else if (obj instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) obj);
                    } else if (obj instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) obj);
                    } else if (obj instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) obj);
                    } else if (obj instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) obj);
                    } else if (obj instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) obj);
                    } else if (obj instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) obj);
                    } else if (obj instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) obj);
                    } else if (obj instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) obj);
                    } else if (obj instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) obj);
                    } else if (obj instanceof Object[]) {
                        Class<?> componentType = obj.getClass().getComponentType();
                        F0.i.b(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) obj);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) obj);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) obj);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                            }
                            bundle.putSerializable(str2, (Serializable) obj);
                        }
                    } else if (obj instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) obj);
                    } else if (obj instanceof IBinder) {
                        p039w.c.a(bundle, str2, (IBinder) obj);
                    } else if (obj instanceof Size) {
                        p039w.d.a(bundle, str2, (Size) obj);
                    } else {
                        if (!(obj instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                        p039w.d.b(bundle, str2, (SizeF) obj);
                    }
                    i2++;
                }
                return bundle;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str3 = (String) entry.getKey();
            Bundle bundleA = ((Q.d) entry.getValue()).a();
            F0.i.e(str3, "key");
            if (bundleA != null) {
                Class[] clsArr = f1636f;
                while (true) {
                    if (i2 >= 29) {
                        throw new IllegalArgumentException("Can't put value with type " + bundleA.getClass() + " into saved state");
                    }
                    Class cls = clsArr[i2];
                    F0.i.b(cls);
                    if (cls.isInstance(bundleA)) {
                        break;
                    }
                    i2++;
                }
            }
            f2.f1639c.get(str3);
            linkedHashMap.put(str3, bundleA);
            P0.a aVar = (P0.a) f2.f1640d.get(str3);
            if (aVar != null) {
                ((P0.b) aVar).a(bundleA);
            }
        }
    }

    public F() {
        this.f1637a = new LinkedHashMap();
        this.f1638b = new LinkedHashMap();
        this.f1639c = new LinkedHashMap();
        this.f1640d = new LinkedHashMap();
        this.f1641e = new androidx.activity.b(1, this);
    }
}
