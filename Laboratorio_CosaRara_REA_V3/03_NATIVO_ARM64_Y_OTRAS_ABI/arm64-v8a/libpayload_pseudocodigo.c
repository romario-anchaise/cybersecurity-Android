/* Pseudocode reconstructed by Ghidra, NOT original C/C++ source. Static analysis only. */
/* Language: AARCH64:LE:64:v8A */

/* 00100aec _FINI_1 */

void _FINI_1(void)

{
  __cxa_finalize(&PTR_LOOP_00105870);
  return;
}



/* 00100afc FUN_00100afc */

void FUN_00100afc(void)

{
  return;
}



/* 00100b04 _FINI_0 */

void _FINI_0(void)

{
  FUN_00100afc();
  return;
}



/* 00100b0c FUN_00100b0c */

void FUN_00100b0c(code *UNRECOVERED_JUMPTABLE)

{
  if (UNRECOVERED_JUMPTABLE != (code *)0x0) {
                    /* WARNING: Could not recover jumptable at 0x00100b18. Too many branches */
                    /* WARNING: Treating indirect jump as call */
    (*UNRECOVERED_JUMPTABLE)();
    return;
  }
  return;
}



/* 00100b20 FUN_00100b20 */

void FUN_00100b20(undefined8 param_1)

{
  __cxa_atexit(FUN_00100b0c,param_1,&PTR_LOOP_00105870);
  return;
}



/* 00100b3c FUN_00100b3c */

void FUN_00100b3c(void)

{
  __register_atfork();
  return;
}



/* 00100b4c Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeAesCbcDecrypt */

void Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeAesCbcDecrypt
               (long *param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4,
               undefined8 param_5)

{
  long lVar1;
  uint uVar2;
  int iVar3;
  int iVar4;
  long lVar5;
  long lVar6;
  long lVar7;
  long lVar8;
  ulong uVar9;
  undefined1 auStack_118 [176];
  long local_68;
  
  lVar1 = tpidr_el0;
  local_68 = *(long *)(lVar1 + 0x28);
  uVar2 = (**(code **)(*param_1 + 0x558))(param_1,param_3);
  iVar3 = (**(code **)(*param_1 + 0x558))(param_1,param_4);
  iVar4 = (**(code **)(*param_1 + 0x558))(param_1,param_5);
  if (0 < (int)uVar2) {
    lVar5 = 0;
    if ((((uVar2 & 0xf) != 0) || (iVar3 != 0x10)) || (iVar4 != 0x10)) goto LAB_00100d80;
    lVar6 = (**(code **)(*param_1 + 0x5c0))(param_1,param_3,0);
    lVar7 = (**(code **)(*param_1 + 0x5c0))(param_1,param_4,0);
    lVar8 = (**(code **)(*param_1 + 0x5c0))(param_1,param_5,0);
    if (((lVar6 != 0) && (lVar7 != 0)) && (lVar8 != 0)) {
      FUN_00100fb0(lVar8,auStack_118);
      FUN_001016d4(auStack_118,lVar7,lVar6,uVar2);
      uVar9 = FUN_00101750(lVar6,uVar2);
      lVar5 = (**(code **)(*param_1 + 0x580))(param_1,uVar9 & 0xffffffff);
      if ((uVar9 != 0) && (lVar5 != 0)) {
        (**(code **)(*param_1 + 0x680))(param_1,lVar5,0,uVar9 & 0xffffffff,lVar6);
      }
      (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar6,2);
      (**(code **)(*param_1 + 0x600))(param_1,param_4,lVar7,2);
      (**(code **)(*param_1 + 0x600))(param_1,param_5,lVar8,2);
      goto LAB_00100d80;
    }
    if (lVar6 != 0) {
      (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar6,2);
    }
    if (lVar7 != 0) {
      (**(code **)(*param_1 + 0x600))(param_1,param_4,lVar7,2);
    }
    if (lVar8 != 0) {
      (**(code **)(*param_1 + 0x600))(param_1,param_5,lVar8,2);
    }
  }
  lVar5 = 0;
LAB_00100d80:
  if (*(long *)(lVar1 + 0x28) == local_68) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail(lVar5);
}



/* 00100db4 Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeGunzip */

void Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeGunzip
               (long *param_1,undefined8 param_2,undefined8 param_3)

{
  long lVar1;
  int iVar2;
  int iVar3;
  long lVar4;
  void *__ptr;
  long lVar5;
  void *__ptr_00;
  ulong uVar6;
  ulong __size;
  long local_d0;
  undefined8 uStack_c8;
  undefined8 local_c0;
  long lStack_b8;
  ulong local_b0;
  undefined8 uStack_a8;
  undefined8 local_a0;
  undefined8 uStack_98;
  undefined8 uStack_90;
  undefined8 uStack_88;
  undefined8 local_80;
  undefined8 uStack_78;
  undefined8 uStack_70;
  undefined8 uStack_68;
  long local_58;
  
  lVar1 = tpidr_el0;
  local_58 = *(long *)(lVar1 + 0x28);
  iVar2 = (**(code **)(*param_1 + 0x558))(param_1,param_3);
  if (iVar2 < 1) {
    lVar5 = 0;
    goto LAB_00100f80;
  }
  lVar4 = (**(code **)(*param_1 + 0x5c0))(param_1,param_3,0);
  lVar5 = 0;
  if (lVar4 == 0) goto LAB_00100f80;
  __size = (ulong)(iVar2 * 4 + 0x10000);
  lStack_b8 = 0;
  local_c0 = 0;
  uStack_a8 = 0;
  local_b0 = 0;
  uStack_98 = 0;
  local_a0 = 0;
  uStack_88 = 0;
  uStack_90 = 0;
  uStack_78 = 0;
  local_80 = 0;
  uStack_68 = 0;
  uStack_70 = 0;
  uStack_c8 = 0;
  local_d0 = 0;
  __ptr = malloc(__size);
  if (__ptr == (void *)0x0) {
    (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar4,2);
    lVar5 = 0;
    goto LAB_00100f80;
  }
  iVar3 = inflateInit2_(&local_d0,0x1f,"1.2.8",0x70);
  if (iVar3 == 0) {
    uVar6 = 0;
    uStack_c8 = CONCAT44(uStack_c8._4_4_,iVar2);
    __ptr_00 = __ptr;
    local_d0 = lVar4;
    do {
      __ptr = __ptr_00;
      if (__size < uVar6 + 0x10000) {
        __size = __size << 1;
        __ptr = realloc(__ptr_00,__size);
        if (__ptr == (void *)0x0) {
          iVar2 = -4;
          __ptr = __ptr_00;
          break;
        }
      }
      lStack_b8 = (long)__ptr + uVar6;
      local_b0 = CONCAT44(local_b0._4_4_,(int)(__size - uVar6));
      iVar2 = inflate(&local_d0,0);
      uVar6 = ((__size - uVar6) - (local_b0 & 0xffffffff)) + uVar6;
      __ptr_00 = __ptr;
    } while (iVar2 == 0);
    inflateEnd(&local_d0);
    if (((iVar2 != 1) && (uVar6 == 0)) ||
       (lVar5 = (**(code **)(*param_1 + 0x580))(param_1,uVar6 & 0xffffffff), lVar5 == 0))
    goto LAB_00100f54;
    (**(code **)(*param_1 + 0x680))(param_1,lVar5,0,uVar6 & 0xffffffff,__ptr);
  }
  else {
LAB_00100f54:
    lVar5 = 0;
  }
  free(__ptr);
  (**(code **)(*param_1 + 0x600))(param_1,param_3,lVar4,2);
LAB_00100f80:
  if (*(long *)(lVar1 + 0x28) != local_58) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail(lVar5);
  }
  return;
}



