/* Pseudocode reconstructed by Ghidra, NOT original C/C++ source. Static analysis only. */
/* Language: ARM:LE:32:v8 */

/* 00010750 _FINI_1 */

void _FINI_1(void)

{
  (*(code *)PTR___cxa_finalize_000122cc)((int)&DAT_0001075c + DAT_0001075c);
  return;
}



/* 00010760 FUN_00010760 */

void FUN_00010760(void)

{
  return;
}



/* 00010764 _FINI_0 */

void _FINI_0(void)

{
  return;
}



/* 000107a4 Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeAesCbcDecrypt */

void Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeAesCbcDecrypt
               (int *param_1,undefined4 param_2,undefined4 param_3,undefined4 param_4,
               undefined4 param_5)

{
  uint uVar1;
  int iVar2;
  int iVar3;
  int iVar4;
  int iVar5;
  int iVar6;
  undefined1 auStack_d8 [176];
  int local_28;
  
  local_28 = **(int **)(DAT_00010910 + 0x107b6);
  uVar1 = (**(code **)(*param_1 + 0x2ac))(param_1,param_3);
  iVar2 = (**(code **)(*param_1 + 0x2ac))(param_1,param_4);
  iVar3 = (**(code **)(*param_1 + 0x2ac))(param_1,param_5);
  if (((0 < (int)uVar1) && ((uVar1 & 0xf) == 0)) && (iVar2 == 0x10 && iVar3 == 0x10)) {
    iVar2 = (**(code **)(*param_1 + 0x2e0))(param_1,param_3,0);
    iVar3 = (**(code **)(*param_1 + 0x2e0))(param_1,param_4,0);
    iVar4 = (**(code **)(*param_1 + 0x2e0))(param_1,param_5,0);
    if ((iVar2 == 0 || iVar3 == 0) || (iVar4 == 0)) {
      if (iVar2 != 0) {
        (**(code **)(*param_1 + 0x300))(param_1,param_3,iVar2,2);
      }
      if (iVar3 != 0) {
        (**(code **)(*param_1 + 0x300))(param_1,param_4,iVar3,2);
      }
      if (iVar4 != 0) {
        (**(code **)(*param_1 + 0x300))(param_1,param_5,iVar4,2);
      }
    }
    else {
      FUN_00010a68(iVar4,auStack_d8);
      FUN_00011090(auStack_d8,iVar3,iVar2,uVar1);
      iVar5 = FUN_000110de(iVar2,uVar1);
      iVar6 = (**(code **)(*param_1 + 0x2c0))(param_1,iVar5);
      if (iVar5 != 0 && iVar6 != 0) {
        (**(code **)(*param_1 + 0x340))(param_1,iVar6,0,iVar5,iVar2);
      }
      (**(code **)(*param_1 + 0x300))(param_1,param_3,iVar2,2);
      (**(code **)(*param_1 + 0x300))(param_1,param_4,iVar3,2);
      (**(code **)(*param_1 + 0x300))(param_1,param_5,iVar4,2);
    }
  }
  if (**(int **)(DAT_00010914 + 0x10878) != local_28) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail(local_28);
  }
  return;
}



/* 00010918 Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeGunzip */

void Java_lyr_stable_wrapper_core_PayloadDecrypt_nativeGunzip
               (int *param_1,undefined4 param_2,undefined4 param_3)

