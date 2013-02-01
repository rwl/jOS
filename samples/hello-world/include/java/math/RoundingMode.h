//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/math/src/main/java/java/math/RoundingMode.java
//
//  Created by rwl on 2/1/13.
//

@class JavaMathRoundingModeEnum;

#import "JreEmulation.h"
#import "java/lang/Enum.h"

typedef enum {
  JavaMathRoundingMode_UP = 0,
  JavaMathRoundingMode_DOWN = 1,
  JavaMathRoundingMode_CEILING = 2,
  JavaMathRoundingMode_FLOOR = 3,
  JavaMathRoundingMode_HALF_UP = 4,
  JavaMathRoundingMode_HALF_DOWN = 5,
  JavaMathRoundingMode_HALF_EVEN = 6,
  JavaMathRoundingMode_UNNECESSARY = 7,
} JavaMathRoundingMode;

@interface JavaMathRoundingModeEnum : JavaLangEnum < NSCopying > {
 @public
  int bigDecimalRM_;
}
@property (nonatomic, assign) int bigDecimalRM;

+ (JavaMathRoundingModeEnum *)UP;
+ (JavaMathRoundingModeEnum *)DOWN;
+ (JavaMathRoundingModeEnum *)CEILING;
+ (JavaMathRoundingModeEnum *)FLOOR;
+ (JavaMathRoundingModeEnum *)HALF_UP;
+ (JavaMathRoundingModeEnum *)HALF_DOWN;
+ (JavaMathRoundingModeEnum *)HALF_EVEN;
+ (JavaMathRoundingModeEnum *)UNNECESSARY;
+ (IOSObjectArray *)values;
+ (JavaMathRoundingModeEnum *)valueOfWithNSString:(NSString *)name;
- (id)copyWithZone:(NSZone *)zone;
- (id)initWithInt:(int)rm
     withNSString:(NSString *)name
          withInt:(int)ordinal;
+ (JavaMathRoundingModeEnum *)valueOfWithInt:(int)mode;
@end
