// EXTRAIDO POR REA; representacion smali; no es proyecto original.
// Evidencia: ev_d380aef9714d29f567f321447dbe7cd8e28302ed2fbee6cfcf047808f91c008a
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.cf', 'method_name': 'B'}

// [jadx java-decompile failed → smali]
// target: w1.cf.B
// markers: Code decompiled incorrectly, please refer to instructions dump
// (Java body was an anti-decompile stub; showing smali. Pass smali_fallback=false for the partial Java.)

.method public final B(Ljava/lang/String;)Ljava/lang/String;
    .registers 11

    .line 1
    iget-object p0, p0, Lw1/cf;->B0:Landroid/content/Context;

    .line 2
    .line 3
    if-nez p0, :cond_7

    .line 4
    .line 5
    const-string p0, "{\"error\":\"no_context\"}"

    .line 6
    .line 7
    return-object p0

    .line 8
    :cond_7
    sget-object v0, Lw1/z0;->a:Ljava/util/concurrent/atomic/AtomicReference;

    .line 9
    .line 10
    const-string v0, "{\"ok\":true,\"status\":\"committed\",\"path\":\""

    .line 11
    .line 12
    if-eqz p1, :cond_122

    .line 13
    .line 14
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    .line 15
    .line 16
    .line 17
    move-result v1

    .line 18
    if-eqz v1, :cond_15

    .line 19
    .line 20
    goto/16 :goto_122

    .line 21
    .line 22
    :cond_15
    new-instance v1, Ljava/io/File;

    .line 23
    .line 24
    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 25
    .line 26
    .line 27
    invoke-virtual {v1}, Ljava/io/File;->isFile()Z

    .line 28
    .line 29
    .line 30
    move-result v2

    .line 31
    const-string v3, "\"}"

    .line 32
    .line 33
    if-nez v2, :cond_38

    .line 34
    .line 35
    new-instance p0, Ljava/lang/StringBuilder;

    .line 36
    .line 37
    const-string v0, "{\"error\":\"not_found\",\"path\":\""

    .line 38
    .line 39
    invoke-direct {p0, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 40
    .line 41
    .line 42
    invoke-static {p1}, Lw1/z0;->b(Ljava/lang/String;)Ljava/lang/String;

    .line 43
    .line 44
    .line 45
    move-result-object p1

    .line 46
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 47
    .line 48
    .line 49
    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 50
    .line 51
    .line 52
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 53
    .line 54
    .line 55
    move-result-object p0

    .line 56
    return-object p0

    .line 57
    :cond_38
    invoke-virtual {v1}, Ljava/io/File;->length()J

    .line 58
    .line 59
    .line 60
    move-result-wide v4

    .line 61
    const-wide/16 v6, 0x0

    .line 62
    .line 63
    cmp-long v2, v4, v6

    .line 64
    .line 65
    if-lez v2, :cond_10a

    .line 66
    .line 67
    invoke-virtual {v1}, Ljava/io/File;->length()J

    .line 68
    .line 69
    .line 70
    move-result-wide v4

    .line 71
    const-wide/32 v6, 0x9600000

    .line 72
    .line 73
    .line 74
    cmp-long v2, v4, v6

    .line 75
    .line 76
    if-lez v2, :cond_4f

    .line 77
    .line 78
    goto/16 :goto_10a

    .line 79
    .line 80
    :cond_4f
    :try_start_4f
    invoke-virtual {p0}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    .line 81
    .line 82
    .line 83
    move-result-object v2

    .line 84
    invoke-virtual {v2}, Ljava/io/File;->getCanonicalFile()Ljava/io/File;

    .line 85
    .line 86
    .line 87
    move-result-object v2

    .line 88
    invoke-virtual {p0}, Landroid/content/Context;->getExternalCacheDir()Ljava/io/File;

    .line 89
    .line 90
    .line 91
    move-result-object v4

    .line 92
    invoke-virtual {v1}, Ljava/io/File;->getCanonicalFile()Ljava/io/File;

    .line 93
    .line 94
    .line 95
    move-result-object v5

    .line 96
    invoke-virtual {v5}, Ljava/io/File;->getPath()Ljava/lang/String;

    .line 97
    .line 98
    .line 99
    move-result-object v6

    .line 100
    new-instance v7, Ljava/lang/StringBuilder;

    .line 101
    .line 102
    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 103
    .line 104
    .line 105
    invoke-virtual {v2}, Ljava/io/File;->getPath()Ljava/lang/String;

    .line 106
    .line 107
    .line 108
    move-result-object v8

    .line 109
    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 110
    .line 111
    .line 112
    sget-object v8, Ljava/io/File;->separator:Ljava/lang/String;

    .line 113
    .line 114
    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    .line 116
    .line 117
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 118
    .line 119
    .line 120
    move-result-object v7

    .line 121
    invoke-virtual {v6, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 122
    .line 123
    .line 124
    move-result v6

    .line 125
    if-nez v6, :cond_ae

    .line 126
    .line 127
    invoke-virtual {v5, v2}, Ljava/io/File;->equals(Ljava/lang/Object;)Z

    .line 128
    .line 129
    .line 130
    move-result v2

    .line 131
    if-eqz v2, :cond_85

    .line 132
    .line 133
    goto :goto_ae

    .line 134
    :cond_85
    if-eqz v4, :cond_f4

    .line 135
    .line 136
    invoke-virtual {v4}, Ljava/io/File;->getCanonicalFile()Ljava/io/File;

    .line 137
    .line 138
    .line 139
    move-result-object v2

    .line 140
    invoke-virtual {v5}, Ljava/io/File;->getPath()Ljava/lang/String;

    .line 141
    .line 142
    .line 143
    move-result-object v4

    .line 144
    new-instance v6, Ljava/lang/StringBuilder;

    .line 145
    .line 146
    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 147
    .line 148
    .line 149
    invoke-virtual {v2}, Ljava/io/File;->getPath()Ljava/lang/String;

    .line 150
    .line 151
    .line 152
    move-result-object v7

    .line 153
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 154
    .line 155
    .line 156
    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 157
    .line 158
    .line 159
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 160
    .line 161
    .line 162
    move-result-object v6

    .line 163
    invoke-virtual {v4, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    .line 164
    .line 165
    .line 166
    move-result v4

    .line 167
    if-nez v4, :cond_ae

    .line 168
    .line 169
    invoke-virtual {v5, v2}, Ljava/io/File;->equals(Ljava/lang/Object;)Z

    .line 170
    .line 171
    .line 172
    move-result v2
    :try_end_ac
    .catch Ljava/io/IOException; {:try_start_4f .. :try_end_ac} :catch_f4

    .line 173
    if-eqz v2, :cond_f4

    .line 174
    .line 175
    :cond_ae
    :goto_ae
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    .line 176
    .line 177
    .line 178
    move-result-object v2

    .line 179
    invoke-virtual {v2}, Landroid/content/pm/PackageManager;->canRequestPackageInstalls()Z

    .line 180
    .line 181
    .line 182
    move-result v2

    .line 183
    if-nez v2, :cond_bb

    .line 184
    .line 185
    const-string p0, "{\"error\":\"need_unknown_sources\"}"

    .line 186
    .line 187
    return-object p0

    .line 188
    :cond_bb
    :try_start_bb
    invoke-static {p0, v1}, Lw1/z0;->a(Landroid/content/Context;Ljava/io/File;)V

    .line 189
    .line 190
    .line 191
    new-instance p0, Ljava/lang/StringBuilder;

    .line 192
    .line 193
    invoke-direct {p0, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 194
    .line 195
    .line 196
    invoke-static {p1}, Lw1/z0;->b(Ljava/lang/String;)Ljava/lang/String;

    .line 197
    .line 198
    .line 199
    move-result-object p1

    .line 200
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 201
    .line 202
    .line 203
    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 204
    .line 205
    .line 206
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 207
    .line 208
    .line 209
    move-result-object p0
    :try_end_d1
    .catch Ljava/lang/Exception; {:try_start_bb .. :try_end_d1} :catch_d2

    .line 210
    return-object p0

    .line 211
    :catch_d2
    move-exception p0

    .line 212
    const-string p1, "ApkInstall"

    .line 213
    .line 214
    const-string v0, "install failed"

    .line 215
    .line 216
    invoke-static {p1, v0, p0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 217
    .line 218
    .line 219
    new-instance p1, Ljava/lang/StringBuilder;

    .line 220
    .line 221
    const-string v0, "{\"error\":\""

    .line 222
    .line 223
    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 224
    .line 225
    .line 226
    invoke-virtual {p0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    .line 227
    .line 228
    .line 229
    move-result-object p0

    .line 230
    invoke-static {p0}, Lw1/z0;->b(Ljava/lang/String;)Ljava/lang/String;

    .line 231
    .line 232
    .line 233
    move-result-object p0

    .line 234
    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 235
    .line 236
    .line 237
    invoke-virtual {p1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 238
    .line 239
    .line 240
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 241
    .line 242
    .line 243
    move-result-object p0

    .line 244
    goto :goto_109

    .line 245
    :catch_f4
    :cond_f4
    new-instance p0, Ljava/lang/StringBuilder;

    .line 246
    .line 247
    const-string v0, "{\"error\":\"path_not_allowed\",\"path\":\""

    .line 248
    .line 249
    invoke-direct {p0, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 250
    .line 251
    .line 252
    invoke-static {p1}, Lw1/z0;->b(Ljava/lang/String;)Ljava/lang/String;

    .line 253
    .line 254
    .line 255
    move-result-object p1

    .line 256
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 257
    .line 258
    .line 259
    invoke-virtual {p0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 260
    .line 261
    .line 262
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 263
    .line 264
    .line 265
    move-result-object p0

    .line 266
    :goto_109
    return-object p0

    .line 267
    :cond_10a
    :goto_10a
    new-instance p0, Ljava/lang/StringBuilder;

    .line 268
    .line 269
    const-string p1, "{\"error\":\"size_invalid\",\"bytes\":"

    .line 270
    .line 271
    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 272
    .line 273
    .line 274
    invoke-virtual {v1}, Ljava/io/File;->length()J

    .line 275
    .line 276
    .line 277
    move-result-wide v0

    .line 278
    invoke-virtual {p0, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 279
    .line 280
    .line 281
    const-string p1, "}"

    .line 282
    .line 283
    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 284
    .line 285
    .line 286
    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 287
    .line 288
    .line 289
    move-result-object p0

    .line 290
    return-object p0

    .line 291
    :cond_122
    :goto_122
    const-string p0, "{\"error\":\"empty_path\"}"

    .line 292
    .line 293
    return-object p0
.end method