{
  int iVar1;
  int iVar2;
  void *__ptr;
  int iVar3;
  uint __size;
  void *__ptr_00;
  int local_60;
  int iStack_5c;
  undefined4 uStack_58;
  int local_54;
  int local_50;
  int iStack_4c;
  undefined4 uStack_48;
  int iStack_44;
  undefined4 local_40;
  int iStack_3c;
  undefined4 uStack_38;
  int iStack_34;
  undefined4 local_30;
  undefined4 local_2c;
  int local_28;
  
  local_28 = **(int **)(DAT_00010a5c + 0x10928);
  iVar1 = (**(code **)(*param_1 + 0x2ac))(param_1,param_3);
  if ((0 < iVar1) && (iVar2 = (**(code **)(*param_1 + 0x2e0))(param_1,param_3,0), iVar2 != 0)) {
    iStack_5c = *(int *)((undefined1  [16])0x0 + (undefined1  [16])0x4);
    uStack_58 = *(undefined4 *)((undefined1  [16])0x0 + (undefined1  [16])0x8);
    local_54 = *(int *)((undefined1  [16])0x0 + (undefined1  [16])0xc);
    local_2c = 0;
    local_60 = 0;
    local_50 = 0;
    local_40 = 0;
    local_30 = 0;
    __size = iVar1 * 4 + 0x10000;
    iStack_4c = iStack_5c;
    uStack_48 = uStack_58;
    iStack_44 = local_54;
    iStack_3c = iStack_5c;
    uStack_38 = uStack_58;
    iStack_34 = local_54;
    __ptr = malloc(__size);
    if (__ptr == (void *)0x0) {
      (**(code **)(*param_1 + 0x300))(param_1,param_3,iVar2,2);
    }
    else {
      iVar3 = inflateInit2_(&local_60,0x1f,DAT_00010a60 + 0x1098a,0x38);
      if (iVar3 == 0) {
        iVar3 = 0;
        __ptr_00 = __ptr;
        local_60 = iVar2;
        iStack_5c = iVar1;
        do {
          __ptr = __ptr_00;
          if (__size < iVar3 + 0x10000U) {
            __size = __size << 1;
            __ptr = realloc(__ptr_00,__size);
            if (__ptr == (void *)0x0) {
              iVar1 = -4;
              __ptr = __ptr_00;
              break;
            }
          }
          local_54 = (int)__ptr + iVar3;
          local_50 = __size - iVar3;
          iVar1 = inflate(&local_60,0);
          iVar3 = iVar3 + ((__size - iVar3) - local_50);
          __ptr_00 = __ptr;
        } while (iVar1 == 0);
        inflateEnd(&local_60);
        if (((iVar1 == 1) || (iVar3 != 0)) &&
           (iVar1 = (**(code **)(*param_1 + 0x2c0))(param_1,iVar3), iVar1 != 0)) {
          (**(code **)(*param_1 + 0x340))(param_1,iVar1,0,iVar3,__ptr);
        }
      }
      free(__ptr);
      (**(code **)(*param_1 + 0x300))(param_1,param_3,iVar2,2);
    }
  }
  if (**(int **)(DAT_00010a64 + 0x10a48) == local_28) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail(local_28);
}



/* 00010a68 FUN_00010a68 */

void FUN_00010a68(undefined8 *param_1,undefined8 *param_2)