/* 00100fb0 FUN_00100fb0 */

void FUN_00100fb0(undefined8 *param_1,undefined8 *param_2)

{
  byte *pbVar1;
  ulong uVar2;
  byte bVar3;
  byte bVar4;
  byte bVar5;
  ulong uVar6;
  byte bVar7;
  undefined8 uVar8;
  
  uVar8 = *param_1;
  uVar2 = 0xc;
  param_2[1] = param_1[1];
  *param_2 = uVar8;
  do {
    pbVar1 = (byte *)((long)param_2 + uVar2);
    uVar2 = uVar2 + 4;
    bVar7 = *pbVar1;
    bVar5 = pbVar1[1];
    uVar6 = (ulong)bVar5;
    bVar4 = pbVar1[2];
    bVar3 = pbVar1[3];
    if ((uVar2 & 0xc) == 0) {
      bVar5 = (&DAT_001006e0)[bVar4];
      bVar4 = (&DAT_001006e0)[bVar3];
      bVar3 = (&DAT_001006e0)[bVar7];
      bVar7 = (&UNK_001007e0)[uVar2 >> 4] ^ (&DAT_001006e0)[uVar6];
    }
    pbVar1[4] = pbVar1[-0xc] ^ bVar7;
    pbVar1[5] = pbVar1[-0xb] ^ bVar5;
    pbVar1[6] = pbVar1[-10] ^ bVar4;
    pbVar1[7] = pbVar1[-9] ^ bVar3;
  } while (uVar2 < 0xac);
  return;
}



/* 0010104c FUN_0010104c */

/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_0010104c(byte *param_1,byte *param_2)

