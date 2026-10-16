// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c1;

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
    public static final Logger f398a = Logger.getLogger(a.class.getName());

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof byte[]) {
            return true;
        }
        boolean z2 = obj instanceof JSONArray;
        Logger logger = f398a;
        if (z2) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    if (a(jSONArray.isNull(i3) ? null : jSONArray.get(i3))) {
                        return true;
                    }
                } catch (JSONException e3) {
                    logger.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e3);
                    return false;
                }
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    if (a(jSONObject.get(itKeys.next()))) {
                        return true;
                    }
                } catch (JSONException e4) {
                    logger.log(Level.WARNING, "An error occured while retrieving data from JSONObject", (Throwable) e4);
                }
            }
        }
        return false;
    }
}