{
  byte bVar1;
  byte bVar2;
  byte bVar3;
  uint uVar4;
  uint uVar5;
  byte bVar6;
  uint uVar7;
  int iVar8;
  byte bVar9;
  byte bVar10;
  uint uVar11;
  byte bVar12;
  uint uVar13;
  undefined8 uVar14;
  
  uVar14 = param_1[1];
  *param_2 = *param_1;
  param_2[1] = uVar14;
  uVar4 = 0xc;
  do {
    bVar9 = *(byte *)((int)param_2 + uVar4);
    uVar5 = uVar4 + 4;
    bVar10 = *(byte *)((int)param_2 + uVar4 + 1);
    uVar11 = (uint)bVar10;
    bVar6 = *(byte *)((int)param_2 + uVar4 + 2);
    uVar7 = (uint)bVar6;
    bVar12 = *(byte *)((int)param_2 + uVar4 + 3);
    uVar13 = (uint)bVar12;
    if ((uVar5 & 0xc) == 0) {
      iVar8 = DAT_00010ae8 + 0x10ac6;
      bVar12 = *(byte *)(iVar8 + (uint)bVar9);
      bVar6 = *(byte *)(iVar8 + uVar13);
      bVar10 = *(byte *)(iVar8 + uVar7);
      bVar9 = *(byte *)(DAT_00010aec + 0x10ac8 + (uVar5 >> 4)) ^ *(byte *)(iVar8 + uVar11);
    }
    bVar1 = *(byte *)((int)param_2 + (uVar4 - 0xc));
    bVar2 = *(byte *)((int)param_2 + (uVar4 - 0xb));
    bVar3 = *(byte *)((int)param_2 + (uVar4 - 9));
    *(byte *)((int)param_2 + uVar4 + 6) = bVar6 ^ *(byte *)((int)param_2 + (uVar4 - 10));
    *(byte *)((int)param_2 + uVar4 + 4) = bVar1 ^ bVar9;
    *(byte *)((int)param_2 + uVar4 + 5) = bVar2 ^ bVar10;
    *(byte *)((int)param_2 + uVar4 + 7) = bVar3 ^ bVar12;
    uVar4 = uVar5;
  } while (uVar5 < 0xac);
  return;
}



/* 00010af0 FUN_00010af0 */

void FUN_00010af0(byte *param_1,ulonglong *param_2)

