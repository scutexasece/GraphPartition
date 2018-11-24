/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package search;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-11-23")
public class MessagePackage implements org.apache.thrift.TBase<MessagePackage, MessagePackage._Fields>, java.io.Serializable, Cloneable, Comparable<MessagePackage> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MessagePackage");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField LEN_FIELD_DESC = new org.apache.thrift.protocol.TField("len", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField CNT_FIELD_DESC = new org.apache.thrift.protocol.TField("cnt", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField TO_FIELD_DESC = new org.apache.thrift.protocol.TField("to", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField FROM_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("fromId", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField OP_FIELD_DESC = new org.apache.thrift.protocol.TField("op", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField BETWEEN_FIELD_DESC = new org.apache.thrift.protocol.TField("between", org.apache.thrift.protocol.TType.DOUBLE, (short)7);
  private static final org.apache.thrift.protocol.TField EDGE_FIELD_DESC = new org.apache.thrift.protocol.TField("edge", org.apache.thrift.protocol.TType.LIST, (short)8);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MessagePackageStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MessagePackageTupleSchemeFactory();

  public int id; // required
  public int len; // required
  public int cnt; // required
  public int to; // required
  public int fromId; // required
  /**
   * 
   * @see Operation
   */
  public Operation op; // required
  public double between; // required
  public java.util.List<java.lang.Integer> edge; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    LEN((short)2, "len"),
    CNT((short)3, "cnt"),
    TO((short)4, "to"),
    FROM_ID((short)5, "fromId"),
    /**
     * 
     * @see Operation
     */
    OP((short)6, "op"),
    BETWEEN((short)7, "between"),
    EDGE((short)8, "edge");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // LEN
          return LEN;
        case 3: // CNT
          return CNT;
        case 4: // TO
          return TO;
        case 5: // FROM_ID
          return FROM_ID;
        case 6: // OP
          return OP;
        case 7: // BETWEEN
          return BETWEEN;
        case 8: // EDGE
          return EDGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __LEN_ISSET_ID = 1;
  private static final int __CNT_ISSET_ID = 2;
  private static final int __TO_ISSET_ID = 3;
  private static final int __FROMID_ISSET_ID = 4;
  private static final int __BETWEEN_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LEN, new org.apache.thrift.meta_data.FieldMetaData("len", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CNT, new org.apache.thrift.meta_data.FieldMetaData("cnt", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TO, new org.apache.thrift.meta_data.FieldMetaData("to", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FROM_ID, new org.apache.thrift.meta_data.FieldMetaData("fromId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.OP, new org.apache.thrift.meta_data.FieldMetaData("op", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, Operation.class)));
    tmpMap.put(_Fields.BETWEEN, new org.apache.thrift.meta_data.FieldMetaData("between", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.EDGE, new org.apache.thrift.meta_data.FieldMetaData("edge", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MessagePackage.class, metaDataMap);
  }

  public MessagePackage() {
  }

  public MessagePackage(
    int id,
    int len,
    int cnt,
    int to,
    int fromId,
    Operation op,
    double between,
    java.util.List<java.lang.Integer> edge)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.len = len;
    setLenIsSet(true);
    this.cnt = cnt;
    setCntIsSet(true);
    this.to = to;
    setToIsSet(true);
    this.fromId = fromId;
    setFromIdIsSet(true);
    this.op = op;
    this.between = between;
    setBetweenIsSet(true);
    this.edge = edge;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MessagePackage(MessagePackage other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.len = other.len;
    this.cnt = other.cnt;
    this.to = other.to;
    this.fromId = other.fromId;
    if (other.isSetOp()) {
      this.op = other.op;
    }
    this.between = other.between;
    if (other.isSetEdge()) {
      java.util.List<java.lang.Integer> __this__edge = new java.util.ArrayList<java.lang.Integer>(other.edge);
      this.edge = __this__edge;
    }
  }

  public MessagePackage deepCopy() {
    return new MessagePackage(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setLenIsSet(false);
    this.len = 0;
    setCntIsSet(false);
    this.cnt = 0;
    setToIsSet(false);
    this.to = 0;
    setFromIdIsSet(false);
    this.fromId = 0;
    this.op = null;
    setBetweenIsSet(false);
    this.between = 0.0;
    this.edge = null;
  }

  public int getId() {
    return this.id;
  }

  public MessagePackage setId(int id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public int getLen() {
    return this.len;
  }

  public MessagePackage setLen(int len) {
    this.len = len;
    setLenIsSet(true);
    return this;
  }

  public void unsetLen() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LEN_ISSET_ID);
  }

  /** Returns true if field len is set (has been assigned a value) and false otherwise */
  public boolean isSetLen() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LEN_ISSET_ID);
  }

  public void setLenIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LEN_ISSET_ID, value);
  }

  public int getCnt() {
    return this.cnt;
  }

  public MessagePackage setCnt(int cnt) {
    this.cnt = cnt;
    setCntIsSet(true);
    return this;
  }

  public void unsetCnt() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CNT_ISSET_ID);
  }

  /** Returns true if field cnt is set (has been assigned a value) and false otherwise */
  public boolean isSetCnt() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CNT_ISSET_ID);
  }

  public void setCntIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CNT_ISSET_ID, value);
  }

  public int getTo() {
    return this.to;
  }

  public MessagePackage setTo(int to) {
    this.to = to;
    setToIsSet(true);
    return this;
  }

  public void unsetTo() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TO_ISSET_ID);
  }

  /** Returns true if field to is set (has been assigned a value) and false otherwise */
  public boolean isSetTo() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TO_ISSET_ID);
  }

  public void setToIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TO_ISSET_ID, value);
  }

  public int getFromId() {
    return this.fromId;
  }

  public MessagePackage setFromId(int fromId) {
    this.fromId = fromId;
    setFromIdIsSet(true);
    return this;
  }

  public void unsetFromId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __FROMID_ISSET_ID);
  }

  /** Returns true if field fromId is set (has been assigned a value) and false otherwise */
  public boolean isSetFromId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __FROMID_ISSET_ID);
  }

  public void setFromIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __FROMID_ISSET_ID, value);
  }

  /**
   * 
   * @see Operation
   */
  public Operation getOp() {
    return this.op;
  }

  /**
   * 
   * @see Operation
   */
  public MessagePackage setOp(Operation op) {
    this.op = op;
    return this;
  }

  public void unsetOp() {
    this.op = null;
  }

  /** Returns true if field op is set (has been assigned a value) and false otherwise */
  public boolean isSetOp() {
    return this.op != null;
  }

  public void setOpIsSet(boolean value) {
    if (!value) {
      this.op = null;
    }
  }

  public double getBetween() {
    return this.between;
  }

  public MessagePackage setBetween(double between) {
    this.between = between;
    setBetweenIsSet(true);
    return this;
  }

  public void unsetBetween() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BETWEEN_ISSET_ID);
  }

  /** Returns true if field between is set (has been assigned a value) and false otherwise */
  public boolean isSetBetween() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BETWEEN_ISSET_ID);
  }

  public void setBetweenIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BETWEEN_ISSET_ID, value);
  }

  public int getEdgeSize() {
    return (this.edge == null) ? 0 : this.edge.size();
  }

  public java.util.Iterator<java.lang.Integer> getEdgeIterator() {
    return (this.edge == null) ? null : this.edge.iterator();
  }

  public void addToEdge(int elem) {
    if (this.edge == null) {
      this.edge = new java.util.ArrayList<java.lang.Integer>();
    }
    this.edge.add(elem);
  }

  public java.util.List<java.lang.Integer> getEdge() {
    return this.edge;
  }

  public MessagePackage setEdge(java.util.List<java.lang.Integer> edge) {
    this.edge = edge;
    return this;
  }

  public void unsetEdge() {
    this.edge = null;
  }

  /** Returns true if field edge is set (has been assigned a value) and false otherwise */
  public boolean isSetEdge() {
    return this.edge != null;
  }

  public void setEdgeIsSet(boolean value) {
    if (!value) {
      this.edge = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((java.lang.Integer)value);
      }
      break;

    case LEN:
      if (value == null) {
        unsetLen();
      } else {
        setLen((java.lang.Integer)value);
      }
      break;

    case CNT:
      if (value == null) {
        unsetCnt();
      } else {
        setCnt((java.lang.Integer)value);
      }
      break;

    case TO:
      if (value == null) {
        unsetTo();
      } else {
        setTo((java.lang.Integer)value);
      }
      break;

    case FROM_ID:
      if (value == null) {
        unsetFromId();
      } else {
        setFromId((java.lang.Integer)value);
      }
      break;

    case OP:
      if (value == null) {
        unsetOp();
      } else {
        setOp((Operation)value);
      }
      break;

    case BETWEEN:
      if (value == null) {
        unsetBetween();
      } else {
        setBetween((java.lang.Double)value);
      }
      break;

    case EDGE:
      if (value == null) {
        unsetEdge();
      } else {
        setEdge((java.util.List<java.lang.Integer>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case LEN:
      return getLen();

    case CNT:
      return getCnt();

    case TO:
      return getTo();

    case FROM_ID:
      return getFromId();

    case OP:
      return getOp();

    case BETWEEN:
      return getBetween();

    case EDGE:
      return getEdge();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case LEN:
      return isSetLen();
    case CNT:
      return isSetCnt();
    case TO:
      return isSetTo();
    case FROM_ID:
      return isSetFromId();
    case OP:
      return isSetOp();
    case BETWEEN:
      return isSetBetween();
    case EDGE:
      return isSetEdge();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof MessagePackage)
      return this.equals((MessagePackage)that);
    return false;
  }

  public boolean equals(MessagePackage that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_id = true;
    boolean that_present_id = true;
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_len = true;
    boolean that_present_len = true;
    if (this_present_len || that_present_len) {
      if (!(this_present_len && that_present_len))
        return false;
      if (this.len != that.len)
        return false;
    }

    boolean this_present_cnt = true;
    boolean that_present_cnt = true;
    if (this_present_cnt || that_present_cnt) {
      if (!(this_present_cnt && that_present_cnt))
        return false;
      if (this.cnt != that.cnt)
        return false;
    }

    boolean this_present_to = true;
    boolean that_present_to = true;
    if (this_present_to || that_present_to) {
      if (!(this_present_to && that_present_to))
        return false;
      if (this.to != that.to)
        return false;
    }

    boolean this_present_fromId = true;
    boolean that_present_fromId = true;
    if (this_present_fromId || that_present_fromId) {
      if (!(this_present_fromId && that_present_fromId))
        return false;
      if (this.fromId != that.fromId)
        return false;
    }

    boolean this_present_op = true && this.isSetOp();
    boolean that_present_op = true && that.isSetOp();
    if (this_present_op || that_present_op) {
      if (!(this_present_op && that_present_op))
        return false;
      if (!this.op.equals(that.op))
        return false;
    }

    boolean this_present_between = true;
    boolean that_present_between = true;
    if (this_present_between || that_present_between) {
      if (!(this_present_between && that_present_between))
        return false;
      if (this.between != that.between)
        return false;
    }

    boolean this_present_edge = true && this.isSetEdge();
    boolean that_present_edge = true && that.isSetEdge();
    if (this_present_edge || that_present_edge) {
      if (!(this_present_edge && that_present_edge))
        return false;
      if (!this.edge.equals(that.edge))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + len;

    hashCode = hashCode * 8191 + cnt;

    hashCode = hashCode * 8191 + to;

    hashCode = hashCode * 8191 + fromId;

    hashCode = hashCode * 8191 + ((isSetOp()) ? 131071 : 524287);
    if (isSetOp())
      hashCode = hashCode * 8191 + op.getValue();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(between);

    hashCode = hashCode * 8191 + ((isSetEdge()) ? 131071 : 524287);
    if (isSetEdge())
      hashCode = hashCode * 8191 + edge.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(MessagePackage other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetLen()).compareTo(other.isSetLen());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLen()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.len, other.len);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCnt()).compareTo(other.isSetCnt());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCnt()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cnt, other.cnt);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTo()).compareTo(other.isSetTo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.to, other.to);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetFromId()).compareTo(other.isSetFromId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFromId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fromId, other.fromId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetOp()).compareTo(other.isSetOp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.op, other.op);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBetween()).compareTo(other.isSetBetween());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBetween()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.between, other.between);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetEdge()).compareTo(other.isSetEdge());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEdge()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.edge, other.edge);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("MessagePackage(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("len:");
    sb.append(this.len);
    first = false;
    if (!first) sb.append(", ");
    sb.append("cnt:");
    sb.append(this.cnt);
    first = false;
    if (!first) sb.append(", ");
    sb.append("to:");
    sb.append(this.to);
    first = false;
    if (!first) sb.append(", ");
    sb.append("fromId:");
    sb.append(this.fromId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("op:");
    if (this.op == null) {
      sb.append("null");
    } else {
      sb.append(this.op);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("between:");
    sb.append(this.between);
    first = false;
    if (!first) sb.append(", ");
    sb.append("edge:");
    if (this.edge == null) {
      sb.append("null");
    } else {
      sb.append(this.edge);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MessagePackageStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MessagePackageStandardScheme getScheme() {
      return new MessagePackageStandardScheme();
    }
  }

  private static class MessagePackageStandardScheme extends org.apache.thrift.scheme.StandardScheme<MessagePackage> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MessagePackage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.id = iprot.readI32();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LEN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.len = iprot.readI32();
              struct.setLenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.cnt = iprot.readI32();
              struct.setCntIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TO
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.to = iprot.readI32();
              struct.setToIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // FROM_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.fromId = iprot.readI32();
              struct.setFromIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // OP
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.op = search.Operation.findByValue(iprot.readI32());
              struct.setOpIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // BETWEEN
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.between = iprot.readDouble();
              struct.setBetweenIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // EDGE
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.edge = new java.util.ArrayList<java.lang.Integer>(_list0.size);
                int _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = iprot.readI32();
                  struct.edge.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setEdgeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MessagePackage struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LEN_FIELD_DESC);
      oprot.writeI32(struct.len);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CNT_FIELD_DESC);
      oprot.writeI32(struct.cnt);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TO_FIELD_DESC);
      oprot.writeI32(struct.to);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(FROM_ID_FIELD_DESC);
      oprot.writeI32(struct.fromId);
      oprot.writeFieldEnd();
      if (struct.op != null) {
        oprot.writeFieldBegin(OP_FIELD_DESC);
        oprot.writeI32(struct.op.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(BETWEEN_FIELD_DESC);
      oprot.writeDouble(struct.between);
      oprot.writeFieldEnd();
      if (struct.edge != null) {
        oprot.writeFieldBegin(EDGE_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.edge.size()));
          for (int _iter3 : struct.edge)
          {
            oprot.writeI32(_iter3);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MessagePackageTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MessagePackageTupleScheme getScheme() {
      return new MessagePackageTupleScheme();
    }
  }

  private static class MessagePackageTupleScheme extends org.apache.thrift.scheme.TupleScheme<MessagePackage> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MessagePackage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetLen()) {
        optionals.set(1);
      }
      if (struct.isSetCnt()) {
        optionals.set(2);
      }
      if (struct.isSetTo()) {
        optionals.set(3);
      }
      if (struct.isSetFromId()) {
        optionals.set(4);
      }
      if (struct.isSetOp()) {
        optionals.set(5);
      }
      if (struct.isSetBetween()) {
        optionals.set(6);
      }
      if (struct.isSetEdge()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetLen()) {
        oprot.writeI32(struct.len);
      }
      if (struct.isSetCnt()) {
        oprot.writeI32(struct.cnt);
      }
      if (struct.isSetTo()) {
        oprot.writeI32(struct.to);
      }
      if (struct.isSetFromId()) {
        oprot.writeI32(struct.fromId);
      }
      if (struct.isSetOp()) {
        oprot.writeI32(struct.op.getValue());
      }
      if (struct.isSetBetween()) {
        oprot.writeDouble(struct.between);
      }
      if (struct.isSetEdge()) {
        {
          oprot.writeI32(struct.edge.size());
          for (int _iter4 : struct.edge)
          {
            oprot.writeI32(_iter4);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MessagePackage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.len = iprot.readI32();
        struct.setLenIsSet(true);
      }
      if (incoming.get(2)) {
        struct.cnt = iprot.readI32();
        struct.setCntIsSet(true);
      }
      if (incoming.get(3)) {
        struct.to = iprot.readI32();
        struct.setToIsSet(true);
      }
      if (incoming.get(4)) {
        struct.fromId = iprot.readI32();
        struct.setFromIdIsSet(true);
      }
      if (incoming.get(5)) {
        struct.op = search.Operation.findByValue(iprot.readI32());
        struct.setOpIsSet(true);
      }
      if (incoming.get(6)) {
        struct.between = iprot.readDouble();
        struct.setBetweenIsSet(true);
      }
      if (incoming.get(7)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.edge = new java.util.ArrayList<java.lang.Integer>(_list5.size);
          int _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = iprot.readI32();
            struct.edge.add(_elem6);
          }
        }
        struct.setEdgeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

