// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_6399a7c40462b76b43728f0f99388843aca6f0ee0a28c1f6ab4d3266115a95e9
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.y2', 'method_name': 'E'}

public final void E(ArrayList arrayList) {
    if (arrayList.isEmpty()) {
        return;
    }
    SQLiteDatabase writableDatabase = getWritableDatabase();
    writableDatabase.beginTransaction();
    try {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_state", (Integer) 1);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str = (String) obj;
            if (str != null && !str.isEmpty()) {
                writableDatabase.update("commitments", contentValues, "id=? AND sync_state=?", new String[]{str, String.valueOf(0)});
            }
        }
        writableDatabase.setTransactionSuccessful();
    } finally {
        writableDatabase.endTransaction();
    }
}