{
  undefined1 auVar1 [16];
  undefined1 auVar2 [16];
  undefined1 auVar3 [16];
  ulong uVar4;
  short sVar5;
  short sVar6;
  short sVar7;
  short sVar8;
  short sVar9;
  short sVar10;
  undefined1 auVar11 [16];
  byte *pbVar12;
  ulong uVar13;
  undefined1 auVar14 [16];
  byte bVar15;
  byte bVar16;
  byte bVar17;
  byte bVar18;
  byte bVar19;
  byte bVar20;
  byte bVar21;
  byte bVar22;
  byte bVar23;
  byte bVar24;
  byte bVar28;
  byte bVar30;
  byte bVar31;
  byte bVar32;
  byte bVar33;
  byte bVar35;
  byte bVar36;
  byte bVar38;
  byte bVar39;
  byte bVar41;
  byte bVar42;
  byte bVar43;
  long lVar25;
  byte bVar37;
  byte bVar44;
  ulong uVar26;
  byte bVar29;
  byte bVar34;
  byte bVar40;
  byte bVar45;
  ulong uVar27;
  byte bVar46;
  byte bVar48;
  byte bVar49;
  byte bVar50;
  byte bVar51;
  byte bVar52;
  byte bVar53;
  long lVar47;
  byte bVar54;
  byte bVar55;
  byte bVar57;
  byte bVar58;
  byte bVar59;
  byte bVar60;
  byte bVar61;
  byte bVar62;
  byte bVar63;
  byte bVar64;
  byte bVar65;
  ulong uVar56;
  byte bVar66;
  byte bVar67;
  byte bVar68;
  byte bVar70;
  byte bVar71;
  byte bVar72;
  byte bVar73;
  byte bVar74;
  byte bVar75;
  byte bVar76;
  byte bVar77;
  byte bVar78;
  ulong uVar69;
  byte bVar79;
  byte bVar80;
  byte bVar81;
  undefined1 uVar82;
  undefined1 uVar83;
  byte bVar84;
  undefined1 uVar85;
  undefined1 uVar86;
  byte bVar87;
  undefined1 uVar88;
  undefined1 uVar89;
  byte bVar90;
  byte bVar91;
  byte bVar92;
  byte bVar93;
  undefined1 uVar94;
  byte bVar95;
  undefined1 uVar96;
  byte bVar97;
  byte bVar98;
  undefined1 uVar99;
  byte bVar100;
  undefined1 uVar101;
  byte bVar102;
  byte bVar103;
  undefined1 uVar104;
  byte bVar105;
  undefined1 uVar106;
  byte bVar107;
  byte bVar108;
  byte bVar109;
  byte bVar110;
  byte bVar111;
  undefined1 uVar112;
  byte bVar113;
  undefined1 uVar114;
  byte bVar115;
  byte bVar116;
  undefined1 uVar117;
  byte bVar118;
  undefined1 uVar119;
  byte bVar120;
  byte bVar121;
  undefined1 uVar122;
  byte bVar123;
  undefined1 uVar124;
  byte bVar125;
  byte bVar126;
  byte bVar127;
  byte bVar128;
  byte bVar129;
  byte bVar130;
  byte bVar131;
  byte bVar132;
  byte bVar133;
  byte bVar134;
  byte bVar135;
  byte bVar136;
  byte bVar137;
  byte bVar138;
  undefined1 uVar139;
  undefined1 uVar140;
  undefined1 uVar141;
  undefined1 uVar142;
  undefined1 uVar143;
  undefined1 uVar144;
  byte bVar145;
  byte bVar146;
  byte bVar147;
  byte bVar148;
  
  auVar11 = _DAT_001006d0;
  uVar13 = 10;
  *param_2 = *param_2 ^ param_1[0xa0];
  param_2[1] = param_2[1] ^ param_1[0xa1];
  param_2[2] = param_2[2] ^ param_1[0xa2];
  param_2[3] = param_2[3] ^ param_1[0xa3];
  param_2[4] = param_2[4] ^ param_1[0xa4];
  param_2[5] = param_2[5] ^ param_1[0xa5];
  param_2[6] = param_2[6] ^ param_1[0xa6];
  param_2[7] = param_2[7] ^ param_1[0xa7];
  param_2[8] = param_2[8] ^ param_1[0xa8];
  param_2[9] = param_2[9] ^ param_1[0xa9];
  param_2[10] = param_2[10] ^ param_1[0xaa];
  param_2[0xb] = param_2[0xb] ^ param_1[0xab];
  param_2[0xc] = param_2[0xc] ^ param_1[0xac];
  param_2[0xd] = param_2[0xd] ^ param_1[0xad];
  param_2[0xe] = param_2[0xe] ^ param_1[0xae];
  pbVar12 = param_1 + 0x9f;
  param_2[0xf] = param_2[0xf] ^ param_1[0xaf];
  do {
    uVar13 = uVar13 - 1;
    bVar15 = param_2[1];
    bVar21 = (&DAT_001007eb)[*param_2];
    bVar16 = param_2[2];
    bVar17 = param_2[3];
    *param_2 = bVar21;
    bVar18 = param_2[5];
    bVar22 = (&DAT_001007eb)[param_2[0xd]];
    bVar19 = param_2[6];
    bVar20 = param_2[9];
    param_2[1] = bVar22;
    bVar23 = (&DAT_001007eb)[param_2[10]];
    param_2[2] = bVar23;
    bVar24 = (&DAT_001007eb)[param_2[7]];
    param_2[3] = bVar24;
    bVar28 = (&DAT_001007eb)[param_2[4]];
    param_2[4] = bVar28;
    bVar15 = (&DAT_001007eb)[bVar15];
    param_2[5] = bVar15;
    bVar29 = (&DAT_001007eb)[param_2[0xe]];
    param_2[6] = bVar29;
    bVar30 = (&DAT_001007eb)[param_2[0xb]];
    param_2[7] = bVar30;
    bVar31 = (&DAT_001007eb)[param_2[8]];
    param_2[8] = bVar31;
    bVar18 = (&DAT_001007eb)[bVar18];
    param_2[9] = bVar18;
    bVar16 = (&DAT_001007eb)[bVar16];
    param_2[10] = bVar16;
    bVar32 = (&DAT_001007eb)[param_2[0xf]];
    param_2[0xb] = bVar32;
    bVar33 = (&DAT_001007eb)[param_2[0xc]];
    param_2[0xc] = bVar33;
    bVar20 = (&DAT_001007eb)[bVar20];
    param_2[0xd] = bVar20;
    bVar19 = (&DAT_001007eb)[bVar19];
    param_2[0xe] = bVar19;
    bVar17 = (&DAT_001007eb)[bVar17];
    param_2[0xf] = bVar17;
    *param_2 = pbVar12[-0xf] ^ bVar21;
    param_2[1] = pbVar12[-0xe] ^ bVar22;
    param_2[2] = pbVar12[-0xd] ^ bVar23;
    param_2[3] = pbVar12[-0xc] ^ bVar24;
    param_2[4] = pbVar12[-0xb] ^ bVar28;
    param_2[5] = pbVar12[-10] ^ bVar15;
    param_2[6] = pbVar12[-9] ^ bVar29;
    param_2[7] = pbVar12[-8] ^ bVar30;
    param_2[8] = pbVar12[-7] ^ bVar31;
    param_2[9] = pbVar12[-6] ^ bVar18;
    param_2[10] = pbVar12[-5] ^ bVar16;
    param_2[0xb] = pbVar12[-4] ^ bVar32;
    param_2[0xc] = pbVar12[-3] ^ bVar33;
    param_2[0xd] = pbVar12[-2] ^ bVar20;
    param_2[0xe] = pbVar12[-1] ^ bVar19;
    bVar15 = *pbVar12;
    pbVar12 = pbVar12 + -0x10;
    param_2[0xf] = bVar15 ^ bVar17;
    lVar47 = *(long *)(param_2 + 8);
    lVar25 = *(long *)param_2;
    bVar36 = (byte)((ulong)lVar25 >> 0x20);
    bVar28 = (byte)((ulong)lVar25 >> 8);
    bVar31 = (byte)((ulong)lVar25 >> 0x10);
    bVar39 = (byte)((ulong)lVar25 >> 0x28);
    bVar42 = (byte)((ulong)lVar25 >> 0x30);
    bVar33 = (byte)((ulong)lVar25 >> 0x18);
    bVar48 = (byte)((ulong)lVar47 >> 8);
    bVar49 = (byte)((ulong)lVar47 >> 0x10);
    bVar44 = (byte)((ulong)lVar25 >> 0x38);
    bVar52 = (byte)((ulong)lVar47 >> 0x28);
    bVar53 = (byte)((ulong)lVar47 >> 0x30);
    bVar51 = (byte)((ulong)lVar47 >> 0x20);
    bVar50 = (byte)((ulong)lVar47 >> 0x18);
    bVar54 = (byte)((ulong)lVar47 >> 0x38);
    bVar23 = (byte)lVar25;
    bVar37 = (byte)lVar47;
    sVar7 = ((ushort)lVar25 & 0xff) * 2;
    uVar82 = (undefined1)((ushort)bVar36 * 2);
    uVar83 = (undefined1)((ushort)((ushort)bVar36 * 2) >> 8);
    sVar5 = ((ushort)lVar47 & 0xff) * 2;
    uVar85 = (undefined1)sVar5;
    uVar86 = (undefined1)((ushort)sVar5 >> 8);
    uVar88 = (undefined1)((ushort)bVar51 * 2);
    uVar89 = (undefined1)((ushort)((ushort)bVar51 * 2) >> 8);
    sVar5 = (ushort)bVar28 * 2;
    uVar94 = (undefined1)((ushort)bVar39 * 2);
    uVar96 = (undefined1)((ushort)((ushort)bVar39 * 2) >> 8);
    uVar99 = (undefined1)((ushort)bVar48 * 2);
    uVar101 = (undefined1)((ushort)((ushort)bVar48 * 2) >> 8);
    uVar104 = (undefined1)((ushort)bVar52 * 2);
    uVar106 = (undefined1)((ushort)((ushort)bVar52 * 2) >> 8);
    sVar6 = (ushort)bVar31 * 2;
    uVar112 = (undefined1)((ushort)bVar42 * 2);
    uVar114 = (undefined1)((ushort)((ushort)bVar42 * 2) >> 8);
    uVar117 = (undefined1)((ushort)bVar49 * 2);
    uVar119 = (undefined1)((ushort)((ushort)bVar49 * 2) >> 8);
    uVar122 = (undefined1)((ushort)bVar53 * 2);
    uVar124 = (undefined1)((ushort)((ushort)bVar53 * 2) >> 8);
    sVar8 = (ushort)bVar33 * 2;
    uVar139 = (undefined1)((ushort)bVar44 * 2);
    uVar140 = (undefined1)((ushort)((ushort)bVar44 * 2) >> 8);
    uVar141 = (undefined1)((ushort)bVar50 * 2);
    uVar142 = (undefined1)((ushort)((ushort)bVar50 * 2) >> 8);
    uVar143 = (undefined1)((ushort)bVar54 * 2);
    uVar144 = (undefined1)((ushort)((ushort)bVar54 * 2) >> 8);
    uVar26 = CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar7)))))) ^
             (CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar7)))))) ^
             CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar7)))))) ^ 0x1b001b001b001b) &
             CONCAT26(-(ushort)((char)bVar51 < '\0'),
                      CONCAT24(-(ushort)((char)bVar37 < '\0'),
                               CONCAT22(-(ushort)((char)bVar36 < '\0'),
                                        -(ushort)((char)bVar23 < '\0'))));
    uVar56 = CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar5)))))) ^
             (CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar5)))))) ^
             CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar5)))))) ^ 0x1b001b001b001b) &
             CONCAT26(-(ushort)((char)bVar52 < '\0'),
                      CONCAT24(-(ushort)((char)bVar48 < '\0'),
                               CONCAT22(-(ushort)((char)bVar39 < '\0'),
                                        -(ushort)((char)bVar28 < '\0'))));
    uVar69 = CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar6)))))) ^
             (CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar6)))))) ^
             CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar6)))))) ^ 0x1b001b001b001b) &
             CONCAT26(-(ushort)((char)bVar53 < '\0'),
                      CONCAT24(-(ushort)((char)bVar49 < '\0'),
                               CONCAT22(-(ushort)((char)bVar42 < '\0'),
                                        -(ushort)((char)bVar31 < '\0'))));
    bVar110 = (byte)uVar26;
    bVar115 = (byte)(uVar26 >> 0x10);
    bVar120 = (byte)(uVar26 >> 0x20);
    bVar125 = (byte)(uVar26 >> 0x30);
    uVar27 = CONCAT17(uVar144,CONCAT16(uVar143,CONCAT15(uVar142,CONCAT14(uVar141,CONCAT13(uVar140,
                                                  CONCAT12(uVar139,sVar8)))))) ^ 0x1b001b001b001b ^
             (CONCAT17(uVar144,CONCAT16(uVar143,CONCAT15(uVar142,CONCAT14(uVar141,CONCAT13(uVar140,
                                                  CONCAT12(uVar139,sVar8)))))) ^ 0x1b001b001b001b ^
             CONCAT17(uVar144,CONCAT16(uVar143,CONCAT15(uVar142,CONCAT14(uVar141,CONCAT13(uVar140,
                                                  CONCAT12(uVar139,sVar8))))))) &
             ~CONCAT17((char)((ushort)-(ushort)(lVar47 < 0) >> 8),
                       CONCAT16((char)-(ushort)(lVar47 < 0),
                                CONCAT15((char)((ushort)-(ushort)((char)bVar50 < '\0') >> 8),
                                         CONCAT14((char)-(ushort)((char)bVar50 < '\0'),
                                                  CONCAT13((char)((ushort)-(ushort)(lVar25 < 0) >> 8
                                                                 ),CONCAT12((char)-(ushort)(lVar25 <
                                                                                           0),
                                                                            -(ushort)((char)bVar33 <
                                                                                     '\0')))))));
    bVar81 = (byte)(uVar27 >> 8);
    bVar19 = (byte)(uVar27 >> 0x10);
    bVar84 = (byte)(uVar27 >> 0x18);
    bVar20 = (byte)(uVar27 >> 0x20);
    bVar87 = (byte)(uVar27 >> 0x28);
    bVar21 = (byte)(uVar27 >> 0x30);
    bVar90 = (byte)(uVar27 >> 0x38);
    bVar92 = (byte)uVar56;
    bVar97 = (byte)(uVar56 >> 0x10);
    bVar102 = (byte)(uVar56 >> 0x20);
    bVar107 = (byte)(uVar56 >> 0x30);
    sVar5 = (short)uVar26 * 2;
    sVar6 = (short)(uVar26 >> 0x10) * 2;
    uVar82 = (undefined1)sVar6;
    uVar83 = (undefined1)((ushort)sVar6 >> 8);
    sVar6 = (short)(uVar26 >> 0x20) * 2;
    uVar85 = (undefined1)sVar6;
    uVar86 = (undefined1)((ushort)sVar6 >> 8);
    sVar6 = (short)(uVar26 >> 0x30) * 2;
    uVar88 = (undefined1)sVar6;
    uVar89 = (undefined1)((ushort)sVar6 >> 8);
    bVar128 = (byte)uVar69;
    bVar131 = (byte)(uVar69 >> 0x10);
    bVar134 = (byte)(uVar69 >> 0x20);
    bVar137 = (byte)(uVar69 >> 0x30);
    sVar6 = (short)uVar56 * 2;
    sVar7 = (short)(uVar56 >> 0x10) * 2;
    uVar94 = (undefined1)sVar7;
    uVar96 = (undefined1)((ushort)sVar7 >> 8);
    sVar7 = (short)(uVar56 >> 0x20) * 2;
    uVar99 = (undefined1)sVar7;
    uVar101 = (undefined1)((ushort)sVar7 >> 8);
    sVar7 = (short)(uVar56 >> 0x30) * 2;
    uVar104 = (undefined1)sVar7;
    uVar106 = (undefined1)((ushort)sVar7 >> 8);
    sVar7 = (short)uVar69 * 2;
    sVar8 = (short)(uVar69 >> 0x10) * 2;
    uVar112 = (undefined1)sVar8;
    uVar114 = (undefined1)((ushort)sVar8 >> 8);
    sVar8 = (short)(uVar69 >> 0x20) * 2;
    uVar117 = (undefined1)sVar8;
    uVar119 = (undefined1)((ushort)sVar8 >> 8);
    sVar8 = (short)(uVar69 >> 0x30) * 2;
    uVar122 = (undefined1)sVar8;
    uVar124 = (undefined1)((ushort)sVar8 >> 8);
    bVar29 = (byte)(uVar26 >> 8);
    bVar34 = (byte)(uVar26 >> 0x18);
    bVar40 = (byte)(uVar26 >> 0x28);
    bVar45 = (byte)(uVar26 >> 0x38);
    bVar15 = (byte)uVar27 ^ bVar28 ^ bVar23;
    bVar16 = bVar19 ^ bVar39 ^ bVar36;
    bVar17 = bVar20 ^ bVar48 ^ bVar37;
    bVar18 = bVar21 ^ bVar52 ^ bVar51;
    bVar70 = (byte)(uVar69 >> 8);
    bVar73 = (byte)(uVar69 >> 0x18);
    bVar76 = (byte)(uVar69 >> 0x28);
    bVar79 = (byte)(uVar69 >> 0x38);
    uVar69 = CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar5)))))) ^
             (CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar5)))))) ^
             CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar5)))))) ^ 0x1b001b001b001b) &
             CONCAT17((char)((ushort)-(ushort)((char)bVar125 < '\0') >> 8),
                      CONCAT16((char)-(ushort)((char)bVar125 < '\0'),
                               CONCAT15((char)((ushort)-(ushort)((char)bVar120 < '\0') >> 8),
                                        CONCAT14((char)-(ushort)((char)bVar120 < '\0'),
                                                 CONCAT13((char)((ushort)-(ushort)((char)bVar115 <
                                                                                  '\0') >> 8),
                                                          CONCAT12((char)-(ushort)((char)bVar115 <
                                                                                  '\0'),
                                                                   -(ushort)((char)bVar110 < '\0')))
                                                ))));
    bVar109 = (byte)uVar69;
    bVar111 = (byte)(uVar69 >> 8);
    bVar113 = (byte)(uVar69 >> 0x10);
    bVar116 = (byte)(uVar69 >> 0x18);
    bVar118 = (byte)(uVar69 >> 0x20);
    bVar121 = (byte)(uVar69 >> 0x28);
    bVar123 = (byte)(uVar69 >> 0x30);
    bVar126 = (byte)(uVar69 >> 0x38);
    uVar26 = CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar6)))))) ^
             (CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar6)))))) ^
             CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar6)))))) ^ 0x1b001b001b001b) &
             CONCAT17((char)((ushort)-(ushort)((char)bVar107 < '\0') >> 8),
                      CONCAT16((char)-(ushort)((char)bVar107 < '\0'),
                               CONCAT15((char)((ushort)-(ushort)((char)bVar102 < '\0') >> 8),
                                        CONCAT14((char)-(ushort)((char)bVar102 < '\0'),
                                                 CONCAT13((char)((ushort)-(ushort)((char)bVar97 <
                                                                                  '\0') >> 8),
                                                          CONCAT12((char)-(ushort)((char)bVar97 <
                                                                                  '\0'),
                                                                   -(ushort)((char)bVar92 < '\0'))))
                                       )));
    bVar91 = (byte)uVar26;
    bVar93 = (byte)(uVar26 >> 8);
    bVar95 = (byte)(uVar26 >> 0x10);
    bVar98 = (byte)(uVar26 >> 0x18);
    bVar100 = (byte)(uVar26 >> 0x20);
    bVar103 = (byte)(uVar26 >> 0x28);
    bVar105 = (byte)(uVar26 >> 0x30);
    bVar108 = (byte)(uVar26 >> 0x38);
    sVar8 = (short)uVar27 * 2;
    sVar5 = (short)(uVar27 >> 0x10) * 2;
    uVar94 = (undefined1)sVar5;
    uVar96 = (undefined1)((ushort)sVar5 >> 8);
    sVar5 = (short)(uVar27 >> 0x20) * 2;
    uVar99 = (undefined1)sVar5;
    uVar101 = (undefined1)((ushort)sVar5 >> 8);
    sVar5 = (short)(uVar27 >> 0x30) * 2;
    uVar104 = (undefined1)sVar5;
    uVar106 = (undefined1)((ushort)sVar5 >> 8);
    uVar4 = CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar7)))))) ^
            (CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar7)))))) ^
            CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar7)))))) ^ 0x1b001b001b001b) &
            CONCAT17((char)((ushort)-(ushort)((char)bVar137 < '\0') >> 8),
                     CONCAT16((char)-(ushort)((char)bVar137 < '\0'),
                              CONCAT15((char)((ushort)-(ushort)((char)bVar134 < '\0') >> 8),
                                       CONCAT14((char)-(ushort)((char)bVar134 < '\0'),
                                                CONCAT13((char)((ushort)-(ushort)((char)bVar131 <
                                                                                 '\0') >> 8),
                                                         CONCAT12((char)-(ushort)((char)bVar131 <
                                                                                 '\0'),
                                                                  -(ushort)((char)bVar128 < '\0'))))
                                      )));
    bVar127 = (byte)uVar4;
    bVar129 = (byte)(uVar4 >> 8);
    bVar130 = (byte)(uVar4 >> 0x10);
    bVar132 = (byte)(uVar4 >> 0x18);
    bVar133 = (byte)(uVar4 >> 0x20);
    bVar135 = (byte)(uVar4 >> 0x28);
    bVar136 = (byte)(uVar4 >> 0x30);
    bVar138 = (byte)(uVar4 >> 0x38);
    bVar57 = (byte)(uVar56 >> 8);
    bVar60 = (byte)(uVar56 >> 0x18);
    bVar63 = (byte)(uVar56 >> 0x28);
    bVar66 = (byte)(uVar56 >> 0x38);
    sVar5 = -(ushort)((char)bVar19 < '\0');
    sVar6 = -(ushort)((char)bVar20 < '\0');
    sVar7 = -(ushort)((char)bVar21 < '\0');
    uVar56 = CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar8)))))) ^ 0x1b001b001b001b;
    sVar9 = (short)uVar69 * 2;
    sVar10 = (short)(uVar69 >> 0x10) * 2;
    uVar82 = (undefined1)sVar10;
    uVar83 = (undefined1)((ushort)sVar10 >> 8);
    sVar10 = (short)(uVar69 >> 0x20) * 2;
    uVar85 = (undefined1)sVar10;
    uVar86 = (undefined1)((ushort)sVar10 >> 8);
    sVar10 = (short)(uVar69 >> 0x30) * 2;
    uVar88 = (undefined1)sVar10;
    uVar89 = (undefined1)((ushort)sVar10 >> 8);
    uVar56 = uVar56 ^ (uVar56 ^ CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,
                                                  CONCAT13(uVar96,CONCAT12(uVar94,sVar8))))))) &
                      ~CONCAT17((char)((ushort)sVar7 >> 8),
                                CONCAT16((char)sVar7,
                                         CONCAT15((char)((ushort)sVar6 >> 8),
                                                  CONCAT14((char)sVar6,
                                                           CONCAT13((char)((ushort)sVar5 >> 8),
                                                                    CONCAT12((char)sVar5,
                                                                             -(ushort)((char)(byte)
                                                  uVar27 < '\0')))))));
    sVar5 = (short)uVar26 * 2;
    sVar6 = (short)(uVar26 >> 0x10) * 2;
    uVar94 = (undefined1)sVar6;
    uVar96 = (undefined1)((ushort)sVar6 >> 8);
    sVar6 = (short)(uVar26 >> 0x20) * 2;
    uVar99 = (undefined1)sVar6;
    uVar101 = (undefined1)((ushort)sVar6 >> 8);
    sVar6 = (short)(uVar26 >> 0x30) * 2;
    uVar104 = (undefined1)sVar6;
    uVar106 = (undefined1)((ushort)sVar6 >> 8);
    sVar6 = (short)uVar4 * 2;
    sVar7 = (short)(uVar4 >> 0x10) * 2;
    uVar112 = (undefined1)sVar7;
    uVar114 = (undefined1)((ushort)sVar7 >> 8);
    sVar7 = (short)(uVar4 >> 0x20) * 2;
    uVar117 = (undefined1)sVar7;
    uVar119 = (undefined1)((ushort)sVar7 >> 8);
    sVar7 = (short)(uVar4 >> 0x30) * 2;
    uVar122 = (undefined1)sVar7;
    uVar124 = (undefined1)((ushort)sVar7 >> 8);
    bVar145 = (byte)uVar56;
    bVar146 = (byte)(uVar56 >> 0x10);
    bVar147 = (byte)(uVar56 >> 0x20);
    bVar148 = (byte)(uVar56 >> 0x30);
    bVar19 = (byte)(uVar56 >> 8);
    bVar20 = (byte)(uVar56 >> 0x18);
    bVar21 = (byte)(uVar56 >> 0x28);
    bVar22 = (byte)(uVar56 >> 0x38);
    uVar26 = CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar9)))))) ^
             (CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar9)))))) ^
             CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar9)))))) ^ 0x1b001b001b001b) &
             CONCAT17((char)((ushort)-(ushort)((char)bVar123 < '\0') >> 8),
                      CONCAT16((char)-(ushort)((char)bVar123 < '\0'),
                               CONCAT15((char)((ushort)-(ushort)((char)bVar118 < '\0') >> 8),
                                        CONCAT14((char)-(ushort)((char)bVar118 < '\0'),
                                                 CONCAT13((char)((ushort)-(ushort)((char)bVar113 <
                                                                                  '\0') >> 8),
                                                          CONCAT12((char)-(ushort)((char)bVar113 <
                                                                                  '\0'),
                                                                   -(ushort)((char)bVar109 < '\0')))
                                                ))));
    uVar69 = CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar5)))))) ^
             (CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar5)))))) ^
             CONCAT17(uVar106,CONCAT16(uVar104,CONCAT15(uVar101,CONCAT14(uVar99,CONCAT13(uVar96,
                                                  CONCAT12(uVar94,sVar5)))))) ^ 0x1b001b001b001b) &
             CONCAT26(-(ushort)((char)bVar105 < '\0'),
                      CONCAT24(-(ushort)((char)bVar100 < '\0'),
                               CONCAT22(-(ushort)((char)bVar95 < '\0'),
                                        -(ushort)((char)bVar91 < '\0'))));
    uVar27 = CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar6)))))) ^
             (CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar6)))))) ^
             CONCAT17(uVar124,CONCAT16(uVar122,CONCAT15(uVar119,CONCAT14(uVar117,CONCAT13(uVar114,
                                                  CONCAT12(uVar112,sVar6)))))) ^ 0x1b001b001b001b) &
             CONCAT17((char)((ushort)-(ushort)((char)bVar136 < '\0') >> 8),
                      CONCAT16((char)-(ushort)((char)bVar136 < '\0'),
                               CONCAT15((char)((ushort)-(ushort)((char)bVar133 < '\0') >> 8),
                                        CONCAT14((char)-(ushort)((char)bVar133 < '\0'),
                                                 CONCAT13((char)((ushort)-(ushort)((char)bVar130 <
                                                                                  '\0') >> 8),
                                                          CONCAT12((char)-(ushort)((char)bVar130 <
                                                                                  '\0'),
                                                                   -(ushort)((char)bVar127 < '\0')))
                                                ))));
    sVar5 = (short)uVar56 * 2;
    sVar6 = (short)(uVar56 >> 0x10) * 2;
    uVar82 = (undefined1)sVar6;
    uVar83 = (undefined1)((ushort)sVar6 >> 8);
    sVar6 = (short)(uVar56 >> 0x20) * 2;
    uVar85 = (undefined1)sVar6;
    uVar86 = (undefined1)((ushort)sVar6 >> 8);
    sVar6 = (short)(uVar56 >> 0x30) * 2;
    uVar88 = (undefined1)sVar6;
    uVar89 = (undefined1)((ushort)sVar6 >> 8);
    bVar55 = (byte)uVar26;
    bVar58 = (byte)(uVar26 >> 8);
    bVar59 = (byte)(uVar26 >> 0x10);
    bVar61 = (byte)(uVar26 >> 0x18);
    bVar62 = (byte)(uVar26 >> 0x20);
    bVar64 = (byte)(uVar26 >> 0x28);
    bVar65 = (byte)(uVar26 >> 0x30);
    bVar67 = (byte)(uVar26 >> 0x38);
    bVar68 = (byte)uVar69 ^ (byte)uVar27;
    bVar71 = (byte)(uVar69 >> 8) ^ (byte)(uVar27 >> 8);
    bVar72 = (byte)(uVar69 >> 0x10) ^ (byte)(uVar27 >> 0x10);
    bVar74 = (byte)(uVar69 >> 0x18) ^ (byte)(uVar27 >> 0x18);
    bVar75 = (byte)(uVar69 >> 0x20) ^ (byte)(uVar27 >> 0x20);
    bVar77 = (byte)(uVar69 >> 0x28) ^ (byte)(uVar27 >> 0x28);
    bVar78 = (byte)(uVar69 >> 0x30) ^ (byte)(uVar27 >> 0x30);
    bVar80 = (byte)(uVar69 >> 0x38) ^ (byte)(uVar27 >> 0x38);
    uVar27 = CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar5)))))) ^
             (CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar5)))))) ^
             CONCAT17(uVar89,CONCAT16(uVar88,CONCAT15(uVar86,CONCAT14(uVar85,CONCAT13(uVar83,
                                                  CONCAT12(uVar82,sVar5)))))) ^ 0x1b001b001b001b) &
             CONCAT17((char)((ushort)-(ushort)((char)bVar148 < '\0') >> 8),
                      CONCAT16((char)-(ushort)((char)bVar148 < '\0'),
                               CONCAT15((char)((ushort)-(ushort)((char)bVar147 < '\0') >> 8),
                                        CONCAT14((char)-(ushort)((char)bVar147 < '\0'),
                                                 CONCAT13((char)((ushort)-(ushort)((char)bVar146 <
                                                                                  '\0') >> 8),
                                                          CONCAT12((char)-(ushort)((char)bVar146 <
                                                                                  '\0'),
                                                                   -(ushort)((char)bVar145 < '\0')))
                                                ))));
    bVar24 = (byte)uVar27;
    bVar30 = (byte)(uVar27 >> 8);
    bVar32 = (byte)(uVar27 >> 0x10);
    bVar35 = (byte)(uVar27 >> 0x18);
    bVar38 = (byte)(uVar27 >> 0x20);
    bVar41 = (byte)(uVar27 >> 0x28);
    bVar43 = (byte)(uVar27 >> 0x30);
    bVar46 = (byte)(uVar27 >> 0x38);
    auVar14[1] = bVar29 ^ bVar57 ^ bVar111 ^ bVar129 ^ bVar58 ^ bVar71 ^ bVar30;
    auVar14[0] = bVar31 ^ bVar28 ^ bVar33 ^ bVar110 ^ bVar92 ^ bVar109 ^ bVar127 ^ bVar55 ^ bVar68 ^
                 bVar24;
    auVar14[2] = bVar42 ^ bVar39 ^ bVar44 ^ bVar115 ^ bVar97 ^ bVar113 ^ bVar130 ^ bVar59 ^ bVar72 ^
                 bVar32;
    auVar14[3] = bVar34 ^ bVar60 ^ bVar116 ^ bVar132 ^ bVar61 ^ bVar74 ^ bVar35;
    auVar14[4] = bVar49 ^ bVar48 ^ bVar50 ^ bVar120 ^ bVar102 ^ bVar118 ^ bVar133 ^ bVar62 ^ bVar75
                 ^ bVar38;
    auVar14[5] = bVar40 ^ bVar63 ^ bVar121 ^ bVar135 ^ bVar64 ^ bVar77 ^ bVar41;
    auVar14[6] = bVar53 ^ bVar52 ^ bVar54 ^ bVar125 ^ bVar107 ^ bVar123 ^ bVar136 ^ bVar65 ^ bVar78
                 ^ bVar43;
    auVar14[7] = bVar45 ^ bVar66 ^ bVar126 ^ bVar138 ^ bVar67 ^ bVar80 ^ bVar46;
    auVar14._8_8_ = 0;
    auVar1[1] = bVar57 ^ bVar70 ^ bVar93 ^ bVar19 ^ bVar58 ^ bVar71 ^ bVar30;
    auVar1[0] = bVar31 ^ bVar23 ^ bVar33 ^ bVar92 ^ bVar128 ^ bVar91 ^ bVar145 ^ bVar55 ^ bVar68 ^
                bVar24;
    auVar1[2] = bVar42 ^ bVar36 ^ bVar44 ^ bVar97 ^ bVar131 ^ bVar95 ^ bVar146 ^ bVar59 ^ bVar72 ^
                bVar32;
    auVar1[3] = bVar60 ^ bVar73 ^ bVar98 ^ bVar20 ^ bVar61 ^ bVar74 ^ bVar35;
    auVar1[4] = bVar49 ^ bVar37 ^ bVar50 ^ bVar102 ^ bVar134 ^ bVar100 ^ bVar147 ^ bVar62 ^ bVar75 ^
                bVar38;
    auVar1[5] = bVar63 ^ bVar76 ^ bVar103 ^ bVar21 ^ bVar64 ^ bVar77 ^ bVar41;
    auVar1[6] = bVar53 ^ bVar51 ^ bVar54 ^ bVar107 ^ bVar137 ^ bVar105 ^ bVar148 ^ bVar65 ^ bVar78 ^
                bVar43;
    auVar1[7] = bVar66 ^ bVar79 ^ bVar108 ^ bVar22 ^ bVar67 ^ bVar80 ^ bVar46;
    auVar1._8_8_ = 0;
    auVar2[1] = bVar81 ^ bVar70 ^ bVar111 ^ bVar129 ^ bVar58 ^ bVar71 ^ bVar30;
    auVar2[0] = bVar15 ^ bVar33 ^ bVar128 ^ bVar109 ^ bVar127 ^ bVar55 ^ bVar68 ^ bVar24;
    auVar2[2] = bVar16 ^ bVar44 ^ bVar131 ^ bVar113 ^ bVar130 ^ bVar59 ^ bVar72 ^ bVar32;
    auVar2[3] = bVar84 ^ bVar73 ^ bVar116 ^ bVar132 ^ bVar61 ^ bVar74 ^ bVar35;
    auVar2[4] = bVar17 ^ bVar50 ^ bVar134 ^ bVar118 ^ bVar133 ^ bVar62 ^ bVar75 ^ bVar38;
    auVar2[5] = bVar87 ^ bVar76 ^ bVar121 ^ bVar135 ^ bVar64 ^ bVar77 ^ bVar41;
    auVar2[6] = bVar18 ^ bVar54 ^ bVar137 ^ bVar123 ^ bVar136 ^ bVar65 ^ bVar78 ^ bVar43;
    auVar2[7] = bVar90 ^ bVar79 ^ bVar126 ^ bVar138 ^ bVar67 ^ bVar80 ^ bVar46;
    auVar2._8_8_ = 0;
    auVar3[1] = bVar81 ^ bVar29 ^ bVar93 ^ bVar19 ^ bVar58 ^ bVar71 ^ bVar30;
    auVar3[0] = bVar15 ^ bVar31 ^ bVar110 ^ bVar91 ^ bVar145 ^ bVar55 ^ bVar68 ^ bVar24;
    auVar3[2] = bVar16 ^ bVar42 ^ bVar115 ^ bVar95 ^ bVar146 ^ bVar59 ^ bVar72 ^ bVar32;
    auVar3[3] = bVar84 ^ bVar34 ^ bVar98 ^ bVar20 ^ bVar61 ^ bVar74 ^ bVar35;
    auVar3[4] = bVar17 ^ bVar49 ^ bVar120 ^ bVar100 ^ bVar147 ^ bVar62 ^ bVar75 ^ bVar38;
    auVar3[5] = bVar87 ^ bVar40 ^ bVar103 ^ bVar21 ^ bVar64 ^ bVar77 ^ bVar41;
    auVar3[6] = bVar18 ^ bVar53 ^ bVar125 ^ bVar105 ^ bVar148 ^ bVar65 ^ bVar78 ^ bVar43;
    auVar3[7] = bVar90 ^ bVar45 ^ bVar108 ^ bVar22 ^ bVar67 ^ bVar80 ^ bVar46;
    auVar3._8_8_ = 0;
    auVar14 = a64_TBL(ZEXT816(0),auVar14,auVar1,auVar2,auVar3,auVar11);
    *(long *)(param_2 + 8) = auVar14._8_8_;
    *(long *)param_2 = auVar14._0_8_;
  } while (1 < uVar13);
  bVar15 = param_2[1];
  bVar16 = param_2[2];
  bVar21 = (&DAT_001007eb)[*param_2];
  bVar17 = param_2[3];
  bVar18 = param_2[5];
  *param_2 = bVar21;
  bVar19 = param_2[6];
  bVar22 = (&DAT_001007eb)[param_2[0xd]];
  bVar20 = param_2[9];
  param_2[1] = bVar22;
  bVar23 = (&DAT_001007eb)[param_2[10]];
  param_2[2] = bVar23;
  bVar24 = (&DAT_001007eb)[param_2[7]];
  param_2[3] = bVar24;
  bVar28 = (&DAT_001007eb)[param_2[4]];
  param_2[4] = bVar28;
  bVar15 = (&DAT_001007eb)[bVar15];
  param_2[5] = bVar15;
  bVar29 = (&DAT_001007eb)[param_2[0xe]];
  param_2[6] = bVar29;
  bVar30 = (&DAT_001007eb)[param_2[0xb]];
  param_2[7] = bVar30;
  bVar31 = (&DAT_001007eb)[param_2[8]];
  param_2[8] = bVar31;
  bVar18 = (&DAT_001007eb)[bVar18];
  param_2[9] = bVar18;
  bVar16 = (&DAT_001007eb)[bVar16];
  param_2[10] = bVar16;
  bVar32 = (&DAT_001007eb)[param_2[0xf]];
  param_2[0xb] = bVar32;
  bVar33 = (&DAT_001007eb)[param_2[0xc]];
  param_2[0xc] = bVar33;
  bVar20 = (&DAT_001007eb)[bVar20];
  param_2[0xd] = bVar20;
  bVar19 = (&DAT_001007eb)[bVar19];
  param_2[0xe] = bVar19;
  bVar17 = (&DAT_001007eb)[bVar17];
  param_2[0xf] = bVar17;
  *param_2 = *param_1 ^ bVar21;
  param_2[1] = param_1[1] ^ bVar22;
  param_2[2] = param_1[2] ^ bVar23;
  param_2[3] = param_1[3] ^ bVar24;
  param_2[4] = param_1[4] ^ bVar28;
  param_2[5] = param_1[5] ^ bVar15;
  param_2[6] = param_1[6] ^ bVar29;
  param_2[7] = param_1[7] ^ bVar30;
  param_2[8] = param_1[8] ^ bVar31;
  param_2[9] = param_1[9] ^ bVar18;
  param_2[10] = param_1[10] ^ bVar16;
  param_2[0xb] = param_1[0xb] ^ bVar32;
  param_2[0xc] = param_1[0xc] ^ bVar33;
  param_2[0xd] = param_1[0xd] ^ bVar20;
  param_2[0xe] = param_1[0xe] ^ bVar19;
  param_2[0xf] = param_1[0xf] ^ bVar17;
  return;
}



