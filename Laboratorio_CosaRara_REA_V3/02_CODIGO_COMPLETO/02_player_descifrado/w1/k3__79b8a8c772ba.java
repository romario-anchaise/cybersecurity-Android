// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k3 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f4387c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static k3 f4388d;

    public static long E(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("metadata", new String[]{"value"}, "key=?", new String[]{str}, null, null, null, "1");
        try {
            long jMax = cursorQuery.moveToFirst() ? Math.max(0L, cursorQuery.getLong(0)) : 0L;
            cursorQuery.close();
            return jMax;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public static void F(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            Cursor cursorQuery = sQLiteDatabase.query("incidents", new String[]{"occurred_at_ms", "payload"}, "event_id=?", new String[]{str}, null, null, null, "1");
            try {
                if (cursorQuery.moveToFirst()) {
                    G(sQLiteDatabase, str, cursorQuery.getLong(0), cursorQuery.getString(1));
                    I(sQLiteDatabase, "reconnect_episode_membership_upgrades", "event_id", "occurred_at_ms");
                }
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            Log.e("DisconnectIncident", "retain episode membership debt failed", th3);
            throw new SQLiteException("retain episode membership debt failed: ".concat(th3.getClass().getSimpleName()));
        }
    }

    public static void G(SQLiteDatabase sQLiteDatabase, String str, long j3, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.optInt("version", 1) == 2 && N(jSONObject.optString("reconnectInstabilityEpisodeId", "")) && jSONObject.optLong("episodeOpenedAtMs", 0L) > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("event_id", str);
                contentValues.put("occurred_at_ms", Long.valueOf(j3));
                contentValues.put("payload", str2);
                contentValues.put("sync_state", (Integer) 0);
                sQLiteDatabase.insertWithOnConflict("reconnect_episode_membership_upgrades", null, contentValues, 4);
            }
        } catch (Throwable th) {
            Log.e("DisconnectIncident", "retain episode membership debt failed", th);
            throw new SQLiteException("retain episode membership debt failed: ".concat(th.getClass().getSimpleName()));
        }
    }

    public static String H(String str) {
        String lowerCase = str.trim().toLowerCase();
        return lowerCase.matches("[a-z0-9_]{1,64}") ? lowerCase : "permanent_reject";
    }

    public static void I(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM ".concat(str), null);
        try {
            int i3 = 0;
            int i4 = cursorRawQuery.moveToFirst() ? cursorRawQuery.getInt(0) : 0;
            cursorRawQuery.close();
            int iMax = Math.max(0, i4 - 50);
            if (iMax == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(iMax);
            Cursor cursorQuery = sQLiteDatabase.query(str, new String[]{str2, "sync_state"}, null, null, null, null, "CASE WHEN sync_state=0 THEN 1 ELSE 0 END ASC, " + str3 + " ASC, " + str2 + " ASC", String.valueOf(iMax));
            int i5 = 0;
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(cursorQuery.getString(0));
                    if (cursorQuery.getInt(1) == 0) {
                        i5++;
                    }
                } catch (Throwable th) {
                    if (cursorQuery == null) {
                        throw th;
                    }
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            cursorQuery.close();
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                sQLiteDatabase.delete(str, str2.concat("=?"), new String[]{(String) obj});
            }
            if (i5 > 0) {
                O(sQLiteDatabase, "episode_debt_omitted_count", E(sQLiteDatabase, "episode_debt_omitted_count") + ((long) i5));
                Log.w("DisconnectIncident", "episode sync debt omitted count=" + i5);
            }
        } catch (Throwable th3) {
            if (cursorRawQuery == null) {
                throw th3;
            }
            try {
                cursorRawQuery.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static void J(SQLiteDatabase sQLiteDatabase) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM incidents", null);
        try {
            int i3 = 0;
            int iMax = cursorRawQuery.moveToFirst() ? Math.max(0, cursorRawQuery.getInt(0) - 50) : 0;
            cursorRawQuery.close();
            if (iMax == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(iMax);
            Cursor cursorQuery = sQLiteDatabase.query("incidents", new String[]{"event_id", "sync_state"}, null, null, null, null, "occurred_at_ms ASC, event_id ASC", String.valueOf(iMax));
            int i4 = 0;
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(cursorQuery.getString(0));
                    if (cursorQuery.getInt(1) == 0) {
                        i4++;
                    }
                } catch (Throwable th) {
                    if (cursorQuery == null) {
                        throw th;
                    }
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            cursorQuery.close();
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                sQLiteDatabase.delete("incidents", "event_id=?", new String[]{(String) obj});
            }
            if (i4 > 0) {
                O(sQLiteDatabase, "dropped_count", E(sQLiteDatabase, "dropped_count") + ((long) i4));
            }
        } catch (Throwable th3) {
            if (cursorRawQuery == null) {
                throw th3;
            }
            try {
                cursorRawQuery.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static boolean N(String str) {
        return str != null && str.matches("repi:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
    }

    public static void O(SQLiteDatabase sQLiteDatabase, String str, long j3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str);
        contentValues.put("value", Long.valueOf(Math.max(0L, j3)));
        sQLiteDatabase.insertWithOnConflict("metadata", null, contentValues, 5);
    }

    public static k3 z(Context context) {
        k3 k3Var;
        synchronized (f4387c) {
            try {
                if (f4388d == null) {
                    f4388d = new k3(context.getApplicationContext(), "disconnect_incidents.db", null, 3);
                }
                k3Var = f4388d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return k3Var;
    }

    public final y.c A() {
        try {
            Cursor cursorQuery = getReadableDatabase().query("incidents", new String[]{"event_id", "occurred_at_ms", "payload"}, "sync_state=?", new String[]{String.valueOf(0)}, null, null, "occurred_at_ms ASC, event_id ASC", "1");
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                String string = cursorQuery.getString(0);
                cursorQuery.getLong(1);
                y.c cVar = new y.c(string, new JSONObject(cursorQuery.getString(2)), 10);
                cursorQuery.close();
                return cVar;
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            Log.e("DisconnectIncident", "read pending failed", th3);
            return null;
        }
        Log.e("DisconnectIncident", "read pending failed", th3);
        return null;
    }

    public final j3 B() {
        Cursor cursorQuery = getReadableDatabase().query("reconnect_episode_closes", new String[]{"episode_id", "opened_at_ms", "closed_at_ms"}, "sync_state=?", new String[]{String.valueOf(0)}, null, null, "closed_at_ms ASC, episode_id ASC", "1");
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            j3 j3Var = new j3(cursorQuery.getLong(1), cursorQuery.getLong(2), cursorQuery.getString(0));
            cursorQuery.close();
            return j3Var;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public final y.e C() {
        try {
            Cursor cursorQuery = getReadableDatabase().query("reconnect_episode_membership_upgrades", new String[]{"event_id", "occurred_at_ms", "payload"}, "sync_state=?", new String[]{String.valueOf(0)}, null, null, "occurred_at_ms ASC, event_id ASC", "1");
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return null;
                }
                String string = cursorQuery.getString(0);
                cursorQuery.getLong(1);
                y.e eVar = new y.e(string, new JSONObject(cursorQuery.getString(2)));
                cursorQuery.close();
                return eVar;
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            Log.e("DisconnectIncident", "read pending episode membership failed", th3);
            return null;
        }
        Log.e("DisconnectIncident", "read pending episode membership failed", th3);
        return null;
    }

    public final synchronized d0.d D(long j3) {
        long jMax = Math.max(1L, j3);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Cursor cursorQuery = writableDatabase.query("reconnect_episode_state", new String[]{"episode_id", "opened_at_ms"}, "singleton=1", null, null, null, null, "1");
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(0);
                    long j4 = cursorQuery.getLong(1);
                    if (N(string) && j4 > 0) {
                        writableDatabase.setTransactionSuccessful();
                        d0.d dVar = new d0.d(string, j4);
                        cursorQuery.close();
                        writableDatabase.endTransaction();
                        return dVar;
                    }
                }
                cursorQuery.close();
                writableDatabase.delete("reconnect_episode_state", null, null);
                String str = "repi:" + UUID.randomUUID();
                ContentValues contentValues = new ContentValues();
                contentValues.put("singleton", (Integer) 1);
                contentValues.put("episode_id", str);
                contentValues.put("opened_at_ms", Long.valueOf(jMax));
                writableDatabase.insertOrThrow("reconnect_episode_state", null, contentValues);
                writableDatabase.setTransactionSuccessful();
                d0.d dVar2 = new d0.d(str, jMax);
                writableDatabase.endTransaction();
                return dVar2;
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            throw th3;
        }
    }

    public final void K(int i3, String str, String str2) {
        if (N(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", Integer.valueOf(i3));
            contentValues.put("rejection_reason", str2);
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.update("reconnect_episode_closes", contentValues, "episode_id=? AND sync_state=?", new String[]{str, String.valueOf(0)});
            I(writableDatabase, "reconnect_episode_closes", "episode_id", "closed_at_ms");
        }
    }

    public final void L(int i3, String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_state", Integer.valueOf(i3));
        contentValues.put("rejection_reason", str2);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.update("reconnect_episode_membership_upgrades", contentValues, "event_id=? AND sync_state=?", new String[]{str, String.valueOf(0)});
        I(writableDatabase, "reconnect_episode_membership_upgrades", "event_id", "occurred_at_ms");
    }

    public final void M(String str, int i3, String str2, long j3, boolean z2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_state", Integer.valueOf(i3));
            contentValues.put("rejection_reason", str2);
            int iUpdate = writableDatabase.update("incidents", contentValues, "event_id=? AND sync_state=?", new String[]{str, String.valueOf(0)});
            if (iUpdate > 0 && j3 > 0) {
                O(writableDatabase, "dropped_count", Math.max(0L, E(writableDatabase, "dropped_count") - j3));
            }
            if (iUpdate > 0 && z2) {
                F(writableDatabase, str);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final synchronized d0.d d() {
        Cursor cursorQuery = getReadableDatabase().query("reconnect_episode_state", new String[]{"episode_id", "opened_at_ms"}, "singleton=1", null, null, null, null, "1");
        try {
            d0.d dVar = null;
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(0);
            long j3 = cursorQuery.getLong(1);
            if (N(string) && j3 > 0) {
                dVar = new d0.d(string, j3);
            }
            cursorQuery.close();
            return dVar;
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            try {
                cursorQuery.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
        throw th;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS incidents (event_id TEXT PRIMARY KEY NOT NULL,occurred_at_ms INTEGER NOT NULL,payload TEXT NOT NULL,sync_state INTEGER NOT NULL DEFAULT 0,rejection_reason TEXT NOT NULL DEFAULT '')");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS disconnect_incidents_pending_idx ON incidents (sync_state, occurred_at_ms)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS metadata (key TEXT PRIMARY KEY NOT NULL,value INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reconnect_episode_state (singleton INTEGER PRIMARY KEY NOT NULL CHECK(singleton=1),episode_id TEXT NOT NULL,opened_at_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reconnect_episode_closes (episode_id TEXT PRIMARY KEY NOT NULL,opened_at_ms INTEGER NOT NULL,closed_at_ms INTEGER NOT NULL,sync_state INTEGER NOT NULL DEFAULT 0,rejection_reason TEXT NOT NULL DEFAULT '')");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS reconnect_episode_closes_pending_idx ON reconnect_episode_closes (sync_state, closed_at_ms)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reconnect_episode_membership_upgrades (event_id TEXT PRIMARY KEY NOT NULL,occurred_at_ms INTEGER NOT NULL,payload TEXT NOT NULL,sync_state INTEGER NOT NULL DEFAULT 0,rejection_reason TEXT NOT NULL DEFAULT '')");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS reconnect_episode_memberships_pending_idx ON reconnect_episode_membership_upgrades (sync_state, occurred_at_ms, event_id)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        if (i3 < 2 && i4 >= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reconnect_episode_state (singleton INTEGER PRIMARY KEY NOT NULL CHECK(singleton=1),episode_id TEXT NOT NULL,opened_at_ms INTEGER NOT NULL)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reconnect_episode_closes (episode_id TEXT PRIMARY KEY NOT NULL,opened_at_ms INTEGER NOT NULL,closed_at_ms INTEGER NOT NULL,sync_state INTEGER NOT NULL DEFAULT 0,rejection_reason TEXT NOT NULL DEFAULT '')");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS reconnect_episode_closes_pending_idx ON reconnect_episode_closes (sync_state, closed_at_ms)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reconnect_episode_membership_upgrades (event_id TEXT PRIMARY KEY NOT NULL,occurred_at_ms INTEGER NOT NULL,payload TEXT NOT NULL,sync_state INTEGER NOT NULL DEFAULT 0,rejection_reason TEXT NOT NULL DEFAULT '')");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS reconnect_episode_memberships_pending_idx ON reconnect_episode_membership_upgrades (sync_state, occurred_at_ms, event_id)");
        }
        if (i3 < 3 && i4 >= 3) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS reconnect_episode_membership_upgrades (event_id TEXT PRIMARY KEY NOT NULL,occurred_at_ms INTEGER NOT NULL,payload TEXT NOT NULL,sync_state INTEGER NOT NULL DEFAULT 0,rejection_reason TEXT NOT NULL DEFAULT '')");
            sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS reconnect_episode_memberships_pending_idx ON reconnect_episode_membership_upgrades (sync_state, occurred_at_ms, event_id)");
            Cursor cursorQuery = sQLiteDatabase.query("incidents", new String[]{"event_id", "occurred_at_ms", "payload"}, "sync_state=?", new String[]{String.valueOf(1)}, null, null, "occurred_at_ms ASC, event_id ASC");
            while (cursorQuery.moveToNext()) {
                try {
                    G(sQLiteDatabase, cursorQuery.getString(0), cursorQuery.getLong(1), cursorQuery.getString(2));
                } catch (Throwable th) {
                    if (cursorQuery == null) {
                        throw th;
                    }
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            cursorQuery.close();
            I(sQLiteDatabase, "reconnect_episode_membership_upgrades", "event_id", "occurred_at_ms");
        }
        if (i4 > 3) {
            throw new SQLiteException(a0.a.g("unsupported disconnect incident version ", i4));
        }
    }

    public final synchronized boolean w(String str, long j3) {
        if (N(str) && j3 > 0) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                Cursor cursorQuery = writableDatabase.query("reconnect_episode_state", new String[]{"episode_id", "opened_at_ms"}, "singleton=1", null, null, null, null, "1");
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        writableDatabase.endTransaction();
                        return false;
                    }
                    String string = cursorQuery.getString(0);
                    long j4 = cursorQuery.getLong(1);
                    cursorQuery.close();
                    if (str.equals(string) && j3 >= j4) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("episode_id", string);
                        contentValues.put("opened_at_ms", Long.valueOf(j4));
                        contentValues.put("closed_at_ms", Long.valueOf(j3));
                        contentValues.put("sync_state", (Integer) 0);
                        writableDatabase.insertWithOnConflict("reconnect_episode_closes", null, contentValues, 4);
                        writableDatabase.delete("reconnect_episode_state", "singleton=1 AND episode_id=?", new String[]{string});
                        I(writableDatabase, "reconnect_episode_closes", "episode_id", "closed_at_ms");
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        return true;
                    }
                    writableDatabase.endTransaction();
                    return false;
                } catch (Throwable th) {
                    if (cursorQuery == null) {
                        throw th;
                    }
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                writableDatabase.endTransaction();
                throw th3;
            }
            writableDatabase.endTransaction();
            throw th3;
        }
        return false;
    }

    public final boolean y(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("eventId", "");
                long jOptLong = jSONObject.optLong("occurredAtMs", 0L);
                if (!strOptString.isEmpty() && jOptLong > 0) {
                    String strSubstring = g3.a(jSONObject, 0L).substring(27);
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransaction();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("event_id", strOptString);
                        contentValues.put("occurred_at_ms", Long.valueOf(jOptLong));
                        contentValues.put("payload", strSubstring);
                        contentValues.put("sync_state", (Integer) 0);
                        if (writableDatabase.insertWithOnConflict("incidents", null, contentValues, 4) < 0) {
                            return false;
                        }
                        J(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        return true;
                    } finally {
                        writableDatabase.endTransaction();
                    }
                }
            } catch (Throwable th) {
                Log.e("DisconnectIncident", "enqueue failed", th);
                return false;
            }
        }
        return false;
    }
}
