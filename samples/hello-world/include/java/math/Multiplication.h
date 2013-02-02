//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/math/src/main/java/java/math/Multiplication.java
//
//  Created by rwl on 2/1/13.
//

@class IOSIntArray;
@class IOSObjectArray;
@class JavaMathBigInteger;

#import "JreEmulation.h"

#define JavaMathMultiplication_whenUseKaratsuba 63

@interface JavaMathMultiplication : NSObject {
}

- (id)init;
+ (int)whenUseKaratsuba;
+ (IOSIntArray *)tenPows;
+ (IOSIntArray *)fivePows;
+ (IOSObjectArray *)bigTenPows;
+ (IOSObjectArray *)bigFivePows;
+ (JavaMathBigInteger *)multiplyWithJavaMathBigInteger:(JavaMathBigInteger *)x
                                withJavaMathBigInteger:(JavaMathBigInteger *)y;
+ (JavaMathBigInteger *)karatsubaWithJavaMathBigInteger:(JavaMathBigInteger *)op1
                                 withJavaMathBigInteger:(JavaMathBigInteger *)op2;
+ (JavaMathBigInteger *)multiplyPAPWithJavaMathBigInteger:(JavaMathBigInteger *)a
                                   withJavaMathBigInteger:(JavaMathBigInteger *)b;
+ (void)multArraysPAPWithJavaLangIntegerArray:(IOSIntArray *)aDigits
                                      withInt:(int)aLen
                     withJavaLangIntegerArray:(IOSIntArray *)bDigits
                                      withInt:(int)bLen
                     withJavaLangIntegerArray:(IOSIntArray *)resDigits;
+ (void)multPAPWithJavaLangIntegerArray:(IOSIntArray *)a
               withJavaLangIntegerArray:(IOSIntArray *)b
               withJavaLangIntegerArray:(IOSIntArray *)t
                                withInt:(int)aLen
                                withInt:(int)bLen;
+ (int)multiplyByIntWithJavaLangIntegerArray:(IOSIntArray *)res
                    withJavaLangIntegerArray:(IOSIntArray *)a
                                     withInt:(int)aSize
                                     withInt:(int)factor;
+ (int)multiplyByIntWithJavaLangIntegerArray:(IOSIntArray *)a
                                     withInt:(int)aSize
                                     withInt:(int)factor;
+ (JavaMathBigInteger *)multiplyByPositiveIntWithJavaMathBigInteger:(JavaMathBigInteger *)val
                                                            withInt:(int)factor;
+ (JavaMathBigInteger *)powWithJavaMathBigInteger:(JavaMathBigInteger *)base
                                          withInt:(int)exponent;
+ (IOSIntArray *)squareWithJavaLangIntegerArray:(IOSIntArray *)a
                                        withInt:(int)aLen
                       withJavaLangIntegerArray:(IOSIntArray *)res;
+ (JavaMathBigInteger *)multiplyByTenPowWithJavaMathBigInteger:(JavaMathBigInteger *)val
                                                   withLongInt:(long long int)exp;
+ (JavaMathBigInteger *)powerOf10WithLongInt:(long long int)exp;
+ (JavaMathBigInteger *)multiplyByFivePowWithJavaMathBigInteger:(JavaMathBigInteger *)val
                                                        withInt:(int)exp;
+ (long long int)unsignedMultAddAddWithInt:(int)a
                                   withInt:(int)b
                                   withInt:(int)c
                                   withInt:(int)d;
@end