{
  ulonglong uVar1;
  ulonglong uVar2;
  ulonglong uVar3;
  byte bVar4;
  byte bVar5;
  byte bVar6;
  byte bVar7;
  byte bVar8;
  byte bVar9;
  byte bVar10;
  byte bVar11;
  byte bVar12;
  byte bVar13;
  byte bVar14;
  byte bVar15;
  byte bVar16;
  byte bVar17;
  byte bVar18;
  byte bVar19;
  uint uVar20;
  int iVar21;
  int iVar22;
  ulonglong in_d19;
  ulonglong in_d20;
  ulonglong in_d21;
  ulonglong uVar23;
  ulonglong uVar24;
  ulonglong uVar25;
  ulonglong uVar26;
  ulonglong uVar27;
  ulonglong in_d24;
  ulonglong uVar28;
  ulonglong uVar29;
  undefined8 uVar30;
  undefined8 uVar31;
  ulonglong uVar32;
  ulonglong uVar33;
  ulonglong uVar34;
  undefined8 uVar35;
  ulonglong uVar36;
  ulonglong uVar37;
  undefined8 uVar38;
  ulonglong uVar39;
  ulonglong uVar40;
  
  *(byte *)param_2 = (byte)*param_2 ^ param_1[0xa0];
  *(byte *)((int)param_2 + 1) = param_1[0xa1] ^ *(byte *)((int)param_2 + 1);
  *(byte *)((int)param_2 + 2) = param_1[0xa2] ^ *(byte *)((int)param_2 + 2);
  *(byte *)((int)param_2 + 3) = param_1[0xa3] ^ *(byte *)((int)param_2 + 3);
  *(byte *)((int)param_2 + 4) = param_1[0xa4] ^ *(byte *)((int)param_2 + 4);
  *(byte *)((int)param_2 + 5) = param_1[0xa5] ^ *(byte *)((int)param_2 + 5);
  *(byte *)((int)param_2 + 6) = param_1[0xa6] ^ *(byte *)((int)param_2 + 6);
  *(byte *)((int)param_2 + 7) = param_1[0xa7] ^ *(byte *)((int)param_2 + 7);
  *(byte *)(param_2 + 1) = param_1[0xa8] ^ (byte)param_2[1];
  *(byte *)((int)param_2 + 9) = param_1[0xa9] ^ *(byte *)((int)param_2 + 9);
  *(byte *)((int)param_2 + 10) = param_1[0xaa] ^ *(byte *)((int)param_2 + 10);
  *(byte *)((int)param_2 + 0xb) = param_1[0xab] ^ *(byte *)((int)param_2 + 0xb);
  *(byte *)((int)param_2 + 0xc) = param_1[0xac] ^ *(byte *)((int)param_2 + 0xc);
  *(byte *)((int)param_2 + 0xd) = param_1[0xad] ^ *(byte *)((int)param_2 + 0xd);
  *(byte *)((int)param_2 + 0xe) = param_1[0xae] ^ *(byte *)((int)param_2 + 0xe);
  *(byte *)((int)param_2 + 0xf) = param_1[0xaf] ^ *(byte *)((int)param_2 + 0xf);
  uVar20 = 10;
  iVar21 = 0;
  iVar22 = DAT_00010bc8 + 0x10bb2;
  do {
    bVar4 = *(byte *)((int)param_2 + 2);
    bVar8 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 1));
    bVar5 = *(byte *)((int)param_2 + 3);
    bVar9 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xe));
    bVar10 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xb));
    bVar11 = *(byte *)(iVar22 + (uint)(byte)*param_2);
    bVar12 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 10));
    bVar13 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 4));
    bVar14 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xd));
    bVar15 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 7));
    bVar6 = *(byte *)((int)param_2 + 6);
    *(byte *)((int)param_2 + 4) = bVar13;
    bVar7 = *(byte *)((int)param_2 + 5);
    *(byte *)((int)param_2 + 7) = bVar10;
    *(byte *)((int)param_2 + 3) = bVar15;
    *(byte *)((int)param_2 + 2) = bVar12;
    *(byte *)((int)param_2 + 1) = bVar14;
    *(byte *)param_2 = bVar11;
    *(byte *)((int)param_2 + 6) = bVar9;
    *(byte *)((int)param_2 + 5) = bVar8;
    bVar16 = *(byte *)(iVar22 + (uint)bVar4);
    bVar17 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xf));
    bVar4 = *(byte *)((int)param_2 + 9);
    bVar18 = *(byte *)(iVar22 + (uint)(byte)param_2[1]);
    bVar7 = *(byte *)(iVar22 + (uint)bVar7);
    *(byte *)((int)param_2 + 0xb) = bVar17;
    *(byte *)((int)param_2 + 10) = bVar16;
    *(byte *)((int)param_2 + 9) = bVar7;
    *(byte *)(param_2 + 1) = bVar18;
    bVar4 = *(byte *)(iVar22 + (uint)bVar4);
    bVar6 = *(byte *)(iVar22 + (uint)bVar6);
    bVar19 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xc));
    bVar5 = *(byte *)(iVar22 + (uint)bVar5);
    *(byte *)((int)param_2 + 0xe) = bVar6;
    *(byte *)((int)param_2 + 0xf) = bVar5;
    *(byte *)((int)param_2 + 0xd) = bVar4;
    *(byte *)((int)param_2 + 0xc) = bVar19;
    *(byte *)param_2 = param_1[iVar21 + 0x90] ^ bVar11;
    *(byte *)((int)param_2 + 1) = bVar14 ^ param_1[iVar21 + 0x91];
    *(byte *)((int)param_2 + 2) = param_1[iVar21 + 0x92] ^ bVar12;
    *(byte *)((int)param_2 + 3) = param_1[iVar21 + 0x93] ^ bVar15;
    *(byte *)((int)param_2 + 4) = param_1[iVar21 + 0x94] ^ bVar13;
    *(byte *)((int)param_2 + 5) = param_1[iVar21 + 0x95] ^ bVar8;
    *(byte *)((int)param_2 + 6) = param_1[iVar21 + 0x96] ^ bVar9;
    *(byte *)((int)param_2 + 7) = param_1[iVar21 + 0x97] ^ bVar10;
    *(byte *)(param_2 + 1) = param_1[iVar21 + 0x98] ^ bVar18;
    *(byte *)((int)param_2 + 9) = param_1[iVar21 + 0x99] ^ bVar7;
    *(byte *)((int)param_2 + 10) = param_1[iVar21 + 0x9a] ^ bVar16;
    *(byte *)((int)param_2 + 0xb) = param_1[iVar21 + 0x9b] ^ bVar17;
    *(byte *)((int)param_2 + 0xc) = param_1[iVar21 + 0x9c] ^ bVar19;
    *(byte *)((int)param_2 + 0xd) = param_1[iVar21 + 0x9d] ^ bVar4;
    *(byte *)((int)param_2 + 0xe) = param_1[iVar21 + 0x9e] ^ bVar6;
    *(byte *)((int)param_2 + 0xf) = param_1[iVar21 + 0x9f] ^ bVar5;
    uVar23 = *param_2;
    uVar1 = in_d21 & 0xff00ff00ff00ff00 | uVar23 >> 8 & 0xff;
    uVar30 = VectorShiftLeft(uVar1,8,0x10,0);
    uVar24 = VectorShiftLeft(uVar1,1,0x10,0);
    uVar2 = in_d24 & 0xff00ff00ff00ff00 | uVar23 & 0xff;
    uVar31 = VectorShiftRight(uVar30,8);
    uVar30 = VectorShiftLeft(uVar2,8,0x10,0);
    uVar26 = VectorShiftLeft(uVar2,1,0x10,0);
    uVar20 = uVar20 - 1;
    uVar3 = in_d19 & 0xff00ff00ff00ff00 | uVar23 >> 0x18 & 0xff;
    iVar21 = iVar21 + -0x10;
    uVar23 = in_d20 & 0xff00ff00ff00ff00 | uVar23 >> 0x10 & 0xff;
    uVar35 = VectorShiftLeft(uVar3,8,0x10,0);
    uVar34 = VectorShiftLeft(uVar3,1,0x10,0);
    uVar30 = VectorShiftRight(uVar30,8);
    uVar30 = VectorCompareGreaterThan(0,uVar30,2);
    uVar38 = VectorShiftLeft(uVar23,8,0x10,0);
    uVar27 = VectorBitwiseInsertIfTrue(uVar26,uVar26 ^ 0x1b001b001b001b,uVar30);
    uVar30 = VectorCompareGreaterThan(0,uVar31,2);
    uVar31 = VectorShiftRight(uVar35,8);
    uVar26 = VectorShiftLeft(uVar23,1,0x10,0);
    uVar25 = VectorBitwiseInsertIfTrue(uVar24,uVar24 ^ 0x1b001b001b001b,uVar30);
    uVar30 = VectorCompareGreaterThan(0,uVar31,2);
    uVar28 = VectorBitwiseSelect(uVar30,uVar34 ^ 0x1b001b001b001b,uVar34);
    uVar30 = VectorShiftRight(uVar38,8);
    uVar30 = VectorCompareGreaterThan(0,uVar30,2);
    uVar32 = VectorBitwiseSelect(uVar30,uVar26 ^ 0x1b001b001b001b,uVar26);
    uVar30 = VectorShiftLeft(uVar25,8,0x10,0);
    uVar35 = VectorShiftLeft(uVar27,8,0x10,0);
    uVar24 = VectorShiftLeft(uVar25,1,0x10,0);
    uVar34 = VectorShiftLeft(uVar27,1,0x10,0);
    uVar30 = VectorShiftRight(uVar30,8);
    uVar31 = VectorCompareGreaterThan(0,uVar30,2);
    uVar35 = VectorShiftRight(uVar35,8);
    uVar30 = VectorShiftLeft(uVar32,8,0x10,0);
    uVar26 = VectorBitwiseInsertIfFalse(uVar24 ^ 0x1b001b001b001b,uVar24,uVar31);
    uVar31 = VectorCompareGreaterThan(0,uVar35,2);
    uVar34 = VectorBitwiseSelect(uVar31,uVar34 ^ 0x1b001b001b001b,uVar34);
    uVar40 = VectorShiftLeft(uVar32,1,0x10,0);
    uVar24 = VectorShiftLeft(uVar28,1,0x10,0);
    uVar31 = VectorShiftLeft(uVar28,8,0x10,0);
    uVar30 = VectorShiftRight(uVar30,8);
    uVar35 = VectorCompareGreaterThan(0,uVar30,2);
    uVar37 = VectorShiftLeft(uVar34,1,0x10,0);
    uVar30 = VectorShiftLeft(uVar34,8,0x10,0);
    uVar33 = VectorBitwiseSelect(uVar35,uVar40 ^ 0x1b001b001b001b,uVar40);
    uVar31 = VectorShiftRight(uVar31,8);
    uVar31 = VectorCompareGreaterThan(0,uVar31,2);
    uVar35 = VectorShiftLeft(uVar26,8,0x10,0);
    uVar40 = VectorBitwiseSelect(uVar31,uVar24 ^ 0x1b001b001b001b,uVar24);
    uVar30 = VectorShiftRight(uVar30,8);
    uVar24 = VectorShiftLeft(uVar26,1,0x10,0);
    uVar30 = VectorCompareGreaterThan(0,uVar30,2);
    uVar31 = VectorShiftLeft(uVar33,8,0x10,0);
    uVar39 = VectorShiftLeft(uVar33,1,0x10,0);
    uVar35 = VectorShiftRight(uVar35,8);
    uVar37 = VectorBitwiseSelect(uVar30,uVar37 ^ 0x1b001b001b001b,uVar37);
    uVar35 = VectorCompareGreaterThan(0,uVar35,2);
    uVar30 = VectorShiftLeft(uVar40,8,0x10,0);
    uVar31 = VectorShiftRight(uVar31,8);
    uVar29 = VectorShiftLeft(uVar40,1,0x10,0);
    uVar31 = VectorCompareGreaterThan(0,uVar31,2);
    uVar36 = VectorBitwiseInsertIfTrue(uVar24,uVar24 ^ 0x1b001b001b001b,uVar35);
    uVar30 = VectorShiftRight(uVar30,8);
    uVar24 = VectorBitwiseSelect(uVar31,uVar39 ^ 0x1b001b001b001b,uVar39);
    uVar30 = VectorCompareGreaterThan(0,uVar30,2);
    in_d24 = VectorBitwiseInsertIfTrue(uVar29,uVar29 ^ 0x1b001b001b001b,uVar30);
    in_d21 = uVar23 ^ uVar1 ^ uVar3 ^ uVar27 ^ uVar25 ^ uVar34 ^ uVar33 ^ uVar37 ^ uVar36 ^ uVar24;
    in_d20 = uVar28 ^ uVar1 ^ uVar2 ^ uVar23 ^ uVar27 ^ uVar26 ^ uVar40 ^ uVar37 ^ uVar36 ^ uVar24 ^
             in_d24;
    in_d19 = uVar23 ^ uVar2 ^ uVar3 ^ uVar25 ^ uVar32 ^ uVar26 ^ uVar40 ^ uVar37 ^ uVar36 ^ uVar24 ^
             in_d24;
    VectorUnzip(in_d20,1);
    VectorUnzip(in_d19,1);
    VectorTableLookup(param_2,(uint)bVar5,2);
    VectorTableLookup(iVar21,(uint)bVar5,2);
    *param_2 = in_d20;
    param_2[1] = in_d21;
  } while (1 < uVar20);
  bVar4 = *(byte *)((int)param_2 + 3);
  bVar7 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xe));
  bVar14 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 1));
  bVar8 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xb));
  bVar15 = *(byte *)(iVar22 + (uint)(byte)*param_2);
  bVar9 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 4));
  bVar16 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xd));
  bVar17 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 7));
  bVar10 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 10));
  bVar13 = *(byte *)((int)param_2 + 2);
  bVar5 = *(byte *)((int)param_2 + 5);
  *(byte *)((int)param_2 + 7) = bVar8;
  bVar6 = *(byte *)((int)param_2 + 6);
  *(byte *)((int)param_2 + 3) = bVar17;
  *(byte *)((int)param_2 + 2) = bVar10;
  *(byte *)((int)param_2 + 1) = bVar16;
  *(byte *)param_2 = bVar15;
  *(byte *)((int)param_2 + 4) = bVar9;
  *(byte *)((int)param_2 + 6) = bVar7;
  *(byte *)((int)param_2 + 5) = bVar14;
  bVar11 = *(byte *)(iVar22 + (uint)bVar5);
  bVar5 = *(byte *)((int)param_2 + 9);
  bVar12 = *(byte *)(iVar22 + (uint)(byte)param_2[1]);
  bVar13 = *(byte *)(iVar22 + (uint)bVar13);
  bVar18 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xf));
  *(byte *)((int)param_2 + 0xb) = bVar18;
  *(byte *)((int)param_2 + 10) = bVar13;
  *(byte *)((int)param_2 + 9) = bVar11;
  *(byte *)(param_2 + 1) = bVar12;
  bVar19 = *(byte *)(iVar22 + (uint)bVar5);
  bVar5 = *(byte *)(iVar22 + (uint)bVar6);
  bVar6 = *(byte *)(iVar22 + (uint)*(byte *)((int)param_2 + 0xc));
  bVar4 = *(byte *)(iVar22 + (uint)bVar4);
  *(byte *)((int)param_2 + 0xe) = bVar5;
  *(byte *)((int)param_2 + 0xf) = bVar4;
  *(byte *)((int)param_2 + 0xd) = bVar19;
  *(byte *)((int)param_2 + 0xc) = bVar6;
  *(byte *)param_2 = *param_1 ^ bVar15;
  *(byte *)((int)param_2 + 1) = param_1[1] ^ bVar16;
  *(byte *)((int)param_2 + 2) = param_1[2] ^ bVar10;
  *(byte *)((int)param_2 + 3) = param_1[3] ^ bVar17;
  *(byte *)((int)param_2 + 4) = param_1[4] ^ bVar9;
  *(byte *)((int)param_2 + 5) = param_1[5] ^ bVar14;
  *(byte *)((int)param_2 + 6) = param_1[6] ^ bVar7;
  *(byte *)((int)param_2 + 7) = param_1[7] ^ bVar8;
  *(byte *)(param_2 + 1) = param_1[8] ^ bVar12;
  *(byte *)((int)param_2 + 9) = param_1[9] ^ bVar11;
  *(byte *)((int)param_2 + 10) = param_1[10] ^ bVar13;
  *(byte *)((int)param_2 + 0xb) = param_1[0xb] ^ bVar18;
  *(byte *)((int)param_2 + 0xc) = param_1[0xc] ^ bVar6;
  *(byte *)((int)param_2 + 0xd) = param_1[0xd] ^ bVar19;
  *(byte *)((int)param_2 + 0xe) = param_1[0xe] ^ bVar5;
  *(byte *)((int)param_2 + 0xf) = param_1[0xf] ^ bVar4;
  return;
}



