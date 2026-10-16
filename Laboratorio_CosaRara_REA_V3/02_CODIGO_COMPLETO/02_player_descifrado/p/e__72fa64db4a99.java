// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2841b = m.f("Data");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f2842c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2843a;

    static {
        e eVar = new e(new HashMap());
        b(eVar);
        f2842c = eVar;
    }

    public e(e eVar) {
        this.f2843a = new HashMap(eVar.f2843a);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static e a(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        Throwable e3;
        String str = f2841b;
        if (bArr.length > 10240) {
            o2.k("Data cannot occupy more than 10240 bytes when serialized");
            return null;
        }
        HashMap map = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                try {
                    for (int i3 = objectInputStream.readInt(); i3 > 0; i3--) {
                        map.put(objectInputStream.readUTF(), objectInputStream.readObject());
                    }
                } catch (IOException | ClassNotFoundException e4) {
                    e3 = e4;
                    Log.e(str, "Error in Data#fromByteArray: ", e3);
                    if (objectInputStream != null) {
                    }
                    byteArrayInputStream.close();
                    return new e(map);
                }
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                        Log.e(str, "Error in Data#fromByteArray: ", e5);
                    }
                }
                try {
                    byteArrayInputStream.close();
                    throw th;
                } catch (IOException e6) {
                    Log.e(str, "Error in Data#fromByteArray: ", e6);
                    throw th;
                }
            }
        } catch (IOException | ClassNotFoundException e7) {
            objectInputStream = null;
            e3 = e7;
        } catch (Throwable th3) {
            objectInputStream = null;
            th = th3;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        try {
            objectInputStream.close();
        } catch (IOException e8) {
            Log.e(str, "Error in Data#fromByteArray: ", e8);
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e9) {
            Log.e(str, "Error in Data#fromByteArray: ", e9);
        }
        return new e(map);
    }

    public static byte[] b(e eVar) throws Throwable {
        String str = f2841b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(eVar.f2843a.size());
                    for (Map.Entry entry : eVar.f2843a.entrySet()) {
                        objectOutputStream2.writeUTF((String) entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e3) {
                        Log.e(str, "Error in Data#toByteArray: ", e3);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        Log.e(str, "Error in Data#toByteArray: ", e4);
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    o2.k("Data cannot occupy more than 10240 bytes when serialized");
                    return null;
                } catch (IOException e5) {
                    e = e5;
                    objectOutputStream = objectOutputStream2;
                    Log.e(str, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e6) {
                            Log.e(str, "Error in Data#toByteArray: ", e6);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e7) {
                        Log.e(str, "Error in Data#toByteArray: ", e7);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e8) {
                            Log.e(str, "Error in Data#toByteArray: ", e8);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e9) {
                        Log.e(str, "Error in Data#toByteArray: ", e9);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e = e10;
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && e.class == obj.getClass()) {
                HashMap map = ((e) obj).f2843a;
                HashMap map2 = this.f2843a;
                Set<String> setKeySet = map2.keySet();
                if (setKeySet.equals(map.keySet())) {
                    for (String str : setKeySet) {
                        Object obj2 = map2.get(str);
                        Object obj3 = map.get(str);
                        if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f2843a.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        HashMap map = this.f2843a;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = map.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public e(HashMap map) {
        this.f2843a = new HashMap(map);
    }
}