/* 001016d4 FUN_001016d4 */

void FUN_001016d4(undefined8 param_1,undefined8 *param_2,long param_3,ulong param_4)

{
  ulong uVar1;
  long lVar2;
  undefined8 uVar3;
  undefined8 uVar4;
  undefined8 uVar5;
  undefined8 uVar6;
  undefined8 uVar7;
  undefined8 uVar8;
  
  if (0xf < param_4) {
    lVar2 = 0;
    uVar3 = *param_2;
    uVar5 = param_2[1];
    do {
      uVar8 = ((undefined8 *)(param_3 + lVar2))[1];
      uVar7 = *(undefined8 *)(param_3 + lVar2);
      FUN_0010104c(param_1,param_3 + lVar2);
      uVar6 = ((undefined8 *)(param_3 + lVar2))[1];
      uVar4 = *(undefined8 *)(param_3 + lVar2);
      uVar1 = lVar2 + 0x20;
      ((undefined8 *)(param_3 + lVar2))[1] =
           CONCAT17((byte)((ulong)uVar6 >> 0x38) ^ (byte)((ulong)uVar5 >> 0x38),
                    CONCAT16((byte)((ulong)uVar6 >> 0x30) ^ (byte)((ulong)uVar5 >> 0x30),
                             CONCAT15((byte)((ulong)uVar6 >> 0x28) ^ (byte)((ulong)uVar5 >> 0x28),
                                      CONCAT14((byte)((ulong)uVar6 >> 0x20) ^
                                               (byte)((ulong)uVar5 >> 0x20),
                                               CONCAT13((byte)((ulong)uVar6 >> 0x18) ^
                                                        (byte)((ulong)uVar5 >> 0x18),
                                                        CONCAT12((byte)((ulong)uVar6 >> 0x10) ^
                                                                 (byte)((ulong)uVar5 >> 0x10),
                                                                 CONCAT11((byte)((ulong)uVar6 >> 8)
                                                                          ^ (byte)((ulong)uVar5 >> 8
                                                                                  ),
                                                                          (byte)uVar6 ^ (byte)uVar5)
                                                                ))))));
      *(undefined8 *)(param_3 + lVar2) =
           CONCAT17((byte)((ulong)uVar4 >> 0x38) ^ (byte)((ulong)uVar3 >> 0x38),
                    CONCAT16((byte)((ulong)uVar4 >> 0x30) ^ (byte)((ulong)uVar3 >> 0x30),
                             CONCAT15((byte)((ulong)uVar4 >> 0x28) ^ (byte)((ulong)uVar3 >> 0x28),
                                      CONCAT14((byte)((ulong)uVar4 >> 0x20) ^
                                               (byte)((ulong)uVar3 >> 0x20),
                                               CONCAT13((byte)((ulong)uVar4 >> 0x18) ^
                                                        (byte)((ulong)uVar3 >> 0x18),
                                                        CONCAT12((byte)((ulong)uVar4 >> 0x10) ^
                                                                 (byte)((ulong)uVar3 >> 0x10),
                                                                 CONCAT11((byte)((ulong)uVar4 >> 8)
                                                                          ^ (byte)((ulong)uVar3 >> 8
                                                                                  ),
                                                                          (byte)uVar4 ^ (byte)uVar3)
                                                                ))))));
      lVar2 = lVar2 + 0x10;
      uVar3 = uVar7;
      uVar5 = uVar8;
    } while (uVar1 <= param_4);
  }
  return;
}