/* 00011090 FUN_00011090 */

void FUN_00011090(undefined4 param_1,uint *param_2,int param_3,uint param_4)

{
  uint uVar1;
  uint uVar2;
  uint uVar3;
  uint uVar4;
  uint uVar5;
  int iVar6;
  uint *puVar7;
  uint uVar8;
  uint uVar9;
  uint uVar10;
  uint uVar11;
  
  if (param_4 < 0x10) {
    return;
  }
  iVar6 = 0;
  uVar8 = *param_2;
  uVar9 = param_2[1];
  uVar10 = param_2[2];
  uVar11 = param_2[3];
  do {
    puVar7 = (uint *)(param_3 + iVar6);
    uVar1 = *puVar7;
    uVar2 = puVar7[1];
    uVar3 = puVar7[2];
    uVar4 = puVar7[3];
    FUN_00010af0(param_1,puVar7);
    uVar5 = iVar6 + 0x20;
    iVar6 = iVar6 + 0x10;
    *puVar7 = *puVar7 ^ uVar8;
    puVar7[1] = puVar7[1] ^ uVar9;
    puVar7[2] = puVar7[2] ^ uVar10;
    puVar7[3] = puVar7[3] ^ uVar11;
    uVar8 = uVar1;
    uVar9 = uVar2;
    uVar10 = uVar3;
    uVar11 = uVar4;
  } while (uVar5 <= param_4);
  return;
}



