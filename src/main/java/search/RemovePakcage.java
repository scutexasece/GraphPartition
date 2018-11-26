/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package search;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-11-24")
public class RemovePakcage implements org.apache.thrift.TBase<RemovePakcage, RemovePakcage._Fields>, java.io.Serializable, Cloneable, Comparable<RemovePakcage> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RemovePakcage");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TO_FIELD_DESC = new org.apache.thrift.protocol.TField("to", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField OP_FIELD_DESC = new org.apache.thrift.protocol.TField("op", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField BETWEEN_FIELD_DESC = new org.apache.thrift.protocol.TField("between", org.apache.thrift.protocol.TType.MAP, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RemovePakcageStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RemovePakcageTupleSchemeFactory();

  public int id; // required
  public int to; // required
  /**
   * 
   * @see RMOperation
   */
  public RMOperation op; // required
  public java.util.Map<java.util.List<java.lang.Integer>,java.lang.Double> between; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    TO((short)2, "to"),
    /**
     * 
     * @see RMOperation
     */
    OP((short)3, "op"),
    BETWEEN((short)4, "between");

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
        case 2: // TO
          return TO;
        case 3: // OP
          return OP;
        case 4: // BETWEEN
          return BETWEEN;
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
  private static final int __TO_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TO, new org.apache.thrift.meta_data.FieldMetaData("to", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.OP, new org.apache.thrift.meta_data.FieldMetaData("op", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, RMOperation.class)));
    tmpMap.put(_Fields.BETWEEN, new org.apache.thrift.meta_data.FieldMetaData("between", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RemovePakcage.class, metaDataMap);
  }

  public RemovePakcage() {
  }

  public RemovePakcage(
    int id,
    int to,
    RMOperation op,
    java.util.Map<java.util.List<java.lang.Integer>,java.lang.Double> between)
  {
    this();
    this.id = id;
    setIdIsSet(true);
    this.to = to;
    setToIsSet(true);
    this.op = op;
    this.between = between;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RemovePakcage(RemovePakcage other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.to = other.to;
    if (other.isSetOp()) {
      this.op = other.op;
    }
    if (other.isSetBetween()) {
      java.util.Map<java.util.List<java.lang.Integer>,java.lang.Double> __this__between = new java.util.HashMap<java.util.List<java.lang.Integer>,java.lang.Double>(other.between.size());
      for (java.util.Map.Entry<java.util.List<java.lang.Integer>, java.lang.Double> other_element : other.between.entrySet()) {

        java.util.List<java.lang.Integer> other_element_key = other_element.getKey();
        java.lang.Double other_element_value = other_element.getValue();

        java.util.List<java.lang.Integer> __this__between_copy_key = new java.util.ArrayList<java.lang.Integer>(other_element_key);

        java.lang.Double __this__between_copy_value = other_element_value;

        __this__between.put(__this__between_copy_key, __this__between_copy_value);
      }
      this.between = __this__between;
    }
  }

  public RemovePakcage deepCopy() {
    return new RemovePakcage(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setToIsSet(false);
    this.to = 0;
    this.op = null;
    this.between = null;
  }

  public int getId() {
    return this.id;
  }

  public RemovePakcage setId(int id) {
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

  public int getTo() {
    return this.to;
  }

  public RemovePakcage setTo(int to) {
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

  /**
   * 
   * @see RMOperation
   */
  public RMOperation getOp() {
    return this.op;
  }

  /**
   * 
   * @see RMOperation
   */
  public RemovePakcage setOp(RMOperation op) {
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

  public int getBetweenSize() {
    return (this.between == null) ? 0 : this.between.size();
  }

  public void putToBetween(java.util.List<java.lang.Integer> key, double val) {
    if (this.between == null) {
      this.between = new java.util.HashMap<java.util.List<java.lang.Integer>,java.lang.Double>();
    }
    this.between.put(key, val);
  }

  public java.util.Map<java.util.List<java.lang.Integer>,java.lang.Double> getBetween() {
    return this.between;
  }

  public RemovePakcage setBetween(java.util.Map<java.util.List<java.lang.Integer>,java.lang.Double> between) {
    this.between = between;
    return this;
  }

  public void unsetBetween() {
    this.between = null;
  }

  /** Returns true if field between is set (has been assigned a value) and false otherwise */
  public boolean isSetBetween() {
    return this.between != null;
  }

  public void setBetweenIsSet(boolean value) {
    if (!value) {
      this.between = null;
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

    case TO:
      if (value == null) {
        unsetTo();
      } else {
        setTo((java.lang.Integer)value);
      }
      break;

    case OP:
      if (value == null) {
        unsetOp();
      } else {
        setOp((RMOperation)value);
      }
      break;

    case BETWEEN:
      if (value == null) {
        unsetBetween();
      } else {
        setBetween((java.util.Map<java.util.List<java.lang.Integer>,java.lang.Double>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case TO:
      return getTo();

    case OP:
      return getOp();

    case BETWEEN:
      return getBetween();

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
    case TO:
      return isSetTo();
    case OP:
      return isSetOp();
    case BETWEEN:
      return isSetBetween();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof RemovePakcage)
      return this.equals((RemovePakcage)that);
    return false;
  }

  public boolean equals(RemovePakcage that) {
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

    boolean this_present_to = true;
    boolean that_present_to = true;
    if (this_present_to || that_present_to) {
      if (!(this_present_to && that_present_to))
        return false;
      if (this.to != that.to)
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

    boolean this_present_between = true && this.isSetBetween();
    boolean that_present_between = true && that.isSetBetween();
    if (this_present_between || that_present_between) {
      if (!(this_present_between && that_present_between))
        return false;
      if (!this.between.equals(that.between))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + id;

    hashCode = hashCode * 8191 + to;

    hashCode = hashCode * 8191 + ((isSetOp()) ? 131071 : 524287);
    if (isSetOp())
      hashCode = hashCode * 8191 + op.getValue();

    hashCode = hashCode * 8191 + ((isSetBetween()) ? 131071 : 524287);
    if (isSetBetween())
      hashCode = hashCode * 8191 + between.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(RemovePakcage other) {
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("RemovePakcage(");
    boolean first = true;

    sb.append("id:");
    sb.append(this.id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("to:");
    sb.append(this.to);
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
    if (this.between == null) {
      sb.append("null");
    } else {
      sb.append(this.between);
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

  private static class RemovePakcageStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RemovePakcageStandardScheme getScheme() {
      return new RemovePakcageStandardScheme();
    }
  }

  private static class RemovePakcageStandardScheme extends org.apache.thrift.scheme.StandardScheme<RemovePakcage> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RemovePakcage struct) throws org.apache.thrift.TException {
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
          case 2: // TO
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.to = iprot.readI32();
              struct.setToIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // OP
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.op = search.RMOperation.findByValue(iprot.readI32());
              struct.setOpIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // BETWEEN
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map16 = iprot.readMapBegin();
                struct.between = new java.util.HashMap<java.util.List<java.lang.Integer>,java.lang.Double>(2*_map16.size);
                java.util.List<java.lang.Integer> _key17;
                double _val18;
                for (int _i19 = 0; _i19 < _map16.size; ++_i19)
                {
                  {
                    org.apache.thrift.protocol.TList _list20 = iprot.readListBegin();
                    _key17 = new java.util.ArrayList<java.lang.Integer>(_list20.size);
                    int _elem21;
                    for (int _i22 = 0; _i22 < _list20.size; ++_i22)
                    {
                      _elem21 = iprot.readI32();
                      _key17.add(_elem21);
                    }
                    iprot.readListEnd();
                  }
                  _val18 = iprot.readDouble();
                  struct.between.put(_key17, _val18);
                }
                iprot.readMapEnd();
              }
              struct.setBetweenIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RemovePakcage struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_FIELD_DESC);
      oprot.writeI32(struct.id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TO_FIELD_DESC);
      oprot.writeI32(struct.to);
      oprot.writeFieldEnd();
      if (struct.op != null) {
        oprot.writeFieldBegin(OP_FIELD_DESC);
        oprot.writeI32(struct.op.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.between != null) {
        oprot.writeFieldBegin(BETWEEN_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.LIST, org.apache.thrift.protocol.TType.DOUBLE, struct.between.size()));
          for (java.util.Map.Entry<java.util.List<java.lang.Integer>, java.lang.Double> _iter23 : struct.between.entrySet())
          {
            {
              oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, _iter23.getKey().size()));
              for (int _iter24 : _iter23.getKey())
              {
                oprot.writeI32(_iter24);
              }
              oprot.writeListEnd();
            }
            oprot.writeDouble(_iter23.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RemovePakcageTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RemovePakcageTupleScheme getScheme() {
      return new RemovePakcageTupleScheme();
    }
  }

  private static class RemovePakcageTupleScheme extends org.apache.thrift.scheme.TupleScheme<RemovePakcage> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RemovePakcage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetTo()) {
        optionals.set(1);
      }
      if (struct.isSetOp()) {
        optionals.set(2);
      }
      if (struct.isSetBetween()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeI32(struct.id);
      }
      if (struct.isSetTo()) {
        oprot.writeI32(struct.to);
      }
      if (struct.isSetOp()) {
        oprot.writeI32(struct.op.getValue());
      }
      if (struct.isSetBetween()) {
        {
          oprot.writeI32(struct.between.size());
          for (java.util.Map.Entry<java.util.List<java.lang.Integer>, java.lang.Double> _iter25 : struct.between.entrySet())
          {
            {
              oprot.writeI32(_iter25.getKey().size());
              for (int _iter26 : _iter25.getKey())
              {
                oprot.writeI32(_iter26);
              }
            }
            oprot.writeDouble(_iter25.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RemovePakcage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readI32();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.to = iprot.readI32();
        struct.setToIsSet(true);
      }
      if (incoming.get(2)) {
        struct.op = search.RMOperation.findByValue(iprot.readI32());
        struct.setOpIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TMap _map27 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.LIST, org.apache.thrift.protocol.TType.DOUBLE, iprot.readI32());
          struct.between = new java.util.HashMap<java.util.List<java.lang.Integer>,java.lang.Double>(2*_map27.size);
          java.util.List<java.lang.Integer> _key28;
          double _val29;
          for (int _i30 = 0; _i30 < _map27.size; ++_i30)
          {
            {
              org.apache.thrift.protocol.TList _list31 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
              _key28 = new java.util.ArrayList<java.lang.Integer>(_list31.size);
              int _elem32;
              for (int _i33 = 0; _i33 < _list31.size; ++_i33)
              {
                _elem32 = iprot.readI32();
                _key28.add(_elem32);
              }
            }
            _val29 = iprot.readDouble();
            struct.between.put(_key28, _val29);
          }
        }
        struct.setBetweenIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

