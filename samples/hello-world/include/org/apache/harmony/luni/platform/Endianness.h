//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/rwl/src/tball/jre_emul/apache_harmony/classlib/modules/luni/src/main/java/org/apache/harmony/luni/platform/Endianness.java
//
//  Created by rwl on 2/1/13.
//

#import "JreEmulation.h"

@interface OrgApacheHarmonyLuniPlatformEndianness : NSObject {
 @public
  NSString *displayName_;
}

@property (nonatomic, copy) NSString *displayName;

+ (OrgApacheHarmonyLuniPlatformEndianness *)getBIG_ENDIAN;
+ (OrgApacheHarmonyLuniPlatformEndianness *)getLITTLE_ENDIAN;
- (id)initWithNSString:(NSString *)displayName;
- (NSString *)description;
@end