/* 000110de FUN_000110de */

uint FUN_000110de(int param_1,uint param_2)

{
  uint uVar1;
  int iVar2;
  uint uVar3;
  bool bVar4;
  
  if ((param_2 != 0) && ((param_2 & 0xf) == 0)) {
    uVar3 = (uint)*(byte *)(param_1 + param_2 + -1);
    if (0xffffffef < uVar3 - 0x11) {
      uVar1 = param_2 - uVar3;
      if (param_2 <= uVar1) {
        return uVar1;
      }
      iVar2 = -uVar3;
      while (*(byte *)(param_1 + param_2 + iVar2) == uVar3) {
        bVar4 = iVar2 == -1;
        iVar2 = iVar2 + 1;
        if (bVar4) {
          return uVar1;
        }
      }
    }
  }
  return 0;
}



/* 00011170 __stack_chk_fail */

void __stack_chk_fail(void)

{
  (*(code *)PTR___stack_chk_fail_000122d8)();
  return;
}



/* 00011180 malloc */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * malloc(size_t __size)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_malloc_000122dc)(__size);
  return pvVar1;
}



/* 00011190 inflateInit2_ */

void inflateInit2_(void)

{
  (*(code *)PTR_inflateInit2__000122e0)();
  return;
}



/* 000111a0 inflate */