/* 00101750 FUN_00101750 */

ulong FUN_00101750(long param_1,ulong param_2)

{
  byte bVar1;
  bool bVar2;
  ulong uVar3;
  long lVar4;
  
  uVar3 = 0;
  if ((param_2 != 0) && ((param_2 & 0xf) == 0)) {
    bVar1 = *(byte *)(param_1 + param_2 + -1);
    if (bVar1 - 0x11 < 0xfffffff0) {
      return 0;
    }
    uVar3 = param_2 - bVar1;
    if (uVar3 < param_2) {
      lVar4 = -(ulong)bVar1;
      do {
        if ((uint)*(byte *)(param_1 + param_2 + lVar4) != (uint)bVar1) {
          return 0;
        }
        bVar2 = lVar4 != -1;
        lVar4 = lVar4 + 1;
      } while (bVar2);
    }
  }
  return uVar3;
}



/* 001017b0 FUN_001017b0 */

void FUN_001017b0(void)

{
  (*(code *)PTR_00105a38)();
  return;
}



/* 001017d0 __cxa_finalize */

void __cxa_finalize(void)

{
  (*(code *)PTR___cxa_finalize_00105a40)();
  return;
}



/* 001017e0 __cxa_atexit */

void __cxa_atexit(void)

{
  (*(code *)PTR___cxa_atexit_00105a48)();
  return;
}



