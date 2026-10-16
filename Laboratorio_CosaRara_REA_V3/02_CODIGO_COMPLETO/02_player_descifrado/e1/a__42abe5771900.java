// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f692a = Logger.getLogger(a.class.getName());

    public static Object a(Object obj, ArrayList arrayList) {
        if (obj == null) {
            return null;
        }
        boolean z2 = obj instanceof byte[];
        Logger logger = f692a;
        if (z2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_placeholder", true);
                jSONObject.put("num", arrayList.size());
                arrayList.add((byte[]) obj);
                return jSONObject;
            } catch (JSONException e3) {
                logger.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e3);
                return null;
            }
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    jSONArray.put(i3, a(jSONArray2.get(i3), arrayList));
                } catch (JSONException e4) {
                    logger.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e4);
                    return null;
                }
            }
            return jSONArray;
        }
        if (!(obj instanceof JSONObject)) {
            return obj;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject3.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject2.put(next, a(jSONObject3.get(next), arrayList));
            } catch (JSONException e5) {
                logger.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e5);
                return null;
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [org.json.JSONObject] */
    public static Object b(Object obj, byte[][] bArr) {
        boolean z2 = obj instanceof JSONArray;
        Logger logger = f692a;
        if (z2) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    jSONArray.put(i3, b(jSONArray.get(i3), bArr));
                } catch (JSONException e3) {
                    logger.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e3);
                    return null;
                }
            }
            return jSONArray;
        }
        if (obj instanceof JSONObject) {
            obj = (JSONObject) obj;
            if (obj.optBoolean("_placeholder")) {
                int iOptInt = obj.optInt("num", -1);
                if (iOptInt < 0 || iOptInt >= bArr.length) {
                    return null;
                }
                return bArr[iOptInt];
            }
            Iterator<String> itKeys = obj.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    obj.put(next, b(obj.get(next), bArr));
                } catch (JSONException e4) {
                    logger.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e4);
                    return null;
                }
            }
        }
        return obj;
    }
}
