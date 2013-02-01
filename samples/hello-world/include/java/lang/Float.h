//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/luni/src/main/java/java/lang/Float.java
//
//  Created by rwl on 2/1/13.
//

#import "JreEmulation.h"
#import "java/lang/Comparable.h"

#define JavaLangFloat_MAX_VALUE __FLT_MAX__
#define JavaLangFloat_MIN_VALUE __FLT_MIN__
#define JavaLangFloat_NEGATIVE_INFINITY -INFINITY
#define JavaLangFloat_NaN NAN
#define JavaLangFloat_POSITIVE_INFINITY INFINITY
#define JavaLangFloat_SIZE 32

@interface JavaLangFloat : NSNumber < JavaLangComparable > {
 @public
  float value_;
}

@property (nonatomic, assign) float value;

+ (float)MAX_VALUE;
+ (float)MIN_VALUE;
+ (float)NaN;
+ (float)POSITIVE_INFINITY;
+ (float)NEGATIVE_INFINITY;
+ (IOSClass *)TYPE;
+ (int)SIZE;
- (id)initWithFloat:(float)value;
- (id)initWithDouble:(double)value;
- (id)initWithNSString:(NSString *)string;
- (int)compareToWithId:(JavaLangFloat *)object;
- (char)byteValue;
- (double)doubleValue;
- (BOOL)isEqual:(id)object;
+ (int)floatToIntBitsWithFloat:(float)value;
+ (int)floatToRawIntBitsWithFloat:(float)value;
- (float)floatValue;
- (NSUInteger)hash;
+ (float)intBitsToFloatWithInt:(int)bits;
- (int)intValue;
- (BOOL)isInfinite;
+ (BOOL)isInfiniteWithFloat:(float)f;
- (BOOL)isNaN;
+ (BOOL)isNaNWithFloat:(float)f;
- (long long int)longLongValue;
+ (float)parseFloatWithNSString:(NSString *)string;
- (short int)shortValue;
- (NSString *)description;
+ (NSString *)toStringWithFloat:(float)f;
+ (JavaLangFloat *)valueOfWithNSString:(NSString *)string;
+ (int)compareWithFloat:(float)float1
              withFloat:(float)float2;
+ (JavaLangFloat *)valueOfWithFloat:(float)f;
+ (NSString *)toHexStringWithFloat:(float)f;
@end