/* 001017f0 __register_atfork */

void __register_atfork(void)

{
  (*(code *)PTR___register_atfork_00105a50)();
  return;
}



/* 00101800 __stack_chk_fail */

void __stack_chk_fail(void)

{
  (*(code *)PTR___stack_chk_fail_00105a58)();
  return;
}



/* 00101810 malloc */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * malloc(size_t __size)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_malloc_00105a60)();
  return pvVar1;
}



/* 00101820 inflateInit2_ */

void inflateInit2_(void)

{
  (*(code *)PTR_inflateInit2__00105a68)();
  return;
}



/* 00101830 inflate */

void inflate(void)

{
  (*(code *)PTR_inflate_00105a70)();
  return;
}



/* 00101840 realloc */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * realloc(void *__ptr,size_t __size)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_realloc_00105a78)();
  return pvVar1;
}



/* 00101850 inflateEnd */

void inflateEnd(void)

{
  (*(code *)PTR_inflateEnd_00105a80)();
  return;
}



/* 00101860 free */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void free(void *__ptr)

{
  (*(code *)PTR_free_00105a88)();
  return;
}



/* 00106000 __cxa_finalize */

/* WARNING: Control flow encountered bad instruction data */

void __cxa_finalize(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106008 __cxa_atexit */

/* WARNING: Control flow encountered bad instruction data */

void __cxa_atexit(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106010 __register_atfork */

/* WARNING: Control flow encountered bad instruction data */

void __register_atfork(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106018 __stack_chk_fail */

/* WARNING: Control flow encountered bad instruction data */

void __stack_chk_fail(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106020 malloc */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * malloc(size_t __size)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106028 inflateInit2_ */

/* WARNING: Control flow encountered bad instruction data */

void inflateInit2_(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106030 inflate */

/* WARNING: Control flow encountered bad instruction data */

void inflate(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106038 realloc */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * realloc(void *__ptr,size_t __size)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106040 inflateEnd */

/* WARNING: Control flow encountered bad instruction data */

void inflateEnd(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00106048 free */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void free(void *__ptr)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}