void inflate(void)

{
  (*(code *)PTR_inflate_000122e4)();
  return;
}



/* 000111b0 realloc */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * realloc(void *__ptr,size_t __size)

{
  void *pvVar1;
  
  pvVar1 = (void *)(*(code *)PTR_realloc_000122e8)(__ptr);
  return pvVar1;
}



/* 000111c0 inflateEnd */

void inflateEnd(void)

{
  (*(code *)PTR_inflateEnd_000122ec)();
  return;
}



/* 000111d0 free */

/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void free(void *__ptr)

{
  (*(code *)PTR_free_000122f0)(__ptr);
  return;
}



/* 00013000 __cxa_finalize */

/* WARNING: Control flow encountered bad instruction data */

void __cxa_finalize(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00013004 __cxa_atexit */

/* WARNING: Control flow encountered bad instruction data */

void __cxa_atexit(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00013008 __register_atfork */

/* WARNING: Control flow encountered bad instruction data */

void __register_atfork(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 0001300c __stack_chk_fail */

/* WARNING: Control flow encountered bad instruction data */

void __stack_chk_fail(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00013014 malloc */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * malloc(size_t __size)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00013018 inflateInit2_ */

/* WARNING: Control flow encountered bad instruction data */

void inflateInit2_(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 0001301c inflate */

/* WARNING: Control flow encountered bad instruction data */

void inflate(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00013020 realloc */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void * realloc(void *__ptr,size_t __size)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00013024 inflateEnd */

/* WARNING: Control flow encountered bad instruction data */

void inflateEnd(void)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}



/* 00013028 free */

/* WARNING: Control flow encountered bad instruction data */
/* WARNING: Unknown calling convention -- yet parameter storage is locked */

void free(void *__ptr)

{
                    /* WARNING: Bad instruction - Truncating control flow here */
  halt_baddata();
}
