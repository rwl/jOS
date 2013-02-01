//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/luni/src/main/java/java/util/Random.java
//
//  Created by rwl on 2/1/13.
//

@class IOSByteArray;

#import "JreEmulation.h"
#import "java/io/Serializable.h"

#define JavaUtilRandom_multiplier 25214903917
#define JavaUtilRandom_serialVersionUID 3905348978240129619

@interface JavaUtilRandom : NSObject < JavaIoSerializable > {
 @public
  BOOL haveNextNextGaussian_;
  long long int seed_;
  double nextNextGaussian_;
}

@property (nonatomic, assign) BOOL haveNextNextGaussian;
@property (nonatomic, assign) long long int seed;
@property (nonatomic, assign) double nextNextGaussian;

- (id)init;
- (id)initWithLongInt:(long long int)seed;
- (int)nextWithInt:(int)bits;
- (BOOL)nextBoolean;
- (void)nextBytesWithJavaLangByteArray:(IOSByteArray *)buf;
- (double)nextDouble;
- (float)nextFloat;
- (double)nextGaussian;
+ (double)iOS_sqrtWithDouble:(double)a;
+ (double)iOS_logWithDouble:(double)a;
- (int)nextInt;
- (int)nextIntWithInt:(int)n;
- (long long int)nextLong;
- (void)setSeedWithLongInt:(long long int)seed;
@end
