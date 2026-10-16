// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1701a;

    public o0(int i3) {
        switch (i3) {
            case 1:
                this.f1701a = new HashMap();
                break;
            default:
                this.f1701a = new HashMap();
                break;
        }
    }

    public synchronized void a() {
        this.f1701a.clear();
    }

    public void b(HashMap map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            HashMap map2 = this.f1701a;
            if (value == null) {
                map2.put(str, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    map2.put(str, value);
                } else {
                    int i3 = 0;
                    if (cls == boolean[].class) {
                        boolean[] zArr = (boolean[]) value;
                        String str2 = p.e.f2841b;
                        Boolean[] boolArr = new Boolean[zArr.length];
                        while (i3 < zArr.length) {
                            boolArr[i3] = Boolean.valueOf(zArr[i3]);
                            i3++;
                        }
                        map2.put(str, boolArr);
                    } else if (cls == byte[].class) {
                        byte[] bArr = (byte[]) value;
                        String str3 = p.e.f2841b;
                        Byte[] bArr2 = new Byte[bArr.length];
                        while (i3 < bArr.length) {
                            bArr2[i3] = Byte.valueOf(bArr[i3]);
                            i3++;
                        }
                        map2.put(str, bArr2);
                    } else if (cls == int[].class) {
                        int[] iArr = (int[]) value;
                        String str4 = p.e.f2841b;
                        Integer[] numArr = new Integer[iArr.length];
                        while (i3 < iArr.length) {
                            numArr[i3] = Integer.valueOf(iArr[i3]);
                            i3++;
                        }
                        map2.put(str, numArr);
                    } else if (cls == long[].class) {
                        long[] jArr = (long[]) value;
                        String str5 = p.e.f2841b;
                        Long[] lArr = new Long[jArr.length];
                        while (i3 < jArr.length) {
                            lArr[i3] = Long.valueOf(jArr[i3]);
                            i3++;
                        }
                        map2.put(str, lArr);
                    } else if (cls == float[].class) {
                        float[] fArr = (float[]) value;
                        String str6 = p.e.f2841b;
                        Float[] fArr2 = new Float[fArr.length];
                        while (i3 < fArr.length) {
                            fArr2[i3] = Float.valueOf(fArr[i3]);
                            i3++;
                        }
                        map2.put(str, fArr2);
                    } else {
                        if (cls != double[].class) {
                            throw new IllegalArgumentException("Key " + str + "has invalid type " + cls);
                        }
                        double[] dArr = (double[]) value;
                        String str7 = p.e.f2841b;
                        Double[] dArr2 = new Double[dArr.length];
                        while (i3 < dArr.length) {
                            dArr2[i3] = Double.valueOf(dArr[i3]);
                            i3++;
                        }
                        map2.put(str, dArr2);
                    }
                }
            }
        }
    }
}
