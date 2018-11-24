/**
 * The first thing to know about are types. The available types in Thrift are:
 *
 *  bool        Boolean, one byte
 *  i8 (byte)   Signed 8-bit integer
 *  i16         Signed 16-bit integer
 *  i32         Signed 32-bit integer
 *  i64         Signed 64-bit integer
 *  double      64-bit floating point value
 *  string      String
 *  binary      Blob (byte array)
 *  map<t1,t2>  Map from one type to another
 *  list<t1>    Ordered list of one type
 *  set<t1>     Set of unique elements of one type
 *
 * Did you also notice that Thrift supports C style comments?
 */


include "shared.thrift"

namespace java search

enum Operation {
  SEARCH = 1,
  REPORT = 2
}

struct MessagePackage{
  1: i32 id,
  2: i32 len,
  3: i32 cnt,
  4: i32 to,
  5: i32 fromId,
  6: Operation op,
  7: double between,
  8: list<i32> edge
}

exception InvalidOperation {
  1: i32 whatOp,
  2: string why
}

service Search extends shared.SharedService {
   void ping(),
   void search(1:MessagePackage msg)
}

